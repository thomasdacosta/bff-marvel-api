package br.com.marvel.utils;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile( { "localstack", "production" })
public class FileServiceS3Impl implements FileService {
	
	@Value("${directory}")
	private String directory;
	
    @Autowired
    private ResourceLoader resourceLoader;	

	@Override
	public void saveFile(InputStream from, String to) {
		Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, to));
		WritableResource writableResource = (WritableResource) resource;
		
        try (OutputStream outputStream = writableResource.getOutputStream()) {
        	from.transferTo(outputStream);
        	outputStream.close();
        } catch (Exception ex) {
        	log.error(ex.getMessage(), ex);
        }		
	}

}
