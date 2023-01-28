package com.build;

import java.text.ParseException;

public abstract class TablesModelAbstractClass {
    public int getRowCount() {return 0;}
    public int getColumnCount() {return 0;}
    public String getColumnContent(int columnIndex){return "";}
    public Object getValueAt(int rowIndex, int columnIndex) throws ParseException {return "";}

}
