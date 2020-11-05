package com.tools.gen.test;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.*;
import com.tools.gen.utils.Indents;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author hiram 2020年11月05日 23:28
 */
public class TestEnjoy {
    public static void main(String[] args) {
        Engine engine = Engine.create("MyFirst");
        engine.setDevMode(true);
        Template template = engine.getTemplate(new FileSource("resources", "class.tmpl"));

        Clazz clazz = new Clazz();
        clazz.setPkg("com.test");
        clazz.setImportList(Arrays.asList("java.math.*", "java.text.*"));
        clazz.setNote(
                Indents.common(0) + "/**\n" +
                        Indents.common(0) + " * hello\n" +
                        Indents.common(0) + " */\n"
        );
        Annotation userAnnotation = new Annotation();
        userAnnotation.setName("Component");
        userAnnotation.setDefaultValue("user");
        Annotation serverAnnotation = new Annotation();
        serverAnnotation.setName("Service");
        Parameter annoParam1 = new Parameter();
        annoParam1.setName("target");
        annoParam1.setValue("/");
        Parameter annoParam2 = new Parameter();
        annoParam2.setName("value");
        annoParam2.setValue("hi");
        serverAnnotation.setParamList(Arrays.asList(annoParam1, annoParam2));
        clazz.setAnnotationList(Arrays.asList(userAnnotation, serverAnnotation));
        clazz.setVisibility("public");
        clazz.setType("class");
        clazz.setName("User");
        clazz.setImplementList(Arrays.asList("Serialize", "Service"));
        clazz.setExtend("InVo");
        Field field1 = new Field();
        field1.setNote(Indents.common(1) + "// 姓名\n");
        field1.setAnnotationList(Arrays.asList(userAnnotation));
        field1.setVisibility("private");
        field1.setType("String");
        field1.setName("name");
        Field field2 = new Field();
        field2.setNote(
                Indents.common(1) + "/**\n" +
                        Indents.common(1) + " * 密码\n" +
                        Indents.common(1) + " */\n"
        );
        field2.setAnnotationList(Arrays.asList(serverAnnotation));
        field2.setVisibility("private");
        field2.setType("String");
        field2.setName("password");
        clazz.setFieldList(Arrays.asList(field1, field2));

        Method setName = new Method();
        setName.setNote(Indents.common(1) + "// set name\n");
        setName.setVisibility("public");
        setName.setReturnType("void");
        setName.setName("setName");
        Parameter name = new Parameter();
        name.setType("String");
        name.setName("name");
        setName.setParamList(Collections.singletonList(name));
        setName.setContent(Indents.methodContent("this.name = name;", 1));

        Method getName = new Method();
        getName.setNote(
                Indents.common(1) + "/**\n" +
                        Indents.common(1) + " * create a new user\n" +
                        Indents.common(1) + " */\n"
        );
        getName.setVisibility("public");
        getName.setReturnType("String");
        getName.setName("getName");
        getName.setContent(Indents.methodContent("return this.name;", 1));

        Method setPassword = new Method();
        Annotation overrideAnnotation = new Annotation();
        overrideAnnotation.setName("Override");
        setPassword.setAnnotationList(Arrays.asList(overrideAnnotation));
        setPassword.setVisibility("public");
        setPassword.setReturnType("void");
        setPassword.setName("setPassword");
        Parameter password = new Parameter();
        password.setType("String");
        password.setName("password");
        setPassword.setParamList(Collections.singletonList(password));
        setPassword.setContent(Indents.methodContent("this.password = password;", 1));

        Method getPassword = new Method();
        getPassword.setNote(Indents.common(1) + "// get password\n");
        getPassword.setAnnotationList(Arrays.asList(overrideAnnotation));
        getPassword.setVisibility("public");
        getPassword.setReturnType("String");
        getPassword.setName("getPassword");
        getPassword.setContent(Indents.methodContent("return this.password;", 1));

        Method create = new Method();
        create.setNote(
                Indents.common(1) + "/**\n" +
                        Indents.common(1) + " * create a new user\n" +
                        Indents.common(1) + " */\n"
        );
        create.setAnnotationList(Arrays.asList(overrideAnnotation));
        create.setVisibility("public");
        create.setReturnType("User");
        create.setName("create");
        create.setParamList(Arrays.asList(name, password));
        String sb =
                Indents.methodContent("User user = new User();", 1) +
                Indents.methodContent("user.setName(name);", 1) +
                Indents.methodContent("user.setPassword(password);", 1) +
                Indents.methodContent("return user;", 1);
        create.setContent(sb);
        clazz.setMethodList(Arrays.asList(setName, getName, setPassword, getPassword, create));

        String s = template.renderToString(Kv.by("clazz", clazz));

        System.out.println(s);
    }
}
