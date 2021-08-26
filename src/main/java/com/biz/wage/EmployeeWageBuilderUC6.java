package com.biz.wage;

public class EmployeeWageBuilderUC6 {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAY = 20;
    public static final int MAX_HRS_IN_MONTH=100;

    public static void main(String[] args) {
        int empHrs = 0;
        int empWage = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays=0;
        while (totalEmpHrs<=MAX_HRS_IN_MONTH && totalWorkingDays<NUM_OF_WORKING_DAY){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 2;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 8;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
            }
            totalEmpHrs+=0;
            System.out.println("Day#: "+totalWorkingDays+"Emp Hr: "+empHrs);
        }
        int totalEmpWage=totalEmpHrs*EMP_RATE_PER_HOUR;
        System.out.println("Total Emp Wage: "+totalEmpWage);
    }
}

