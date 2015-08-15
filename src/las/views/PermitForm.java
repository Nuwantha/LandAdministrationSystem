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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import las.common_classes.GUIitemsValidator;
import las.controllers.ClientController;
import las.controllers.GramaNiladariDivisionController;
import las.controllers.LandController;
import las.controllers.LotController;
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

        //cancel permit
        cancelpermit_permit_number_combo.setEditable(true);
        JTextComponent editorCancelPemitPNCombo = (JTextComponent) cancelpermit_permit_number_combo.getEditor().getEditorComponent();
        editorCancelPemitPNCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) cancelpermit_permit_number_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    ArrayList<Permit> simmilarPlanNumbers = PermitController.getSimilarPermitNumbers(item);
                    for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                        list.add(simmilarPlanNumbers.get(i).getPermitNumber());
                    }
                    GUIitemsValidator.addItemToCombo(list, cancelpermit_permit_number_combo);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        //seach permit 
        searchpermit_permit_number_combo.setEditable(true);
        JTextComponent editorSearchPemitPNCombo = (JTextComponent) searchpermit_permit_number_combo.getEditor().getEditorComponent();
        editorSearchPemitPNCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String item = (String) searchpermit_permit_number_combo.getEditor().getItem();
                ArrayList<Object> list = new ArrayList();
                try {
                    ArrayList<Permit> simmilarPlanNumbers = PermitController.getSimilarPermitNumbers(item);
                    for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                        list.add(simmilarPlanNumbers.get(i).getPermitNumber());
                    }
                    GUIitemsValidator.addItemToCombo(list, searchpermit_permit_number_combo);

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

                    ArrayList<Client> simmilarNICs = ClientController.getNoPermitOwners(item);
                    for (int i = 0; i < simmilarNICs.size(); i++) {
                        list.add(simmilarNICs.get(i).getNIC());
                    }
                    GUIitemsValidator.addItemToCombo(list, add_permit_nic_combo);

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
        addpermit_permit_issue_dateChooser = new org.freixas.jcalendar.JCalendarCombo();
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
        searchpermit_permit_number_combo = new javax.swing.JComboBox();
        searchPermit_issueDate = new javax.swing.JTextField();
        Add_Save1 = new javax.swing.JButton();
        Add_Cancel1 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        editpermit_landName_test = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        searchpermit_division_name_test = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        searchpermit_acres_test = new javax.swing.JTextField();
        searchpermit_perches_test = new javax.swing.JTextField();
        searchpermit_roods_test = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        searchPermit_DivisionumberTest = new javax.swing.JTextField();
        searchPermitPlanNumberTest = new javax.swing.JTextField();
        searchPermitLotNumberTest = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        searchpermit_NOS_name_test = new javax.swing.JTextField();
        searchpermit_NOS_nic_test = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchpermit_NOS_address_test = new javax.swing.JTextArea();
        nicInvalidLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        searchpermit_nameText = new javax.swing.JTextField();
        searchpermit_telephoneText = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        searchpermit_addressText = new javax.swing.JTextArea();
        searchpermit_no_of_children_test = new javax.swing.JTextField();
        searchpermit_marriedStatusRButton = new javax.swing.JRadioButton();
        searchpermit_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        searchpermit_annualIncome = new javax.swing.JTextField();
        searchpermit_DOB_test = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        searchPermit_clientNic = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        addpermit_add_permit_button1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        AddGND2 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        AddGNDNo2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        AddNotSurveyedNorth2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        AddNotSurveyedEast2 = new javax.swing.JTextField();
        AddNotSurveyedSouth2 = new javax.swing.JTextField();
        AddNotSurveyedWest2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        cancelpermit_permit_number_combo = new javax.swing.JComboBox();
        cancelPermit_issueDate = new javax.swing.JTextField();
        Add_Save2 = new javax.swing.JButton();
        Add_Cancel2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cancelpermit_landName_test = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        cancelpermit_division_name_test = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        cancelpermit_acres_test = new javax.swing.JTextField();
        cancelpermit_perches_test = new javax.swing.JTextField();
        cancelpermit_roods_test = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        cancelPermit_DivisionumberTest = new javax.swing.JTextField();
        cancelPermitPlanNumberTest = new javax.swing.JTextField();
        cancelPermitLotNumberTest = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        cancelpermit_NOS_name_test = new javax.swing.JTextField();
        cancelpermit_NOS_nic_test = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        cancelpermit_NOS_address_test = new javax.swing.JTextArea();
        nicInvalidLabel2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        cancelpermit_nameText = new javax.swing.JTextField();
        cancelpermit_telephoneText = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        cancelpermit_addressText = new javax.swing.JTextArea();
        cancelpermit_no_of_children_test = new javax.swing.JTextField();
        cancelpermit_marriedStatusRButton = new javax.swing.JRadioButton();
        cancelpermit_singleStatusRButton = new javax.swing.JRadioButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        cancelpermit_annualIncome = new javax.swing.JTextField();
        cancelpermit_DOB_test = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        cancelPermit_clientNic = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        cancelpermit_cancel_permit_button = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        viewAll_load_buttun = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        viewAll_table = new javax.swing.JTable();

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
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addpermit_permit_numberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addpermit_permit_issue_dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addpermit_permit_issue_dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add_permit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(add_permit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel102)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel101)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add_permit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(add_permit_division_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel99)
                                        .addGap(79, 79, 79)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(add_permit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add_permit_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(add_permit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(add_permit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(add_permit_lot_number_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(add_permit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_permit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel101)
                            .addComponent(add_permit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel102)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("New successor details"));

        jLabel10.setText("Name:");

        jLabel11.setText("NIC:");

        jLabel12.setText("Address:");

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
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(addpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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

        jLabel37.setText("No. of children:");

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
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(add_permit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel37))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_permit_no_of_children_test)
                            .addComponent(add_permit_annualIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Save)
                    .addComponent(Add_Cancel))
                .addGap(23, 23, 23))
        );

        jTabbedPane4.addTab("Add Permit", jPanel2);

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

        searchpermit_permit_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchpermit_permit_number_comboItemStateChanged(evt);
            }
        });
        searchpermit_permit_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_permit_number_comboActionPerformed(evt);
            }
        });
        searchpermit_permit_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_permit_number_comboActionPerformed(evt);
            }
        });

        searchPermit_issueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPermit_issueDateActionPerformed(evt);
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
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddGNDNo1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(AddGND1))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchpermit_permit_number_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPermit_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchpermit_permit_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPermit_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        searchpermit_division_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_division_name_testActionPerformed(evt);
            }
        });

        jLabel24.setText("Included Land");

        jLabel25.setText("Included Division");

        jLabel104.setText("Expected Extent");

        searchpermit_perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_perches_testActionPerformed(evt);
            }
        });

        jLabel105.setText("Roods");

        jLabel106.setText("Perches");

        jLabel107.setText("Acre / Hectare");

        jLabel108.setText("Lot No");

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
                            .addComponent(searchpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addGap(29, 29, 29)
                                .addComponent(searchPermitLotNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel104)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(searchpermit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel106)
                                    .addComponent(jLabel107))))
                        .addGap(46, 46, 46)
                        .addComponent(searchpermit_roods_test)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel105))
                    .addComponent(jLabel25)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(searchPermitPlanNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(searchPermit_DivisionumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPermit_DivisionumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editpermit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPermitPlanNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(searchPermitLotNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(searchpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchpermit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchpermit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel105)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel107)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel106)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Nominated Successor details"));

        jLabel26.setText("Name:");

        jLabel42.setText("NIC:");

        jLabel43.setText("Address:");

        searchpermit_NOS_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_NOS_name_testActionPerformed(evt);
            }
        });

        searchpermit_NOS_nic_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_NOS_nic_testActionPerformed(evt);
            }
        });

        searchpermit_NOS_address_test.setColumns(20);
        searchpermit_NOS_address_test.setRows(5);
        jScrollPane2.setViewportView(searchpermit_NOS_address_test);

        nicInvalidLabel1.setForeground(new java.awt.Color(255, 0, 0));
        nicInvalidLabel1.setText("NIC is invalid");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(searchpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nicInvalidLabel1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(searchpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(searchpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Owner Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        searchpermit_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchpermit_nameTextKeyReleased(evt);
            }
        });

        searchpermit_addressText.setColumns(20);
        searchpermit_addressText.setRows(5);
        jScrollPane4.setViewportView(searchpermit_addressText);

        searchpermit_no_of_children_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchpermit_no_of_children_testActionPerformed(evt);
            }
        });

        buttonGroup1.add(searchpermit_marriedStatusRButton);
        searchpermit_marriedStatusRButton.setText("Married");

        buttonGroup1.add(searchpermit_singleStatusRButton);
        searchpermit_singleStatusRButton.setText("Single");

        jLabel45.setText("NIC :");

        jLabel46.setText("Name:");

        jLabel47.setText("Phone Number:");

        jLabel48.setText("Address:");

        jLabel49.setText("Birthday:");

        jLabel50.setText("Status:");

        jLabel51.setText("Annual Income:");

        jLabel52.setText("No. of children:");

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
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchpermit_DOB_test)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(searchpermit_nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(searchpermit_marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(searchpermit_singleStatusRButton))
                            .addComponent(searchPermit_clientNic)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(searchpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchpermit_no_of_children_test)
                            .addComponent(searchpermit_annualIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPermit_clientNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(searchpermit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(13, 13, 13)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(searchpermit_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchpermit_marriedStatusRButton)
                    .addComponent(searchpermit_singleStatusRButton)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(searchpermit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(searchpermit_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
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

        jTabbedPane4.addTab("Search Permit", jPanel12);

        jPanel5.setPreferredSize(new java.awt.Dimension(581, 581));

        jPanel18.setPreferredSize(new java.awt.Dimension(950, 600));

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Permit Information"));
        jPanel19.setPreferredSize(new java.awt.Dimension(581, 581));

        jLabel13.setText("Grama Niladari Division:");

        AddGND2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGND2ActionPerformed(evt);
            }
        });

        jLabel44.setText("Permit No:");

        jLabel53.setText("Grama Niladari Division No:");

        AddGNDNo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGNDNo2ActionPerformed(evt);
            }
        });

        jLabel54.setText("On The North By:");

        AddNotSurveyedNorth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedNorth2ActionPerformed(evt);
            }
        });

        jLabel55.setText("On The East  By:");

        jLabel56.setText("On The South By:");

        jLabel57.setText("On The West By:");

        AddNotSurveyedEast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedEast2ActionPerformed(evt);
            }
        });

        AddNotSurveyedSouth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedSouth2ActionPerformed(evt);
            }
        });

        AddNotSurveyedWest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNotSurveyedWest2ActionPerformed(evt);
            }
        });

        jLabel58.setText("Issue Date:");

        cancelpermit_permit_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cancelpermit_permit_number_comboItemStateChanged(evt);
            }
        });
        cancelpermit_permit_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_permit_number_comboActionPerformed(evt);
            }
        });

        cancelPermit_issueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPermit_issueDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddNotSurveyedWest2))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel54))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddNotSurveyedEast2)
                                    .addComponent(AddNotSurveyedSouth2)
                                    .addComponent(AddNotSurveyedNorth2)))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AddGNDNo2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(AddGND2)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cancelpermit_permit_number_combo, 0, 121, Short.MAX_VALUE)
                                    .addComponent(cancelPermit_issueDate))))
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelpermit_permit_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelPermit_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(488, 488, 488)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedNorth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedEast2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedSouth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNotSurveyedWest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGND2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGNDNo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(13, 13, 13))
        );

        Add_Save2.setText("Save");
        Add_Save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Save2ActionPerformed(evt);
            }
        });

        Add_Cancel2.setText("Cancel");

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Details"));

        jLabel59.setText("Plan Number");

        jLabel60.setText("Land Name");

        cancelpermit_landName_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_landName_testActionPerformed(evt);
            }
        });

        jLabel61.setText("Division Number:");

        jLabel62.setText("Name:");

        cancelpermit_division_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_division_name_testActionPerformed(evt);
            }
        });

        jLabel63.setText("Included Land");

        jLabel64.setText("Included Division");

        jLabel109.setText("Expected Extent");

        cancelpermit_perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_perches_testActionPerformed(evt);
            }
        });

        jLabel110.setText("Roods");

        jLabel111.setText("Perches");

        jLabel112.setText("Acre / Hectare");

        jLabel113.setText("Lot No");

        cancelPermitLotNumberTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPermitLotNumberTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(286, 286, 286)
                            .addComponent(cancelpermit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cancelpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cancelPermitPlanNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(cancelPermit_DivisionumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel113)
                                .addGap(29, 29, 29)
                                .addComponent(cancelPermitLotNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel109)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancelpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cancelpermit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel111)
                                    .addComponent(jLabel112))))
                        .addGap(46, 46, 46)
                        .addComponent(cancelpermit_roods_test)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel110)))
                .addGap(35, 35, 35))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelpermit_division_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelPermit_DivisionumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel63)
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelpermit_landName_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelPermitPlanNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(cancelPermitLotNumberTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(cancelpermit_acres_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelpermit_perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel112)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel110)
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(cancelpermit_roods_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("New successor details"));

        jLabel65.setText("Name:");

        jLabel66.setText("NIC:");

        jLabel67.setText("Address:");

        cancelpermit_NOS_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_NOS_name_testActionPerformed(evt);
            }
        });

        cancelpermit_NOS_nic_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_NOS_nic_testActionPerformed(evt);
            }
        });

        cancelpermit_NOS_address_test.setColumns(20);
        cancelpermit_NOS_address_test.setRows(5);
        jScrollPane6.setViewportView(cancelpermit_NOS_address_test);

        nicInvalidLabel2.setForeground(new java.awt.Color(255, 0, 0));
        nicInvalidLabel2.setText("NIC is invalid");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67))
                .addGap(37, 37, 37)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(cancelpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nicInvalidLabel2))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(cancelpermit_NOS_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(cancelpermit_NOS_nic_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicInvalidLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "owner Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        cancelpermit_nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cancelpermit_nameTextKeyReleased(evt);
            }
        });

        cancelpermit_addressText.setColumns(20);
        cancelpermit_addressText.setRows(5);
        jScrollPane7.setViewportView(cancelpermit_addressText);

        cancelpermit_no_of_children_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_no_of_children_testActionPerformed(evt);
            }
        });

        buttonGroup1.add(cancelpermit_marriedStatusRButton);
        cancelpermit_marriedStatusRButton.setText("Married");

        buttonGroup1.add(cancelpermit_singleStatusRButton);
        cancelpermit_singleStatusRButton.setText("Single");

        jLabel68.setText("NIC :");

        jLabel69.setText("Name:");

        jLabel70.setText("Phone Number:");

        jLabel71.setText("Address:");

        jLabel72.setText("Birthday:");

        jLabel73.setText("Status:");

        jLabel74.setText("Annual Income:");

        jLabel75.setText("No. of children:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelpermit_DOB_test)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(cancelpermit_nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(cancelpermit_marriedStatusRButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelpermit_singleStatusRButton))
                            .addComponent(cancelPermit_clientNic)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cancelpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelpermit_no_of_children_test)
                            .addComponent(cancelpermit_annualIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelPermit_clientNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(cancelpermit_nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelpermit_telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addGap(13, 13, 13)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(cancelpermit_DOB_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelpermit_marriedStatusRButton)
                    .addComponent(cancelpermit_singleStatusRButton)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(cancelpermit_annualIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(cancelpermit_no_of_children_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelpermit_cancel_permit_button.setText("Cancel Permit");
        cancelpermit_cancel_permit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelpermit_cancel_permit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelpermit_cancel_permit_button)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(cancelpermit_cancel_permit_button)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Add_Cancel2)
                        .addGap(35, 35, 35)
                        .addComponent(Add_Save2)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Save2)
                    .addComponent(Add_Cancel2))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Cancel Permit", jPanel5);

        jPanel10.setPreferredSize(new java.awt.Dimension(581, 581));

        viewAll_load_buttun.setText("Load");
        viewAll_load_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAll_load_buttunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(760, Short.MAX_VALUE)
                .addComponent(viewAll_load_buttun, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(viewAll_load_buttun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewAll_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PermitNumber", "IssueDate", "Clientname", "ClientNic", "DivisionalNumber", "PlanNumber", "LandName", "LotNumber", "NominateSuccesor", "OwnarshipPosition"
            }
        ));
        jScrollPane5.setViewportView(viewAll_table);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("View All Permits", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
                GUIitemsValidator.addItemToCombo(list, add_permit_planNumber_combo);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_permit_division_number_comboItemStateChanged

    private void add_permit_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_add_permit_planNumber_comboItemStateChanged
        try {
            Land searchLand = LandController.getAvailableLotOfLand(String.valueOf(add_permit_planNumber_combo.getSelectedItem()));
            if (searchLand != null) {
                add_permit_landName_test.setText(searchLand.getLandName());
                ArrayList<Lot> lotList = searchLand.getLotList();
                ArrayList<Object> list = new ArrayList();
                for (Lot lot : lotList) {
                    list.add(lot.getLotNumber());
                }
                GUIitemsValidator.addItemToCombo(list, add_permit_lot_number_Combo);

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

    private void searchpermit_division_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_division_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_division_name_testActionPerformed

    private void searchpermit_perches_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_perches_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_perches_testActionPerformed

    private void searchpermit_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchpermit_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_nameTextKeyReleased

    private void searchpermit_no_of_children_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_no_of_children_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_no_of_children_testActionPerformed

    private void addpermit_add_permit_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpermit_add_permit_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addpermit_add_permit_button1ActionPerformed

    private void searchpermit_permit_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchpermit_permit_number_comboItemStateChanged
        try {
            Permit searchPermit = PermitController.searchPermit(String.valueOf(searchpermit_permit_number_combo.getSelectedItem()));
            if (searchPermit != null) {
                Client client = searchPermit.getClient();
                NominatedSuccessor nominatedSuccessor = searchPermit.getNominatedSuccessor();
                Lot lot = searchPermit.getLot();
                String permitIssueDate = searchPermit.getPermitIssueDate();
                searchpermit_nameText.setText(client.getClientName());
                searchpermit_telephoneText.setText(client.getTelephone());
                searchPermit_clientNic.setText(client.getNIC());
                searchpermit_DOB_test.setText(client.getBirthday());
                searchpermit_addressText.setText(client.getAddress());
                searchpermit_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                searchpermit_no_of_children_test.setText(String.valueOf(client.getNumberOfMarriedSons() + client.getNumberOfUnmarriedSons()));
                if (client.isMarried() == 1) {
                    searchpermit_marriedStatusRButton.setSelected(true);
                } else {
                    searchpermit_singleStatusRButton.setSelected(true);
                }

                int year = Integer.parseInt(permitIssueDate.substring(0, 3));
                int month = Integer.parseInt(permitIssueDate.substring(5, 6));
                int date = Integer.parseInt(permitIssueDate.substring(8, 9));
                Date issueDate = new Date(year, month, date);

                searchpermit_NOS_address_test.setText(nominatedSuccessor.getAddress());
                searchpermit_NOS_name_test.setText(nominatedSuccessor.getAddress());
                searchpermit_NOS_nic_test.setText(nominatedSuccessor.getNIC_S());

                searchPermitLotNumberTest.setText(lot.getLotNumber());
                searchpermit_acres_test.setText(String.valueOf(lot.getNumberOfAcres()));
                searchpermit_perches_test.setText(String.valueOf(lot.getNumberOfPerches()));
                searchpermit_roods_test.setText(String.valueOf(lot.getNumberofRoods()));

                Land land = lot.getLand();
                searchPermitPlanNumberTest.setText(land.getPlanNumber());
                editpermit_landName_test.setText(land.getLandName());
                searchPermit_DivisionumberTest.setText(land.getDivisionNumber());
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                searchpermit_division_name_test.setText(searchGND.getDivisionName());

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchpermit_permit_number_comboItemStateChanged

    private void searchPermit_issueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPermit_issueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPermit_issueDateActionPerformed

    private void searchpermit_NOS_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_NOS_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_NOS_name_testActionPerformed

    private void searchpermit_NOS_nic_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_NOS_nic_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_NOS_nic_testActionPerformed

    private void viewAll_load_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAll_load_buttunActionPerformed
        DefaultTableModel model = (DefaultTableModel) viewAll_table.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        try {
            ArrayList<Permit> allPermit = PermitController.getAllPermit();

            for (Permit permit : allPermit) {
                Object[] rowdata = {permit.getPermitNumber(), permit.getPermitIssueDate(), permit.getClient().getClientName(), permit.getClient().getNIC(), permit.getLot().getLand().getDivisionNumber(), permit.getLot().getLand().getPlanNumber(), permit.getLot().getLand().getLandName(), permit.getLot().getLotNumber(), permit.getNominatedSuccessor().getName(), permit.getClient().getPermitOwnershipPosition()};
                model.addRow(rowdata);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_viewAll_load_buttunActionPerformed

    private void AddGND2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGND2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGND2ActionPerformed

    private void AddGNDNo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGNDNo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGNDNo2ActionPerformed

    private void AddNotSurveyedNorth2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedNorth2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedNorth2ActionPerformed

    private void AddNotSurveyedEast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedEast2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedEast2ActionPerformed

    private void AddNotSurveyedSouth2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedSouth2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedSouth2ActionPerformed

    private void AddNotSurveyedWest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNotSurveyedWest2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddNotSurveyedWest2ActionPerformed

    private void cancelpermit_permit_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cancelpermit_permit_number_comboItemStateChanged
        try {
            Permit searchPermit = PermitController.searchPermit(String.valueOf(cancelpermit_permit_number_combo.getSelectedItem()));
            if (searchPermit != null) {
                Client client = searchPermit.getClient();
                NominatedSuccessor nominatedSuccessor = searchPermit.getNominatedSuccessor();
                Lot lot = searchPermit.getLot();
                String permitIssueDate = searchPermit.getPermitIssueDate();
                cancelpermit_nameText.setText(client.getClientName());
                cancelpermit_telephoneText.setText(client.getTelephone());
                cancelPermit_clientNic.setText(client.getNIC());
                cancelpermit_DOB_test.setText(client.getBirthday());
                cancelpermit_addressText.setText(client.getAddress());
                cancelpermit_annualIncome.setText(String.valueOf(client.getAnnualIncome()));
                cancelpermit_no_of_children_test.setText(String.valueOf(client.getNumberOfMarriedSons() + client.getNumberOfUnmarriedSons()));
                if (client.isMarried() == 1) {
                    cancelpermit_marriedStatusRButton.setSelected(true);
                } else {
                    cancelpermit_singleStatusRButton.setSelected(true);
                }
                int year = Integer.parseInt(permitIssueDate.substring(0, 3));
                int month = Integer.parseInt(permitIssueDate.substring(5, 6));
                int date = Integer.parseInt(permitIssueDate.substring(8, 9));
                Date issueDate = new Date(year, month, date);

                cancelPermit_issueDate.setText(permitIssueDate);
                cancelpermit_NOS_address_test.setText(nominatedSuccessor.getAddress());
                cancelpermit_NOS_name_test.setText(nominatedSuccessor.getAddress());
                cancelpermit_NOS_nic_test.setText(nominatedSuccessor.getNIC_S());

                cancelPermitLotNumberTest.setText(lot.getLotNumber());
                cancelpermit_acres_test.setText(String.valueOf(lot.getNumberOfAcres()));
                cancelpermit_perches_test.setText(String.valueOf(lot.getNumberOfPerches()));
                cancelpermit_roods_test.setText(String.valueOf(lot.getNumberofRoods()));

                Land land = lot.getLand();
                cancelPermitPlanNumberTest.setText(land.getPlanNumber());
                cancelpermit_landName_test.setText(land.getLandName());
                cancelPermit_DivisionumberTest.setText(land.getDivisionNumber());
                GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND(land.getDivisionNumber());
                cancelpermit_division_name_test.setText(searchGND.getDivisionName());

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cancelpermit_permit_number_comboItemStateChanged

    private void cancelPermit_issueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPermit_issueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelPermit_issueDateActionPerformed

    private void Add_Save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Save2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_Save2ActionPerformed

    private void cancelpermit_landName_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_landName_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_landName_testActionPerformed

    private void cancelpermit_division_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_division_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_division_name_testActionPerformed

    private void cancelpermit_perches_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_perches_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_perches_testActionPerformed

    private void cancelpermit_NOS_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_NOS_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_NOS_name_testActionPerformed

    private void cancelpermit_NOS_nic_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_NOS_nic_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_NOS_nic_testActionPerformed

    private void cancelpermit_nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelpermit_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_nameTextKeyReleased

    private void cancelpermit_no_of_children_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_no_of_children_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_no_of_children_testActionPerformed

    private void cancelpermit_cancel_permit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_cancel_permit_buttonActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Do you want to cancel permit");
        if (showConfirmDialog == 0) {
            try {
                NominatedSuccessor nominatedSuccessor = new NominatedSuccessor(cancelpermit_NOS_nic_test.getText(), cancelpermit_NOS_name_test.getText(), cancelpermit_NOS_address_test.getText());
                Client searchClient = ClientController.searchClient(cancelPermit_clientNic.getText());
                Lot searchLot = LotController.searchLot(cancelPermitLotNumberTest.getText());
                Permit permit = new Permit(String.valueOf(cancelpermit_permit_number_combo.getSelectedItem()), cancelPermit_issueDate.getText(), searchLot, searchClient, nominatedSuccessor);
                boolean cancelPermit = PermitController.cancelPermit(permit);
                if (cancelPermit) {
                    JOptionPane.showMessageDialog(this, "permit cancel successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "permit does not cancel successfully");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PermitForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cancelpermit_cancel_permit_buttonActionPerformed

    private void cancelPermitLotNumberTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPermitLotNumberTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelPermitLotNumberTestActionPerformed

    private void cancelpermit_permit_number_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelpermit_permit_number_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelpermit_permit_number_comboActionPerformed

    private void searchpermit_permit_number_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchpermit_permit_number_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchpermit_permit_number_comboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddGND;
    private javax.swing.JTextField AddGND1;
    private javax.swing.JTextField AddGND2;
    private javax.swing.JTextField AddGNDNo;
    private javax.swing.JTextField AddGNDNo1;
    private javax.swing.JTextField AddGNDNo2;
    private javax.swing.JTextField AddNotSurveyedEast;
    private javax.swing.JTextField AddNotSurveyedEast1;
    private javax.swing.JTextField AddNotSurveyedEast2;
    private javax.swing.JTextField AddNotSurveyedNorth;
    private javax.swing.JTextField AddNotSurveyedNorth1;
    private javax.swing.JTextField AddNotSurveyedNorth2;
    private javax.swing.JTextField AddNotSurveyedSouth;
    private javax.swing.JTextField AddNotSurveyedSouth1;
    private javax.swing.JTextField AddNotSurveyedSouth2;
    private javax.swing.JTextField AddNotSurveyedWest;
    private javax.swing.JTextField AddNotSurveyedWest1;
    private javax.swing.JTextField AddNotSurveyedWest2;
    private javax.swing.JButton Add_Cancel;
    private javax.swing.JButton Add_Cancel1;
    private javax.swing.JButton Add_Cancel2;
    private javax.swing.JButton Add_Save;
    private javax.swing.JButton Add_Save1;
    private javax.swing.JButton Add_Save2;
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
    private org.freixas.jcalendar.JCalendarCombo addpermit_permit_issue_dateChooser;
    private javax.swing.JTextField addpermit_permit_numberTest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cancelPermitLotNumberTest;
    private javax.swing.JTextField cancelPermitPlanNumberTest;
    private javax.swing.JTextField cancelPermit_DivisionumberTest;
    private javax.swing.JTextField cancelPermit_clientNic;
    private javax.swing.JTextField cancelPermit_issueDate;
    private javax.swing.JTextField cancelpermit_DOB_test;
    private javax.swing.JTextArea cancelpermit_NOS_address_test;
    private javax.swing.JTextField cancelpermit_NOS_name_test;
    private javax.swing.JTextField cancelpermit_NOS_nic_test;
    private javax.swing.JTextField cancelpermit_acres_test;
    private javax.swing.JTextArea cancelpermit_addressText;
    private javax.swing.JTextField cancelpermit_annualIncome;
    private javax.swing.JButton cancelpermit_cancel_permit_button;
    private javax.swing.JTextField cancelpermit_division_name_test;
    private javax.swing.JTextField cancelpermit_landName_test;
    private javax.swing.JRadioButton cancelpermit_marriedStatusRButton;
    private javax.swing.JTextField cancelpermit_nameText;
    private javax.swing.JTextField cancelpermit_no_of_children_test;
    private javax.swing.JTextField cancelpermit_perches_test;
    private javax.swing.JComboBox cancelpermit_permit_number_combo;
    private javax.swing.JTextField cancelpermit_roods_test;
    private javax.swing.JRadioButton cancelpermit_singleStatusRButton;
    private javax.swing.JTextField cancelpermit_telephoneText;
    private javax.swing.JTextField editpermit_landName_test;
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
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
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
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel nicInvalidLabel;
    private javax.swing.JLabel nicInvalidLabel1;
    private javax.swing.JLabel nicInvalidLabel2;
    private javax.swing.JTextField searchPermitLotNumberTest;
    private javax.swing.JTextField searchPermitPlanNumberTest;
    private javax.swing.JTextField searchPermit_DivisionumberTest;
    private javax.swing.JTextField searchPermit_clientNic;
    private javax.swing.JTextField searchPermit_issueDate;
    private javax.swing.JTextField searchpermit_DOB_test;
    private javax.swing.JTextArea searchpermit_NOS_address_test;
    private javax.swing.JTextField searchpermit_NOS_name_test;
    private javax.swing.JTextField searchpermit_NOS_nic_test;
    private javax.swing.JTextField searchpermit_acres_test;
    private javax.swing.JTextArea searchpermit_addressText;
    private javax.swing.JTextField searchpermit_annualIncome;
    private javax.swing.JTextField searchpermit_division_name_test;
    private javax.swing.JRadioButton searchpermit_marriedStatusRButton;
    private javax.swing.JTextField searchpermit_nameText;
    private javax.swing.JTextField searchpermit_no_of_children_test;
    private javax.swing.JTextField searchpermit_perches_test;
    private javax.swing.JComboBox searchpermit_permit_number_combo;
    private javax.swing.JTextField searchpermit_roods_test;
    private javax.swing.JRadioButton searchpermit_singleStatusRButton;
    private javax.swing.JTextField searchpermit_telephoneText;
    private javax.swing.JButton viewAll_load_buttun;
    private javax.swing.JTable viewAll_table;
    // End of variables declaration//GEN-END:variables
}
