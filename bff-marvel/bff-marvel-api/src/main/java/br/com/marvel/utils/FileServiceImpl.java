package br.com.marvel.utils;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileServiceImpl implements FileService {
	
	@Value("${directory}")
	private String directory;
	
    @Autowired
    private ResourceLoader resourceLoader;	

	@Override
	public void saveFile(String from, String to) {
		Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, to));
		WritableResource writableResource = (WritableResource) resource;
		
        try (OutputStream outputStream = writableResource.getOutputStream()) {
        	byte[] fileContent = Files.readAllBytes(new File(from).toPath());
            outputStream.write(fileContent);
        } catch (Exception ex) {
        	// @TODO Por enquanto somente logar a mensagem de erro se ocasionar um problema
        	log.error(ex.getMessage(), ex);
        }		
	}

}
