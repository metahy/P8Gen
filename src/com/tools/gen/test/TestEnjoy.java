package com.tools.gen.test;

import com.tools.gen.entity.*;
import com.tools.gen.utils.GenUtils;
import com.tools.gen.utils.Indents;
import com.tools.gen.utils.NoteUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author hiram 2020年11月05日 23:28
 */
public class TestEnjoy {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        clazz.setPkg("com.test");
        clazz.setImportList(Arrays.asList("java.math.*", "java.text.*"));
        clazz.setNote(NoteUtils.multiLine(Arrays.asList("hello"), 0));
        Annotation userAnnotation = new Annotation();
        userAnnotation.setName("Component");
        userAnnotation.setDefaultValue("user");
        Annotation serverAnnotation = new Annotation();
        serverAnnotation.setName("Service");
        Param annoParam1 = new Param();
        annoParam1.setName("target");
        annoParam1.setValue("/");
        Param annoParam2 = new Param();
        annoParam2.setName("value");
        annoParam2.setValue("hi");
        serverAnnotation.setParamList(Arrays.asList(annoParam1, annoParam2));
        clazz.setAnnotationList(Arrays.asList(userAnnotation, serverAnnotation));
        clazz.setVisibility("public");
        clazz.setName("User");
        clazz.setImplementList(Arrays.asList("Serialize", "Service"));
        clazz.setExtend("InVo");
        Field field1 = new Field();
        field1.setNote(NoteUtils.singleLine("姓名" ,1));
        field1.setAnnotationList(Arrays.asList(userAnnotation));
        field1.setVisibility("private");
        field1.setType("String");
        field1.setName("name");
        Field field2 = new Field();
        field2.setNote(NoteUtils.multiLine(Arrays.asList("密码", "@Param password"), 1));
        field2.setAnnotationList(Arrays.asList(serverAnnotation));
        field2.setVisibility("private");
        field2.setType("String");
        field2.setName("password");
        clazz.setFieldList(Arrays.asList(field1, field2));

        Method setName = new Method();
        setName.setNote(NoteUtils.singleLine("set name", 1));
        setName.setVisibility("public");
        setName.setReturnType("void");
        setName.setName("setName");
        Param name = new Param();
        name.setType("String");
        name.setName("name");
        setName.setParamList(Collections.singletonList(name));
        setName.setContent(Indents.method("this.name = name;", 1));

        Method getName = new Method();
        getName.setNote(NoteUtils.multiLine(Arrays.asList("get name"), 1));
        getName.setVisibility("public");
        getName.setReturnType("String");
        getName.setName("getName");
        getName.setContent(Indents.method("return this.name;", 1));

        Method setPassword = new Method();
        Annotation overrideAnnotation = new Annotation();
        overrideAnnotation.setName("Override");
        setPassword.setAnnotationList(Arrays.asList(overrideAnnotation));
        setPassword.setVisibility("public");
        setPassword.setReturnType("void");
        setPassword.setName("setPassword");
        Param password = new Param();
        password.setType("String");
        password.setName("password");
        setPassword.setParamList(Collections.singletonList(password));
        setPassword.setContent(Indents.method("this.password = password;", 1));

        Method getPassword = new Method();
        getPassword.setNote(NoteUtils.singleLine("get password", 1));
        getPassword.setAnnotationList(Arrays.asList(overrideAnnotation));
        getPassword.setVisibility("public");
        getPassword.setReturnType("String");
        getPassword.setName("getPassword");
        getPassword.setContent(Indents.method("return this.password;", 1));

        Method create = new Method();
        create.setNote(NoteUtils.multiLine(Arrays.asList("create a new user", "@Param name", "@Param password", "@Return user"), 1));
        create.setAnnotationList(Arrays.asList(overrideAnnotation));
        create.setVisibility("public");
        create.setReturnType("User");
        create.setName("create");
        create.setParamList(Arrays.asList(name, password));
        String sb =
                Indents.method("User user = new User();", 1) +
                Indents.method("user.setName(name);", 1) +
                Indents.method("user.setPassword(password);", 1) +
                Indents.method("return user;", 1);
        create.setContent(sb);
        clazz.setMethodList(Arrays.asList(setName, getName, setPassword, getPassword, create));

        System.out.println(GenUtils.generate(clazz));
    }
}
