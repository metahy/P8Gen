package com.tools.gen;

import com.tools.gen.entity.Clazz;
import com.tools.gen.entity.Interface;
import com.tools.gen.entity.P8TradeInfo;
import com.tools.gen.pattern.ClazzGenStrategy;
import com.tools.gen.pattern.DataTransformGenStrategy;
import com.tools.gen.pattern.GenContext;
import com.tools.gen.pattern.InterfaceGenStrategy;
import com.tools.gen.utils.FileUtils;
import com.tools.gen.utils.P8TradeInfoReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // generate java code base package
    public static final String basePackage = "com.ccb.fpp.cmds";
    // trade source
    public static final String fileName = "P8TradeInfo.txt";

    public static void main(String[] args) throws Exception {

        // obtain trade info
        P8TradeInfo tradeInfo = P8TradeInfoReader.read("resources/" + fileName);

        GenContext<Clazz> clazzGenContent = new GenContext<>(new ClazzGenStrategy());
        GenContext<Interface> interfaceGenContent = new GenContext<>(new InterfaceGenStrategy());
        GenContext<Map<String, Object>> dataTransformGenContent = new GenContext<>(new DataTransformGenStrategy());

        // remove old directory
        FileUtils.delete(new File("./result/" + basePackage.replaceAll("\\.", "/")));

        // generate java
        // TODO
        System.out.println("----------------------");
        System.out.println(clazzGenContent.generate(tradeInfo.getInVo()));
        System.out.println("----------------------");
        System.out.println();

        // TODO
        System.out.println("----------------------");
        System.out.println(clazzGenContent.generate(tradeInfo.getOutVo()));
        System.out.println("----------------------");
        System.out.println();

        // TODO
        System.out.println("----------------------");
        tradeInfo.getGrpList().forEach(c -> System.out.println(clazzGenContent.generate(c)));
        System.out.println("----------------------");
        System.out.println();

        // TODO
        System.out.println("----------------------");
        System.out.println(interfaceGenContent.generate(tradeInfo.getService()));
        System.out.println("----------------------");
        System.out.println();

        // TODO
        System.out.println("----------------------");
        System.out.println(clazzGenContent.generate(tradeInfo.getServiceImpl()));
        System.out.println("----------------------");

        // TODO
        System.out.println("----------------------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("trade", tradeInfo);
        map.put("path", "resources/" + fileName);
        System.out.println(dataTransformGenContent.generate(map));
        System.out.println("----------------------");
    }
}
