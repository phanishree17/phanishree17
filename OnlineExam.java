package com.practice;
import java.util.*;
import java.util.concurrent.*;

public class OnlineExam {

    // ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    static Scanner sc = new Scanner(System.in);
    static Map<Integer, String> answers = new HashMap<>();
    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {

        System.out.println(BLUE + "=================================" + RESET);
        System.out.println(CYAN + "      WELCOME TO ONLINE EXAM      " + RESET);
        System.out.println(BLUE + "=================================" + RESET);

        System.out.print(YELLOW + "Enter your name: " + RESET);
        String name = sc.nextLine();

        System.out.println(GREEN + "\nHello " + name + ", Exam will start now!" + RESET);
        System.out.println(RED + "You have 30 seconds to complete the test.\n" + RESET);

        startTimer(30); // 30 seconds timer

        String[] questions = {
                "1. Java is a ?\nA. Programming Language\nB. OS\nC. Browser\nD. App",
                "2. Which is not a data type?\nA. int\nB. float\nC. char\nD. string",
                "3. Which keyword is used to create object?\nA. class\nB. new\nC. public\nD. void",
                "4. DSA stands for?\nA. Data System Algorithm\nB. Data Structure Algorithm\nC. Data Structure and Algorithm\nD. Digital System Algorithm",
                "5. Which loop runs at least once?\nA. for\nB. while\nC. do-while\nD. foreach"
        };

        String[] correctAns = {"A", "D", "B", "C", "C"};

        for (int i = 0; i < questions.length; i++) {
            if (timeUp) break;

            System.out.println(YELLOW + "\n" + questions[i] + RESET);
            System.out.print(CYAN + "Enter answer (A/B/C/D): " + RESET);
            String ans = sc.nextLine().toUpperCase();
            answers.put(i, ans);
        }

        for (int i = 0; i < correctAns.length; i++) {
            if (answers.containsKey(i) && answers.get(i).equals(correctAns[i])) {
                score++;
            }
        }

        System.out.println(BLUE + "\n================ RESULT ================" + RESET);
        System.out.println(GREEN + "Student Name: " + name + RESET);
        System.out.println("Total Questions: " + questions.length);
        System.out.println(GREEN + "Correct Answers: " + score + RESET);
        System.out.println(RED + "Wrong Answers: " + (questions.length - score) + RESET);
        System.out.println("Score Percentage: " + (score * 100 / questions.length) + "%");

        if (score >= 3)
            System.out.println(GREEN + "Status: PASS ✅" + RESET);
        else
            System.out.println(RED + "Status: FAIL ❌" + RESET);

        System.out.println(BLUE + "=======================================" + RESET);
    }

    static void startTimer(int seconds) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            timeUp = true;
            System.out.println(RED + "\n⏰ TIME UP! Exam Auto Submitted." + RESET);
        }, seconds, TimeUnit.SECONDS);
    }
}
