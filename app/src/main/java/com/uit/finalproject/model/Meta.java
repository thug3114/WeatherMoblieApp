package com.uit.finalproject.model;

public class Meta {
    private Boolean readOnly;

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "readOnly=" + readOnly +
                '}';
    }
}
