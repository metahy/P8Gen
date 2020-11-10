package com.tools.gen.entity;

import java.util.List;

public class Field {

    // note
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility = "private";

    // is field static
    private boolean isStatic;

    // is field final
    private boolean isFinal;

    // is field volatile
    private boolean isVolatile;

    // type
    private String type;

    // field name
    private String name;

    // default value
    private String value;

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

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isVolatile() {
        return isVolatile;
    }

    public void setVolatile(boolean aVolatile) {
        isVolatile = aVolatile;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Field{" +
                "note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", isStatic=" + isStatic +
                ", isFinal=" + isFinal +
                ", isVolatile=" + isVolatile +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
