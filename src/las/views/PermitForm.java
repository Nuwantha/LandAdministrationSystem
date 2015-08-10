/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.views;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import las.common_classes.ComboItemAdder;
import las.controllers.ClientController;
import las.controllers.GramaNiladariDivisionController;
import las.controllers.LandController;
import las.controllers.LotController;
import las.controllers.NominatedSuccessorController;
import las.controllers.PermitController;
import las.models.Client;
import las.models.GramaNiladariDivision;
import las.models.Land;
import las.models.Lot;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 *
 * @author H.P. Asela
 */
public class PermitForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form PermitForm
     */
    public PermitForm() {
        initComponents();

        //edit permit 
        editpermit_permit_number_combo.setEditable(true);
        JTextComponent editorEditPemitPNCombo = (JTextComponent) editpermit_permit_number_combo.getEditor().getEditorComponent();
        editorEditPemitPNCombo.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) editpermit_permit_number_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    ArrayList<Permit> simmilarPlanNumbers = PermitController.getSimmilarPlanNumbers(item);
                    for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                        list.add(simmilarPlanNumbers.get(i).getPermitNumber());
                    }
                    ComboItemAdder.addItemToCombo(list, editpermit_permit_number_combo);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        
        add_permit_nic_combo.setEditable(true);
        JTextComponent editorAddPemitNICCombo = (JTextComponent) add_permit_nic_combo.getEditor().getEditorComponent();
        editorAddPemitNICCombo.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) add_permit_nic_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    
                    ArrayList<Client> simmilarNICs = ClientController.getSimmilarNICs(item);
                    for (int i = 0; i < simmilarNICs.size(); i++) {
                        list.add(simmilarNICs.get(i).getNIC());
                    }
                    ComboItemAdder.addItemToCombo(list, add_permit_nic_combo);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        
        add_permit_division_number_combo.setEditable(true);
        JTextComponent editorDivisionalNumberCombo = (JTextComponent) add_permit_division_number_combo.getEditor().getEditorComponent();
        
        editorDivisionalNumberCombo.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                
                add_permit_division_number_combo.setPopupVisible(true);
                String test = String.valueOf(add_permit_division_number_combo.getEditor().getItem());
                add_permit_division_number_combo.removeAllItems();
                try {
                    ArrayList<GramaNiladariDivision> simmilarGndDivisionNumbers = GramaNiladariDivisionController.getSimmilarGndDivisionNumbers(test);
                    for (GramaNiladariDivision simmilarGndDivisionNumber : simmilarGndDivisionNumbers) {
                        add_permit_division_number_combo.addItem(simmilarGndDivisionNumber.getDivisionNumber());
                    }
                    add_permit_division_number_combo.getEditor().setItem(test);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        AddGND = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddGNDNo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        AddNotSurveyedNorth = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        AddNotSurveyedEast = new javax.swing.JTextField();
        AddNotSurveyedSouth = new javax.swing.JTextField();
        AddNotSurveyedWest = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addpermit_permit_numberTest = new javax.swing.JTextField();
        Add_Save = new javax.swing.JButton();
        Add_Cancel = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        add_permit_landName_test = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        add_permit_division_name_test = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        add_permit_lot_number_Combo = new javax.swing.JComboBox();
        jLabel100 = new javax.swing.JLabel();
        add_permit_acres_test = new javax.swing.JTextField();
        add_permit_perches_test = new javax.swing.JTextField();
        add_permit_roods_test = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        add_permit_division_number_combo = new javax.swing.JComboBox();
        add_permit_planNumber_combo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addpermit_NOS_name_test = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        addpermit_NOS_nic_test = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addpermit_NOS_address_test = new javax.swing.JTextArea();
        nicInvalidLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        add_permit_nic_combo = new javax.swing.JComboBox();
        add_permit_nameText = new javax.swing.JTextField();
        add_permit_telephoneText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        add_permit_addressText = new javax.swing.JTextArea();
        add_permit_no_of_children_test = new javax.swing.JTextField();
        add_permit_marriedStatusRButton = new javax.swing.JRadioButton();
        add_permit_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        add_permit_annualIncome = new javax.swing.JTextField();
        add_permit_DOB_test = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addpermit_add_permit_button = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        AddGND1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AddGNDNo1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        AddNotSurveyedNorth1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        AddNotSurveyedEast1 = new javax.swing.JTextField();
        AddNotSurveyedSouth1 = new javax.swing.JTextField();
        AddNotSurveyedWest1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        editpermit_permit_number_combo = new javax.swing.JComboBox();
        Add_Save1 = new javax.swing.JButton();
        Add_Cancel1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        editpermit_landName_test = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        editpermit_division_name_test = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        editpermit_lot_number_Combo = new javax.swing.JComboBox();
        jLabel104 = new javax.swing.JLabel();
        editpermit_acres_test = new javax.swing.JTextField();
        editpermit_perches_test = new javax.swing.JTextField();
        editpermit_roods_test = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        editpermit_division_number_combo = new javax.swing.JComboBox();
        editpermit_planNumber_combo = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        editpermit_NOS_name_test = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        editpermit_NOS_nic_test = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        editpermit_NOS_address_test = new javax.swing.JTextArea();
        nicInvalidLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        editPermit_nic_combo = new javax.swing.JComboBox();
        editpermit_nameText = new javax.swing.JTextField();
        editpermit_telephoneText = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        editpermit_addressText = new javax.swing.JTextArea();
        editpermit_no_of_children_test = new javax.swing.JTextField();
        editpermit_marriedStatusRButton = new javax.swing.JRadioButton();
        editpermit_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        editpermit_annualIncome = new javax.swing.JTextField();
        editpermit_DOB_test = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        addpermit_add_permit_button1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setTitle("Permit");
        setPreferredSize(new java.awt.Dimension(960, 600));

        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane4.setPreferredSize(new java.awt.Dimension(581, 581));

        jPanel2.setPreferredSize(new java.awt.Dimension(950, 600));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Permit Information"));
        jPanel6.setPreferredSize(new java.awt.Dimension(581, 581));

        jLabel4.setText("Grama Niladari Division:");

        AddGND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGNDActionPerformed(evt);
            }
        });

        jLabel5.setText("Permit No:");

        jLabel7.setText("Grama Niladari Division No:");

        AddGNDNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGNDNoActionPerformed(evt);
            }
        });

        jLabel27.setText("On The North By:");

        AddNotSurveyedNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedNorthActionPerformed(evt);
            }
        });

        jLabel28.setText("On The East  By:");

        jLabel29.setText("On The South By:");

        jLabel30.setText("On The West By:");

        AddNotSurveyedEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedEastActionPerformed(evt);
            }
        });

        AddNotSurveyedSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedSouthActionPerformed(evt);
            }
        });

        AddNotSurveyedWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedWestActionPerformed(evt);
            }
        });

        jLabel3.setText("Issue Date:");

        addpermit_permit_numberTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpermit_permit_numberTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddNotSurveyedWest))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddNotSurveyedEast)
                                    .addComponent(AddNotSurveyedSouth)
                                    .addComponent(AddNotSurveyedNorth)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AddGNDNo, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(AddGND)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(addpermit_permit_numberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addpermit_permit_numberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(488, 488, 488)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGNDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(13, 13, 13))
        );

        Add_Save.setText("Save");
        Add_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_SaveActionPerformed(evt);
            }
        });

        Add_Cancel.setText("Cancel");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Details"));

        jLabel14.setText("Plan Number");

        jLabel15.setText("Land Name");

        add_permit_landName_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_landName_testActionPerformed(evt);
            }
        });

        jLabel16.setText("Division Number:");

        jLabel17.setText("Name:");

        add_permit_division_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_division_name_testActionPerformed(evt);
            }
        });

        jLabel1.setText("Included Land");

        jLabel2.setText("Included Division");

        add_permit_lot_number_Combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                add_permit_lot_number_ComboItemStateChanged(evt);
            }
        });
        add_permit_lot_number_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_lot_number_ComboActionPerformed(evt);
            }
        });

        jLabel100.setText("Expected Extent");

        add_permit_perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_perches_testActionPerformed(evt);
            }
        });

        jLabel103.setText("Roods");

        jLabel102.setText("Perches");

        jLabel101.setText("Acre / Hectare");

        jLabel99.setText("Lot No");

        add_permit_division_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                add_permit_division_number_comboItemStateChanged(evt);
            }
        });
        add_permit_division_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_division_number_comboActionPerformed(evt);
            }
        });

        add_permit_planNumber_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                add_permit_planNumber_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(286, 286, 286)
                            .addComponent(add_permit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(add_permit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel99)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(add_permit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(add_permit_roods_test, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(add_permit_perches_test, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel103)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel101)))
                            .addComponent(add_permit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(add_permit_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(add_permit_division_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_permit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_permit_division_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_permit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_permit_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(add_permit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel103))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(add_permit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_permit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_permit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("New successor details"));

        jLabel10.setText("Name:");

        jLabel11.setText("NIC:");

        jLabel12.setText("Address:");

        jLabel13.setText("Relationship:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Son", "Spouse", "Daughter", "Brother", "Other relation" }));

        addpermit_NOS_address_test.setColumns(20);
        addpermit_NOS_address_test.setRows(5);
        jScrollPane1.setViewportView(addpermit_NOS_address_test);

        nicInvalidLabel.setForeground(new java.awt.Color(255, 0, 0));
        nicInvalidLabel.setText("NIC is invalid");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nicInvalidLabel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(addpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(addpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "owner Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        add_permit_nic_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                add_permit_nic_comboItemStateChanged(evt);
            }
        });

        add_permit_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_permit_nameTextKeyReleased(evt);
            }
        });

        add_permit_addressText.setColumns(20);
        add_permit_addressText.setRows(5);
        jScrollPane3.setViewportView(add_permit_addressText);

        add_permit_no_of_children_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_permit_no_of_children_testActionPerformed(evt);
            }
        });

        buttonGroup1.add(add_permit_marriedStatusRButton);
        add_permit_marriedStatusRButton.setText("Married");

        buttonGroup1.add(add_permit_singleStatusRButton);
        add_permit_singleStatusRButton.setText("Single");

        jLabel32.setText("NIC :");

        jLabel18.setText("Name:");

        jLabel33.setText("Phone Number:");

        jLabel34.setText("Address:");

        jLabel35.setText("Birthday:");

        jLabel36.setText("Status:");

        jLabel39.setText("Annual Income:");

        jLabel37.setText("No. of married children:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(add_permit_DOB_test, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                            .addComponent(add_permit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_permit_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(add_permit_marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(add_permit_singleStatusRButton))))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addGap(48, 48, 48)
                            .addComponent(add_permit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(add_permit_no_of_children_test))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(add_permit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_permit_nic_combo))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(add_permit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_permit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(add_permit_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_permit_marriedStatusRButton)
                    .addComponent(add_permit_singleStatusRButton)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(add_permit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(add_permit_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addpermit_add_permit_button.setText("Add Permit");
        addpermit_add_permit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpermit_add_permit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addpermit_add_permit_button)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addpermit_add_permit_button)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Add_Cancel)
                        .addGap(35, 35, 35)
                        .addComponent(Add_Save)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Save)
                    .addComponent(Add_Cancel))
                .addGap(23, 23, 23))
        );

        jTabbedPane4.addTab("Add Permit", jPanel2);

        jPanel10.setPreferredSize(new java.awt.Dimension(581, 581));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("View All Permits", jPanel10);

        jPanel12.setPreferredSize(new java.awt.Dimension(581, 581));

        jPanel3.setPreferredSize(new java.awt.Dimension(950, 600));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Permit Information"));
        jPanel8.setPreferredSize(new java.awt.Dimension(581, 581));

        jLabel6.setText("Grama Niladari Division:");

        AddGND1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGND1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Permit No:");

        jLabel9.setText("Grama Niladari Division No:");

        AddGNDNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGNDNo1ActionPerformed(evt);
            }
        });

        jLabel31.setText("On The North By:");

        AddNotSurveyedNorth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedNorth1ActionPerformed(evt);
            }
        });

        jLabel38.setText("On The East  By:");

        jLabel40.setText("On The South By:");

        jLabel41.setText("On The West By:");

        AddNotSurveyedEast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedEast1ActionPerformed(evt);
            }
        });

        AddNotSurveyedSouth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedSouth1ActionPerformed(evt);
            }
        });

        AddNotSurveyedWest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedWest1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Issue Date:");

        editpermit_permit_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editpermit_permit_number_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddNotSurveyedWest1))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddNotSurveyedEast1)
                                    .addComponent(AddNotSurveyedSouth1)
                                    .addComponent(AddNotSurveyedNorth1)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AddGNDNo1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(AddGND1)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(editpermit_permit_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_permit_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(488, 488, 488)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedNorth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedEast1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedSouth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedWest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGND1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGNDNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13))
        );

        Add_Save1.setText("Save");
        Add_Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Save1ActionPerformed(evt);
            }
        });

        Add_Cancel1.setText("Cancel");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Details"));

        jLabel20.setText("Plan Number");

        jLabel21.setText("Land Name");

        editpermit_landName_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_landName_testActionPerformed(evt);
            }
        });

        jLabel22.setText("Division Number:");

        jLabel23.setText("Name:");

        editpermit_division_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_division_name_testActionPerformed(evt);
            }
        });

        jLabel24.setText("Included Land");

        jLabel25.setText("Included Division");

        editpermit_lot_number_Combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editpermit_lot_number_ComboItemStateChanged(evt);
            }
        });
        editpermit_lot_number_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_lot_number_ComboActionPerformed(evt);
            }
        });

        jLabel104.setText("Expected Extent");

        editpermit_perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_perches_testActionPerformed(evt);
            }
        });

        jLabel105.setText("Roods");

        jLabel106.setText("Perches");

        jLabel107.setText("Acre / Hectare");

        jLabel108.setText("Lot No");

        editpermit_division_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editpermit_division_number_comboItemStateChanged(evt);
            }
        });
        editpermit_division_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_division_number_comboActionPerformed(evt);
            }
        });

        editpermit_planNumber_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editpermit_planNumber_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(286, 286, 286)
                            .addComponent(editpermit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel108)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel104)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editpermit_roods_test, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(editpermit_perches_test, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel105)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel107)))
                            .addComponent(editpermit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel25)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(editpermit_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editpermit_division_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_division_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(editpermit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(editpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editpermit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editpermit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("New successor details"));

        jLabel26.setText("Name:");

        jLabel42.setText("NIC:");

        jLabel43.setText("Address:");

        jLabel44.setText("Relationship:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Son", "Spouse", "Daughter", "Brother", "Other relation" }));

        editpermit_NOS_address_test.setColumns(20);
        editpermit_NOS_address_test.setRows(5);
        jScrollPane2.setViewportView(editpermit_NOS_address_test);

        nicInvalidLabel1.setForeground(new java.awt.Color(255, 0, 0));
        nicInvalidLabel1.setText("NIC is invalid");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel26)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(editpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nicInvalidLabel1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(editpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(editpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "owner Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        editPermit_nic_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editPermit_nic_comboItemStateChanged(evt);
            }
        });

        editpermit_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editpermit_nameTextKeyReleased(evt);
            }
        });

        editpermit_addressText.setColumns(20);
        editpermit_addressText.setRows(5);
        jScrollPane4.setViewportView(editpermit_addressText);

        editpermit_no_of_children_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpermit_no_of_children_testActionPerformed(evt);
            }
        });

        buttonGroup1.add(editpermit_marriedStatusRButton);
        editpermit_marriedStatusRButton.setText("Married");

        buttonGroup1.add(editpermit_singleStatusRButton);
        editpermit_singleStatusRButton.setText("Single");

        jLabel45.setText("NIC :");

        jLabel46.setText("Name:");

        jLabel47.setText("Phone Number:");

        jLabel48.setText("Address:");

        jLabel49.setText("Birthday:");

        jLabel50.setText("Status:");

        jLabel51.setText("Annual Income:");

        jLabel52.setText("No. of married children:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(editpermit_DOB_test, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                            .addComponent(editpermit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editPermit_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(editpermit_marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(editpermit_singleStatusRButton))))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel51)
                            .addGap(48, 48, 48)
                            .addComponent(editpermit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel52)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editpermit_no_of_children_test))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(editpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPermit_nic_combo))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(editpermit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(13, 13, 13)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(editpermit_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editpermit_marriedStatusRButton)
                    .addComponent(editpermit_singleStatusRButton)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(editpermit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(editpermit_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addpermit_add_permit_button1.setText("Update Permit");
        addpermit_add_permit_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpermit_add_permit_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addpermit_add_permit_button1)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(addpermit_add_permit_button1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Add_Cancel1)
                        .addGap(35, 35, 35)
                        .addComponent(Add_Save1)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Save1)
                    .addComponent(Add_Cancel1))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Edit Permit", jPanel12);

        jPanel5.setPreferredSize(new java.awt.Dimension(581, 581));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Search Permit", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane4.getAccessibleContext().setAccessibleName("Add Permit");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Add_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_SaveActionPerformed
        // TODO add your handling code here:
        //String AddPermitNum=AddPermitNo.getText();
//        String Add_Village=AddVillage.getText();
        //      String Add_LandName=AddLandName.getText();
//        String Add_lotNo=AddLotNo.getText();
        String Add_PlanNo = addpermit_permit_numberTest.getText();
    //    String SurveyedHectares_Acres=AddHectares_Acres.getText();
        // String Surveyed_Roods=AddRoods.getText();
        //String Surveyed_Perches=AddPerches.getText();
        // String Surveyed_North=AddBoundedNorth.getText();
        //String Surveyed_East=AddBoundedEast.getText();
        //String Surveyed_South=AddBoundedSouth.getText();
        //String Surveyed_West=AddBoundedWest.getText();
        //String NotSurveyedHectares_Acres=AddNotSurveyedHectares_Acres.getText();
        //String NotSurveyed_Roods=AddNotSurveyedRoods.getText();
        //String NotSurveyed_Perches=AddNotSurveyedPerches.getText();
        //  String NotSurveyed_North=AddNotSurveyedNorth.getText();
        String NotSurveyed_East = AddNotSurveyedEast.getText();
        String NotSurveyed_South = AddNotSurveyedSouth.getText();
        String NotSurveyed_West = AddNotSurveyedWest.getText();
        String Add_GND = AddGND.getText();
        String Add_GNDNo = AddGNDNo.getText();
        //String Add_PermitHolder=AddPermitHolder.getText();
//        String Add_PermitHolderNIC=AddPermitHolderNIC.getText();
        //  String Add_SuccessorName=AddSuccessorName.getText();
    }//GEN-LAST:event_Add_SaveActionPerformed

    private void add_permit_perches_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_perches_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_perches_testActionPerformed

    private void addpermit_permit_numberTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpermit_permit_numberTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addpermit_permit_numberTestActionPerformed

    private void AddNotSurveyedWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedWestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedWestActionPerformed

    private void AddNotSurveyedSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedSouthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedSouthActionPerformed

    private void AddNotSurveyedEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedEastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedEastActionPerformed

    private void AddNotSurveyedNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedNorthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedNorthActionPerformed

    private void AddGNDNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGNDNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGNDNoActionPerformed

    private void AddGNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGNDActionPerformed

    private void addpermit_permit_issue_dateChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpermit_permit_issue_dateChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addpermit_permit_issue_dateChooserActionPerformed

    private void add_permit_landName_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_landName_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_landName_testActionPerformed

    private void add_permit_division_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_division_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_division_name_testActionPerformed

    private void add_permit_nic_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_permit_nic_comboItemStateChanged
        try {
            Client searchClient = ClientController.searchClient((String) add_permit_nic_combo.getSelectedItem());
            if (searchClient != null) {
                add_permit_nameText.setText(searchClient.getClientName());
                add_permit_DOB_test.setText(searchClient.getBirthday());
                add_permit_no_of_children_test.setText(String.valueOf(searchClient.getNumberOfMarriedSons() + searchClient.getNumberOfUnmarriedSons()));
                add_permit_telephoneText.setText(searchClient.getTelephone());
                if (searchClient.isMarried() == 0) {
                    add_permit_singleStatusRButton.setSelected(true);
                } else {
                    add_permit_marriedStatusRButton.setSelected(true);
                }
                add_permit_annualIncome.setText(String.valueOf(searchClient.getAnnualIncome()));
                add_permit_addressText.setText(searchClient.getAddress());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_permit_nic_comboItemStateChanged

    private void add_permit_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_permit_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_nameTextKeyReleased

    private void add_permit_no_of_children_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_no_of_children_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_no_of_children_testActionPerformed

    private void add_permit_lot_number_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_lot_number_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_lot_number_ComboActionPerformed

    private void add_permit_division_number_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_permit_division_number_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_permit_division_number_comboActionPerformed

    private void add_permit_division_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_permit_division_number_comboItemStateChanged
        try {
            GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND((String) add_permit_division_number_combo.getSelectedItem());
            if (searchGND != null) {
                add_permit_division_name_test.setText(searchGND.getDivisionName());
                ArrayList<Land> landsOfDivision = LandController.getLandsOfDivision(searchGND.getDivisionNumber());
                ArrayList<Object> list = new ArrayList();
                for (Land land : landsOfDivision) {
                    list.add(land.getPlanNumber());
                }
                ComboItemAdder.addItemToCombo(list, add_permit_planNumber_combo);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_permit_division_number_comboItemStateChanged

    private void add_permit_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_permit_planNumber_comboItemStateChanged
        try {
            Land searchLand = LandController.searchLand(String.valueOf(add_permit_planNumber_combo.getSelectedItem()));
            if (searchLand != null) {
                add_permit_landName_test.setText(searchLand.getLandName());
                ArrayList<Lot> lotList = searchLand.getLotList();
                ArrayList<Object> list = new ArrayList();
                for (Lot lot : lotList) {
                    list.add(lot.getLotNumber());
                }
                ComboItemAdder.addItemToCombo(list, add_permit_lot_number_Combo);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_permit_planNumber_comboItemStateChanged

    private void add_permit_lot_number_ComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_permit_lot_number_ComboItemStateChanged
        try {
            Lot searchLot = LotController.searchLot(String.valueOf(add_permit_lot_number_Combo.getSelectedItem()));
            if (searchLot != null) {
                add_permit_acres_test.setText(String.valueOf(searchLot.getNumberOfAcres()));
                add_permit_perches_test.setText(String.valueOf(searchLot.getNumberOfPerches()));
                add_permit_roods_test.setText(String.valueOf(searchLot.getNumberofRoods()));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_permit_lot_number_ComboItemStateChanged

    private void addpermit_add_permit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpermit_add_permit_buttonActionPerformed
        try {
            String permitNumber = String.valueOf(add_permit_division_number_combo.getSelectedItem()) + "/ENC/";
            int permitCountOfDivision = PermitController.getPermitCountOfDivision(String.valueOf(add_permit_division_number_combo.getSelectedItem()));
            if (permitCountOfDivision < 10) {
                permitNumber += "0" + String.valueOf(permitCountOfDivision + 1);                
            } else {
                permitNumber += String.valueOf(permitCountOfDivision + 1);
            }
            addpermit_permit_numberTest.setText(permitNumber);
            NominatedSuccessor nominatedSuccessor = new NominatedSuccessor(addpermit_NOS_nic_test.getText(), addpermit_NOS_name_test.getText(), addpermit_NOS_address_test.getText());
            Client searchClient = ClientController.searchClient(String.valueOf(add_permit_nic_combo.getSelectedItem()));
            Lot searchLot = LotController.searchLot(String.valueOf(add_permit_lot_number_Combo.getSelectedItem()));
            Date date = addpermit_permit_issue_dateChooser.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String issueDate = simpleDateFormat.format(date);
            Permit permit = new Permit(addpermit_permit_numberTest.getText(), issueDate, searchLot, searchClient, nominatedSuccessor);
            boolean addNewPermit = PermitController.addNewPermit(permit);
            if (addNewPermit) {
                JOptionPane.showMessageDialog(this, "permit Added successfully");
            } else {
                JOptionPane.showMessageDialog(this, "permit does not added successfully");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addpermit_add_permit_buttonActionPerformed

    private void AddGND1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGND1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGND1ActionPerformed

    private void AddGNDNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGNDNo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGNDNo1ActionPerformed

    private void AddNotSurveyedNorth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedNorth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedNorth1ActionPerformed

    private void AddNotSurveyedEast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedEast1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedEast1ActionPerformed

    private void AddNotSurveyedSouth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedSouth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedSouth1ActionPerformed

    private void AddNotSurveyedWest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedWest1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedWest1ActionPerformed

    private void Add_Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Save1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_Save1ActionPerformed

    private void editpermit_landName_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_landName_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_landName_testActionPerformed

    private void editpermit_division_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_division_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_division_name_testActionPerformed

    private void editpermit_lot_number_ComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editpermit_lot_number_ComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_lot_number_ComboItemStateChanged

    private void editpermit_lot_number_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_lot_number_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_lot_number_ComboActionPerformed

    private void editpermit_perches_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_perches_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_perches_testActionPerformed

    private void editpermit_division_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editpermit_division_number_comboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_division_number_comboItemStateChanged

    private void editpermit_division_number_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_division_number_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_division_number_comboActionPerformed

    private void editpermit_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editpermit_planNumber_comboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_planNumber_comboItemStateChanged

    private void editPermit_nic_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editPermit_nic_comboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_editPermit_nic_comboItemStateChanged

    private void editpermit_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editpermit_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_nameTextKeyReleased

    private void editpermit_no_of_children_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpermit_no_of_children_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editpermit_no_of_children_testActionPerformed

    private void addpermit_add_permit_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpermit_add_permit_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addpermit_add_permit_button1ActionPerformed

    private void editpermit_permit_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editpermit_permit_number_comboItemStateChanged
        try {
            Permit searchPermit = PermitController.searchPermit(String.valueOf(editpermit_permit_number_combo.getSelectedItem()));
            if (searchPermit != null) {
                Client client = searchPermit.getClient();
                NominatedSuccessor nominatedSuccessor = searchPermit.getNominatedSuccessor();
                Lot lot = searchPermit.getLot();
                String permitIssueDate = searchPermit.getPermitIssueDate();
                editpermit_nameText.setText(client.getClientName());
                editpermit_telephoneText.setText(client.getTelephone());
                editPermit_nic_combo.setSelectedItem(client.getNIC());
                editpermit_DOB_test.setText(client.getBirthday());
                editpermit_addressText.setText(client.getAddress());
                editpermit_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                if (client.isMarried() == 1) {
                    editpermit_marriedStatusRButton.setSelected(true);
                } else {
                    editpermit_singleStatusRButton.setSelected(true);
                }
                
                int year = Integer.parseInt(permitIssueDate.substring(0, 3));
                int month = Integer.parseInt(permitIssueDate.substring(5, 6));
                int date = Integer.parseInt(permitIssueDate.substring(8, 9));
                Date issueDate = new Date(year, month, date);
                editpermit_CalendarCombo.setDate(issueDate);
                editpermit_NOS_address_test.setText(nominatedSuccessor.getAddress());
                editpermit_NOS_name_test.setText(nominatedSuccessor.getAddress());
                editpermit_NOS_nic_test.setText(nominatedSuccessor.getNIC_S());
                
                editpermit_lot_number_Combo.removeAllItems();
                editpermit_lot_number_Combo.addItem(lot.getLotNumber());
                editpermit_lot_number_Combo.setSelectedItem(lot.getLotNumber());
                
                editpermit_acres_test.setText(String.valueOf(lot.getNumberOfAcres()));
                editpermit_perches_test.setText(String.valueOf(lot.getNumberOfPerches()));
                editpermit_roods_test.setText(String.valueOf(lot.getNumberofRoods()));
                
                Land land = lot.getLand();
                
                editpermit_planNumber_combo.removeAllItems();
                editpermit_planNumber_combo.addItem(land.getPlanNumber());
                editpermit_planNumber_combo.setSelectedItem(land.getPlanNumber());
                editpermit_landName_test.setText(land.getLandName());
                
                editpermit_planNumber_combo.removeAllItems();
                editpermit_division_number_combo.addItem(land.getDivisionNumber());
                editpermit_planNumber_combo.setSelectedItem(land.getDivisionNumber());
                
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                editpermit_division_name_test.setText(searchGND.getDivisionName());
                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_editpermit_permit_number_comboItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddGND;
    private javax.swing.JTextField AddGND1;
    private javax.swing.JTextField AddGNDNo;
    private javax.swing.JTextField AddGNDNo1;
    private javax.swing.JTextField AddNotSurveyedEast;
    private javax.swing.JTextField AddNotSurveyedEast1;
    private javax.swing.JTextField AddNotSurveyedNorth;
    private javax.swing.JTextField AddNotSurveyedNorth1;
    private javax.swing.JTextField AddNotSurveyedSouth;
    private javax.swing.JTextField AddNotSurveyedSouth1;
    private javax.swing.JTextField AddNotSurveyedWest;
    private javax.swing.JTextField AddNotSurveyedWest1;
    private javax.swing.JButton Add_Cancel;
    private javax.swing.JButton Add_Cancel1;
    private javax.swing.JButton Add_Save;
    private javax.swing.JButton Add_Save1;
    private javax.swing.JTextField add_permit_DOB_test;
    private javax.swing.JTextField add_permit_acres_test;
    private javax.swing.JTextArea add_permit_addressText;
    private javax.swing.JTextField add_permit_annualIncome;
    private javax.swing.JTextField add_permit_division_name_test;
    private javax.swing.JComboBox add_permit_division_number_combo;
    private javax.swing.JTextField add_permit_landName_test;
    private javax.swing.JComboBox add_permit_lot_number_Combo;
    private javax.swing.JRadioButton add_permit_marriedStatusRButton;
    private javax.swing.JTextField add_permit_nameText;
    private javax.swing.JComboBox add_permit_nic_combo;
    private javax.swing.JTextField add_permit_no_of_children_test;
    private javax.swing.JTextField add_permit_perches_test;
    private javax.swing.JComboBox add_permit_planNumber_combo;
    private javax.swing.JTextField add_permit_roods_test;
    private javax.swing.JRadioButton add_permit_singleStatusRButton;
    private javax.swing.JTextField add_permit_telephoneText;
    private javax.swing.JTextArea addpermit_NOS_address_test;
    private javax.swing.JTextField addpermit_NOS_name_test;
    private javax.swing.JTextField addpermit_NOS_nic_test;
    private javax.swing.JButton addpermit_add_permit_button;
    private javax.swing.JButton addpermit_add_permit_button1;
    private javax.swing.JTextField addpermit_permit_numberTest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox editPermit_nic_combo;
    private javax.swing.JTextField editpermit_DOB_test;
    private javax.swing.JTextArea editpermit_NOS_address_test;
    private javax.swing.JTextField editpermit_NOS_name_test;
    private javax.swing.JTextField editpermit_NOS_nic_test;
    private javax.swing.JTextField editpermit_acres_test;
    private javax.swing.JTextArea editpermit_addressText;
    private javax.swing.JTextField editpermit_annualIncome;
    private javax.swing.JTextField editpermit_division_name_test;
    private javax.swing.JComboBox editpermit_division_number_combo;
    private javax.swing.JTextField editpermit_landName_test;
    private javax.swing.JComboBox editpermit_lot_number_Combo;
    private javax.swing.JRadioButton editpermit_marriedStatusRButton;
    private javax.swing.JTextField editpermit_nameText;
    private javax.swing.JTextField editpermit_no_of_children_test;
    private javax.swing.JTextField editpermit_perches_test;
    private javax.swing.JComboBox editpermit_permit_number_combo;
    private javax.swing.JComboBox editpermit_planNumber_combo;
    private javax.swing.JTextField editpermit_roods_test;
    private javax.swing.JRadioButton editpermit_singleStatusRButton;
    private javax.swing.JTextField editpermit_telephoneText;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel nicInvalidLabel;
    private javax.swing.JLabel nicInvalidLabel1;
    // End of variables declaration//GEN-END:variables
}
