package br.com.marvel;

import software.amazon.awscdk.App;

public final class BffMarvelCdkApp {

    public static void main(final String[] args) {
        App app = new App();
        BffMarvelCdkStack bffMarvelCdkStack = new BffMarvelCdkStack(app, "BffMarvelCdkStack");
        bffMarvelCdkStack.create();
        app.synth();
    }

}
