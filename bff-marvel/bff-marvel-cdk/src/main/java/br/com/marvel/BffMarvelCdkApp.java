package br.com.marvel;

import software.amazon.awscdk.App;

public final class BffMarvelCdkApp {

    public static void main(final String[] args) {
        App app = new App();
        new BffMarvelCdkStack(app, "BffMarvelCdkStack");
        app.synth();
    }

}
