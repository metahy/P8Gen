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

    // class name
    private String name;

    // implements
    private Set<String> extendsList;

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

    public String getName() {
        return name;
    }

    public Interface setName(String name) {
        this.name = name;
        return this;
    }

    public Set<String> getExtendsList() {
        return extendsList;
    }

    public Interface setExtendsList(Set<String> extendsList) {
        this.extendsList = extendsList;
        return this;
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
                ", name='" + name + '\'' +
                ", extendsList=" + extendsList +
                ", fieldList=" + fieldList +
                ", emptyMethodList=" + emptyMethodList +
                ", defaultMethodList=" + defaultMethodList +
                ", staticMethodList=" + staticMethodList +
                '}';
    }
}
