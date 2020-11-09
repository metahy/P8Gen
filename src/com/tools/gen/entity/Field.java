package com.tools.gen.entity;

import java.util.List;

public class Field {

    // note
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility = "private";

    // type
    private String type;

    // field name
    private String name;

    public Field() {
    }

    public Field(String visibility, String type, String name, String note) {
        this.visibility = visibility;
        this.type = type;
        this.name = name;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

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

    @Override
    public String toString() {
        return "Field{" +
                "note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
