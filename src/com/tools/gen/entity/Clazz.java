package com.tools.gen.entity;

import java.util.List;

public class Clazz {

    // package
    private String pkg;

    // imports
    private List<String> importList;

    // notes
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility = "public";

    // class name
    private String name;

    // implements
    private List<String> implementList;

    // extends
    private String extend;

    // fields
    private List<Field> fieldList;

    // methods
    private List<Method> methodList;

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public List<String> getImportList() {
        return importList;
    }

    public void setImportList(List<String> importList) {
        this.importList = importList;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImplementList() {
        return implementList;
    }

    public void setImplementList(List<String> implementList) {
        this.implementList = implementList;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "pkg='" + pkg + '\'' +
                ", importList=" + importList +
                ", note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", name='" + name + '\'' +
                ", implementList=" + implementList +
                ", extend='" + extend + '\'' +
                ", fieldList=" + fieldList +
                ", methodList=" + methodList +
                '}';
    }
}
