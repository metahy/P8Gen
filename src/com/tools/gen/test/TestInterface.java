package com.tools.gen.test;

import com.tools.gen.entity.Field;
import com.tools.gen.entity.Interface;
import com.tools.gen.entity.Method;
import com.tools.gen.entity.Param;
import com.tools.gen.pattern.GenContext;
import com.tools.gen.pattern.InterfaceGenStrategy;
import com.tools.gen.utils.Indents;
import com.tools.gen.utils.NoteUtils;
import sun.reflect.misc.MethodUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hiram 2020年11月16日 23:03
 */
public class TestInterface {
    public static void main(String[] args) {
        Interface interFace = new Interface();

        interFace.setPkg("com.test");

        Set<String> importSet = new TreeSet<>();
        importSet.add("java.math.*");
        importSet.add("java.text.*");
        interFace.setImportSet(importSet);

        interFace.setVisibility("public");

        interFace.setName("TestInterface");

        Set<String> extendsSet = new TreeSet<>();
        extendsSet.add("Serializable");
        extendsSet.add("FileInputStream");
        interFace.setExtendsSet(extendsSet);

        List<Field> fieldList = new ArrayList<>();
        Field field = new Field().setNote(NoteUtils.singleLine("test", 1)).setType("String").setName("test").setValue("\"HaHa\"");
        fieldList.add(field);
        interFace.setFieldList(fieldList);

        List<Method> emptyMethodList = new ArrayList<>();
        Method method = new Method();
        method.setReturnType("String");
        method.setName("say");
        List<Param> paramList = new ArrayList<>();
        Param param = new Param();
        param.setType("String");
        param.setName("name");
        paramList.add(param);
        method.setParamList(paramList);
        emptyMethodList.add(method);
        interFace.setEmptyMethodList(emptyMethodList);

        List<Method> defaultMethodList = new ArrayList<>();
        Method defaultMethodA = new Method();
        defaultMethodA.setVisibility("private");
        defaultMethodA.setReturnType("String");
        defaultMethodA.setName("testDefault");
        defaultMethodA.setParamList(paramList);
        defaultMethodA.setContent(Indents.method("String result = \"Hello\" + name;", 1) + Indents.method("return result;", 1));
        defaultMethodList.add(defaultMethodA);
        interFace.setDefaultMethodList(defaultMethodList);

        List<Method> staticMethodList = new ArrayList<>();
        staticMethodList.add(defaultMethodA);
        interFace.setStaticMethodList(staticMethodList);

        GenContext<Interface> context = new GenContext<>(new InterfaceGenStrategy());
        System.out.println(context.generate(interFace));
    }
}
