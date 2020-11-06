package com.tools.gen.entity;

import java.util.List;

/**
 * @author hiram 2020年11月06日 01:09
 */
public class Annotation {

    private String name;

    private String defaultValue;

    private List<Param> paramList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
        this.paramList = paramList;
    }

    @Override
    public String toString() {
        return "Annotation{" +
                "name='" + name + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", paramList=" + paramList +
                '}';
    }
}
