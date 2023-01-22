package com.testing.View;

import com.testing.Controller.InvoiceActionListener;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String args[]) {
        InvoiceActionListener i = new InvoiceActionListener();
        Scanner sc = new Scanner(System.in);
        int selectedOption;
        while(true){
            System.out.println("Select an action");
            System.out.println("1- Create New Invoice");
            System.out.println("2- Show Saved Invoice");
            selectedOption = sc.nextInt();
            i.actionSelected(selectedOption);
            System.out.println("Invoice Generated!");
        }


    }
}
