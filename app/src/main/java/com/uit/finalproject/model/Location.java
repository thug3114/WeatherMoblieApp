package com.uit.finalproject.model;

public class Location {
    private String type;
    private Object value;
    private String name;
    private Long timestamp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
