package com.testing.Model;

public class InvoiceLine {

    private String itemName;
    private double itemPrice;
    private int itemCount;
    private InvoiceHeader invoiceHeader;

    /*Default constructor*/
    public InvoiceLine(){}

    /*Parametrized constructor*/
    public InvoiceLine(String itemName, double itemPrice, int itemCount, InvoiceHeader invoiceHeader) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.invoiceHeader = invoiceHeader;

    }


    /*Setters*/
    public void setItemName(String itemName) {this.itemName = itemName;}
    public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}
    public void setItemCount(int itemCount) {this.itemCount = itemCount;}
    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {this.invoiceHeader = invoiceHeader;}

    /*Getters*/
    public String getItemName() {return itemName;}
    public double getItemPrice() {return itemPrice;}
    public int getItemCount() {return itemCount;}
    public InvoiceHeader getInvoiceHeader() {return invoiceHeader;}

    /* ********************************************************************* *
     *  Desc: This method prints a line string contains all the data should  *
     *        be in the line as Item name, item price and item count         *
     *  Inputs: N/A                                                          *
     *  Outputs: String of line data                                         *
     * ********************************************************************* */
    @Override
    public String toString() {
        return  "\tInvoiceLines\t\n" +
                "itemName=" + itemName + ",\n"+
                " itemPrice=" + itemPrice + ",\n"+
                " itemCount=" + itemCount + ".";
    }


    /* **************************************** *
     *  Desc: This method gets the invoice total*
     *  Inputs: N/A                             *
     *  Outputs: Invoice total                  *
     * **************************************** */
    public double getItemTotal(){return itemPrice * itemCount;}


    /* ************************************* ****** *
     *  Desc: This method prints the saved LineData *
     *  Inputs: N/A                                 *
     *  Outputs: String of line data                *
     * ******************************************** */
    public String saveLinesData(){
        return "" + getInvoiceHeader().getInvoiceNum() + ",\n"
                + getItemName() + ",\n"
                + getItemPrice() + ",\n"
                + getItemCount()+".";
    }
}
