# P8Gen 
![P8Gen](resources/images/P8GenLogoWithName.jpg)

![Build Passing](https://img.shields.io/badge/build-passing-brightgreen)
![License MIT](https://img.shields.io/badge/license-MIT-blue)
![GitHub repo size](https://img.shields.io/github/repo-size/hiramjoyce/P8Gen)

![JDK](https://img.shields.io/badge/JDK-1.8+-green)
![Enjoy Template Engine](https://img.shields.io/badge/Enjoy_Template_Engine-4.9.02-green)
![commons io](https://img.shields.io/badge/commons_io-2.5-green)

`P8Gen`是一个用于生成代码的工具，开发之初是为了特定场景下根据特定配置生成代码和配置文件等。在后续开发中不断扩展，目前P8Gen已经是一个功能齐全的Java代码生成工具。

`P8Gen` is a tool for generating code, the initial purpose of development is to generate code and configuration files for specific scenarios based on specific configurations. It will be expanded in subsequent development, now P8Gen has been a fully functional Java code generation tool


## 安装 Install

下载源码，作为普通java项目导入到IDEA或者Eclipse中

Download the source code and import it into IDEA or Eclipse as a normal Java project


## 使用 Usage

1. 参考resources目录中P8TradeInfo.txt文件，新建一个文件，配置好要生成的交易相关的属性
2. 找到Main.java，修改basePackage[生成的代码将以此包路径为根路径]和fileName[上一步配置好的文件]这两个属性
3. 运行Main.java的main方法

- a. Refer to the p8Tradeinfo.txt file in the Resources directory, create a new file, and configure the properties of the transaction to be generated
- b. Find main.java and change the basePackage(the generated code will be rooted from this package path) and fileName(the file configured in the previous step) properties
- c. Run the main() method in Main.java

## 举例🌰 Example

编辑 P8TradeInfo.txt 如下：

Edit P8TradeInfo.txt like this:

- P8TradeInfo.txt
```txt
A0541T160
现券价格同步服务
---
TXN_VRTY_ECD	交易品种编码	120958		C
TXN_VRTY_ECD1	交易品种编码	120958		N
PLDTP_BYBK_OFR1_GRP			1	Group
..MDL_DT	成交日期	102830		C
..MDL_TM	成交时间	103549		N
PLDTP_BYBK_OFR2_GRP	注释		*N	Group
..WAIR	加权平均利率	103563		N
..LTST_INTRT	最新利率	103618		C
BYBK_TRM	回购期限	103348		N
---
StrUsInd	启用标志	128683	1	C
BYBK_TRM	回购期限	103348		N
TXN_VRTY_ECD	交易品种编码	120958		C
TEST_ABC_GRP	测试			Group
..LTST_PRC	最新价格	103549		N
..TT_PRC	最新价格	103549		N
TEST_CBA			1	Group
..MDL_DT	成交日期	102830		C
..MDL_PRC	成交价格	103549		N
```

生成的Java代码和xml如下：

The result of the generator would be like this:

- A0541T160Service.java
```java
package com.ccb.fpp.cmds.business.service;

import com.ccb.fpp.cmds.business.vo.A0541T160OutVo;
import com.ccb.openframework.datatransform.message.TxRequestMsg;

public interface A0541T160Service {

    A0541T160OutVo doService(TxRequestMsg txRequestMsg);

}
```

- A0541T160ServiceImpl.java
```java
package com.ccb.fpp.cmds.business.service.impl;

import com.ccb.fpp.cmds.business.service.A0541T160Service;
import com.ccb.fpp.cmds.business.vo.A0541T160InVo;
import com.ccb.fpp.cmds.business.vo.A0541T160OutVo;
import com.ccb.openframework.datatransform.message.TxRequestMsg;
import com.ccb.openframework.log.Log;
import com.ccb.openframework.log.LogFactory;
import org.springframework.stereotype.Service;

/**
 * 现券价格同步服务
 */
@Service("a0541T160ServiceImpl")
public class A0541T160ServiceImpl implements A0541T160Service {
    private static final Log logger = LogFactory.getLog(A0541T160ServiceImpl.class);

    @Override
    public A0541T160OutVo doService(TxRequestMsg txRequestMsg) {
        logger.info("--->>> call A0541T160ServiceImpl.doService()");
        A0541T160InVo inVo = (A0541T160InVo) txRequestMsg.getMsgBody().getMsgBodyEntity();
        A0541T160OutVo outVo = new A0541T160OutVo();
        // TODO your business code here
        
        return outVo;
    }

}
```

- A0541T160InVo.java
```java
package com.ccb.fpp.cmds.business.vo;

import com.ccb.openframework.datatransform.message.TxRequestMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0541T160InVo implements Serializable, TxRequestMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    // 交易品种编码
    private String txnVrtyEcd;

    // 交易品种编码
    private BigDecimal txnVrtyEcd1;

    private PldtpBybkOfr1 pldtpBybkOfr1;

    // 注释
    private List<PldtpBybkOfr2> pldtpBybkOfr2List;

    // 回购期限
    private BigDecimal bybkTrm;

    public void setTxnVrtyEcd(String txnVrtyEcd) {
        this.txnVrtyEcd = txnVrtyEcd;
    }

    public String getTxnVrtyEcd() {
        return txnVrtyEcd;
    }

    public void setTxnVrtyEcd1(BigDecimal txnVrtyEcd1) {
        this.txnVrtyEcd1 = txnVrtyEcd1;
    }

    public BigDecimal getTxnVrtyEcd1() {
        return txnVrtyEcd1;
    }

    public void setPldtpBybkOfr1(PldtpBybkOfr1 pldtpBybkOfr1) {
        this.pldtpBybkOfr1 = pldtpBybkOfr1;
    }

    public PldtpBybkOfr1 getPldtpBybkOfr1() {
        return pldtpBybkOfr1;
    }

    public void setPldtpBybkOfr2List(List<PldtpBybkOfr2> pldtpBybkOfr2List) {
        this.pldtpBybkOfr2List = pldtpBybkOfr2List;
    }

    public List<PldtpBybkOfr2> getPldtpBybkOfr2List() {
        return pldtpBybkOfr2List;
    }

    public void setBybkTrm(BigDecimal bybkTrm) {
        this.bybkTrm = bybkTrm;
    }

    public BigDecimal getBybkTrm() {
        return bybkTrm;
    }

}
```

- A0541T160OutVo.java
```java
package com.ccb.fpp.cmds.business.vo;

import com.ccb.openframework.datatransform.message.TxResponseMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0541T160OutVo implements Serializable, TxResponseMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    // 启用标志
    private String strusind;

    // 回购期限
    private BigDecimal bybkTrm;

    // 交易品种编码
    private String txnVrtyEcd;

    // 测试
    private List<TestAbc> testAbcList;

    private TestCba testCba;

    public void setStrusind(String strusind) {
        this.strusind = strusind;
    }

    public String getStrusind() {
        return strusind;
    }

    public void setBybkTrm(BigDecimal bybkTrm) {
        this.bybkTrm = bybkTrm;
    }

    public BigDecimal getBybkTrm() {
        return bybkTrm;
    }

    public void setTxnVrtyEcd(String txnVrtyEcd) {
        this.txnVrtyEcd = txnVrtyEcd;
    }

    public String getTxnVrtyEcd() {
        return txnVrtyEcd;
    }

    public void setTestAbcList(List<TestAbc> testAbcList) {
        this.testAbcList = testAbcList;
    }

    public List<TestAbc> getTestAbcList() {
        return testAbcList;
    }

    public void setTestCba(TestCba testCba) {
        this.testCba = testCba;
    }

    public TestCba getTestCba() {
        return testCba;
    }

}
```

- PldtpBybkOfr1.java
```java
package com.ccb.fpp.cmds.business.vo;

import java.math.BigDecimal;

public class PldtpBybkOfr1 {

    // 成交日期
    private String mdlDt;

    // 成交时间
    private BigDecimal mdlTm;

    public void setMdlDt(String mdlDt) {
        this.mdlDt = mdlDt;
    }

    public String getMdlDt() {
        return mdlDt;
    }

    public void setMdlTm(BigDecimal mdlTm) {
        this.mdlTm = mdlTm;
    }

    public BigDecimal getMdlTm() {
        return mdlTm;
    }

}
```

- PldtpBybkOfr2.java
```java
package com.ccb.fpp.cmds.business.vo;

import java.math.BigDecimal;

public class PldtpBybkOfr2 {

    // 加权平均利率
    private BigDecimal wair;

    // 最新利率
    private String ltstIntrt;

    public void setWair(BigDecimal wair) {
        this.wair = wair;
    }

    public BigDecimal getWair() {
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

- TestAbc.java
```java
package com.ccb.fpp.cmds.business.vo;

import java.math.BigDecimal;

public class TestAbc {

    // 最新价格
    private BigDecimal ltstPrc;

    // 最新价格
    private BigDecimal ttPrc;

    public void setLtstPrc(BigDecimal ltstPrc) {
        this.ltstPrc = ltstPrc;
    }

    public BigDecimal getLtstPrc() {
        return ltstPrc;
    }

    public void setTtPrc(BigDecimal ttPrc) {
        this.ttPrc = ttPrc;
    }

    public BigDecimal getTtPrc() {
        return ttPrc;
    }

}
```

- TestCba.java
```java
package com.ccb.fpp.cmds.business.vo;

import java.math.BigDecimal;

public class TestCba {

    // 成交日期
    private String mdlDt;

    // 成交价格
    private BigDecimal mdlPrc;

    public void setMdlDt(String mdlDt) {
        this.mdlDt = mdlDt;
    }

    public String getMdlDt() {
        return mdlDt;
    }

    public void setMdlPrc(BigDecimal mdlPrc) {
        this.mdlPrc = mdlPrc;
    }

    public BigDecimal getMdlPrc() {
        return mdlPrc;
    }

}
```

- A0541T160.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<mappings>
    <mapping id="A0541T160-request" auto="true" parser="xml2BeanParser" transformer="xml2BeanTransformer" extends="abstract_in_request_msg">
        <structure node-name="ENTITY" field="msgBodyEntity" type="com.ccb.fpp.cmds.business.vo.A0541T160InVo" override="abstract-in-request-entity">
            <value node-name="TXN_VRTY_ECD" field="txnVrtyEcd" type="java.lang.String"/>
            <value node-name="TXN_VRTY_ECD1" field="txnVrtyEcd1" type="java.math.BigDecimal"/>
            <structure node-name="PLDTP_BYBK_OFR1_GRP" field="pldtpBybkOfr1" type="com.ccb.fpp.cmds.business.vo.PldtpBybkOfr1" is-wrap="true">
                <value node-name="MDL_DT" field="mdlDt" type="java.lang.String"/>
                <value node-name="MDL_TM" field="mdlTm" type="java.math.BigDecimal"/>
            </structure>
            <collection node-name="PLDTP_BYBK_OFR2_GRP" field="pldtpBybkOfr2List" type="java.util.ArrayList" is-wrap="false">
                <structure node-name="PLDTP_BYBK_OFR2_GRP" field="pldtpBybkOfr2List" type="com.ccb.fpp.cmds.business.vo.PldtpBybkOfr2" is-wrap="true">
                    <value node-name="WAIR" field="wair" type="java.math.BigDecimal"/>
                    <value node-name="LTST_INTRT" field="ltstIntrt" type="java.lang.String"/>
                </structure>
            </collection>
            <value node-name="BYBK_TRM" field="bybkTrm" type="java.math.BigDecimal"/>
        </structure>
    </mapping>
    <segment id="com.ccb.fpp.cmds.business.vo.A0541T160OutVo-entity">
        <template>
            <![CDATA[<ENTITY>
                <StrUsInd><![CDATA[${(A0541T160_outData.strusind)!}]${"]>"}</StrUsInd>
                <#setting number_format="0.########"><BYBK_TRM><![CDATA[${(A0541T160_outData.bybkTrm)!}]${"]>"}</BYBK_TRM>
                <TXN_VRTY_ECD><![CDATA[${(A0541T160_outData.txnVrtyEcd)!}]${"]>"}</TXN_VRTY_ECD>
                <#list A0541T160_outData.testAbcList! as testAbc>
                    <TEST_ABC_GRP type="G">
                        <#setting number_format="0.########"><LTST_PRC><![CDATA[${(testAbc.ltstPrc)!}]${"]>"}</LTST_PRC>
                        <#setting number_format="0.########"><TT_PRC><![CDATA[${(testAbc.ttPrc)!}]${"]>"}</TT_PRC>
                    <TEST_ABC_GRP>
                </#list>
                <TEST_CBA>
                    <MDL_DT><![CDATA[${(A0541T160_outData.testCba.mdlDt)!}]${"]>"}</MDL_DT>
                    <#setting number_format="0.########"><MDL_PRC><![CDATA[${(A0541T160_outData.testCba.mdlPrc)!}]${"]>"}</MDL_PRC>
                <TEST_CBA>
            </ENTITY>]]>
        </template>
    </segment>
    <mapping id="A0541T160-response" parser="bean2TextParser" transformer="bean2TextTransformer">
        <include segment-id="transaction"/>
        <include segment-id="in-response-header"/>
        <include segment-id="transaction-body"/>
        <include segment-id="in-response-content-common"/>
        <include segment-id="com.ccb.fpp.cmds.business.vo.A0541T160OutVo-entity"/>
        <include segment-id="/transaction-body"/>
        <include segment-id="response-emb"/>
        <include segment-id="/transaction"/>
    </mapping>
</mappings>
```

## 计划 Plan

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

- [x] trade reader
- [x] inVo
- [x] outVo
- [x] service
- [x] service implement
- [x] data transform xml
- [x] other class in inVo or outVo
- [x] data transform template
- [x] Group support single

> About GenUtils

- [x] use strategy pattern