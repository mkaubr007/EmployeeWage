package com.biz.wage;
import java.util.*;

public class EmployeeWage implements IComputeEmpWage {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    private int numOfCompany = 0;
    private List<CompanyEmpWage> companyEmpWageList;
    private Map<String,CompanyEmpWage>companyToEmpWageMap;
    public  Map<String,CompanyInfo> companyInfoMap = new HashMap<String,CompanyInfo>();

    public EmployeeWage(){
        companyEmpWageList=new LinkedList<>();
        companyToEmpWageMap=new HashMap<>();
    }
    public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){
        CompanyEmpWage companyEmpWage=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        companyEmpWage.add(companyEmpWage);
        companyToEmpWageMap.put(company,companyEmpWage);
    }

    @Override
    public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

    }

    public void computeEmpWage() {
        for (int i=0;i<companyEmpWageList.size();i++){
            CompanyEmpWage companyEmpWage=companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }
    @Override
    public int getTotalWage(String company){
        return companyToEmpWageMap.get(company).totalEmpWage;
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage){...}
    public static void main(String[] args) {
        IComputeEmpWage employeeWageBuilder = new EmployeeWage();
        employeeWageBuilder.addCompany("DMart",20,20,100);
        employeeWageBuilder.addCompany("Reliance",20,20,100);
        employeeWageBuilder.computeEmpWage();
        System.out.println("Total Merge for DMart: "+employeeWageBuilder.getTotalWage("DMart"));

    }

}