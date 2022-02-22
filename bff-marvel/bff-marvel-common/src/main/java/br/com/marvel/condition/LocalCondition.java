package br.com.marvel.condition;

import java.util.Arrays;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LocalCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return !Arrays.stream(context.getEnvironment().getActiveProfiles()).anyMatch("localstack"::equals)
				&& !Arrays.stream(context.getEnvironment().getActiveProfiles()).anyMatch("production"::equals);
	}

}
