package com.testing.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    /*Private data*/
    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine>invoiceLines;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    /*Default constructor*/
    public InvoiceHeader() {}

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    /*Setters*/
    public void setInvoiceNum(int invoiceNum) {this.invoiceNum = invoiceNum;}
    public void setInvoiceDate(Date invoiceDate){
        try {
            this.invoiceDate = new SimpleDateFormat().parse(invoiceDate.toString());
            //this.invoiceDate = invoiceDate;
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    /*Getters*/
    public int getInvoiceNum() {return invoiceNum;}
    public Date getInvoiceDate() {return invoiceDate;}
    public String getCustomerName() {return customerName;}
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
        String headerContent = "\tInvoiceHeader\t\n"+
                "Invoice Number=" + invoiceNum +",\n"+
                "Invoice Date=" + invoiceDate +",\n"+
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
    public String saveHeaderData(){
        return " " + getInvoiceNum() + ",\n"
                + dateFormat.format(getInvoiceDate()) + ",\n"
                + getCustomerName()+".";
    }
}


