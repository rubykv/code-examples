package com.codesample.kafka.kafka_demo.model;

public class AccountEvent {
    private String payload;
    private String id;

    public AccountEvent() {
        super();
    }

    public AccountEvent(String payload, String id) {
        super();
        this.payload = payload;
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
