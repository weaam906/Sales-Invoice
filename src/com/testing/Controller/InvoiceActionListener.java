package com.testing.Controller;

import com.opencsv.CSVReader;
import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceLine;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author We'am Kamal
 * @Date Jan.2023
 */
public class InvoiceActionListener extends Component {
    double total = 0.0;
    double price=0.0;
    String headerFilePath="D://My Data//work//FWD//Sales Invoice//src//InvoiceHeader.csv";
    String lineFilePath="D://My Data//work//FWD//Sales Invoice//src//InvoiceLine.csv";
    InvoiceHeader invoiceHeader = new InvoiceHeader();
    ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
    ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<InvoiceHeader>();
    int n = invoiceHeader.getInvoiceNum();


    public void actionSelected(int num) {
        switch (num){
            case 1: createNewInvoice(); break;
            case 2: showSavedInvoice(); break;
        }
    }

    public void createNewInvoice() {
        InvoiceHeader invH = new InvoiceHeader();
        InvoiceLine invL = new InvoiceLine();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Customer Name: ");
            invH.setCustomerName(sc.nextLine());
            System.out.println("Enter the Invoice Number: ");
            invH.setInvoiceNum(Integer.parseInt(sc.nextLine()));
            System.out.println("Enter the Date in form of"+" dd"+"-"+"mm"+"-"+"yyyy:");
            invH.setInvoiceDate(sc.nextLine());
        try {
            System.out.println(invH.getInvoiceDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        n= invH.getInvoiceNum();
            System.out.println(invH);
        System.out.println("Inv header added successfully");
            for(int i=0; i<n; i++) {
                System.out.println("Enter the Item Name: ");
                invH.addInvLine(invL);
                invL.setItemName(sc.nextLine());
                System.out.println("Enter the Item price: ");
                invL.setItemPrice(sc.nextInt());
                System.out.println("Enter the Item Quantity : ");
                invL.setItemCount(sc.nextInt());
                System.out.println();
                //Calculating the total amount
                total = total + (invL.getItemPrice()*invL.getItemCount());
            }
            System.out.println(invL);
        addNewHeader(invH);
        saveInvoiceHeaderFile(invH);
        saveInvoiceFile(invL,invH);
    }

    private void showSavedInvoice(){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(headerFilePath));
            try{
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> records = csvReader.readAll();
                for (String[] record : records) {
                    for(int i =0;i<invoiceHeaders.size();i++){
                        System.out.println("Invoice"+i+"Num {");
                        invoiceHeader = invoiceHeaders.get(i);
                        System.out.println(invoiceHeader.toString()) ;
                        System.out.println(record[0]+", "+record[1]+", "+record[2]);
                    }
                }
            }catch (FileNotFoundException e) {
                if (!reader.ready()) {
                    System.out.println(headerFilePath + " does not exist!");
                    System.exit(0);
                    e.printStackTrace();
                }
            }catch ( IllegalFormatException e){
                System.out.println(headerFilePath + " File has wrong data format!");
                System.exit(0);
                e.printStackTrace();
            }catch (UTFDataFormatException e){
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewHeader(InvoiceHeader inv_H) {

        invoiceHeaders.add(inv_H);
    }

    private void saveInvoiceHeaderFile(InvoiceHeader invoiceHeader){
        try {
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            File file = new File(headerFilePath);
            System.out.println(file.getPath());
            FileWriter outputFile = new FileWriter(file.getPath(), true);
            try {
                outputFile.append((char) invoiceHeader.getInvoiceNum());
                outputFile.append(",");
                outputFile.append(formatter.format(invoiceHeader.getInvoiceDate()));
                outputFile.append(",");
                outputFile.append(invoiceHeader.getCustomerName());
                outputFile.append(",\n");
                outputFile.flush();
                outputFile.close();
            }catch (FileNotFoundException e) {   // 1- File not found exception
                if (!file.exists()) {
                    System.out.println(file.getPath()+ "File not found!");
                    System.exit(0);
                    e.printStackTrace();
                }
            }
        }catch (IllegalFormatException e){    // 2- Wrong file format exception
            System.out.println("Wrong file format!");
            System.exit(0);
            e.printStackTrace();

        }catch (InvalidPathException e) { // 3-Folder/File path is not found exception
            System.out.println("File path is not found!");
            System.exit(0);
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveInvoiceFile(InvoiceLine invoiceLine, InvoiceHeader invoiceHeader){
        try {
            File file = new File(lineFilePath);
            FileWriter outputFile = new FileWriter("InvoiceLine.csv", true);
            invoiceHeader.addInvLine(invoiceLine);
            try{
                outputFile.append((CharSequence) invoiceLine.getInvoiceHeader());
                outputFile.append(",");
                outputFile.append(invoiceLine.getItemName());
                outputFile.append(",");
                outputFile.append((char) invoiceLine.getItemPrice());
                outputFile.append(",");
                outputFile.append((char) invoiceLine.getItemCount());
                outputFile.append(",\n");
                outputFile.flush();
                outputFile.close();
            }catch (FileNotFoundException e) {   // 1- File not found exception
                if (!file.exists()) {
                    System.out.println(file.getPath()+ "File not found!");
                    System.exit(0);
                    e.printStackTrace();
                }
            }
        }catch (IllegalFormatException e){    // 2- Wrong file format exception
            System.out.println("Wrong file format!");
            System.exit(0);
            e.printStackTrace();

        }catch (InvalidPathException e) { // 3-Folder/File path is not found exception
            System.out.println("File path is not found!");
            System.exit(0);
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

