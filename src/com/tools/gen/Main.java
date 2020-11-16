package com.tools.gen;

import com.tools.gen.entity.Clazz;
import com.tools.gen.entity.Interface;
import com.tools.gen.entity.P8TradeInfo;
import com.tools.gen.pattern.ClazzGenStrategy;
import com.tools.gen.pattern.GenContext;
import com.tools.gen.pattern.InterfaceGenStrategy;
import com.tools.gen.utils.GenUtils;
import com.tools.gen.utils.Logger;
import com.tools.gen.utils.P8TradeInfoReader;

public class Main {
    // generate java code base package
    public static final String basePackage = "com.ccb.fpp.test";
    // trade source
    public static final String fileName = "P8TradeInfo.txt";

    public static void main(String[] args) throws Exception {

        // obtain trade info
        P8TradeInfo tradeInfo = P8TradeInfoReader.read("resources/" + fileName);
        Logger.info(tradeInfo);

        GenContext<Clazz> clazzGenContent = new GenContext<>(new ClazzGenStrategy());
        GenContext<Interface> interfaceGenContent = new GenContext<>(new InterfaceGenStrategy());

        // generate java
        // TODO
        System.out.println("----------------------");
        System.out.println(clazzGenContent.generate(tradeInfo.getInVo()));
        System.out.println("----------------------");

        // TODO
        System.out.println("----------------------");
        System.out.println(clazzGenContent.generate(tradeInfo.getOutVo()));
        System.out.println("----------------------");

        // TODO
        System.out.println("----------------------");
        tradeInfo.getGrpList().forEach(c -> System.out.println(clazzGenContent.generate(c)));
        System.out.println("----------------------");

        // TODO
//        System.out.println("----------------------");
//        System.out.println(interfaceGenContent.generate(tradeInfo.getService()));
//        System.out.println("----------------------");

        // TODO
//        System.out.println("----------------------");
//        System.out.println(clazzGenContent.generate(tradeInfo.getServiceImpl()));
//        System.out.println("----------------------");
    }
}
