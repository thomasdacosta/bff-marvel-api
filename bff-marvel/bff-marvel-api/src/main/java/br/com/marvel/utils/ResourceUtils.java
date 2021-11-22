package br.com.marvel.utils;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.Resource;

public class ResourceUtils {
	
	public static String getContentFile(Resource resource) {
		try {
			return new String(
				      Files.readAllBytes(resource.getFile().toPath()));
		} catch (IOException e) {
			return null;
		}
	}

}
