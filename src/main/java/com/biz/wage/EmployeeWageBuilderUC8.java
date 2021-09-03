package com.biz.wage;

public class EmployeeWageBuilderUC8 {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    public static int computeEmpWage (String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays=0;
        while (totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numOfWorkingDays){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 2;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 8;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
            }
            totalEmpHrs+=empHrs;
            System.out.println("Day#: "+totalWorkingDays+"Emp Hr: "+empHrs);
        }
        int totalEmpWage=totalEmpHrs*empRatePerHour;
        System.out.println("Total Emp Wage: "+totalEmpWage);
        return totalEmpWage;
    }

    public static void main(String[] args) {
        computeEmpWage("V2",20,20,100);
        computeEmpWage("CityLife",20,20,100);
    }
}
