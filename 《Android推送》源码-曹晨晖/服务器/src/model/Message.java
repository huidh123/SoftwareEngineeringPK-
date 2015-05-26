package model;

import java.sql.Timestamp;

public class Message {
	private String message;
	private String uuid;
	private Timestamp sendTime;

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Message(String message, String uuid) {
		super();
		this.message = message;
		this.uuid = uuid;
	}

	public Message(String message, String uuid, Timestamp sendTime) {
		super();
		this.message = message;
		this.uuid = uuid;
		this.sendTime = sendTime;
	}

	public Message(String message) {
		super();
		this.message = message;
		uuid = "ALL";
	}

}
