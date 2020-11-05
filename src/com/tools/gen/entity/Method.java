package com.tools.gen.entity;

import java.util.List;

public class Method {

    // note
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility;

    // return type
    private String returnType;

    // method name
    private String name;

    // params
    private List<Parameter> paramList;

    // method content
    private String content;

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

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParamList() {
        return paramList;
    }

    public void setParamList(List<Parameter> paramList) {
        this.paramList = paramList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Method{" +
                "note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", returnType='" + returnType + '\'' +
                ", name='" + name + '\'' +
                ", paramList=" + paramList +
                ", content='" + content + '\'' +
                '}';
    }
}
