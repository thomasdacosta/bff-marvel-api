package br.com.marvel.file;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.marvel.file.ports.FileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile({ "default", "local" })
public class FileServiceDefaultImpl implements FileService {

	@Value("${directory}")
	private String directory;

	@Override
	public void saveFile(InputStream from, String to) {
		try {
			Path tempDir = Files.createTempDirectory(directory);
			File file = new File(String.format("%s%s%s", tempDir.toAbsolutePath().toString(), File.separator, to));

			Files.copy(from, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
