/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bigbank;

import java.time.Year;
import java.util.Scanner;
/**
 *
 * @author BIG44
 */
public class Accounts {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;
    
    //Class constructor
    Accounts(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }
    
    //Function that allows user to deposit m9oney
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    
    //Function for withdrawing money
    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = amount;
        }
    }
    
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: R" + previousTransaction);
        }else if (previousTransaction < 0){
            System.out.println("Withdrew: R" + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction occured");
        }
    }
    
    //Function for calculating interest for current funds after a number of years
    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalannce = (balance * interestRate * years + balance);
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be R " + newBalannce);
    }
    
    //Function shwing main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. EXIT");
        
        
        do {            
           System.out.println();
           System.out.println("Enter an option: ");
           char option1 = scanner.next().charAt(0);
           option = Character.toUpperCase(option1);
           System.out.println();
           
            switch (option) {
                //Case A allows user to check their account balance
                case 'A':
                    System.out.println("********************************");
                    System.out.println("Balance = R" + balance);
                    System.out.println("********************************");
                    System.out.println();
                    break;
                //Case B allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter the amount you would like to deposit");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //Case C allows the user to withdraw money from their bank account
                case 'C':
                    System.out.println("Enter the amount you would like to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case D allows the user to view previous transaction
                case 'D':
                    System.out.println("********************************");
                    getPreviousTransaction();
                    System.out.println("********************************");
                    System.out.println();
                    break;
                //Case E allows the user to calculate the interest
                case 'E':
                    System.out.println("********************************");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //Case F exits the user from their account
                case 'F': 
                    System.out.println("********************************");
                    break;
                //The deafault case lets the user know that they have typed in an incorrect selection
                default:
                    System.out.println("ERROR: Invalid option. Please enter A, B, C, D, E or F");
                    break;
            }
           
        } while (option != 'F');
        System.out.println("Thank You for banking with us!");
    }
}
