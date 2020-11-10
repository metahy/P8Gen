package com.tools.gen.entity;

public class Block {

    // note
    private String note;

    // content
    private String content;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Block{" +
                "note='" + note + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
