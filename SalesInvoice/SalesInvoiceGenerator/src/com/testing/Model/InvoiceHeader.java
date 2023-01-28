package com.testing.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader{
    /*Private data*/
    private int invoiceNum;
    private static int invoiceID;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine>invoiceLines;
    private ArrayList<InvoiceHeader> invoiceHeaders;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    /*Default constructor*/
    public InvoiceHeader() {
        invoiceID++;
    }

    public InvoiceHeader(int invoiceNum, String invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        invoiceID++;
    }

    /*Setters*/
    public void setInvoiceNum(int invoiceNum) {
        try {
            if (invoiceNum >0 && invoiceNum %1 == 0) {
                this.invoiceNum = invoiceNum;
            }
        }catch (Exception e){
            System.out.println("Wrong number, try again");
            System.out.println(e.getMessage());
        }
    }
    public void setInvoiceDate(String invoiceDate){
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(invoiceDate);
            this.invoiceDate = invoiceDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);
    }
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
    public void setInvoiceHeaders(ArrayList<InvoiceHeader> invoiceHeaders) {this.invoiceHeaders = invoiceHeaders;}

    /*Getters*/
    public int getInvoiceNum() {return invoiceNum;}
    public static int getInvoiceID(){return invoiceID;}
    public Date getInvoiceDate() throws ParseException {return dateFormat.parse(invoiceDate);}
    public String getCustomerName() {return customerName;}
    public ArrayList<InvoiceHeader> getInvoiceHeaders() {
        if(invoiceHeaders ==null){invoiceHeaders = new ArrayList<>();}
        return invoiceHeaders;
    }
    public ArrayList<InvoiceLine> getInvoiceLines() {
        if(invoiceLines == null) {invoiceLines = new ArrayList<>();}
        return invoiceLines;
    }
    /* ********************************************************************* *
     *  Desc: This method prints a header string contains all the data       *
     *        should be in the header as Inv.no, Inv.Date and cust.Name for  *
     *        each invoiceLine added to the queue till the queue is empty    *
     *  Inputs: N/A                                                          *
     *  Outputs: String of header data                                       *
     * ********************************************************************* */
    @Override
    public String toString() {
        String headerContent =
                //"\tInvoiceHeader\t\n"+
                "Invoice Number=" + invoiceNum +", "+
                "Invoice Date=" + invoiceDate +", "+
                "Customer Name=" + customerName +".";
        for(InvoiceLine line: getInvoiceLines()){
            headerContent += "\n\t" +line;
        }
        return headerContent;
    }


    /* **************************************************** *
     *  Desc: This method prints the total of invoice items *
     *  Inputs: N/A                                         *
     *  Outputs: double of the items total price            *
     * **************************************************** */
    public double getInvoiceTotalNumber() {
        double total = 0.0;
        for(InvoiceLine line: getInvoiceLines()){
            total += line.getItemTotal();
        }
        return total;
    }


    /* **************************************** *
     *  Desc: This method adds the InvoiceLines *
     *  Inputs: InvoiceLine object              *
     *  Outputs: N/A                            *
     * **************************************** */
    public void addInvLine(InvoiceLine line){getInvoiceLines().add(line);}


    /* ********************************************** *
     *  Desc: This method prints the saved headerData *
     *  Inputs: N/A                                   *
     *  Outputs: String of header data                *
     * ********************************************** */
    public String saveHeaderData() throws ParseException {
        return " " + getInvoiceNum() + ",\n"
                + dateFormat.format(getInvoiceDate()) + ",\n"
                + getCustomerName()+".";
    }

}


