package com.uit.finalproject.model;

public class WindSpeed {
    private String type;
    private Double value;
    private String name;
    private Meta meta;
    private Long timestamp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WindSpeed{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", timestamp=" + timestamp +
                '}';
    }
}
