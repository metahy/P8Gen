package com.tools.gen.utils;

import com.tools.gen.Main;
import com.tools.gen.entity.Clazz;
import com.tools.gen.entity.P8TradeInfo;

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



        // TODO
    }

    private static void genAndSetOutVo(P8TradeInfo tradeInfo, List<String> lines) {
        Clazz outVo = new Clazz();
        outVo.setPkg(Main.basePackage + ".business.vo");



        // TODO
    }

}
