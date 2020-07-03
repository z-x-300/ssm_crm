package com.zhangxin.vo;

public class QueryVo {

    //客户名称
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    //当前页
    private Integer page;
    //每页数
    private Integer size =10;
    //开始行
    private Integer startRow =0;

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }
}
