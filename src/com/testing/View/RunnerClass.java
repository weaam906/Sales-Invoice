package com.testing.View;

import com.testing.Controller.InvoiceActionListener;
import com.testing.Model.InvoiceHeader;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String args[]) {
        InvoiceActionListener i = new InvoiceActionListener();
        InvoiceHeader invoiceHeader = new InvoiceHeader();
        Scanner sc = new Scanner(System.in);
        int selectedOption;
        while(true){
            System.out.println("Select an action");
            System.out.println("1- Create New Invoice");
            System.out.println("2- Save Invoice");
            System.out.println("3- Delete Existed Invoice");
            System.out.println("4- Show Saved Invoice");
            System.out.println("5- Cancel Line Creation");
            selectedOption = sc.nextInt();
            i.actionSelected(selectedOption);
            System.out.println("Invoice Generated!");
        }


    }
}
