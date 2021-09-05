package com.biz.wage;

public interface IComputeEmpWage {
    public void addCompany(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
        public void computeEmpWage();
        public int getTotalWage(String company);
}
