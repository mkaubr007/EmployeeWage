package com.biz.wage;

public class EmployeeWage {
    static final int IS_PART_TIME=1;
    static final int IS_FULL_TIME=2;
    static int EMP_RATE_PER_HOUR=20;
    static int NUM_OF_WORKING_DAY=20;
    static int MAX_HRS_IN_MONTH=100;
    static int empHrs=0;
    static int empWage=0;
    static int totalEmpWage = 0;
    static int totalEmpHrs = 0;
    static int totalWorkingDays=0;
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage");
        attendance();
        employeeWage();
        employeePartTime();
        switchCase();
        monthlyWage();
        totalWage();
    }

    public static void attendance() {
        double empCheck=Math.floor(Math.random()*10)%2;
        if (empCheck==IS_FULL_TIME)
            System.out.println("Employee is Present");
        else
            System.out.println("Employee is Absent");
    }
    public static void employeeWage() {
        double empCheck=Math.floor(Math.random()*10)%2;
        if (empCheck==IS_FULL_TIME)
            empHrs=8;
        else
            empHrs=0;
        empWage=empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Emp Wage :"+empWage);
    }
    public static void employeePartTime() {
        double empCheck=Math.floor(Math.random()*10)%2;
        if(empCheck==IS_PART_TIME)
            empHrs=8;
        else if (empCheck==IS_FULL_TIME)
            empHrs=8;
        else
            empHrs=0;
        empWage=empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Emp Wage :"+empWage);
    }
    public static void switchCase() {
        EmployeeWage emp=new EmployeeWage();
        int empCheck=(int)Math.floor(Math.random()*10)%2;
        switch (empCheck){
            case IS_PART_TIME:
                empHrs=8;
                break;
            case IS_FULL_TIME:
                empHrs=8;
        }
        empWage=empHrs * EMP_RATE_PER_HOUR;
        System.out.println("Emp Wage :"+empWage);
    }

    public static void monthlyWage() {
        for (int day = 0; day < NUM_OF_WORKING_DAY; day++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 2;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 8;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
            }
            empWage = empHrs * EMP_RATE_PER_HOUR;
            totalEmpWage += empWage;
            System.out.println("Emp Wage :" + empWage);
        }
        System.out.println("Total Emp Wage: " + totalEmpWage);
    }
    public static void totalWage() {
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