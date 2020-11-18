# P8Gen 
![P8Gen](resources/images/P8GenLogoWithName.jpg)

![Build Passing](https://img.shields.io/badge/build-passing-brightgreen)
![License MIT](https://img.shields.io/badge/license-MIT-blue)
![Enjoy Template Engine](https://img.shields.io/badge/EnjoyTemplateEngine-4.9.02-green)
![GitHub repo size](https://img.shields.io/github/repo-size/hiramjoyce/P8Gen)

`P8Gen` is a code generator.

> Test*.java is example to use P8Gen tool for you.

#### Plan

> About generator 
- [x] package
- [x] import set
- [x] class notes
- [x] class annotation
- [x] class annotation default value
- [x] class annotation param
- [x] class visibility
- [x] class isAbstract
- [x] class isFinal
- [x] class isStatic(for inner class)
- [ ] inner class
- [x] class name
- [x] class implement set
- [x] class extend
- [ ] static blocks
- [ ] blocks
- [ ] constructs(empty and with param)
- [ ] abstract class(class should contain abstract method)
- [ ] interface
- [ ] interface implements
- [ ] interface extends(multi)
- [ ] interface field
- [ ] interface method
- [ ] interface default method
- [ ] enum about...
- [ ] annotation about...
- [x] static fields
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
- [x] method visibility
- [x] method isStatic
- [x] method isFinal
- [x] method isSynchronized
- [x] method return type
- [x] method name
- [x] method param
- [x] method param annotation
- [x] method content
- [x] ~~class default visibility value - public~~
- [x] ~~field default visibility value - private~~
- [x] ~~method default visibility value - public~~
- [x] method default return type - void

> About trade
- [ ] trade reader
- [x] inVo
- [x] outVo
- [x] service
- [x] service implement
- [ ] data transform xml
- [x] other class in inVo or outVo

> About GenUtils
- [x] use strategy pattern

`How to use`:

1. Write the trade info template(you can reference the `P8TradeInfo.txt`)
2. Update the Main.java to use you template which defined at step 1.
3. Update the basePackage in the Main.java(it means where your code will be generated to)
4. Run the main(). 

```java
public class Main {
    // generate java code base package
    public static final String basePackage = "com.ccb.fpp.test";
    // trade source
    public static final String fileName = "P8TradeInfo.txt";

    public static void main(String[] args) throws Exception {

        // obtain trade info
        P8TradeInfo tradeInfo = P8TradeInfoReader.read("resources/" + fileName);
        Logger.info(tradeInfo);

        // generate java
        // TODO
        System.out.println("----------------------");
        System.out.println(GenUtils.generate(tradeInfo.getInVo()));
        System.out.println("----------------------");

        // TODO
        System.out.println("----------------------");
        System.out.println(GenUtils.generate(tradeInfo.getOutVo()));
        System.out.println("----------------------");

        // TODO
        System.out.println("----------------------");
        tradeInfo.getGrpList().forEach(c -> System.out.println(GenUtils.generate(c)));
        System.out.println("----------------------");
    }
}
```

you will see the result like this:
```java
package com.ccb.fpp.test.business.vo;

import com.ccb.openframework.datatransform.message.TxRequestMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0541T160InVo implements Serializable, TxRequestMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    private List<PldtpBybkOfr1> pldtpBybkOfr1;

    // 交易品种编码
    private String txnVrtyEcd;

    // 交易品种编码
    private BegDecimal txnVrtyEcd1;

    private List<PldtpBybkOfr2> pldtpBybkOfr2;

    // 回购期限
    private BegDecimal bybkTrm;

    public void setPldtpBybkOfr1(List<PldtpBybkOfr1> pldtpBybkOfr1) {
        this.pldtpBybkOfr1 = pldtpBybkOfr1;
    }

    public List<PldtpBybkOfr1> getPldtpBybkOfr1() {
        return pldtpBybkOfr1;
    }

    public void setTxnVrtyEcd(String txnVrtyEcd) {
        this.txnVrtyEcd = txnVrtyEcd;
    }

    public String getTxnVrtyEcd() {
        return txnVrtyEcd;
    }

    public void setTxnVrtyEcd1(BegDecimal txnVrtyEcd1) {
        this.txnVrtyEcd1 = txnVrtyEcd1;
    }

    public BegDecimal getTxnVrtyEcd1() {
        return txnVrtyEcd1;
    }

    public void setPldtpBybkOfr2(List<PldtpBybkOfr2> pldtpBybkOfr2) {
        this.pldtpBybkOfr2 = pldtpBybkOfr2;
    }

    public List<PldtpBybkOfr2> getPldtpBybkOfr2() {
        return pldtpBybkOfr2;
    }

    public void setBybkTrm(BegDecimal bybkTrm) {
        this.bybkTrm = bybkTrm;
    }

    public BegDecimal getBybkTrm() {
        return bybkTrm;
    }

}

package com.ccb.fpp.test.business.vo;

import com.ccb.openframework.datatransform.message.TxResponseMsgBodyEntity;
import java.io.Serializable;

public class A0541T160OutVo implements Serializable, TxResponseMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    // 启用标志
    private String strusind;

    public void setStrusind(String strusind) {
        this.strusind = strusind;
    }

    public String getStrusind() {
        return strusind;
    }

}

package com.ccb.fpp.test.business.vo;

import java.math.BigDecimal;

public class PldtpBybkOfr1 {

    // 成交日期
    private String mdlDt;

    // 成交时间
    private BegDecimal mdlTm;

    public void setMdlDt(String mdlDt) {
        this.mdlDt = mdlDt;
    }

    public String getMdlDt() {
        return mdlDt;
    }

    public void setMdlTm(BegDecimal mdlTm) {
        this.mdlTm = mdlTm;
    }

    public BegDecimal getMdlTm() {
        return mdlTm;
    }

}
package com.ccb.fpp.test.business.vo;

import java.math.BigDecimal;

public class PldtpBybkOfr2 {

    // 加权平均利率
    private BegDecimal wair;

    // 最新利率
    private String ltstIntrt;

    public void setWair(BegDecimal wair) {
        this.wair = wair;
    }

    public BegDecimal getWair() {
        return wair;
    }

    public void setLtstIntrt(String ltstIntrt) {
        this.ltstIntrt = ltstIntrt;
    }

    public String getLtstIntrt() {
        return ltstIntrt;
    }

}
```
