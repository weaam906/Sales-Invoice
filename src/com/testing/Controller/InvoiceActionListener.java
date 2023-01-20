package com.testing.Controller;

import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceLine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author We'am Kamal
 * @Date Jan.2023
 */
public class InvoiceActionListener{
    double total = 0.0;
    double price=0.0;
   // private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
   //     String headerString = "";
   //     String lineString= "";
//
   //     for(InvoiceHeader header: getInvoiceHeaderList()){
   //         headerString += header.saveHeaderData();
   //         headerString +="\n";
   //         for (InvoiceLine line: header.getInvoiceLines()){
   //             lineString += line.saveLinesData();
   //             lineString += "\n";
   //         }
   //     }
   //     JFileChooser fileSelect = new JFileChooser();
   //     File invoiceFile = fileSelect.getSelectedFile();
   //     try {
   //         System.out.println("Please select the header file");
   //         FileWriter headerFileWriter = new FileWriter(invoiceFile);
   //         headerFileWriter.write(headerString);
   //         headerFileWriter.flush();
   //         headerFileWriter.close();
//
   //         System.out.println("Please select the line file");
   //         FileWriter lineFileWriter = new FileWriter(invoiceFile);
   //         lineFileWriter.write(lineString);
   //         lineFileWriter.flush();
   //         lineFileWriter.close();
//
   //     } catch (IOException e) {
   //         e.printStackTrace();
   //         System.out.println(e.getMessage());
   //     }
   //     System.out.println("Your data has been saved successfully");
    }

    private void deleteExistingInvoice() {}

    private void showSavedInvoice() {
     //      //get the page
     //      PDPage mypage = invc.getPage(0);
     //      try {
     //          //Prepare Content Stream
     //          PDPageContentStream cs = new PDPageContentStream(invc, mypage);

     //          //Writing Single Line text
     //          //Writing the Invoice title
     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 20);
     //          cs.newLineAtOffset(140, 750);
     //          cs.showText(invoiceHeader.toString());
     //          cs.endText();

     //          //Writing Multiple Lines
     //          //writing the customer details
     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(60, 610);
     //          cs.showText("Customer Name: ");
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(170, 610);
     //          cs.showText(invoiceHeader.getCustomerName());
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.newLineAtOffset(80, 540);
     //          cs.showText("Product Name");
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.newLineAtOffset(200, 540);
     //          cs.showText("Price");
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.newLineAtOffset(310, 540);
     //          cs.showText("Quantity");
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 12);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(80, 520);
     //          invoiceLines = invoiceHeader.getInvoiceLines();
     //          for(int i =0; i<n; i++) {
     //              cs.showText(invoiceLines.get(i).getItemName());
     //              cs.newLine();
     //          }
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 12);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(200, 520);
     //          for(int i =0; i<n; i++) {
     //              cs.showText(invoiceLines.get(i).getItemPrice());
     //              cs.newLine();
     //          }
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 12);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(310, 520);
     //          for(int i =0; i<n; i++) {
     //              cs.showText(invoiceLines.get(i).getItemCount());
     //              cs.newLine();
     //          }
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 12);
     //          cs.setLeading(20f);
     //          cs.newLineAtOffset(410, 520);
     //          for(int i =0; i<n; i++) {
     //              price = invoiceLines.get(i).getItemPrice()*invoiceLines.get(i).getItemCount();
     //              cs.showText((price));
     //              cs.newLine();
     //          }
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          cs.newLineAtOffset(310, (500-(20*n)));
     //          cs.showText("Total: ");
     //          cs.endText();

     //          cs.beginText();
     //          cs.setFont(PDType1Font.TIMES_ROMAN, 14);
     //          //Calculating where total is to be written using number of products
     //          cs.newLineAtOffset(410, (500-(20*n)));
     //          cs.showText(total);
     //          cs.endText();

     //          //Close the content stream
     //          cs.close();
     //          //Save the PDF
     //          //invc.save("C:\Users\rajla\Documents\eclipse-workspace\Pdf");
     //          invc.save("INVOICE.Pdf");

     //      } catch (IOException e) {
     //          e.printStackTrace();
     //      }
    }

    private void cancelLineCreation() {}

}

