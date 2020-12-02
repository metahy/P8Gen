package com.tools.gen.pattern;

import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.Main;
import com.tools.gen.utils.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTransformGenStrategy extends GenStrategy<Map<String, Object>> {
    private final Template template;

    public DataTransformGenStrategy() {
        Engine engine = Engine.create("DataTransformGenEngine");
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/datatransform.tmpl"));
    }

    @Override
    public String generate(Map<String, Object> map) {
        assert map != null;
        StringBuilder inVoSb = new StringBuilder();
        StringBuilder outVoSb = new StringBuilder();

        List<String> lines = null;
        try {
            lines = P8TradeInfoReader.checkFile((String) map.get("path"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert lines != null;
        // get trade basic info
        List<String> basicInfoLines = P8TradeInfoReader.getBasicInfoLines(lines);
        // deal trade basic info
        String tradeCd = basicInfoLines.get(0);

        List<String> inVoLines = P8TradeInfoReader.getInVoLines(lines);

        List<List<String>> inVoFieldLinesList = P8TradeInfoReader.getFieldLinesListAndImportSet(inVoLines, null);

        for (List<String> fieldLines : inVoFieldLinesList) {
            String[] ss = fieldLines.get(0).split("\t");

            // class's String/BigDecimal field
            if (!"Group".equals(ss[4])) {
                inVoSb.append(Indents.with(3)).append("<value node-name=\"").append(ss[0]).append("\" field=\"").append(CamelCaseUtils.toSmallCamelCase(ss[0])).append("\" type=\"").append("C".equals(ss[4]) ? "java.lang.String" : "java.math.BigDecimal").append("\"/>").append("\n");
            }
            // class's class field
            else if ("*N".equals(ss[3]) || "".equals(ss[3])) {
                String fieldClassName = CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4));
                inVoSb.append(Indents.with(3)).append("<collection node-name=\"").append(ss[0]).append("\" field=\"").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append("List").append("\" type=\"java.util.ArrayList\" is-wrap=\"false\">").append("\n");
                inVoSb.append(Indents.with(4)).append("<structure node-name=\"").append(ss[0]).append("\" field=\"").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append("List").append("\" type=\"").append(Main.basePackage).append(".business.vo.").append(fieldClassName).append("\" is-wrap=\"true\">").append("\n");
                for (int i = 1; i < fieldLines.size(); i++) {
                    String[] ss2 = fieldLines.get(i).split("\t");
                    inVoSb.append(Indents.with(5)).append("<value node-name=\"").append(ss2[0].substring(2)).append("\" field=\"").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append("\" type=\"").append("C".equals(ss2[4]) ? "java.lang.String" : "java.math.BigDecimal").append("\"/>").append("\n");
                }
                inVoSb.append(Indents.with(4)).append("</structure>").append("\n").append(Indents.with(3)).append("</collection>").append("\n");
            } else {
                String fieldClassName = ss[0].endsWith("_GRP") || ss[0].endsWith("_Grp") ? CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4)) : CamelCaseUtils.toBigCamelCase(ss[0]);
                inVoSb.append(Indents.with(3)).append("<structure node-name=\"").append(ss[0]).append("\" field=\"").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append("\" type=\"").append(Main.basePackage).append(".business.vo.").append(fieldClassName).append("\" is-wrap=\"true\">").append("\n");
                for (int i = 1; i < fieldLines.size(); i++) {
                    String[] ss2 = fieldLines.get(i).split("\t");
                    inVoSb.append(Indents.with(4)).append("<value node-name=\"").append(ss2[0].substring(2)).append("\" field=\"").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append("\" type=\"").append("C".equals(ss2[4]) ? "java.lang.String" : "java.math.BigDecimal").append("\"/>").append("\n");
                }
                inVoSb.append(Indents.with(3)).append("</structure>").append("\n");
            }
        }


        List<String> outVoLines = P8TradeInfoReader.getOutVoLines(lines);

        List<List<String>> outVoFieldLinesList = P8TradeInfoReader.getFieldLinesListAndImportSet(outVoLines, null);

        for (List<String> fieldLines : outVoFieldLinesList) {
            String[] ss = fieldLines.get(0).split("\t");

            // class's String/BigDecimal field
            if (!"Group".equals(ss[4])) {
                if ("C".equals(ss[4])) {
                    outVoSb.append(Indents.with(4)).append("<").append(ss[0]).append("><![CDATA[${(").append(tradeCd).append("_outData.").append(CamelCaseUtils.toSmallCamelCase(ss[0])).append(")!}]${\"]>\"}</").append(ss[0]).append(">").append("\n");
                } else {
                    outVoSb.append(Indents.with(4)).append("<#setting number_format=\"0.########\"><").append(ss[0]).append("><![CDATA[${(").append(tradeCd).append("_outData.").append(CamelCaseUtils.toSmallCamelCase(ss[0])).append(")!}]${\"]>\"}</").append(ss[0]).append(">").append("\n");
                }
            }
            // class's class field
            else if ("*N".equals(ss[3]) || "".equals(ss[3])) {
                String fieldClassName = CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4));
                outVoSb.append(Indents.with(4)).append("<#list ").append(tradeCd).append("_outData.").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append("List! as ").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append(">").append("\n");
                outVoSb.append(Indents.with(5)).append("<").append(ss[0]).append(" type=\"G\">").append("\n");
                for (int i = 1; i < fieldLines.size(); i++) {
                    String[] ss2 = fieldLines.get(i).split("\t");
                    if ("C".equals(ss2[4])) {
                        outVoSb.append(Indents.with(6)).append("<").append(ss2[0].substring(2)).append("><![CDATA[${(").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append(".").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append(")!}]${\"]>\"}</").append(ss2[0].substring(2)).append(">").append("\n");
                    } else {
                        outVoSb.append(Indents.with(6)).append("<#setting number_format=\"0.########\"><").append(ss2[0].substring(2)).append("><![CDATA[${(").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append(".").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append(")!}]${\"]>\"}</").append(ss2[0].substring(2)).append(">").append("\n");
                    }
                }
                outVoSb.append(Indents.with(5)).append("<").append(ss[0]).append(">").append("\n").append(Indents.with(4)).append("</#list>").append("\n");
            } else {
                String fieldClassName = ss[0].endsWith("_GRP") || ss[0].endsWith("_Grp") ? CamelCaseUtils.toBigCamelCase(ss[0].substring(0, ss[0].length() - 4)) : CamelCaseUtils.toBigCamelCase(ss[0]);
                outVoSb.append(Indents.with(4)).append("<").append(ss[0]).append(">").append("\n");
                for (int i = 1; i < fieldLines.size(); i++) {
                    String[] ss2 = fieldLines.get(i).split("\t");
                    if ("C".equals(ss2[4])) {
                        outVoSb.append(Indents.with(5)).append("<").append(ss2[0].substring(2)).append("><![CDATA[${(").append(tradeCd).append("_outData.").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append(".").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append(")!}]${\"]>\"}</").append(ss2[0].substring(2)).append(">").append("\n");
                    } else {
                        outVoSb.append(Indents.with(5)).append("<#setting number_format=\"0.########\"><").append(ss2[0].substring(2)).append("><![CDATA[${(").append(tradeCd).append("_outData.").append(fieldClassName.substring(0, 1).toLowerCase()).append(fieldClassName.substring(1)).append(".").append(CamelCaseUtils.toSmallCamelCase(ss2[0])).append(")!}]${\"]>\"}</").append(ss2[0].substring(2)).append(">").append("\n");
                    }
                }
                outVoSb.append(Indents.with(4)).append("<").append(ss[0]).append(">").append("\n");
            }
        }

        File file = new File("./result/datatransform/" + tradeCd + ".xml");
        HashMap<String, Object> kv = new HashMap<>();
        kv.put("inVo", inVoSb.substring(0, inVoSb.length() - 1));
        kv.put("outVo", outVoSb.substring(0, outVoSb.length() - 1));
        kv.put("trade", map.get("trade"));
        String string = template.renderToString(kv);
        FileUtils.write(string.getBytes(), file);
        return string;
    }
}
