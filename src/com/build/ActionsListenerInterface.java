package com.build;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;

public interface ActionsListenerInterface {

    public void actionSelected(ActionEvent actionEvent);
    public void valueChanged(ListSelectionEvent listSelectionEvent);
}
