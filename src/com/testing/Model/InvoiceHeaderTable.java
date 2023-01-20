package com.testing.Model;

import com.build.TablesModelAbstractClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceHeaderTable extends TablesModelAbstractClass {

    private List<InvoiceHeader> invoiceHeaders;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public InvoiceHeaderTable(List<InvoiceHeader> invoiceHeaders) {this.invoiceHeaders = invoiceHeaders;}

    public InvoiceHeaderTable() {}

    public List<InvoiceHeader> getInvoiceHeaders() {return invoiceHeaders;}

    /* ********************************************* *
     * In this method, you get the number of headers *
     * ********************************************* */
    @Override
    public int getRowCount() {return invoiceHeaders.size();}


    /* ******************************************************************** *
     * In this method, you get the number of data written inside the header *
     * ******************************************************************** */
    @Override
    public int getColumnCount() {return 4;}  // 1-Inv.no 2-Inv.date 3-Customer.name 4-Inv.total


    /* ************************************************************** *
     * In this method, you get the content of a certain line by index *
     * ************************************************************** */
    @Override
    public String getColumnContent(int columnIndex) {
        switch (columnIndex){
            case 0: return "Number";
            case 1: return "Date";
            case 2: return "Customer Name";
            case 3: return "Total items";
            default: return "";
        }
    }


    /* ************************************************************************* *
     * In this method, you get a certain header content of certain line by index *
     * ************************************************************************* */
    @Override
    public Object getValueAt(int rowIndex,int columnIndex) {
        InvoiceHeader headerRow = invoiceHeaders.get(rowIndex);
        switch (columnIndex){
            case 0: return headerRow.getInvoiceNum();
            case 1: return headerRow.getInvoiceDate();
            case 2: return headerRow.getCustomerName();
            case 3: return headerRow.getInvoiceTotalNumber();
            default: return "";
        }
    }
}
