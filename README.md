# P8Gen 
![P8Gen][Base64Str]

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

[Base64Str]:data:image/jpg;base64,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
