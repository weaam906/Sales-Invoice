package com.testing.Controller;

import com.build.ActionsListenerInterface;
import com.testing.Model.InvoiceHeader;
import com.testing.Model.InvoiceLine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author We'am Kamal
 * @Date Jan.2023
 */
public class InvoiceActionListener implements ActionsListenerInterface {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    List<InvoiceHeader> invoiceHeaderList = new ArrayList<>();
    InvoiceLine invoiceLine = new InvoiceLine();
    InvoiceHeader invoiceHeader = new InvoiceHeader();

    @Override
    public void actionSelected(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "LoadFile": loadFile(); break;
            case "SaveFile": saveFile(); break;
            case "CreateNewInvoice": createNewInvoice(); break;
            case "AgreeInvoiceCreation": agreeInvoiceCreation(); break;
            case "DeleteExistedInvoice": deleteExistingInvoice(); break;
            case "CreateNewLine": createNewLine(); break;
            case "cancelLineCreation": cancelLineCreation(); break;
            case "DeleteExistedLine": deleteExistingLine(); break;
        }
    }

    private void loadFile() {}

    private void saveFile() {
        String headerString = "";
        String lineString= "";

        for(InvoiceHeader header: getInvoiceHeaderList()){
            headerString += header.saveHeaderData();
            headerString +="\n";
            for (InvoiceLine line: header.getInvoiceLines()){
                lineString += line.saveLinesData();
                lineString += "\n";
            }
        }
        JFileChooser fileSelect = new JFileChooser();
        File invoiceFile = fileSelect.getSelectedFile();
        try {
            System.out.println("Please select the header file");
            FileWriter headerFileWriter = new FileWriter(invoiceFile);
            headerFileWriter.write(headerString);
            headerFileWriter.flush();
            headerFileWriter.close();

            System.out.println("Please select the line file");
            FileWriter lineFileWriter = new FileWriter(invoiceFile);
            lineFileWriter.write(lineString);
            lineFileWriter.flush();
            lineFileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("Your data has been saved successfully");
    }

    private void createNewInvoice() {}

    private void agreeInvoiceCreation() {
        //   String itemName = invoiceLine.getItemName();
        //   String itemPriceString = String.valueOf(invoiceLine.getItemPrice());
        //   String itemCountString = String.valueOf(invoiceLine.getItemCount());
    }

    private void deleteExistingInvoice() {}

    private void createNewLine() {}

    private void cancelLineCreation() {}

    private void deleteExistingLine() {}


    public List<InvoiceHeader> getInvoiceHeaderList(){return invoiceHeaderList;}
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {}
}

