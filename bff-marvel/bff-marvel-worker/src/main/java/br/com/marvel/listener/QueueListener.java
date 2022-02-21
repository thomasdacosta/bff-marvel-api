package br.com.marvel.listener;

import org.springframework.stereotype.Component;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;

@Component
public class QueueListener {
	
	@SqsListener("${queue.name}")
	public void queueListener(String message) {
		System.out.println(message);
	}

}
