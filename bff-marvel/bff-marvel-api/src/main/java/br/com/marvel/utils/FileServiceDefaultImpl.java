package br.com.marvel.utils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile({ "default", "local" })
public class FileServiceDefaultImpl implements FileService {

	@Override
	public void saveFile(InputStream from, String to) {
		try {
			Path tempDir = Files.createTempDirectory("marvel_characters_");
			File file = new File(String.format("%s%s%s", tempDir.toAbsolutePath().toString(), File.separator, to));

			Files.copy(from, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
