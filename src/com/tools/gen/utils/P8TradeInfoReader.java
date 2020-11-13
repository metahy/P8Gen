package com.tools.gen.utils;

import com.tools.gen.Main;
import com.tools.gen.entity.Clazz;
import com.tools.gen.entity.Field;
import com.tools.gen.entity.P8TradeInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
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

        List<List<String>> fieldList = new ArrayList<>();

        List<String> field = null;
        if (lines.size() > 0) {
            for (String line : lines) {
                String[] ss = line.split("\t");
                if ("Group".equals(ss[4])) {
                    importSet.add(Main.basePackage + ".business.vo." + CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length()-4)));
                    field = new ArrayList<>();
                    field.add(line);
                } else if (ss[0].startsWith("..")) {
                    if (field != null) {
                        field.add(line);
                    }
                } else {
                    if (field != null) {
                        fieldList.add(field);
                    }
                    field = new ArrayList<>();
                    field.add(line);
                    if ("N".equals(ss[4])) {
                        importSet.add("java.math.BigDecimal");
                    }
                    fieldList.add(field);
                    field = null;
                }
            }
            if (field != null) {
                fieldList.add(field);
            }
        }

        inVo.setImportSet(importSet);
        inVo.setVisibility("public");
        inVo.setName(tradeInfo.getTradeCd() + "InVo");
        Set<String> implementSet = new TreeSet<>();
        implementSet.add("Serializable");
        implementSet.add("TxRequestMsgBodyEntity");
        inVo.setImplementSet(implementSet);
        List<Field> fields = new ArrayList<>();
        Field serialVersionUID = new Field()
                .setVisibility("private").setStatic(true).setFinal(true)
                .setType("long").setName("serialVersionUID").setValue("1L");
        fields.add(serialVersionUID);
        inVo.setStaticFieldList(fields);

        // TODO
        tradeInfo.setInVo(inVo);
    }

    private static void genAndSetOutVo(P8TradeInfo tradeInfo, List<String> lines) {
        Clazz outVo = new Clazz();
        outVo.setPkg(Main.basePackage + ".business.vo");



        // TODO
        tradeInfo.setOutVo(outVo);
    }

}
