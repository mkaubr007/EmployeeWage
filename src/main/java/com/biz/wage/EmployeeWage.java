package com.biz.wage;

import java.util.*;

public class EmployeeWage implements IComputeEmpWage {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private List<CompanyInfo> companyEmpWageList;
    private Map<String,CompanyInfo> companyToEmpWageMap;
    public EmployeeWage(){
        companyEmpWageList=new LinkedList<CompanyInfo>();
        companyToEmpWageMap=new HashMap<>();
    }

    private int numOfCompany = 0;

    public static int computeEmpWage(CompanyInfo companyInfo) {
        int empHrs = 0;
        int totalWage = 0;
        int totalHrs = 0;

        int day = 1;
        while (day <= companyInfo.noOfWorkingDays && totalHrs < companyInfo.maxHrsPerMonth) {
            double empCheck = Math.floor(Math.random() * 10) % 3;
            switch ((int) empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            int empWage = empHrs * companyInfo.empRatePerHr;

            totalHrs += empHrs;
            totalWage += empWage;
            day++;
        }
        return totalWage;
    }

    public static void main(String[] args) {
        IComputeEmpWage employeeWageBuilder = new EmployeeWage();
        employeeWageBuilder.addCompany("DMart", 20, 6, 10);
        employeeWageBuilder.addCompany("JIO", 27, 16, 10);
        employeeWageBuilder.addCompany("Airtel", 27, 16, 10);
        employeeWageBuilder.computeEmpWage();
        System.out.println("Total Wage for DMart Company: "+employeeWageBuilder.getTotalWage("DMart"));
    }

    public void addCompany(String companyName, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        CompanyInfo companyInfo = new CompanyInfo(companyName, empRatePerHr, noOfWorkingDays, maxHrsPerMonth);
      // companyInfoArray[numOfCompany] = companyInfo;
        companyEmpWageList.add(companyInfo);



    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            int totalWage = EmployeeWage.computeEmpWage(companyEmpWageList.get(i));
            companyEmpWageList.get(i).setTotalWage(totalWage);
            companyToEmpWageMap.put(companyEmpWageList.get(i).companyName,companyEmpWageList.get(i));
        }

    }

    @Override
    public int getTotalWage(String company) {
        return companyToEmpWageMap.get(company).totalWage;
    }

}