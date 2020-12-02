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

Edit P8TradeInfo.txt like this:

```txt
A0541T160
现券价格同步服务
---
PLDTP_BYBK_OFR1_GRP				Group
..MDL_DT	成交日期	102830		C
..MDL_TM	成交时间	103549		N
TXN_VRTY_ECD	交易品种编码	120958		C
TXN_VRTY_ECD1	交易品种编码	120958		N
PLDTP_BYBK_OFR2_GRP				Group
..WAIR	加权平均利率	103563		N
..LTST_INTRT	最新利率	103618		C
BYBK_TRM	回购期限	103348		N
---
StrUsInd	启用标志	128683	1	C
BYBK_TRM	回购期限	103348		N
TXN_VRTY_ECD	交易品种编码	120958		C
TEST_ABC_GRP				Group
..MDL_DT	成交日期	102830		C
..MDL_PRC	成交价格	103549		N
..LTST_PRC	最新价格	103549		N
..TT_PRC	最新价格	103549		N
```

The result of the generator would be like this:

```java
package com.ccb.fpp.cmds.business.service;

import com.ccb.fpp.cmds.business.vo.A0541T160OutVo;
import com.ccb.openframework.datatransform.message.TxRequestMsg;

public interface A0541T160Service {

    A0541T160OutVo doService(TxRequestMsg txRequestMsg);

}
```
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
```java
package com.ccb.fpp.cmds.business.vo;

import com.ccb.openframework.datatransform.message.TxRequestMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0541T160InVo implements Serializable, TxRequestMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    private List<PldtpBybkOfr1> pldtpBybkOfr1List;

    // 交易品种编码
    private String txnVrtyEcd;

    // 交易品种编码
    private BigDecimal txnVrtyEcd1;

    private List<PldtpBybkOfr2> pldtpBybkOfr2List;

    // 回购期限
    private BigDecimal bybkTrm;

    public void setPldtpBybkOfr1List(List<PldtpBybkOfr1> pldtpBybkOfr1List) {
        this.pldtpBybkOfr1List = pldtpBybkOfr1List;
    }

    public List<PldtpBybkOfr1> getPldtpBybkOfr1List() {
        return pldtpBybkOfr1List;
    }

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

    private List<TestAbc> testAbcList;

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

}
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