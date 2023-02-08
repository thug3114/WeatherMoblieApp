package com.uit.finalproject.model;

public class Notes {
    private String type;
    private Integer value;
    private String name;
    private Long timestamp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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
        return "Notes{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
