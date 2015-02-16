/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import DatabaseUtilities.DatabaseExporter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author dbennett3
 */
public class DatabaseExportFrame extends javax.swing.JFrame {

    private javax.swing.JPanel contentPane;
    private javax.swing.JButton ExportSubmitButton;
    private javax.swing.JCheckBox SelectAllCheck;
    private javax.swing.JScrollPane TableListPanel;
    private javax.swing.JList TableList;
    private List<String> names = new ArrayList<String>();
    
    /**
     * Creates new form DatabaseExportFrame
     */
    public DatabaseExportFrame() {
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
    
    private JFrame getFrame()
    {
        return this;
    }
    
    
    private void initComponents() {
        setTitle("Database Export");
        TableListPanel = new javax.swing.JScrollPane();
        TableList = new javax.swing.JList();
        ExportSubmitButton = new javax.swing.JButton();
        SelectAllCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 100, 600, 400));
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        
        TableList.setPreferredSize(new Dimension(500,300));
        DefaultListModel tableModel = new DefaultListModel();
        for(Object str : names) {
            tableModel.addElement(str);
        }
        TableList.setModel(tableModel);
        TableListPanel.setViewportView(TableList);
        
        contentPane.add(TableList, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        JButton submitButton = new JButton("Export");
        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        List<String> selectedTables = new ArrayList<String>();
                        selectedTables = TableList.getSelectedValuesList();
                        try{
                            DatabaseExporter.exportDatabase(selectedTables, "MyZip.zip");
                            getFrame().dispose();
                        }catch(Exception e)
                        { }
                        
                    }                      
                });
        panel.add(submitButton);
        
        JCheckBox selectAll = new JCheckBox();
        selectAll.setLabel("Select all");
        selectAll.addItemListener(new ItemListener() 
            {
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                    if(e.getStateChange() == ItemEvent.SELECTED)
                    {
                        int[] indices = new int[names.size()];
                        for(int iter = 0; iter < names.size(); iter++)
                        {
                            indices[iter] = iter;
                        }
                        TableList.setSelectedIndices(indices);
                        TableList.setEnabled(false);
                    } 
                    else
                    {
                        TableList.clearSelection();
                        TableList.setEnabled(true);
                    }
                }
            });
        panel.add(selectAll);
        

    }               


}
