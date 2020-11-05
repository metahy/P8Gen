package com.tools.gen;

import com.jfinal.template.Engine;
import com.tools.gen.entity.P8TradeInfo;
import com.tools.gen.utils.Logger;
import com.tools.gen.utils.P8TradeInfoReader;

public class Main {

    public static void main(String[] args) throws Exception {

        // trade source
        String fileName = "P8TradeInfo.txt";

        // obtain trade info
        P8TradeInfo tradeInfo = P8TradeInfoReader.read("resources/" + fileName);
        Logger.info(tradeInfo);

        // generate java
        // TODO

        // generate xml
        // TODO
    }
}
