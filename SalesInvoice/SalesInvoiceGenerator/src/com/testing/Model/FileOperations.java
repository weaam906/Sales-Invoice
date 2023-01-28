package com.testing.Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {
   public FileInputStream file;
   public ArrayList<InvoiceHeader> invoiceHeaders;

public ArrayList<InvoiceHeader> readHeaderFile(){
        try {
            file = new FileInputStream("SalesInvoice/Files/InvoiceHeader.csv");
            int size = file.available();
            for(int i=0;i<size;i++){
                file.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {file.close();} catch (IOException e) {}
        }
    return invoiceHeaders;
}

public void writeHeaderFile(ArrayList<InvoiceHeader> invoiceHeaders){

}

}
