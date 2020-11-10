package com.tools.gen.entity;

import java.util.List;

public class Constructor {

    // note
    private String note;

    // visibility
    private String visibility;

    // method name
    private String name;

    // params
    private List<Param> paramList;

    // method content
    private String content;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
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
        return "Constructor{" +
                "note='" + note + '\'' +
                ", visibility='" + visibility + '\'' +
                ", name='" + name + '\'' +
                ", paramList=" + paramList +
                ", content='" + content + '\'' +
                '}';
    }
}
