package com.tools.gen.entity;

import java.util.List;
import java.util.Set;

public class Clazz {

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

    // is class abstract
    private boolean isAbstract;

    // is class final
    private boolean isFinal;

    // is class static(inner class)
    private boolean isStatic;

    // class name
    private String name;

    // implements
    private Set<String> implementSet;

    // extends
    private Set<String> extendsSet;

    // fields
    private List<Field> fieldList;

    // TODO constructors
    private List<Constructor> constructorList;

    // TODO static blocks
    private List<Block> staticBlockList;

    // TODO blocks
    private List<Block> blockList;

    // methods
    private List<Method> methodList;

    // TODO inner classes
    private List<Clazz> innerClazzList;

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public Set<String> getImportSet() {
        return importSet;
    }

    public void setImportSet(Set<String> importSet) {
        this.importSet = importSet;
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

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getImplementSet() {
        return implementSet;
    }

    public void setImplementSet(Set<String> implementSet) {
        this.implementSet = implementSet;
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

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Block> getStaticBlockList() {
        return staticBlockList;
    }

    public void setStaticBlockList(List<Block> staticBlockList) {
        this.staticBlockList = staticBlockList;
    }

    public List<Constructor> getConstructorList() {
        return constructorList;
    }

    public void setConstructorList(List<Constructor> constructorList) {
        this.constructorList = constructorList;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }

    public List<Clazz> getInnerClazzList() {
        return innerClazzList;
    }

    public void setInnerClazzList(List<Clazz> innerClazzList) {
        this.innerClazzList = innerClazzList;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "pkg='" + pkg + '\'' +
                ", importSet=" + importSet +
                ", note='" + note + '\'' +
                ", annotationList=" + annotationList +
                ", visibility='" + visibility + '\'' +
                ", isAbstract=" + isAbstract +
                ", isFinal=" + isFinal +
                ", isStatic=" + isStatic +
                ", name='" + name + '\'' +
                ", implementSet=" + implementSet +
                ", extendsSet='" + extendsSet + '\'' +
                ", fieldList=" + fieldList +
                ", constructorList=" + constructorList +
                ", staticBlockList=" + staticBlockList +
                ", blockList=" + blockList +
                ", methodList=" + methodList +
                ", innerClazzList=" + innerClazzList +
                '}';
    }
}
