package com.uit.finalproject.model;

import java.sql.Timestamp;

public class SunIrradiance {
    private String type;
    private Integer value;
    private String name;
    private Meta meta;
    private long timestamp;

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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SunIrradiance{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", timestamp=" + timestamp +
                '}';
    }
}
