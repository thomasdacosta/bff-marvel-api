package br.com.marvel.listener.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;

import br.com.marvel.listener.exception.FileListenerException;
import io.awspring.cloud.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {

	@Value("${directory}")
	private String directory;

	@Autowired
	private ResourceLoader resourceLoader;

	private ResourcePatternResolver resourcePatternResolver;

	@Autowired
	public void setupResolver(ApplicationContext applicationContext, AmazonS3 amazonS3) {
		this.resourcePatternResolver = new PathMatchingSimpleStorageResourcePatternResolver(amazonS3,
				applicationContext);
	}

	public boolean isFileExists(String file) {
		try {
			Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, file));
			return resource.contentLength() > 0;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<Resource> searchFile(String name) {
		Resource[] resources = null;

		try {
			resources = this.resourcePatternResolver.getResources(String.format("s3://%s/%s*.*", directory, name));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return Arrays.asList(resources).stream().sorted(new Comparator<Resource>() {

			@Override
			public int compare(Resource o1, Resource o2) {
				return o1.getFilename().compareTo(o2.getFilename());
			}

		}).collect(Collectors.toList());
	}

	public void saveFile(InputStream from, String to) throws FileListenerException {
		Resource resource = this.resourceLoader.getResource(String.format("s3://%s/%s", directory, to));
		WritableResource writableResource = (WritableResource) resource;

		try (OutputStream outputStream = writableResource.getOutputStream()) {
			from.transferTo(outputStream);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new FileListenerException(ex.getMessage(), ex);
		}
	}

	public String getFileName(String size, String... values) {
		return String.format("%s_%s_%s.%s", patternFile(values[0]), values[1], size, values[2]);
	}

	public String patternFile(String name) {
		return name.toLowerCase().replace(" ", "_").replace("/", "_");
	}

}
