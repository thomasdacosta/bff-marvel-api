package br.com.marvel.listener.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Notification {
	
	@JsonProperty("Type")
	@Getter @Setter
	private String type;
	
	@JsonProperty("MessageId")
	@Getter @Setter
	private String messageId;
	
	@JsonProperty("TopicArn")
	@Getter @Setter
	private String topicArn;
	
	@JsonProperty("Message")
	@Getter @Setter
	private String message;
	
	@JsonProperty("Timestamp")
	@Getter @Setter
	private String timestamp;
	
	@JsonProperty("SignatureVersion")
	@Getter @Setter
	private String signatureVersion;

	@JsonProperty("Signature")
	@Getter @Setter
	private String signature;
	
	@JsonProperty("SigningCertURL")
	@Getter @Setter
	private String signingCertURL;
	
	@JsonProperty("MessageAttributes")
	@Getter @Setter
	private Map<String, Header> messageAttributes;
}

