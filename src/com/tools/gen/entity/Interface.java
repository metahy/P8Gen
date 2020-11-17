package com.tools.gen.entity;

import java.util.List;
import java.util.Set;

public class Interface {

    // package
    private String pkg;

    // imports
    private Set<String> importSet;

    // notes
    private String note;

    // annotations
    private List<Annotation> annotationList;

    // visibility
    private String visibility;

    // class name
    private String name;

    // implements
    private Set<String> extendsSet;

    // fields
    private List<Field> fieldList;

    // methods
    private List<Method> emptyMethodList;

    // methods
    private List<Method> defaultMethodList;

    // methods
    private List<Method> staticMethodList;

    public String getPkg() {
        return pkg;
    }

    public Interface setPkg(String pkg) {
        this.pkg = pkg;
        return this;
    }

    public Set<String> getImportSet() {
        return importSet;
    }

    public Interface setImportSet(Set<String> importSet) {
        this.importSet = importSet;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Interface setNote(String note) {
        this.note = note;
        return this;
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

    public Interface setName(String name) {
        this.name = name;
        return this;
    }

    public Set<String> getExtendsSet() {
        return extendsSet;
    }

    public void setExtendsSet(Set<String> extendsSet) {
        this.extendsSet = extendsSet;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public Interface setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
        return this;
    }

    public List<Method> getEmptyMethodList() {
        return emptyMethodList;
    }

    public Interface setEmptyMethodList(List<Method> emptyMethodList) {
        this.emptyMethodList = emptyMethodList;
        return this;
    }

    public List<Method> getDefaultMethodList() {
        return defaultMethodList;
    }

    public Interface setDefaultMethodList(List<Method> defaultMethodList) {
        this.defaultMethodList = defaultMethodList;
        return this;
    }

    public List<Method> getStaticMethodList() {
        return staticMethodList;
    }

    public Interface setStaticMethodList(List<Method> staticMethodList) {
        this.staticMethodList = staticMethodList;
        return this;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "pkg='" + pkg + '\'' +
                ", importSet=" + importSet +
                ", note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", name='" + name + '\'' +
                ", extendsSet=" + extendsSet +
                ", fieldList=" + fieldList +
                ", emptyMethodList=" + emptyMethodList +
                ", defaultMethodList=" + defaultMethodList +
                ", staticMethodList=" + staticMethodList +
                '}';
    }
}
