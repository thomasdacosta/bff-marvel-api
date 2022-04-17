package br.com.thomasdacosta.handler.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties("UnsubscribeURL")
public class Notification {

	@JsonProperty("Type")
	private String type;

	@JsonProperty("MessageId")
	private String messageId;

	@JsonProperty("TopicArn")
	private String topicArn;

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Timestamp")
	private String timestamp;

	@JsonProperty("SignatureVersion")
	private String signatureVersion;

	@JsonProperty("Signature")
	private String signature;

	@JsonProperty("SigningCertURL")
	private String signingCertURL;

	@JsonProperty("MessageAttributes")
	private Map<String, Header> messageAttributes;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getTopicArn() {
		return topicArn;
	}

	public void setTopicArn(String topicArn) {
		this.topicArn = topicArn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSignatureVersion() {
		return signatureVersion;
	}

	public void setSignatureVersion(String signatureVersion) {
		this.signatureVersion = signatureVersion;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSigningCertURL() {
		return signingCertURL;
	}

	public void setSigningCertURL(String signingCertURL) {
		this.signingCertURL = signingCertURL;
	}

	public Map<String, Header> getMessageAttributes() {
		return messageAttributes;
	}

	public void setMessageAttributes(Map<String, Header> messageAttributes) {
		this.messageAttributes = messageAttributes;
	}
}
