package com.testing.Model;

import com.build.TablesModelAbstractClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceLineTable extends TablesModelAbstractClass {

    private List<InvoiceLine> invoiceLines;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceLineTable(List<InvoiceLine> invoiceLines) {this.invoiceLines = invoiceLines;}
    public InvoiceLineTable() {}
    public List<InvoiceLine> getInvoiceLines() {return invoiceLines;}

    /* ******************************************* *
     * In this method, you get the number of Lines *
     * ******************************************* */
    @Override
    public int getRowCount() {return invoiceLines.size();}

    /* ****************************************************************** *
     * In this method, you get the number of data written inside the line *
     * ****************************************************************** */
    @Override
    public int getColumnCount() {return 4;}

    /* ************************************************************** *
     * In this method, you get the content of a certain line by index *
     * ************************************************************** */
    @Override
    public String getColumnContent(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Item Count";
            case 3:
                return "Item Total";
            default:
                return "";
        }
    }

    /* *********************************************************************** *
     * In this method, you get a certain line content of certain line by index *
     * *********************************************************************** */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine lineRow = invoiceLines.get(rowIndex);
        switch (columnIndex){
            case 0: return lineRow.getItemName();
            case 1: return lineRow.getItemPrice();
            case 2: return lineRow.getItemCount();
            case 3: return lineRow.getItemTotal();
            default: return "";
        }
    }
}
