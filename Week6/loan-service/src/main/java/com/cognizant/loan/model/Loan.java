package com.cognizant.loan.model;

public class Loan {

    private Long loanId;
    private Long accountId;
    private String loanType;
    private double principal;
    private double interestRate;

    public Loan() {
    }

    public Loan(Long loanId, Long accountId, String loanType, double principal, double interestRate) {
        this.loanId = loanId;
        this.accountId = accountId;
        this.loanType = loanType;
        this.principal = principal;
        this.interestRate = interestRate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
