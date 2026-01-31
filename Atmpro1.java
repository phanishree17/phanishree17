package com.practice;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Atmpro1 {

    static Scanner sc = new Scanner(System.in);
    static double balance = 10000;
    static int pin = 1234;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== WELCOME TO ATM =====");
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Wrong PIN! Access Denied.");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + balance);
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    showHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }

    static void deposit() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            history.add("Deposited ₹" + amount + " on " + time());
            System.out.println("Deposit successful");
        } else {
            System.out.println("Invalid amount");
        }
    }

    static void withdraw() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn ₹" + amount + " on " + time());
            System.out.println("Withdraw successful");
        } else {
            System.out.println("Invalid or insufficient balance");
        }
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    static String time() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}
