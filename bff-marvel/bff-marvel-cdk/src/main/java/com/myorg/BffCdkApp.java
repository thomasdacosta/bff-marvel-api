package com.myorg;

import software.amazon.awscdk.App;

public final class BffCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        new BffCdkStack(app, "BffCdkStack");

        app.synth();
    }
}
