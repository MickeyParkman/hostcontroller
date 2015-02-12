/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author dbennett3
 */
public class TableListFrame extends javax.swing.JPanel {

    private javax.swing.JScrollPane TableListPane;
    private javax.swing.JList TableList;
    private List<String> names = new ArrayList<String>();
    /**
     * Creates new form TableListFrame
     */
    public TableListFrame() {
        initTableList();
        initComponents();
    }
    
    private void initTableList()
    {
        try {
            names = DatabaseUtilities.DatabaseDataObjectUtilities.getTables();
        }catch(Exception e) {
        }
    }    
    
    private void initComponents() {
        TableListPane = new JScrollPane();
        TableList = new JList();
        
        TableList.setPreferredSize(new Dimension(500,300));
        DefaultListModel tableModel = new DefaultListModel();
        for(Object str : names) {
            tableModel.addElement(str);
        }
        TableList.setModel(tableModel);
        TableListPane.setViewportView(TableList);
        
    }



}
