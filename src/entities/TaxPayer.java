package entities;

import utils.NumberFormatter;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){
        double monthlySalary = salaryIncome / 12;

        if (monthlySalary < 3000){
            return 0;
        }

        if (monthlySalary < 5000){
            return salaryIncome * 0.1;
        }

        return salaryIncome * 0.2;
    }

    public double servicesTax(){
        if (servicesIncome > 0){
            return servicesIncome * 0.15;
        }
        return 0;
    }

    public double capitalTax(){
        if (capitalIncome > 0){
            return capitalIncome * 0.2;
        }
        return 0;
    }

    public double grossTax(){
        return  salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate(){
        double spendings = healthSpending + educationSpending;
        double maxRebate = grossTax() * 0.3;

        if (spendings > maxRebate){
            return maxRebate;
        }

        return spendings;
    }

    public double netTax(){
        return (grossTax() - taxRebate());
    }

    public String toString(){
        return "Imposto bruto total: " + NumberFormatter.numberFormatter(grossTax()) + "\n" +
                "Abatimento: " + NumberFormatter.numberFormatter(taxRebate()) + "\n" +
                "Imposto devido: " + NumberFormatter.numberFormatter(netTax());
    }

}
