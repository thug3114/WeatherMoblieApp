package com.uit.finalproject.model;

import java.util.Arrays;
import java.util.jar.Attributes;

public class Asset {
    private String id;
    private Integer version;
    private String createedOn;
    private String name;
    private boolean accessPublicRead;
    private String parentId;
    private String realm;
    private String type;
    private String[] path;
    private ObjectAttributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateedOn() {
        return createedOn;
    }

    public void setCreateedOn(String createedOn) {
        this.createedOn = createedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAccessPublicRead() {
        return accessPublicRead;
    }

    public void setAccessPublicRead(boolean accessPublicRead) {
        this.accessPublicRead = accessPublicRead;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public ObjectAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(ObjectAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", createedOn='" + createedOn + '\'' +
                ", name='" + name + '\'' +
                ", accessPublicRead=" + accessPublicRead +
                ", parentId='" + parentId + '\'' +
                ", realm='" + realm + '\'' +
                ", type='" + type + '\'' +
                ", path=" + Arrays.toString(path) +
                ", attributes=" + attributes +
                '}';
    }
}
