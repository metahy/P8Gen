### P8Gen
---
> A tool for generate java code

Component: *Enjoy Template Engine*

Plan

> About generator 
- [x] package
- [x] imports
- [x] class notes
- [x] class annotation
- [x] class annotation default value
- [x] class annotation param
- [x] class visibility
- [ ] class isAbstract
- [ ] class isFinal
- [ ] class isStatic(inner class)
- [x] class name
- [x] class implements
- [x] class extends
- [ ] interface
- [ ] interface implements
- [ ] interface extends
- [ ] interface field
- [ ] interface method
- [ ] interface default method
- [ ] enum about...
- [ ] annotation about...
- [x] field notes
- [x] field annotation
- [x] field annotation default value
- [x] field annotation param
- [x] field visibility
- [x] field isStatic
- [x] field isFinal
- [x] field isVolatile
- [x] field type
- [x] field name
- [x] field default value
- [x] method notes
- [x] method annotation
- [x] method annotation default value
- [x] method annotation param
- [ ] method hasVisibility
- [x] method visibility
- [ ] method isStatic
- [ ] method isFinal
- [ ] method isSynchronized
- [x] method return type
- [x] method name
- [x] method param
- [ ] method param annotation
- [x] method content
- [ ] inner class
- [ ] static blocks
- [ ] blocks
- [ ] constructs(empty and with param)
- [x] class default visibility value - public
- [x] field default visibility value - private
- [x] method default visibility value - public
- [x] method default return type - void

> About trade
- [ ] trade reader
- [ ] inVo
- [ ] outVo
- [ ] service
- [ ] service implement
- [ ] data transform xml
- [ ] other class in inVo or outVo

`How to use`:

```java
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
//        field1.setVisibility("public");
        field1.setType("String");
        field1.setName("name");
//        field1.setFinal(true);
//        field1.setStatic(true);
//        field1.setVolatile(true);
//        field1.setValue("\"zhangsan\"");
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
```

you will see the result like this:
```java
package com.test;

import java.math.*;
import java.text.*;

/**
 * hello
 */
@Component("user")
@Service(target = "/", value = "hi")
public class User implements Serialize, Service extends InVo {

    // 姓名
    @Component("user")
    private String name;

    /**
     * 密码
     * @Param password
     */
    @Service(target = "/", value = "hi")
    private String password;

    // set name
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    // get password
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * create a new user
     * @Param name
     * @Param password
     * @Return user
     */
    @Override
    public User create(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}
```
