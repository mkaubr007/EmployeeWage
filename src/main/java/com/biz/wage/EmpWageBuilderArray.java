package com.biz.wage;

public class EmpWageBuilderArray implements IComputeEmpWage{
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany=0;
    private CompanyEmpWage[] companyEmpWageArray;
    public EmpWageBuilderArray(){
        companyEmpWageArray=new CompanyEmpWage[5];
    }
    private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){
        companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        numOfCompany++;
    }

    @Override
    public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

    }

    public void computeEmpWage(){
        for (int i=0;i<numOfCompany;i++){
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    @Override
    public int getTotalWage(String company) {
        return 0;
    }

    private int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 2;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 8;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + "Emp Hr: " + empHrs);
        }
        return totalEmpHrs = totalEmpHrs * companyEmpWage.empRatePerHour;
    }
    public static void main(String[] args) {
    EmpWageBuilderArray empWageBuilder=new EmpWageBuilderArray();
    empWageBuilder.addCompanyEmpWage("DMart",20,20,100);
    empWageBuilder.addCompanyEmpWage("Reliance",20,20,100);
    empWageBuilder.computeEmpWage();
    }
}
