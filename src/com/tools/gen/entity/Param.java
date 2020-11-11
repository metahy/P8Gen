package com.tools.gen.entity;

import java.util.List;

public class Param {

    // param type
    private String type;

    // param name
    private String name;

    // param value
    private String value;

    // param annotation
    private List<Annotation> annotationList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
    }

    @Override
    public String toString() {
        return "Param{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", annotationList=" + annotationList +
                '}';
    }
}
