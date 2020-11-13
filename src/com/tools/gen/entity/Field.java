package com.tools.gen.entity;

import java.util.List;

public class Field {

    // note
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility;

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

    public String getNote() {
        return note;
    }

    public Field setNote(String note) {
        this.note = note;
        return this;
    }

    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public Field setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
        return this;
    }

    public String getVisibility() {
        return visibility;
    }

    public Field setVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public Field setStatic(boolean aStatic) {
        isStatic = aStatic;
        return this;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public Field setFinal(boolean aFinal) {
        isFinal = aFinal;
        return this;
    }

    public boolean isVolatile() {
        return isVolatile;
    }

    public Field setVolatile(boolean aVolatile) {
        isVolatile = aVolatile;
        return this;
    }

    public String getType() {
        return type;
    }

    public Field setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Field setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Field setValue(String value) {
        this.value = value;
        return this;
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
