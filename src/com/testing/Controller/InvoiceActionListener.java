package com.testing.Controller;

import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceLine;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author We'am Kamal
 * @Date Jan.2023
 */
public class InvoiceActionListener extends Component {
    double total = 0.0;
    double price=0.0;
    InvoiceLine invoiceLine = new InvoiceLine();
    InvoiceHeader invoiceHeader = new InvoiceHeader();
    ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
    int n = invoiceHeader.getInvoiceNum();


    public void actionSelected(int num) {
        switch (num){
            case 1: createNewInvoice(); break;
            case 2: saveFile(); break;
            case 3: deleteExistingInvoice(); break;
            case 4: showSavedInvoice(); break;
            case 5: cancelLineCreation(); break;
        }
    }

    private void createNewInvoice() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Customer Name: ");
            invoiceHeader.setCustomerName(sc.nextLine());
            System.out.println("Enter the Invoice Number: ");
            invoiceHeader.setInvoiceNum(Integer.parseInt(sc.nextLine()));
            System.out.println("Enter the Date in form of"+" dd"+"-"+"mm"+"-"+"yyyy:");
            invoiceHeader.setInvoiceDate(sc.nextLine());
            n= invoiceHeader.getInvoiceNum();
            System.out.println();
            for(int i=0; i<n; i++) {
                System.out.println("Enter the Item Name: ");
                invoiceLine.setItemName(sc.nextLine());
                System.out.println("Enter the Item price: ");
                invoiceLine.setItemPrice(sc.nextInt());
                System.out.println("Enter the Item Quantity : ");
                invoiceLine.setItemCount(sc.nextInt());
                System.out.println();
                //Calculating the total amount
                total = total + (invoiceLine.getItemPrice()*invoiceLine.getItemCount());
            }
    }

    private void saveFile() {
        String headerString = "";
        String lineString = "";

        for (InvoiceHeader header : invoiceHeader.getInvoiceHeaders()) {
            try {
                headerString += header.saveHeaderData();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            headerString += "\n";
            for (InvoiceLine line : header.getInvoiceLines()) {
                lineString += line.saveLinesData();
                lineString += "\n";
            }
        }
        JFileChooser fileSelect = new JFileChooser();
        fileSelect.showOpenDialog(this);
        String filePath = fileSelect.getSelectedFile().getPath();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            int size = fis.available();
            byte[] b = new byte[size];
            fis.read(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {try {fis.close();} catch (IOException e) {}
        }
            System.out.println("Your data has been saved successfully");
    }
    private void deleteExistingInvoice() {}

    private void showSavedInvoice() {}

    private void cancelLineCreation() {}

}

