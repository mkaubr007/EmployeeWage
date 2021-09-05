package com.biz.wage;

public class EmployeeWageBuilderObject {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;

    public EmployeeWageBuilderObject(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }


    public void computeEmpWage() {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
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
        totalEmpWage = totalEmpHrs * empRatePerHour;
    }
    public String toString(){
        return "Total Emp Wage of Company "+company+"is"+totalEmpWage;
    }
    public static void main(String[] args) {
       EmployeeWageBuilderObject dMart=new EmployeeWageBuilderObject("DMart",20,20,100);
       EmployeeWageBuilderObject reliance=new EmployeeWageBuilderObject("Reliance",20,20,100);
       dMart.computeEmpWage();
       System.out.println(dMart);
       reliance.computeEmpWage();
        System.out.println(reliance);
    }
}
