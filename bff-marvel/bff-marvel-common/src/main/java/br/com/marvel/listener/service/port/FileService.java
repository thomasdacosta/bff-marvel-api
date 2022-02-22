package br.com.marvel.listener.service.port;

import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.Resource;

import br.com.marvel.listener.exception.FileListenerException;

public interface FileService {

	boolean isFileExists(String file);

	List<Resource> searchFile(String name);

	void saveFile(InputStream from, String to) throws FileListenerException;

	String getFileName(String size, String... values);

	String patternFile(String name);

}