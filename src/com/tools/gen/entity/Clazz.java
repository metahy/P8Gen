package com.tools.gen.entity;

import java.util.List;

public class Clazz {

    // package
    private String pkg;

    // imports
    private List<String> importList;

    // class name
    private String name;

    // implements
    private List<String> implementList;

    // extends
    private List<String> extendList;

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

    public List<String> getExtendList() {
        return extendList;
    }

    public void setExtendList(List<String> extendList) {
        this.extendList = extendList;
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
                ", name='" + name + '\'' +
                ", implementList=" + implementList +
                ", extendList=" + extendList +
                ", fieldList=" + fieldList +
                ", methodList=" + methodList +
                '}';
    }
}
