package com.kh.sqlitedept;

public class DeptVo {

    private int deptNo;
    private String deptName;
    private String deptLocation;

    public DeptVo(int deptNo, String deptName, String deptLocation) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    @Override
    public String toString() {
        return "DeptVo{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", deptLocation='" + deptLocation + '\'' +
                '}';
    }

}//DeptVo
