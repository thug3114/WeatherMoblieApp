package com.uit.finalproject.model;

public class UVIndex {
    private String type;
    private Integer value;
    private String name;
    public MetaUVIndex meta;
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

    public MetaUVIndex getMeta() {
        return meta;
    }

    public void setMeta(MetaUVIndex meta) {
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
        return "UVIndex{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", timestamp=" + timestamp +
                '}';
    }
}
