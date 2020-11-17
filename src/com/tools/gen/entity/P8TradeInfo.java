package com.tools.gen.entity;

import java.util.List;

public class P8TradeInfo {
    private String tradeCd;
    private String tradeName;
    private Clazz inVo;
    private Clazz outVo;
    private List<Clazz> grpList;
    private Interface service;
    private Clazz serviceImpl;

    public String getTradeCd() {
        return tradeCd;
    }

    public void setTradeCd(String tradeCd) {
        this.tradeCd = tradeCd;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Clazz getInVo() {
        return inVo;
    }

    public void setInVo(Clazz inVo) {
        this.inVo = inVo;
    }

    public Clazz getOutVo() {
        return outVo;
    }

    public void setOutVo(Clazz outVo) {
        this.outVo = outVo;
    }

    public List<Clazz> getGrpList() {
        return grpList;
    }

    public void setGrpList(List<Clazz> grpList) {
        this.grpList = grpList;
    }

    public Interface getService() {
        return service;
    }

    public void setService(Interface service) {
        this.service = service;
    }

    public Clazz getServiceImpl() {
        return serviceImpl;
    }

    public void setServiceImpl(Clazz serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public String toString() {
        return "P8TradeInfo{" +
                "tradeCd='" + tradeCd + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", inVo=" + inVo +
                ", outVo=" + outVo +
                ", grpList=" + grpList +
                ", service=" + service +
                ", serviceImpl=" + serviceImpl +
                '}';
    }
}
