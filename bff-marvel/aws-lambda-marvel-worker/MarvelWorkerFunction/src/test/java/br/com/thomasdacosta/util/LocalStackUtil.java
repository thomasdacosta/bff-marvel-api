package br.com.thomasdacosta.util;

import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

public class LocalStackUtil {

    private static final DockerImageName localstackImage = DockerImageName.parse("localstack/localstack:latest");

    public static LocalStackContainer localstack = new LocalStackContainer(localstackImage)
            .withServices(LocalStackContainer.Service.S3);

    public static LocalStackContainer getLocalstack() {
        if (!localstack.isRunning())
            localstack.start();
        return localstack;
    }

}
