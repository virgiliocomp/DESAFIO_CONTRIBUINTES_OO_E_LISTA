package application;

import entities.TaxPayer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        List<TaxPayer> taxPayers = new ArrayList<>();

        int contributorsAmount;
        double salaryIncome;
        double servicesIncome;
        double capitalIncome;
        double healthSpending;
        double educationSpending;


        System.out.print("Quantos contribuintes você vai digitar? ");
        contributorsAmount = sc.nextInt();

        System.out.println();

        for (int i = 0; i < contributorsAmount; i++) {
            System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
            System.out.print("Renda anual com salário: ");
            salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviços: ");
            servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            educationSpending = sc.nextDouble();
            taxPayers.add( new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
        }

        for (int i = 0; i < taxPayers.size(); i++){
            System.out.println("\nResumo do " + (i + 1) + "o contribuinte:");
            System.out.println(taxPayers.get(i));
        }

    }
}
