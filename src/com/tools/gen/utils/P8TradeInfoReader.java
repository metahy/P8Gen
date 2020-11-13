package com.tools.gen.utils;

import com.tools.gen.Main;
import com.tools.gen.entity.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class P8TradeInfoReader {

    public static P8TradeInfo read(String filePath) throws Exception {
        // check file format and return file lines
        List<String> lines = checkFile(filePath);

        // deal trade code and name
        P8TradeInfo tradeInfo = new P8TradeInfo();

        // get trade basic info
        List<String> basicInfoLines = getBasicInfoLines(lines);
        // deal trade basic info
        tradeInfo.setTradeCd(basicInfoLines.get(0));
        tradeInfo.setTradeName(basicInfoLines.get(1));

        // get trade inVo lines
        List<String> inVoLines = getInVoLines(lines);
        // deal trade inVo
        genAndSetInVo(tradeInfo, inVoLines);

        // get trade outVo lines
        List<String> outVoLines = getOutVoLines(lines);
        // deal trade outVo
        genAndSetOutVo(tradeInfo, outVoLines);

        return tradeInfo;
    }

    public static List<String> checkFile(String filePath) throws Exception {
        List<String> lines = new ArrayList<>();
        // 第一行联机交易码
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String line = reader.readLine();
        if (StringUtils.isBlank(line)) {
            throw new UnknownFormatFlagsException("第一行应填写联机交易码");
        }
        lines.add(line);

        // 第二行联机交易中文名
        line = reader.readLine();
        if (StringUtils.isBlank(line)) {
            Logger.warn("trade name is empty.");
        }
        lines.add(line);

        // 三个短横线分隔
        line = reader.readLine();
        if (!StringUtils.isEqual("---", line)) {
            throw new UnknownFormatFlagsException("第三行应填写三个短横线分隔");
        }
        lines.add(line);

        // 请求报文
        while (!StringUtils.isBlank(line = reader.readLine()) && !StringUtils.isEqual("---", line)) {
            lines.add(line);
        }

        // 三个短横线分隔
        if (!StringUtils.isEqual("---", line)) {
            throw new UnknownFormatFlagsException("应填写三个短横线分隔请求报文和响应报文");
        }
        lines.add(line);

        // 响应报文
        while (!StringUtils.isBlank(line = reader.readLine()) && !StringUtils.isEqual("---", line)) {
            lines.add(line);
        }

        Logger.info("trade check pass, file has " + lines.size() + " lines.");
        return lines;
    }

    private static List<String> getBasicInfoLines(List<String> lines) {
        List<String> basicInfoLines = new ArrayList<>();

        basicInfoLines.add(lines.get(0));
        basicInfoLines.add(lines.get(1));

        Logger.info("basic lines size - " + basicInfoLines.size());

        return basicInfoLines;
    }

    private static List<String> getInVoLines(List<String> lines) {
        List<String> inVoLines = new ArrayList<>();

        for (int i = lines.indexOf("---") + 1; i < lines.lastIndexOf("---"); i++) {
            inVoLines.add(lines.get(i));
        }

        Logger.info("inVo  lines size - " + inVoLines.size());

        return inVoLines;
    }

    private static List<String> getOutVoLines(List<String> lines) {
        List<String> outVoLines = new ArrayList<>();

        for (int i = lines.lastIndexOf("---") + 1; i < lines.size(); i++) {
            outVoLines.add(lines.get(i));
        }

        Logger.info("outVo lines size - " + outVoLines.size());

        return outVoLines;
    }

    private static void genAndSetInVo(P8TradeInfo tradeInfo, List<String> lines) {
        Clazz inVo = new Clazz();
        inVo.setPkg(Main.basePackage + ".business.vo");
        Set<String> importSet = new TreeSet<>();
        importSet.add("com.ccb.openframework.datatransform.message.TxRequestMsgBodyEntity");
        importSet.add("java.io.Serializable");

        List<List<String>> fieldLinesList = new ArrayList<>();
        List<String> fieldsLine = null;
        if (lines.size() > 0) {
            for (String line : lines) {
                String[] ss = line.split("\t");
                if ("Group".equals(ss[4])) {
                    importSet.add("java.util.List");
                    fieldsLine = new ArrayList<>();
                    fieldsLine.add(line);
                } else if (ss[0].startsWith("..")) {
                    if (fieldsLine != null) {
                        fieldsLine.add(line);
                    }
                } else {
                    if (fieldsLine != null) {
                        fieldLinesList.add(fieldsLine);
                    }
                    fieldsLine = new ArrayList<>();
                    fieldsLine.add(line);
                    if ("N".equals(ss[4])) {
                        importSet.add("java.math.BigDecimal");
                    }
                    fieldLinesList.add(fieldsLine);
                    fieldsLine = null;
                }
            }
            if (fieldsLine != null) {
                fieldLinesList.add(fieldsLine);
            }
        }

        inVo.setImportSet(importSet);
        inVo.setVisibility("public");
        inVo.setName(tradeInfo.getTradeCd() + "InVo");
        Set<String> implementSet = new TreeSet<>();
        implementSet.add("Serializable");
        implementSet.add("TxRequestMsgBodyEntity");
        inVo.setImplementSet(implementSet);

        List<Field> staticFieldLists = new ArrayList<>();
        Field serialVersionUID = new Field()
                .setVisibility("private").setStatic(true).setFinal(true)
                .setType("long").setName("serialVersionUID").setValue("1L");
        staticFieldLists.add(serialVersionUID);
        inVo.setStaticFieldList(staticFieldLists);

        List<Field> fieldLists = new ArrayList<>();
        List<Method> methodList = new ArrayList<>();
        List<Clazz> grpList = new ArrayList<>();
        tradeInfo.setGrpList(grpList);

        // deal field lines list
        if (fieldLinesList.size() > 0) {
            for (List<String> fieldLines : fieldLinesList) {
                // class's String/BigDecimal field
                String[] ss = fieldLines.get(0).split("\t");
                Field field;
                if (fieldLines.size() == 1) {
                    field = new Field().setVisibility("private").setType("C".equals(ss[4]) ? "String" : "BegDecimal").setName(CamelCaseUtils.toSmallCamelCase(ss[0]));
                }
                // class's class field
                else {
                    String fieldClassName = CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4));
                    field = new Field().setVisibility("private").setType("List<" + fieldClassName + ">").setName(fieldClassName.substring(0, 1).toLowerCase() + fieldClassName.substring(1));
                    genGrpList(tradeInfo, field, fieldLines);
                }
                fieldLists.add(field);
                methodList.addAll(genGetterAndSetter(tradeInfo, field));
            }
        }

        inVo.setFieldList(fieldLists);
        // TODO Override toString

        inVo.setMethodList(methodList);

        // TODO
        tradeInfo.setInVo(inVo);
    }

    private static void genAndSetOutVo(P8TradeInfo tradeInfo, List<String> lines) {
        Clazz outVo = new Clazz();
        outVo.setPkg(Main.basePackage + ".business.vo");
        Set<String> importSet = new TreeSet<>();
        importSet.add("com.ccb.openframework.datatransform.message.TxResponseMsgBodyEntity");
        importSet.add("java.io.Serializable");

        List<List<String>> fieldLinesList = new ArrayList<>();
        List<String> fieldsLine = null;
        if (lines.size() > 0) {
            for (String line : lines) {
                String[] ss = line.split("\t");
                if ("Group".equals(ss[4])) {
                    importSet.add("java.util.List");
                    fieldsLine = new ArrayList<>();
                    fieldsLine.add(line);
                } else if (ss[0].startsWith("..")) {
                    if (fieldsLine != null) {
                        fieldsLine.add(line);
                    }
                } else {
                    if (fieldsLine != null) {
                        fieldLinesList.add(fieldsLine);
                    }
                    fieldsLine = new ArrayList<>();
                    fieldsLine.add(line);
                    if ("N".equals(ss[4])) {
                        importSet.add("java.math.BigDecimal");
                    }
                    fieldLinesList.add(fieldsLine);
                    fieldsLine = null;
                }
            }
            if (fieldsLine != null) {
                fieldLinesList.add(fieldsLine);
            }
        }

        outVo.setImportSet(importSet);
        outVo.setVisibility("public");
        outVo.setName(tradeInfo.getTradeCd() + "OutVo");
        Set<String> implementSet = new TreeSet<>();
        implementSet.add("Serializable");
        implementSet.add("TxResponseMsgBodyEntity");
        outVo.setImplementSet(implementSet);

        List<Field> staticFieldLists = new ArrayList<>();
        Field serialVersionUID = new Field()
                .setVisibility("private").setStatic(true).setFinal(true)
                .setType("long").setName("serialVersionUID").setValue("1L");
        staticFieldLists.add(serialVersionUID);
        outVo.setStaticFieldList(staticFieldLists);

        List<Field> fieldLists = new ArrayList<>();
        List<Method> methodList = new ArrayList<>();
        List<Clazz> grpList = tradeInfo.getGrpList();

        // deal field lines list
        if (fieldLinesList.size() > 0) {
            for (List<String> fieldLines : fieldLinesList) {
                // class's String/BigDecimal field
                String[] ss = fieldLines.get(0).split("\t");
                Field field;
                if (fieldLines.size() == 1) {
                    field = new Field().setVisibility("private").setType("C".equals(ss[4]) ? "String" : "BegDecimal").setName(CamelCaseUtils.toSmallCamelCase(ss[0]));
                }
                // class's class field
                else {
                    String fieldClassName = CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4));
                    field = new Field().setVisibility("private").setType("List<" + fieldClassName + ">").setName(fieldClassName.substring(0, 1).toLowerCase() + fieldClassName.substring(1));
                    genGrpList(tradeInfo, field, fieldLines);
                }
                fieldLists.add(field);
                methodList.addAll(genGetterAndSetter(tradeInfo, field));
            }
        }

        outVo.setFieldList(fieldLists);
        // TODO Override toString

        outVo.setMethodList(methodList);

        // TODO
        tradeInfo.setOutVo(outVo);
    }

    private static List<Method> genGetterAndSetter(P8TradeInfo tradeInfo, Field field) {
        List<Method> methodList = new ArrayList<>();

        // gen setter
        Method setter = new Method();
        setter.setVisibility("public");
        setter.setReturnType("void");
        setter.setName("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
        List<Param> paramList = new ArrayList<>();
        Param param = new Param();
        param.setType(field.getType());
        param.setName(field.getName());
        paramList.add(param);
        setter.setParamList(paramList);
        setter.setContent(Indents.method("this." + field.getName() + " = " + field.getName() + ";", 1));

        // gen getter
        Method getter = new Method();
        getter.setVisibility("public");
        getter.setReturnType(field.getType());
        getter.setName("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
        getter.setContent(Indents.method("return " + field.getName() + ";", 1));

        methodList.add(setter);
        methodList.add(getter);

        return methodList;
    }

    private static void genGrpList(P8TradeInfo tradeInfo, Field field, List<String> fieldLines) {
        String targetClazzName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        Clazz clazz = null;
        if (tradeInfo.getGrpList().size() > 0) {
            for (Clazz forClazz : tradeInfo.getGrpList()) {
                if (forClazz.getName().equals(targetClazzName)) {
                    clazz = forClazz;
                }
            }
        }

        if (clazz != null) {

            Set<String> importSet = clazz.getImportSet();

            List<Field> fieldLists = clazz.getFieldList();
            List<Method> methodList = clazz.getMethodList();

            Field innerField;
            A : for (int i = 1; i < fieldLines.size(); i++) {
                String fieldLine = fieldLines.get(i);
                String[] ss = fieldLine.split("\t");

                if (fieldLists.size() > 0) {
                    for (Field forField : fieldLists) {
                        if (forField.getName().equals(CamelCaseUtils.toSmallCamelCase(ss[0]))) {
                            if (!forField.getType().equals("C".equals(ss[4]) ? "String" : "BegDecimal")) {
                                Logger.warn("Field [" + forField.getName() + "] type diff [" + forField.getType() + ", " + ("C".equals(ss[4]) ? "String" : "BegDecimal") + "], will use the one who was first defined.");
                            }
                            continue A;
                        }
                    }
                }

                if ("N".equals(ss[4])) {
                    importSet.add("java.math.BigDecimal");
                }
                innerField = new Field().setVisibility("private").setType("C".equals(ss[4]) ? "String" : "BegDecimal").setName(CamelCaseUtils.toSmallCamelCase(ss[0]));
                fieldLists.add(innerField);
                methodList.addAll(genGetterAndSetter(tradeInfo, innerField));
            }

        } else {
            clazz = new Clazz();
            clazz.setPkg(Main.basePackage + ".business.vo");
            Set<String> importSet = new TreeSet<>();

            clazz.setVisibility("public");
            clazz.setName(field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));

            List<Field> fieldLists = new ArrayList<>();
            List<Method> methodList = new ArrayList<>();

            Field innerField;
            for (int i = 1; i < fieldLines.size(); i++) {
                String fieldLine = fieldLines.get(i);
                String[] ss = fieldLine.split("\t");
                if ("N".equals(ss[4])) {
                    importSet.add("java.math.BigDecimal");
                }
                innerField = new Field().setVisibility("private").setType("C".equals(ss[4]) ? "String" : "BegDecimal").setName(CamelCaseUtils.toSmallCamelCase(ss[0]));
                fieldLists.add(innerField);
                methodList.addAll(genGetterAndSetter(tradeInfo, innerField));
            }

            clazz.setImportSet(importSet);

            clazz.setFieldList(fieldLists);
            // TODO Override toString

            clazz.setMethodList(methodList);
            tradeInfo.getGrpList().add(clazz);
        }
    }

}
