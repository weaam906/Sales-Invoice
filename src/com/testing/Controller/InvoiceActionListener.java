package com.testing.Controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceLine;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            case 2: saveFile(); break;
            case 3: deleteExistingInvoice(); break;
            case 4: showSavedInvoice(); break;
            case 5: cancelLineCreation(); break;
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
            n= invH.getInvoiceNum();
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
        addNewHeader(invH);
    }

    private void saveFile() {
   //    String headerString = "";
   //    String lineString = "";

   //    for (InvoiceHeader header : invoiceHeader.getInvoiceHeaders()) {
   //        try {
   //            headerString += header.saveHeaderData();
   //        } catch (ParseException e) {
   //            e.printStackTrace();
   //        }
   //        headerString += "\n";
   //        for (InvoiceLine line : header.getInvoiceLines()) {
   //            lineString += line.saveLinesData();
   //            lineString += "\n";
   //        }
   //    }
   //    JFileChooser fileSelect = new JFileChooser();
   //    fileSelect.showOpenDialog(this);
   //    String filePath = fileSelect.getSelectedFile().getPath();
   //    FileInputStream fis = null;
   //    try {
   //        fis = new FileInputStream(filePath);
   //        int size = fis.available();
   //        byte[] b = new byte[size];
   //        fis.read(b);

   //    } catch (FileNotFoundException e) {
   //        e.printStackTrace();
   //    } catch (IOException e) {
   //        e.printStackTrace();
   //    }
   //    finally {try {fis.close();} catch (IOException e) {}
   //    }
                 // first create file object for file placed at location
            try{
                File file = new File(headerFilePath);


        try {
                // create FileWriter object with file as parameter
                FileWriter outputFile = new FileWriter(file);

                // create CSVWriter object fileWriter object as parameter
                CSVWriter writer = new CSVWriter(outputFile);

                // adding header to csv
                String[] header = {};

                writer.writeNext(header);

                // add data to csv
            for(int i=0;i< invoiceHeaders.size();i++){
               invoiceHeader = invoiceHeaders.get(i);
                header[0]= String.valueOf(invoiceHeader.getInvoiceNum());
                header[1]= String.valueOf(invoiceHeader.getInvoiceDate());
                header[2]= invoiceHeader.getCustomerName();
            }
                writer.writeNext(header);
                // closing writer connection
                writer.close();
            System.out.println("Your data has been saved successfully");
        }
            catch (IOException e) {
                e.printStackTrace();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    private void deleteExistingInvoice() {}

    private void showSavedInvoice(){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(headerFilePath));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void cancelLineCreation() {}

    private void addNewHeader(InvoiceHeader inv_H) {
        invoiceHeaders.add(inv_H);
    }
}

