/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.views;

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
//import las.common_classes.ComboItemAdder;
import las.common_classes.GUIitemsValidator;
import las.common_classes.PatternChecker;
import las.controllers.ClientController;
import las.models.Client;

/**
 *
 * @author Gimhani
 */
public class ApplicantForm extends javax.swing.JInternalFrame {
    String searchednic;
    /**
     * Creates new form ApplicantForm
     */
    public ApplicantForm() {
        initComponents();
        nameText.requestFocus(); 
        namenotvalidlabel.setVisible(false);
       nicnotvalidlabel.setVisible(false);
       phonenumnotvalidlabel.setVisible(false);
       occupationnotvalidlabel.setVisible(false);
       incomenotvalidlabel.setVisible(false);
        //registerButton.setEnabled(false);
        addCurrentResidenceButton.setEnabled(false);
        editnamenotvalidlabel.setVisible(false);
        editphonenonotvalidlabel.setVisible(false);
        editbirthdaynotvalidlabel.setVisible(false);
        editmarriedchildrennotvalidlabel.setVisible(false);
        editunmarriedchildrennotvalidlabel.setVisible(false);
        editoccupationnotvalidlabel.setVisible(false);
        editincomenotvalidlabel.setVisible(false);
        search_DOB_test.setEditable(false);
        search_addressText.setEditable(false);
        search_annualIncome.setEditable(false);
        search_marided_sons.setEditable(false);
        search_nameText.setEditable(false);
        search_telephoneText.setEditable(false);
        search_unmarried_sons.setEditable(false);
        search_nic_combo.setEditable(true);
        /*search_nic_combo.setEditable(true);
        registerButton.setEnabled(false);
        search_DOB_test.setEditable(false);
        search_addressText.setEditable(false);
        search_annualIncome.setEditable(false);
        search_marided_sons.setEditable(false);
        search_marriedStatusRButton.setEnabled(false);
        search_nameText.setEditable(false);
        search_singleStatusRButton.setEnabled(false);
        search_telephoneText.setEditable(false);
        search_unmarried_sons.setEditable(false);
        searchoccupationbutton.setEditable(false);*/
        
        JTextComponent editorSearchNICCombo = (JTextComponent) search_nic_combo.getEditor().getEditorComponent();
        editorSearchNICCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) search_nic_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {

                    ArrayList<Client> simmilarNICs = ClientController.getSimmilarNICs(item);
                    for (int i = 0; i < simmilarNICs.size(); i++) {
                        list.add(simmilarNICs.get(i).getNIC());
                    }
                    GUIitemsValidator.addItemToCombo(list, search_nic_combo);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        edit_nic_combo.setEditable(true);
        JTextComponent editorEditNICCombo = (JTextComponent) edit_nic_combo.getEditor().getEditorComponent();
        editorEditNICCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) edit_nic_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {

                    ArrayList<Client> simmilarNICs = ClientController.getSimmilarNICs(item);
                    for (int i = 0; i < simmilarNICs.size(); i++) {
                        list.add(simmilarNICs.get(i).getNIC());
                    }
                    GUIitemsValidator.addItemToCombo(list, edit_nic_combo);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public ApplicantForm(String nic){
        try {
            this.searchednic=nic;
            searchClient(nic);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusButtonGroup = new javax.swing.ButtonGroup();
        CurrentResidencePanel = new javax.swing.JPanel();
        currentResidenceLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        newApplicantTab = new javax.swing.JPanel();
        NewApplicantDetailPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        personalDetailPanel = new javax.swing.JPanel();
        RegNo = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        NIC = new javax.swing.JLabel();
        applicantNumberText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        nicText = new javax.swing.JTextField();
        telephoneText = new javax.swing.JTextField();
        PhoneNo = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        Birthday = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        marriedStatusRButton = new javax.swing.JRadioButton();
        singleStatusRButton = new javax.swing.JRadioButton();
        childrenCountPanel = new javax.swing.JPanel();
        NumberOfMarriedChildren = new javax.swing.JLabel();
        NoOfUnmarriedChildren = new javax.swing.JLabel();
        marriedChildrenCountSpinner = new javax.swing.JSpinner();
        unmarriedChildrenCountSpinner = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        Occupation = new javax.swing.JLabel();
        occupationText = new javax.swing.JTextField();
        AnnualIncome = new javax.swing.JLabel();
        annualIncomeText = new javax.swing.JTextField();
        occupationnotvalidlabel = new javax.swing.JLabel();
        incomenotvalidlabel = new javax.swing.JLabel();
        addCurrentResidenceButton = new javax.swing.JButton();
        namenotvalidlabel = new javax.swing.JLabel();
        nicnotvalidlabel = new javax.swing.JLabel();
        phonenumnotvalidlabel = new javax.swing.JLabel();
        birthdayChooser1 = new org.freixas.jcalendar.JCalendarCombo();
        jPanel5 = new javax.swing.JPanel();
        personalDetailPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        search_nameText = new javax.swing.JTextField();
        search_telephoneText = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        search_addressText = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        search_marriedStatusRButton = new javax.swing.JRadioButton();
        search_singleStatusRButton = new javax.swing.JRadioButton();
        childrenCountPanel1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        search_marided_sons = new javax.swing.JTextField();
        search_unmarried_sons = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        searchoccupationbutton = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        search_annualIncome = new javax.swing.JTextField();
        search_DOB_test = new javax.swing.JTextField();
        search_nic_combo = new javax.swing.JComboBox();
        personalDetailPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        edit_nameText = new javax.swing.JTextField();
        edit_telephoneText = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        edit_addressText = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        edit_marriedStatusRButton = new javax.swing.JRadioButton();
        edit_singleStatusRButton = new javax.swing.JRadioButton();
        childrenCountPanel2 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        edit_marided_sons = new javax.swing.JTextField();
        edit_unmarried_sons = new javax.swing.JTextField();
        editmarriedchildrennotvalidlabel = new javax.swing.JLabel();
        editunmarriedchildrennotvalidlabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        editoccupation = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        edit_annualIncome = new javax.swing.JTextField();
        editoccupationnotvalidlabel = new javax.swing.JLabel();
        editincomenotvalidlabel = new javax.swing.JLabel();
        edit_DOB_test = new javax.swing.JTextField();
        edit_nic_combo = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        edit_update_buttun = new javax.swing.JButton();
        editnamenotvalidlabel = new javax.swing.JLabel();
        editphonenonotvalidlabel = new javax.swing.JLabel();
        editbirthdaynotvalidlabel = new javax.swing.JLabel();

        currentResidenceLabel.setText("Current Residence : ");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel13.setText("01. Applicant is ");

        jRadioButton3.setText("the owner of this land above");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("not the owner of this land");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("If not the owner"));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel14.setText("Owner of land:");

        jLabel15.setText("Relationship to owner:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("If applicant is the owner"));

        jLabel16.setText("Size of land:");

        jLabel18.setText("acres");

        jLabel19.setText("roods");

        jLabel20.setText("perches");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel20))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel19))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel21.setText("02.Is the land illegal (a government property?)");

        jRadioButton5.setText("Yes");

        jRadioButton6.setText("No");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jLabel22.setText("03.Has applicant applied before to land kachcheri?");

        jRadioButton7.setText("Yes");

        jRadioButton8.setText("No");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jLabel23.setText("04.Is applcant name already in application register?");

        jButton3.setText("Check availability");

        resultLabel.setText("<Result Label>");

        jButton4.setText("Cancel");

        jButton5.setText("Register");

        jButton6.setText("<Back");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout CurrentResidencePanelLayout = new javax.swing.GroupLayout(CurrentResidencePanel);
        CurrentResidencePanel.setLayout(CurrentResidencePanelLayout);
        CurrentResidencePanelLayout.setHorizontalGroup(
            CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                        .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resultLabel))
                            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton7)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton8))
                            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton6))
                            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentResidenceLabel)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                                        .addComponent(jRadioButton3)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRadioButton4))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CurrentResidencePanelLayout.setVerticalGroup(
            CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrentResidencePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentResidenceLabel))
                .addGap(7, 7, 7)
                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CurrentResidencePanelLayout.createSequentialGroup()
                        .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addGap(18, 18, 18)
                        .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8))
                        .addGap(18, 18, 18)
                        .addGroup(CurrentResidencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jButton3)
                            .addComponent(resultLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(605, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        personalDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        RegNo.setText("Reg No:");

        Name.setText("Name:");

        NIC.setText("NIC :");

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextKeyReleased(evt);
            }
        });

        nicText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicTextActionPerformed(evt);
            }
        });
        nicText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicTextKeyReleased(evt);
            }
        });

        telephoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextActionPerformed(evt);
            }
        });
        telephoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephoneTextKeyReleased(evt);
            }
        });

        PhoneNo.setText("Phone Number:");

        Address.setText("Address:");

        addressText.setColumns(20);
        addressText.setRows(5);
        addressText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressTextKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(addressText);

        Birthday.setText("Birthday:");

        Status.setText("Status:");

        statusButtonGroup.add(marriedStatusRButton);
        marriedStatusRButton.setText("Married");
        marriedStatusRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                marriedStatusRButtonStateChanged(evt);
            }
        });
        marriedStatusRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriedStatusRButtonActionPerformed(evt);
            }
        });
        marriedStatusRButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                marriedStatusRButtonKeyReleased(evt);
            }
        });

        statusButtonGroup.add(singleStatusRButton);
        singleStatusRButton.setText("Single");
        singleStatusRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                singleStatusRButtonStateChanged(evt);
            }
        });
        singleStatusRButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                singleStatusRButtonKeyReleased(evt);
            }
        });

        childrenCountPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Number of children"));

        NumberOfMarriedChildren.setText("No. of married children:");

        NoOfUnmarriedChildren.setText("No. of  unmarried children:");

        marriedChildrenCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                marriedChildrenCountSpinnerStateChanged(evt);
            }
        });
        marriedChildrenCountSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                marriedChildrenCountSpinnerKeyReleased(evt);
            }
        });

        unmarriedChildrenCountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                unmarriedChildrenCountSpinnerStateChanged(evt);
            }
        });
        unmarriedChildrenCountSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unmarriedChildrenCountSpinnerKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout childrenCountPanelLayout = new javax.swing.GroupLayout(childrenCountPanel);
        childrenCountPanel.setLayout(childrenCountPanelLayout);
        childrenCountPanelLayout.setHorizontalGroup(
            childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NoOfUnmarriedChildren, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(NumberOfMarriedChildren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marriedChildrenCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unmarriedChildrenCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        childrenCountPanelLayout.setVerticalGroup(
            childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberOfMarriedChildren)
                    .addComponent(marriedChildrenCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoOfUnmarriedChildren)
                    .addComponent(unmarriedChildrenCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Income Details"));

        Occupation.setText("Occupation:");

        occupationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationTextActionPerformed(evt);
            }
        });
        occupationText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                occupationTextKeyReleased(evt);
            }
        });

        AnnualIncome.setText("Estimated Annual Income: Rs.");

        annualIncomeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                annualIncomeTextKeyReleased(evt);
            }
        });

        occupationnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        occupationnotvalidlabel.setText("Not Valid");

        incomenotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        incomenotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AnnualIncome)
                    .addComponent(Occupation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(occupationText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(occupationnotvalidlabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(annualIncomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(incomenotvalidlabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Occupation)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(occupationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(occupationnotvalidlabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AnnualIncome)
                        .addComponent(annualIncomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(incomenotvalidlabel))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        addCurrentResidenceButton.setText("Add current residence details");
        addCurrentResidenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCurrentResidenceButtonActionPerformed(evt);
            }
        });
        addCurrentResidenceButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addCurrentResidenceButtonKeyReleased(evt);
            }
        });

        namenotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        namenotvalidlabel.setText("Not Valid");

        nicnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        nicnotvalidlabel.setText("Not Valid");

        phonenumnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        phonenumnotvalidlabel.setText("Not Valid");

        birthdayChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayChooser1ActionPerformed(evt);
            }
        });
        birthdayChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                birthdayChooser1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout personalDetailPanelLayout = new javax.swing.GroupLayout(personalDetailPanel);
        personalDetailPanel.setLayout(personalDetailPanelLayout);
        personalDetailPanelLayout.setHorizontalGroup(
            personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(RegNo)
                                .addComponent(NIC)
                                .addComponent(Name)
                                .addComponent(PhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Status))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                                .addComponent(marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(singleStatusRButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(telephoneText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nicText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(applicantNumberText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(namenotvalidlabel)
                                            .addComponent(nicnotvalidlabel)
                                            .addComponent(phonenumnotvalidlabel)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(birthdayChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(childrenCountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalDetailPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addCurrentResidenceButton)))
                .addContainerGap())
        );
        personalDetailPanelLayout.setVerticalGroup(
            personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegNo)
                            .addComponent(applicantNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namenotvalidlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIC)
                            .addComponent(nicText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicnotvalidlabel))
                        .addGap(9, 9, 9)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PhoneNo)
                            .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phonenumnotvalidlabel, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(childrenCountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Address)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Birthday)
                            .addComponent(birthdayChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status)
                    .addComponent(marriedStatusRButton)
                    .addComponent(singleStatusRButton))
                .addGap(3, 3, 3)
                .addComponent(addCurrentResidenceButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NewApplicantDetailPanelLayout = new javax.swing.GroupLayout(NewApplicantDetailPanel);
        NewApplicantDetailPanel.setLayout(NewApplicantDetailPanelLayout);
        NewApplicantDetailPanelLayout.setHorizontalGroup(
            NewApplicantDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewApplicantDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewApplicantDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personalDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NewApplicantDetailPanelLayout.setVerticalGroup(
            NewApplicantDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewApplicantDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout newApplicantTabLayout = new javax.swing.GroupLayout(newApplicantTab);
        newApplicantTab.setLayout(newApplicantTabLayout);
        newApplicantTabLayout.setHorizontalGroup(
            newApplicantTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newApplicantTabLayout.createSequentialGroup()
                .addComponent(NewApplicantDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        newApplicantTabLayout.setVerticalGroup(
            newApplicantTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newApplicantTabLayout.createSequentialGroup()
                .addComponent(NewApplicantDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add new applicant", newApplicantTab);

        personalDetailPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        jLabel17.setText("Name:");

        jLabel24.setText("NIC :");

        search_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_nameTextKeyReleased(evt);
            }
        });

        jLabel25.setText("Phone Number:");

        jLabel26.setText("Address:");

        search_addressText.setColumns(20);
        search_addressText.setRows(5);
        jScrollPane3.setViewportView(search_addressText);

        jLabel27.setText("Birthday:");

        jLabel28.setText("Status:");

        statusButtonGroup.add(search_marriedStatusRButton);
        search_marriedStatusRButton.setText("Married");

        statusButtonGroup.add(search_singleStatusRButton);
        search_singleStatusRButton.setText("Single");

        childrenCountPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Number of children"));

        jLabel29.setText("No. of married children:");

        jLabel30.setText("No. of  unmarried children:");

        javax.swing.GroupLayout childrenCountPanel1Layout = new javax.swing.GroupLayout(childrenCountPanel1);
        childrenCountPanel1.setLayout(childrenCountPanel1Layout);
        childrenCountPanel1Layout.setHorizontalGroup(
            childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_unmarried_sons, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(search_marided_sons))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        childrenCountPanel1Layout.setVerticalGroup(
            childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(search_marided_sons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(search_unmarried_sons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Income Details"));

        jLabel31.setText("Occupation:");

        jLabel32.setText("Estimated Annual Income: Rs.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchoccupationbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(searchoccupationbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(search_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        search_DOB_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_DOB_testActionPerformed(evt);
            }
        });

        search_nic_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                search_nic_comboItemStateChanged(evt);
            }
        });
        search_nic_combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_nic_comboKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout personalDetailPanel1Layout = new javax.swing.GroupLayout(personalDetailPanel1);
        personalDetailPanel1.setLayout(personalDetailPanel1Layout);
        personalDetailPanel1Layout.setHorizontalGroup(
            personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel24)
                        .addComponent(jLabel17)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                            .addComponent(search_DOB_test)
                            .addGap(181, 181, 181))
                        .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                            .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(search_nameText)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(search_telephoneText))
                                .addComponent(search_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)))
                    .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                        .addComponent(search_marriedStatusRButton)
                        .addGap(18, 18, 18)
                        .addComponent(search_singleStatusRButton)
                        .addGap(211, 211, 211)))
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                        .addComponent(childrenCountPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalDetailPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        personalDetailPanel1Layout.setVerticalGroup(
            personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                        .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalDetailPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(search_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(search_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(search_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(childrenCountPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel1Layout.createSequentialGroup()
                        .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(search_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(personalDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(search_marriedStatusRButton)
                    .addComponent(search_singleStatusRButton))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personalDetailPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(personalDetailPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search applicant", jPanel5);

        personalDetailPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        jLabel33.setText("Name:");

        jLabel34.setText("NIC :");

        edit_nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_nameTextActionPerformed(evt);
            }
        });
        edit_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_nameTextKeyReleased(evt);
            }
        });

        edit_telephoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_telephoneTextKeyReleased(evt);
            }
        });

        jLabel35.setText("Phone Number:");

        jLabel36.setText("Address:");

        edit_addressText.setColumns(20);
        edit_addressText.setRows(5);
        edit_addressText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_addressTextKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(edit_addressText);

        jLabel37.setText("Birthday:");

        jLabel38.setText("Status:");

        statusButtonGroup.add(edit_marriedStatusRButton);
        edit_marriedStatusRButton.setText("Married");
        edit_marriedStatusRButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_marriedStatusRButtonKeyReleased(evt);
            }
        });

        statusButtonGroup.add(edit_singleStatusRButton);
        edit_singleStatusRButton.setText("Single");
        edit_singleStatusRButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_singleStatusRButtonKeyReleased(evt);
            }
        });

        childrenCountPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Number of children"));

        jLabel39.setText("No. of married children:");

        jLabel40.setText("No. of  unmarried children:");

        edit_marided_sons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_marided_sonsKeyReleased(evt);
            }
        });

        edit_unmarried_sons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_unmarried_sonsKeyReleased(evt);
            }
        });

        editmarriedchildrennotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editmarriedchildrennotvalidlabel.setText("Not Valid");

        editunmarriedchildrennotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editunmarriedchildrennotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout childrenCountPanel2Layout = new javax.swing.GroupLayout(childrenCountPanel2);
        childrenCountPanel2.setLayout(childrenCountPanel2Layout);
        childrenCountPanel2Layout.setHorizontalGroup(
            childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edit_unmarried_sons, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(edit_marided_sons))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editmarriedchildrennotvalidlabel)
                    .addComponent(editunmarriedchildrennotvalidlabel))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        childrenCountPanel2Layout.setVerticalGroup(
            childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childrenCountPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(edit_marided_sons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editmarriedchildrennotvalidlabel))
                .addGap(18, 18, 18)
                .addGroup(childrenCountPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(edit_unmarried_sons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editunmarriedchildrennotvalidlabel))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Income Details"));

        jLabel41.setText("Occupation:");

        editoccupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editoccupationKeyReleased(evt);
            }
        });

        jLabel42.setText("Estimated Annual Income: Rs.");

        edit_annualIncome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_annualIncomeKeyReleased(evt);
            }
        });

        editoccupationnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editoccupationnotvalidlabel.setText("Not Valid");

        editincomenotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editincomenotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(editoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editoccupationnotvalidlabel))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(edit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editincomenotvalidlabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editoccupationnotvalidlabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(edit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editincomenotvalidlabel))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        edit_DOB_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_DOB_testActionPerformed(evt);
            }
        });
        edit_DOB_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_DOB_testKeyReleased(evt);
            }
        });

        edit_nic_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                edit_nic_comboItemStateChanged(evt);
            }
        });
        edit_nic_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_nic_comboActionPerformed(evt);
            }
        });

        edit_update_buttun.setText("Update");
        edit_update_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_update_buttunActionPerformed(evt);
            }
        });
        edit_update_buttun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edit_update_buttunKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edit_update_buttun, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(edit_update_buttun)
                .addGap(33, 33, 33))
        );

        editnamenotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editnamenotvalidlabel.setText("Not Valid");

        editphonenonotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editphonenonotvalidlabel.setText("Not Valid");

        editbirthdaynotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editbirthdaynotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout personalDetailPanel2Layout = new javax.swing.GroupLayout(personalDetailPanel2);
        personalDetailPanel2.setLayout(personalDetailPanel2Layout);
        personalDetailPanel2Layout.setHorizontalGroup(
            personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel34)
                                .addComponent(jLabel33)
                                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(edit_DOB_test, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editbirthdaynotvalidlabel)
                                        .addGap(129, 129, 129))
                                    .addComponent(edit_nameText)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(edit_telephoneText)
                                    .addComponent(edit_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editnamenotvalidlabel)
                                    .addComponent(editphonenonotvalidlabel)))
                            .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                                .addComponent(edit_marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(edit_singleStatusRButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(childrenCountPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))))
        );
        personalDetailPanel2Layout.setVerticalGroup(
            personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalDetailPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(edit_nic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(edit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editnamenotvalidlabel))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(edit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editphonenonotvalidlabel, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(childrenCountPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanel2Layout.createSequentialGroup()
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(edit_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editbirthdaynotvalidlabel)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(personalDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(edit_marriedStatusRButton)
                    .addComponent(edit_singleStatusRButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Edit applicant", personalDetailPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed
public void EnableAddButton(){
    if(nameText.getText().trim().length()!=0 && nicText.getText().trim().length()!=0 && telephoneText.getText().trim().length()!=0 && addressText.getText().trim().length()!=0 && annualIncomeText.getText().trim().length()!=0 &&(marriedStatusRButton.isSelected()|| singleStatusRButton.isSelected()) ){
        registerButton.setEnabled(true);
    }
    else{
        registerButton.setEnabled(false);
    }}
    private void edit_nic_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_edit_nic_comboItemStateChanged
        try {
            Client searchClient = ClientController.searchClient((String) edit_nic_combo.getSelectedItem());
            if (searchClient != null) {
                edit_nameText.setText(searchClient.getClientName());
                edit_DOB_test.setText(searchClient.getBirthday());
                edit_marided_sons.setText(String.valueOf(searchClient.getNumberOfMarriedSons()));
                edit_telephoneText.setText(searchClient.getTelephone());
                edit_unmarried_sons.setText(String.valueOf(searchClient.getNumberOfUnmarriedSons()));
                if (searchClient.isMarried() == 0) {
                    edit_singleStatusRButton.setSelected(true);
                } else {
                    edit_marriedStatusRButton.setSelected(true);
                }
                edit_annualIncome.setText(String.valueOf(searchClient.getAnnualIncome()));
                edit_addressText.setText(searchClient.getAddress());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edit_nic_comboItemStateChanged

    private void edit_DOB_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_DOB_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_DOB_testActionPerformed

    private void edit_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_nameTextKeyReleased
        // TODO add your handling code here:
        editnamenotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(edit_nameText.getText());
        edit_nameText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(edit_nameText.getText())){
            
               edit_telephoneText.requestFocus();}
            else{
                editnamenotvalidlabel.setVisible(true);
            }
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            edit_telephoneText.requestFocus();
        }
    }//GEN-LAST:event_edit_nameTextKeyReleased

    private void search_nic_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_search_nic_comboItemStateChanged
        try {
           searchClient((String) search_nic_combo.getSelectedItem());
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_nic_comboItemStateChanged

    private void searchClient(String nic) throws ClassNotFoundException, SQLException{
        
            Client searchClient = ClientController.searchClient(nic);
            if (searchClient != null) {
                search_nameText.setText(searchClient.getClientName());
                search_DOB_test.setText(searchClient.getBirthday());
                search_marided_sons.setText(String.valueOf(searchClient.getNumberOfMarriedSons()));
                search_telephoneText.setText(searchClient.getTelephone());
                search_unmarried_sons.setText(String.valueOf(searchClient.getNumberOfUnmarriedSons()));
                if (searchClient.isMarried() == 0) {
                    search_singleStatusRButton.setSelected(true);
                } else {
                    search_marriedStatusRButton.setSelected(true);
                }
                search_annualIncome.setText(String.valueOf(searchClient.getAnnualIncome()));
                search_addressText.setText(searchClient.getAddress());
            }
        
    }
    
    private void search_DOB_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_DOB_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_DOB_testActionPerformed

    private void search_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search_nameTextKeyReleased

    private void addCurrentResidenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCurrentResidenceButtonActionPerformed
        // new CurrentResidenceDetailForm(null, true,this,nicText.getText(),nameText.getText()).setVisible(true);
    }//GEN-LAST:event_addCurrentResidenceButtonActionPerformed

    private void nicTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicTextKeyReleased
         EnableAddButton();
        if (nameText.getText() != "" && nicText.getText() != "") {
            addCurrentResidenceButton.setEnabled(true);
        }
         nicnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkNIC(nicText.getText());
        nicText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkNICdirect(nicText.getText())){
                telephoneText.requestFocus();
       }
            else{
                nicnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            telephoneText.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            nameText.requestFocus();
        }
    }//GEN-LAST:event_nicTextKeyReleased

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
        if (nameText.getText() != "" && nicText.getText() != "") {
            addCurrentResidenceButton.setEnabled(true);
        }
        namenotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(nameText.getText());
        nameText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(nameText.getText())){
               nicText.requestFocus();}
            else{
               namenotvalidlabel.setVisible(true); 
            }
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            nicText.requestFocus();
        }
        EnableAddButton();
    }//GEN-LAST:event_nameTextKeyReleased

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        int isMarried = 1;
        String applicantNumber = applicantNumberText.getText();
        String aplicantName = nameText.getText();
        String nic = nicText.getText();
        String telephoneNumber = telephoneText.getText();
        String address = addressText.getText();
        Date date = birthdayChooser1.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String DOB = simpleDateFormat.format(date);
        System.out.println(DOB);
        if (singleStatusRButton.isSelected()) {
            isMarried = 0;
        }
        int marriedSons = 0,unmarriedSons = 0;
        double annualincome = 0;
        try{
         marriedSons = Integer.parseInt(marriedChildrenCountSpinner.getValue().toString());
         unmarriedSons = Integer.parseInt(unmarriedChildrenCountSpinner.getValue().toString());
         annualincome = Double.parseDouble(annualIncomeText.getText());}
        catch (Exception e){         
            JOptionPane.showMessageDialog(rootPane, "OOps! Something Went Wrong!");
        
        }

        
        if(!PatternChecker.checkStringdirect(nameText.getText())){
               namenotvalidlabel.setVisible(true);}
        else if (!PatternChecker.checkNICdirect(nicText.getText())){
                nicnotvalidlabel.setVisible(true);}
        else if (!PatternChecker.checkTelNumdirect(telephoneText.getText())){
                phonenumnotvalidlabel.setVisible(true);     }
        else if(!PatternChecker.checkStringdirect(occupationText.getText())){
               occupationnotvalidlabel.setVisible(true);}
         else if(!PatternChecker.checkDecimaldirect(annualIncomeText.getText())){
               incomenotvalidlabel.setVisible(true);}
        else{
        Client client = new Client(nic, aplicantName, DOB, telephoneNumber, address, annualincome, 0, 0, isMarried, marriedSons, unmarriedSons);
        try {
            boolean addNewClient = ClientController.addNewClient(client);
            if (addNewClient) {
                JOptionPane.showMessageDialog(rootPane, "applicant added successfully");
                applicantNumberText.setText(null);
                nameText.setText(null);
                nicText.setText(null);
                telephoneText.setText(null);
                addressText.setText(null);
                annualIncomeText.setText(null);
                marriedStatusRButton.setSelected(false);
                singleStatusRButton.setSelected(false);
                occupationText.setText(null);
                marriedChildrenCountSpinner.setValue(0);
                unmarriedChildrenCountSpinner.setValue(0);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
            
        }}
        
        

    }//GEN-LAST:event_registerButtonActionPerformed

    private void edit_update_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_update_buttunActionPerformed
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Do you want to update");
        if (showConfirmDialog == 0) {
            int isMarried = 1;
            String applicantNumber = applicantNumberText.getText();
            String aplicantName = edit_nameText.getText();
            String nic = String.valueOf(edit_nic_combo.getSelectedItem());
            String telephoneNumber = edit_telephoneText.getText();
            String address = edit_addressText.getText();
        //Date date = birthdayChooser.getDate();
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            //String DOB = simpleDateFormat.format(date);
            String DOB = edit_DOB_test.getText();
            if (edit_singleStatusRButton.isSelected()) {
                isMarried = 0;
            }
            int marriedSons=0;
            int unmarriedSons=0;
            double annualincome=0;
            try{
            marriedSons = Integer.parseInt(edit_marided_sons.getText());
            }
            catch(Exception e){
                editmarriedchildrennotvalidlabel.setEnabled(true);
            }
            try{
              unmarriedSons = Integer.parseInt(edit_unmarried_sons.getText());
            }
            catch(Exception e){
                editunmarriedchildrennotvalidlabel.setEnabled(true);
            }
           try{
            annualincome = Double.parseDouble(edit_annualIncome.getText());}
           catch(Exception e){
               editincomenotvalidlabel.setVisible(true);
           }

            Client client = new Client(nic, aplicantName, DOB, telephoneNumber, address, annualincome, 0, 0, isMarried, marriedSons, unmarriedSons);
            if(!PatternChecker.checkStringdirect(edit_nameText.getText())){
               editnamenotvalidlabel.setVisible(true);}
        else if (!PatternChecker.checkTelNumdirect(edit_telephoneText.getText())){
                editphonenonotvalidlabel.setVisible(true);     }
        else if(!PatternChecker.checkStringdirect(editoccupation.getText())){
               editoccupationnotvalidlabel.setVisible(true);}
         else if(!PatternChecker.checkDecimaldirect(edit_annualIncome.getText())){
               editincomenotvalidlabel.setVisible(true);}
         else{   
            if(edit_nameText.getText().trim().length()!=0 && edit_telephoneText.getText().trim().length()!=0 && edit_addressText.getText().trim().length()!=0 && edit_marided_sons.getText().trim().length()!=0 && edit_unmarried_sons.getText().trim().length()!=0 && edit_annualIncome.getText().trim().length()!=0 && editoccupation.getText().trim().length()!=0 && (edit_marriedStatusRButton.isSelected()|| edit_singleStatusRButton.isSelected())){
            try {
                int updateClient = ClientController.updateClient(client);
                if(updateClient>0){
                    JOptionPane.showMessageDialog(this,"update successfully");
                    edit_nameText.setText(null);
                    edit_nic_combo.setSelectedItem(null);
                    edit_telephoneText.setText(null);
                    edit_addressText.setText(null);     
                    edit_DOB_test.setText(null);
                    edit_marided_sons.setText(null);
                    edit_unmarried_sons.setText(null);
                    editoccupation.setText(null);
                    edit_annualIncome.setText(null);
                    edit_marriedStatusRButton.setSelected(false);
                    edit_singleStatusRButton.setSelected(false);
                }else{
                    JOptionPane.showMessageDialog(this, "doesn't updated");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ApplicantForm.class.getName()).log(Level.SEVERE, null, ex);
            }}
            else{
            JOptionPane.showMessageDialog(this,"Please Fill The Relevant Details In The Blanks");
        }
        }   
        }
    }//GEN-LAST:event_edit_update_buttunActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameTextActionPerformed

    private void nicTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicTextActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nicTextActionPerformed

    private void telephoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
         phonenumnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkTelNum(telephoneText.getText());
        telephoneText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkTelNumdirect(telephoneText.getText())){
                addressText.requestFocus();
       }
            else{
                phonenumnotvalidlabel.setVisible(true);
        }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            addressText.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            nicText.requestFocus();
        }
    }//GEN-LAST:event_telephoneTextKeyReleased

    private void addressTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTextKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
         if(evt.getKeyCode()==KeyEvent.VK_ENTER && addressText.getText().trim().length()!=0){
            
                birthdayChooser1.requestFocus();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
           birthdayChooser1.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            telephoneText.requestFocus();
        }
    }//GEN-LAST:event_addressTextKeyReleased

    private void marriedChildrenCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_marriedChildrenCountSpinnerStateChanged
        // TODO add your handling code here:
        GUIitemsValidator.limitminimumSpinnerValue(marriedChildrenCountSpinner,0);
    }//GEN-LAST:event_marriedChildrenCountSpinnerStateChanged

    private void unmarriedChildrenCountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_unmarriedChildrenCountSpinnerStateChanged
        // TODO add your handling code here:
         GUIitemsValidator.limitminimumSpinnerValue(unmarriedChildrenCountSpinner,0);
    }//GEN-LAST:event_unmarriedChildrenCountSpinnerStateChanged

    private void marriedStatusRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedStatusRButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_marriedStatusRButtonActionPerformed

    private void marriedStatusRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_marriedStatusRButtonStateChanged
        // TODO add your handling code here:
        if(marriedStatusRButton.isSelected()){
            singleStatusRButton.setSelected(false);
        }
    }//GEN-LAST:event_marriedStatusRButtonStateChanged

    private void marriedStatusRButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marriedStatusRButtonKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                marriedStatusRButton.isSelected();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            marriedChildrenCountSpinner.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            birthdayChooser1.requestFocus();
            
        }
        
         else if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
           singleStatusRButton.requestFocus();
            
        }
    }//GEN-LAST:event_marriedStatusRButtonKeyReleased

    private void singleStatusRButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_singleStatusRButtonKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                singleStatusRButton.isSelected();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            marriedChildrenCountSpinner.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            birthdayChooser1.requestFocus();
            
        }
       
         else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
           marriedStatusRButton.requestFocus();
            
        }
    }//GEN-LAST:event_singleStatusRButtonKeyReleased

    private void marriedChildrenCountSpinnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marriedChildrenCountSpinnerKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                unmarriedChildrenCountSpinner.requestFocus();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            GUIitemsValidator.decrementSpinnerValue(marriedChildrenCountSpinner);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            GUIitemsValidator.incermentSpinnerValue(marriedChildrenCountSpinner);
            
        }
    
    }//GEN-LAST:event_marriedChildrenCountSpinnerKeyReleased

    private void unmarriedChildrenCountSpinnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unmarriedChildrenCountSpinnerKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
               occupationText.requestFocus();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            GUIitemsValidator.decrementSpinnerValue(unmarriedChildrenCountSpinner);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            GUIitemsValidator.incermentSpinnerValue(unmarriedChildrenCountSpinner);
            
        }
    }//GEN-LAST:event_unmarriedChildrenCountSpinnerKeyReleased

    private void occupationTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationTextActionPerformed

    private void occupationTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationTextKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
        occupationnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(occupationText.getText());
        occupationText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(occupationText.getText())){
               annualIncomeText.requestFocus();}
            else{
                occupationnotvalidlabel.setVisible(true);
            }
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            annualIncomeText.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            unmarriedChildrenCountSpinner.requestFocus();
            
        }
    }//GEN-LAST:event_occupationTextKeyReleased

    private void annualIncomeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_annualIncomeTextKeyReleased
        // TODO add your handling code here:
         EnableAddButton();
       incomenotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkDecimal(annualIncomeText.getText());
        annualIncomeText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkDecimaldirect(annualIncomeText.getText())){
               addCurrentResidenceButton.requestFocus();}
            else{
               incomenotvalidlabel.setVisible(true);  
            }
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
             addCurrentResidenceButton.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
           occupationText.requestFocus();
            
        }
    }//GEN-LAST:event_annualIncomeTextKeyReleased

    private void birthdayChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayChooser1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_birthdayChooser1ActionPerformed

    private void birthdayChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_birthdayChooser1KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
               marriedStatusRButton.requestFocus();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
             marriedStatusRButton.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
           addressText.requestFocus();
            
        }
    }//GEN-LAST:event_birthdayChooser1KeyReleased

    private void edit_nic_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_nic_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_nic_comboActionPerformed

    private void edit_nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_nameTextActionPerformed

    private void edit_telephoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_telephoneTextKeyReleased
        // TODO add your handling code here:
        editphonenonotvalidlabel.setVisible(false);
         String newtext=PatternChecker.checkTelNum(edit_telephoneText.getText());
        edit_telephoneText.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkTelNumdirect(edit_telephoneText.getText())){
                edit_addressText.requestFocus();
       }
            else{
              editphonenonotvalidlabel.setVisible(true);
        }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            edit_addressText.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_nameText.requestFocus();
        }
        
    }//GEN-LAST:event_edit_telephoneTextKeyReleased

    private void edit_addressTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_addressTextKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && edit_addressText.getText().trim().length()!=0){
            
                edit_DOB_test.requestFocus();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            edit_DOB_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
           edit_telephoneText.requestFocus();
        }
    }//GEN-LAST:event_edit_addressTextKeyReleased

    private void edit_DOB_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_DOB_testKeyReleased
         // TODO add your handling code here:
        editbirthdaynotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkDate(edit_DOB_test.getText());
        edit_DOB_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.birthdayChecker(edit_DOB_test.getText())){
            edit_marriedStatusRButton.requestFocus();}
            else{
               editbirthdaynotvalidlabel.setVisible(true); 
            }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            edit_marriedStatusRButton.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_addressText.requestFocus();
        }
    }//GEN-LAST:event_edit_DOB_testKeyReleased

    private void edit_marriedStatusRButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_marriedStatusRButtonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                edit_marriedStatusRButton.isSelected();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            edit_marided_sons.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_DOB_test.requestFocus();
            
        }
        
         else if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
           edit_singleStatusRButton.requestFocus();
            
        }
    }//GEN-LAST:event_edit_marriedStatusRButtonKeyReleased

    private void edit_singleStatusRButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_singleStatusRButtonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                edit_singleStatusRButton.isSelected();
       }
            
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){          
            edit_marided_sons.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_DOB_test.requestFocus();
            
        }
        
         else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
           edit_marriedStatusRButton.requestFocus();
            
        }
    }//GEN-LAST:event_edit_singleStatusRButtonKeyReleased

    private void edit_marided_sonsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_marided_sonsKeyReleased
        // TODO add your handling code here:
        editmarriedchildrennotvalidlabel.setVisible(false);
         String newtext=PatternChecker.checkInteger(edit_marided_sons.getText());
        edit_marided_sons.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (PatternChecker.checkIntegerdirect(edit_marided_sons.getText())){
                edit_unmarried_sons.requestFocus();
       }
            else{
              editmarriedchildrennotvalidlabel.setVisible(false);
        }
           }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            edit_unmarried_sons.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_singleStatusRButton.requestFocus();
        }
    }//GEN-LAST:event_edit_marided_sonsKeyReleased

    private void edit_unmarried_sonsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_unmarried_sonsKeyReleased
        // TODO add your handling code here:
        editunmarriedchildrennotvalidlabel.setVisible(false);
         String newtext=PatternChecker.checkInteger(edit_unmarried_sons.getText());
        edit_unmarried_sons.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkIntegerdirect(edit_unmarried_sons.getText())){
          editoccupation.requestFocus();}
            else{
             editunmarriedchildrennotvalidlabel.setVisible(true);   
            }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            editoccupation.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_marided_sons.requestFocus();
        }
    }//GEN-LAST:event_edit_unmarried_sonsKeyReleased

    private void editoccupationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoccupationKeyReleased
        // TODO add your handling code here:
        editoccupationnotvalidlabel.setVisible(false);
         String newtext=PatternChecker.checkstring(editoccupation.getText());
        editoccupation.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(editoccupation.getText())){
          edit_annualIncome.requestFocus();}
            else{
                 editoccupationnotvalidlabel.setVisible(true);
            }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            edit_annualIncome.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_unmarried_sons.requestFocus();
        }
    }//GEN-LAST:event_editoccupationKeyReleased

    private void edit_annualIncomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_annualIncomeKeyReleased
        // TODO add your handling code here:
        editincomenotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkInteger(edit_annualIncome.getText());
        edit_annualIncome.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkDecimaldirect(edit_annualIncome.getText())){
          edit_update_buttun.requestFocus();}
        else{
            editincomenotvalidlabel.setVisible(true);
        }}
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
           edit_update_buttun.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            editoccupation.requestFocus();
        }
    }//GEN-LAST:event_edit_annualIncomeKeyReleased

    private void edit_update_buttunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edit_update_buttunKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_UP){
            edit_annualIncome.requestFocus();
        }
    }//GEN-LAST:event_edit_update_buttunKeyReleased

    private void addCurrentResidenceButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addCurrentResidenceButtonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            annualIncomeText.requestFocus();
        }
    }//GEN-LAST:event_addCurrentResidenceButtonKeyReleased

    private void telephoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextActionPerformed

    private void singleStatusRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_singleStatusRButtonStateChanged
        // TODO add your handling code here:
        if(singleStatusRButton.isSelected()){
            marriedStatusRButton.setSelected(false);
        }
    }//GEN-LAST:event_singleStatusRButtonStateChanged

    private void search_nic_comboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_nic_comboKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search_nic_comboKeyReleased

    public void getResidenceData() { //to accept data from current residence detail form

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel AnnualIncome;
    private javax.swing.JLabel Birthday;
    private javax.swing.JPanel CurrentResidencePanel;
    private javax.swing.JLabel NIC;
    private javax.swing.JLabel Name;
    private javax.swing.JPanel NewApplicantDetailPanel;
    private javax.swing.JLabel NoOfUnmarriedChildren;
    private javax.swing.JLabel NumberOfMarriedChildren;
    private javax.swing.JLabel Occupation;
    private javax.swing.JLabel PhoneNo;
    private javax.swing.JLabel RegNo;
    private javax.swing.JLabel Status;
    private javax.swing.JButton addCurrentResidenceButton;
    private javax.swing.JTextArea addressText;
    private javax.swing.JTextField annualIncomeText;
    private javax.swing.JTextField applicantNumberText;
    private org.freixas.jcalendar.JCalendarCombo birthdayChooser1;
    private javax.swing.JPanel childrenCountPanel;
    private javax.swing.JPanel childrenCountPanel1;
    private javax.swing.JPanel childrenCountPanel2;
    private javax.swing.JLabel currentResidenceLabel;
    private javax.swing.JTextField edit_DOB_test;
    private javax.swing.JTextArea edit_addressText;
    private javax.swing.JTextField edit_annualIncome;
    private javax.swing.JTextField edit_marided_sons;
    private javax.swing.JRadioButton edit_marriedStatusRButton;
    private javax.swing.JTextField edit_nameText;
    private javax.swing.JComboBox edit_nic_combo;
    private javax.swing.JRadioButton edit_singleStatusRButton;
    private javax.swing.JTextField edit_telephoneText;
    private javax.swing.JTextField edit_unmarried_sons;
    private javax.swing.JButton edit_update_buttun;
    private javax.swing.JLabel editbirthdaynotvalidlabel;
    private javax.swing.JLabel editincomenotvalidlabel;
    private javax.swing.JLabel editmarriedchildrennotvalidlabel;
    private javax.swing.JLabel editnamenotvalidlabel;
    private javax.swing.JTextField editoccupation;
    private javax.swing.JLabel editoccupationnotvalidlabel;
    private javax.swing.JLabel editphonenonotvalidlabel;
    private javax.swing.JLabel editunmarriedchildrennotvalidlabel;
    private javax.swing.JLabel incomenotvalidlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JSpinner marriedChildrenCountSpinner;
    private javax.swing.JRadioButton marriedStatusRButton;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel namenotvalidlabel;
    private javax.swing.JPanel newApplicantTab;
    private javax.swing.JTextField nicText;
    private javax.swing.JLabel nicnotvalidlabel;
    private javax.swing.JTextField occupationText;
    private javax.swing.JLabel occupationnotvalidlabel;
    private javax.swing.JPanel personalDetailPanel;
    private javax.swing.JPanel personalDetailPanel1;
    private javax.swing.JPanel personalDetailPanel2;
    private javax.swing.JLabel phonenumnotvalidlabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextField search_DOB_test;
    private javax.swing.JTextArea search_addressText;
    private javax.swing.JTextField search_annualIncome;
    private javax.swing.JTextField search_marided_sons;
    private javax.swing.JRadioButton search_marriedStatusRButton;
    private javax.swing.JTextField search_nameText;
    private javax.swing.JComboBox search_nic_combo;
    private javax.swing.JRadioButton search_singleStatusRButton;
    private javax.swing.JTextField search_telephoneText;
    private javax.swing.JTextField search_unmarried_sons;
    private javax.swing.JTextField searchoccupationbutton;
    private javax.swing.JRadioButton singleStatusRButton;
    private javax.swing.ButtonGroup statusButtonGroup;
    private javax.swing.JTextField telephoneText;
    private javax.swing.JSpinner unmarriedChildrenCountSpinner;
    // End of variables declaration//GEN-END:variables
}
