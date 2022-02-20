package br.com.marvel.messaging;

import org.springframework.stereotype.Service;

import br.com.marvel.messaging.port.MessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocalMessageService implements MessageService {

	@Override
	public void sendMessage(String message) {
		log.info("Enviando mensagem com LocalMessageService");
	}

}
