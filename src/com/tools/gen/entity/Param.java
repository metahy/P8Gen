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
    private Annotation annotation;

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

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "Param{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", annotation=" + annotation +
                '}';
    }
}
