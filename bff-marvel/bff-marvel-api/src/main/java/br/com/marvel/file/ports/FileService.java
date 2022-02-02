package br.com.marvel.file.ports;

import java.io.InputStream;

public interface FileService {
	
	public void saveFile(InputStream from, String to);

}
