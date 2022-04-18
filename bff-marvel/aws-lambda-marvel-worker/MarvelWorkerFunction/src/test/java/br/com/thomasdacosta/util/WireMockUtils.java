package br.com.thomasdacosta.util;

import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockUtils {

    public static void serverImage() {
        WireMock.stubFor(WireMock
                .get("/imageMarvel/portrait_uncanny.jpg")
                .willReturn(WireMock
                        .aResponse().withStatus(200).withBody("file")));
    }

}
