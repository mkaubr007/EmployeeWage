package com.biz.wage;


public class CompanyInfo {

    public int totalWage;
    public String companyName;
    public  final int empRatePerHr;
    public final int noOfWorkingDays;
    public final int maxHrsPerMonth;



    public CompanyInfo(String companyName, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        this.companyName = companyName;
        this.empRatePerHr = empRatePerHr;
        this.noOfWorkingDays = noOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }



    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Total Emp Wage for Company: "+companyName+" is: "+totalWage;
    }

}
