package com.uit.finalproject.model;

public class MetaUVIndex {
    private Boolean readOnly;
    public String label;

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "MetaUVIndex{" +
                "readOnly=" + readOnly +
                ", label='" + label + '\'' +
                '}';
    }
}
