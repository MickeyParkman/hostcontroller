/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import DatabaseUtilities.DatabaseExporter;
import DatabaseUtilities.DatabaseImporter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author dbennett3
 */
public class DatabaseImportFrame extends javax.swing.JFrame {

    private javax.swing.JPanel contentPane;
    private javax.swing.JButton ImportSubmitButton;
    private javax.swing.JCheckBox SelectAllCheck;
    private javax.swing.JScrollPane TableListPanel;
    private javax.swing.JList TableList;
    private List<String> names = new ArrayList<String>();
    private List<String> fileNames = new ArrayList<String>();
    private String zipName;
    
    /**
     * Creates new form DatabaseExportFrame
     */
    public DatabaseImportFrame(String zipName) throws IOException {
        this.zipName = zipName;
        initTableList();
        initComponents();
    }
    
    private void initTableList() throws IOException
    {
        System.out.println(zipName);
        ZipFile zip = new ZipFile(new File(zipName));
        ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
        for(ZipEntry e; (e = zin.getNextEntry()) != null;) {
            String fileName = e.toString();
            fileNames.add(fileName);
            names.add(fileName);
            //names.add(fileName);
            /*
            if(fileName.contains("CAPABILITY")) {
                names.add("CAPABILITY");
            }else if(fileName.contains("PREFERENCE")) {
                names.add("PREFERENCE");
            }else if(fileName.contains("AIRFIELD")) {
                names.add("AIRFIELD");
            }else if(fileName.contains("RUNWAY")) {
                names.add("RUNWAY");
            }else if(fileName.contains("GLIDERPOSITION")) {
                names.add("GLIDERPOSITION");
            }else if(fileName.contains("WINCHPOSITION")) {
                names.add("WINCHPOSITION");
            }else if(fileName.contains("PARACHUTE")) {
                names.add("PARACHUTE");
            }else if(fileName.contains("PILOT")) {
                names.add("PILOT");
            }else if(fileName.contains("PROFILE")) {
                names.add("PROFILE");
            }else if(fileName.contains("GLIDER")) {
                names.add("GLIDER");
            }else if(fileName.contains("Messages")) {
                names.add("Messages");
            }
            */
        }
    }
    
    private JFrame getFrame()
    {
        return this;
    }
    
    
    private void initComponents() {
        setTitle("Import tables");
        TableListPanel = new javax.swing.JScrollPane();
        TableList = new javax.swing.JList();
        ImportSubmitButton = new javax.swing.JButton();
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
        JButton submitButton = new JButton("Import");
        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        
                        List<String> selectedTables = new ArrayList<String>();
                        selectedTables = TableList.getSelectedValuesList();
                        
                        int[] selectedIndices;
                        selectedIndices = TableList.getSelectedIndices();

                        for(String p : selectedTables) {
                            System.out.println(p);
                        }
                        
                        for(int i : selectedIndices) {
                            System.out.println(fileNames.get(i));
                        }

                        try{
                            DatabaseImporter.importDatabase(fileNames);
                            getFrame().dispose();
                        }catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Couldn't import", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
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
