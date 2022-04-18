package br.com.thomasdacosta.handler.util;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class LoggerUtil {

    private static LambdaLogger lambdaLogger = null;
    private static Context context = null;

    public static void setLogger(Context ctx) {
        if (ctx != null) {
            lambdaLogger = ctx.getLogger();
            context = ctx;
        }
    }

    public static void log(String message) {
        if (lambdaLogger != null)
            lambdaLogger.log(String.format("ID:%s - %s",context.getAwsRequestId(), message));
        else
            System.out.println(String.format("ID:%s - %s",0, message));
    }

    public static void error(Throwable ex) {
        if (lambdaLogger != null)
            lambdaLogger.log(String.format("ID:%s - %s",context.getAwsRequestId(), ExceptionUtils.getStackTrace(ex)));
        else
            System.out.println(String.format("ID:%s - %s",0, ExceptionUtils.getStackTrace(ex)));
    }

}
