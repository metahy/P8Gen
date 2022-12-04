# P8Gen 
![P8Gen](resources/images/P8GenLogoWithName.jpg)

![Build Passing](https://img.shields.io/badge/build-passing-brightgreen)
![License MIT](https://img.shields.io/badge/license-MIT-blue)
![GitHub repo size](https://img.shields.io/github/repo-size/metahy/P8Gen)

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
A0000T000
测试服务
---
FIELD_ABC_UVW	属性1	123456		C
FIELD_ABC_XYZ	属性2	654321		N
GROUP_FIELD1_GRP			1	Group
..INNER_FIELD1	内部属性1	234567		C
..INNER_FIELD2	内部属性2	765432		N
GROUP_FIELD2_GRP	注释		*N	Group
..INNER_FIELD3	内部属性3	345678		N
..INNER_FIELD4	内部属性4	876543		C
FIELD_ABC_OMN	属性3	012345		N
---
FIELD_ABC_DEF	属性4	456789	1	C
FIELD_ABC_GHI	属性5	987654		N
GROUP_FIELD2_GRP	注释		1	Group
..INNER_FIELD3	内部属性3	345678		N
..INNER_FIELD4	内部属性4	876543		C
FIELD_ABC_JKL	属性6	678901		C
GROUP_FIELD3_GRP			*N	Group
..INNER_FIELD5	内部属性5	567890		C
..INNER_FIELD6	内部属性6	098765		N
```

生成的Java代码和xml如下：

The result of the generator would be like this:

- A0000T000Service.java
```java
package com.hiram.test.base.business.service;

import com.[WARN].openframework.datatransform.message.TxRequestMsg;
import com.hiram.test.base.business.vo.A0000T000OutVo;

public interface A0000T000Service {

    A0000T000OutVo doService(TxRequestMsg txRequestMsg);

}
```

- A0000T000ServiceImpl.java
```java
package com.hiram.test.base.business.service.impl;

import com.[WARN].openframework.datatransform.message.TxRequestMsg;
import com.[WARN].openframework.log.Log;
import com.[WARN].openframework.log.LogFactory;
import com.hiram.test.base.business.service.A0000T000Service;
import com.hiram.test.base.business.vo.A0000T000InVo;
import com.hiram.test.base.business.vo.A0000T000OutVo;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 */
@Service("a0000T000ServiceImpl")
public class A0000T000ServiceImpl implements A0000T000Service {
    private static final Log logger = LogFactory.getLog(A0000T000ServiceImpl.class);

    @Override
    public A0000T000OutVo doService(TxRequestMsg txRequestMsg) {
        logger.info("--->>> call A0000T000ServiceImpl.doService()");
        A0000T000InVo inVo = (A0000T000InVo) txRequestMsg.getMsgBody().getMsgBodyEntity();
        A0000T000OutVo outVo = new A0000T000OutVo();
        // TODO your business code here
        
        return outVo;
    }

}
```

- A0000T000InVo.java
```java
package com.hiram.test.base.business.vo;

import com.[WARN].openframework.datatransform.message.TxRequestMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0000T000InVo implements Serializable, TxRequestMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    // 属性1
    private String fieldAbcUvw;

    // 属性2
    private BigDecimal fieldAbcXyz;

    private GroupField1 groupField1;

    // 注释
    private List<GroupField2> groupField2List;

    // 属性3
    private BigDecimal fieldAbcOmn;

    public void setFieldAbcUvw(String fieldAbcUvw) {
        this.fieldAbcUvw = fieldAbcUvw;
    }

    public String getFieldAbcUvw() {
        return fieldAbcUvw;
    }

    public void setFieldAbcXyz(BigDecimal fieldAbcXyz) {
        this.fieldAbcXyz = fieldAbcXyz;
    }

    public BigDecimal getFieldAbcXyz() {
        return fieldAbcXyz;
    }

    public void setGroupField1(GroupField1 groupField1) {
        this.groupField1 = groupField1;
    }

    public GroupField1 getGroupField1() {
        return groupField1;
    }

    public void setGroupField2List(List<GroupField2> groupField2List) {
        this.groupField2List = groupField2List;
    }

    public List<GroupField2> getGroupField2List() {
        return groupField2List;
    }

    public void setFieldAbcOmn(BigDecimal fieldAbcOmn) {
        this.fieldAbcOmn = fieldAbcOmn;
    }

    public BigDecimal getFieldAbcOmn() {
        return fieldAbcOmn;
    }

}
```

- A0000T000OutVo.java
```java
package com.hiram.test.base.business.vo;

import com.[WARN].openframework.datatransform.message.TxResponseMsgBodyEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class A0000T000OutVo implements Serializable, TxResponseMsgBodyEntity {
    private static final long serialVersionUID = 1L;

    // 属性4
    private String fieldAbcDef;

    // 属性5
    private BigDecimal fieldAbcGhi;

    // 注释
    private GroupField2 groupField2;

    // 属性6
    private String fieldAbcJkl;

    private List<GroupField3> groupField3List;

    public void setFieldAbcDef(String fieldAbcDef) {
        this.fieldAbcDef = fieldAbcDef;
    }

    public String getFieldAbcDef() {
        return fieldAbcDef;
    }

    public void setFieldAbcGhi(BigDecimal fieldAbcGhi) {
        this.fieldAbcGhi = fieldAbcGhi;
    }

    public BigDecimal getFieldAbcGhi() {
        return fieldAbcGhi;
    }

    public void setGroupField2(GroupField2 groupField2) {
        this.groupField2 = groupField2;
    }

    public GroupField2 getGroupField2() {
        return groupField2;
    }

    public void setFieldAbcJkl(String fieldAbcJkl) {
        this.fieldAbcJkl = fieldAbcJkl;
    }

    public String getFieldAbcJkl() {
        return fieldAbcJkl;
    }

    public void setGroupField3List(List<GroupField3> groupField3List) {
        this.groupField3List = groupField3List;
    }

    public List<GroupField3> getGroupField3List() {
        return groupField3List;
    }

}
```

- GroupField1.java
```java
package com.hiram.test.base.business.vo;

import java.math.BigDecimal;

public class GroupField1 {

    // 内部属性1
    private String innerField1;

    // 内部属性2
    private BigDecimal innerField2;

    public void setInnerField1(String innerField1) {
        this.innerField1 = innerField1;
    }

    public String getInnerField1() {
        return innerField1;
    }

    public void setInnerField2(BigDecimal innerField2) {
        this.innerField2 = innerField2;
    }

    public BigDecimal getInnerField2() {
        return innerField2;
    }

}
```

- GroupField2.java
```java
package com.hiram.test.base.business.vo;

import java.math.BigDecimal;

public class GroupField2 {

    // 内部属性3
    private BigDecimal innerField3;

    // 内部属性4
    private String innerField4;

    // 内部属性7
    private String innerField7;

    // 内部属性8
    private String innerField8;

    public void setInnerField3(BigDecimal innerField3) {
        this.innerField3 = innerField3;
    }

    public BigDecimal getInnerField3() {
        return innerField3;
    }

    public void setInnerField4(String innerField4) {
        this.innerField4 = innerField4;
    }

    public String getInnerField4() {
        return innerField4;
    }

    public void setInnerField7(String innerField7) {
        this.innerField7 = innerField7;
    }

    public String getInnerField7() {
        return innerField7;
    }

    public void setInnerField8(String innerField8) {
        this.innerField8 = innerField8;
    }

    public String getInnerField8() {
        return innerField8;
    }

}
```

- GroupField3.java
```java
package com.hiram.test.base.business.vo;

import java.math.BigDecimal;

public class GroupField3 {

    // 内部属性5
    private String innerField5;

    // 内部属性6
    private BigDecimal innerField6;

    public void setInnerField5(String innerField5) {
        this.innerField5 = innerField5;
    }

    public String getInnerField5() {
        return innerField5;
    }

    public void setInnerField6(BigDecimal innerField6) {
        this.innerField6 = innerField6;
    }

    public BigDecimal getInnerField6() {
        return innerField6;
    }

}
```

- A0000T000.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<mappings>
    <mapping id="A0000T000-request" auto="true" parser="xml2BeanParser" transformer="xml2BeanTransformer" extends="abstract_in_request_msg">
        <structure node-name="ENTITY" field="msgBodyEntity" type="com.hiram.test.base.business.vo.A0000T000InVo" override="abstract-in-request-entity">
            <value node-name="FIELD_ABC_UVW" field="fieldAbcUvw" type="java.lang.String"/>
            <value node-name="FIELD_ABC_XYZ" field="fieldAbcXyz" type="java.math.BigDecimal"/>
            <structure node-name="GROUP_FIELD1_GRP" field="groupField1" type="com.hiram.test.base.business.vo.GroupField1" is-wrap="true">
                <value node-name="INNER_FIELD1" field="innerField1" type="java.lang.String"/>
                <value node-name="INNER_FIELD2" field="innerField2" type="java.math.BigDecimal"/>
            </structure>
            <collection node-name="GROUP_FIELD2_GRP" field="groupField2List" type="java.util.ArrayList" is-wrap="false">
                <structure node-name="GROUP_FIELD2_GRP" field="groupField2List" type="com.hiram.test.base.business.vo.GroupField2" is-wrap="true">
                    <value node-name="INNER_FIELD3" field="innerField3" type="java.math.BigDecimal"/>
                    <value node-name="INNER_FIELD4" field="innerField4" type="java.lang.String"/>
                    <value node-name="INNER_FIELD7" field="innerField7" type="java.lang.String"/>
                </structure>
            </collection>
            <value node-name="FIELD_ABC_OMN" field="fieldAbcOmn" type="java.math.BigDecimal"/>
        </structure>
    </mapping>
    <segment id="com.hiram.test.base.business.vo.A0000T000OutVo-entity">
        <template>
            <![CDATA[<ENTITY>
                <FIELD_ABC_DEF><![CDATA[${(A0000T000_outData.fieldAbcDef)!}]${"]>"}</FIELD_ABC_DEF>
                <#setting number_format="0.########"><FIELD_ABC_GHI><![CDATA[${(A0000T000_outData.fieldAbcGhi)!}]${"]>"}</FIELD_ABC_GHI>
                <GROUP_FIELD2_GRP>
                    <#setting number_format="0.########"><INNER_FIELD3><![CDATA[${(A0000T000_outData.groupField2.innerField3)!}]${"]>"}</INNER_FIELD3>
                    <INNER_FIELD4><![CDATA[${(A0000T000_outData.groupField2.innerField4)!}]${"]>"}</INNER_FIELD4>
                    <INNER_FIELD8><![CDATA[${(A0000T000_outData.groupField2.innerField8)!}]${"]>"}</INNER_FIELD8>
                <GROUP_FIELD2_GRP>
                <FIELD_ABC_JKL><![CDATA[${(A0000T000_outData.fieldAbcJkl)!}]${"]>"}</FIELD_ABC_JKL>
                <#list A0000T000_outData.groupField3List! as groupField3>
                    <GROUP_FIELD3_GRP type="G">
                        <INNER_FIELD5><![CDATA[${(groupField3.innerField5)!}]${"]>"}</INNER_FIELD5>
                        <#setting number_format="0.########"><INNER_FIELD6><![CDATA[${(groupField3.innerField6)!}]${"]>"}</INNER_FIELD6>
                    <GROUP_FIELD3_GRP>
                </#list>
            </ENTITY>]]>
        </template>
    </segment>
    <mapping id="A0000T000-response" parser="bean2TextParser" transformer="bean2TextTransformer">
        <include segment-id="transaction"/>
        <include segment-id="in-response-header"/>
        <include segment-id="transaction-body"/>
        <include segment-id="in-response-content-common"/>
        <include segment-id="com.hiram.test.base.business.vo.A0000T000OutVo-entity"/>
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
