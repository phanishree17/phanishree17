package com.practice;

import java.util.Scanner;   // IMPORTANT LINE

public class Number 
{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // No error now

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("You entered: " + num);

        sc.close();
    }
}
