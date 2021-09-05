package com.biz.wage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeWage implements IComputeEmpWage {

    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    List<CompanyInfo> listCompany = new ArrayList<CompanyInfo>();
    public static Map<String,CompanyInfo> companyInfoMap = new HashMap<String,CompanyInfo>();

    private int numOfCompany = 0;

    public static int computeEmpWage(CompanyInfo companyInfo) {
        int empHrs = 0;
        int totalWage = 0;
        int totalHrs = 0;

        int day = 1;
        while (day <= companyInfo.getNoOfWorkingDays() && totalHrs < companyInfo.getMaxHrsPerMonth()) {
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
            int empWage = empHrs * companyInfo.getEmpRatePerHr();

            totalHrs += empHrs;
            totalWage += empWage;
            day++;
        }
        return totalWage;
    }

    public static void main(String[] args) {
        IComputeEmpWage employeeWageBuilder = new EmployeeWage();
        ((EmployeeWage) employeeWageBuilder).addCompanyEmpWage("DMart", 20, 6, 10);
        ((EmployeeWage) employeeWageBuilder).addCompanyEmpWage("JIO", 27, 16, 10);
        ((EmployeeWage) employeeWageBuilder).addCompanyEmpWage("Airtel", 27, 16, 10);
        employeeWageBuilder.computeEmpWage();
        System.out.println("Map:"+companyInfoMap);
        System.out.println(companyInfoMap.get("DMart"));

    }

    public void addCompanyEmpWage(String companyName, int empRatePerHr, int noOfWorkingDays, int maxHrsPerMonth) {
        CompanyInfo companyInfo = new CompanyInfo(companyName, empRatePerHr, noOfWorkingDays, maxHrsPerMonth);
        listCompany.add(companyInfo);



    }

    @Override
    public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

    }

    public void computeEmpWage() {
        for (int i = 0; i < listCompany.size(); i++) {
            int totalWage = EmployeeWage.computeEmpWage(listCompany.get(i));
            listCompany.get(i).setTotalWage(totalWage);
            companyInfoMap.put(listCompany.get(i).getCompanyName(),listCompany.get(i));
        }

    }

    @Override
    public int getTotalWage(String company) {
        return 0;
    }

}