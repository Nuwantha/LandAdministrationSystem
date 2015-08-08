/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import las.common_classes.ComboItemAdder;
import las.common_classes.IdGenerator;
import las.controllers.GramaNiladariDivisionController;
import las.controllers.LandController;
import las.controllers.LotController;
import las.models.GramaNiladariDivision;
import las.models.Land;
import las.models.Lot;

/**
 *
 * @author Uer
 */
public class LandForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form Land
     */
    public LandForm() {
        initComponents();

        try {
            Lot lastAddedLot = LotController.getLastAddedLot();
            lot_number_test.setText(IdGenerator.generateNextLotNumber(lastAddedLot.getLotNumber()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //search combo
            
            //update cobo ekata
            search_planNumber_combo.setEditable(true);
            JTextComponent editorSearchPlanNumberCombo = (JTextComponent) search_planNumber_combo.getEditor().getEditorComponent();
            editorSearchPlanNumberCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    String item = (String) search_planNumber_combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    try {

                        ArrayList<Land> simmilarPlanNumbers = LandController.getSimmilarPlanNumbers(item);
                        for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                            list.add(simmilarPlanNumbers.get(i).getPlanNumber());
                        }
                        ComboItemAdder.addItemToCombo(list,search_planNumber_combo);

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            
            
            
            //update cobo ekata
            update_planNumber_combo.setEditable(true);
            JTextComponent editorPlanNumberCombo = (JTextComponent) update_planNumber_combo.getEditor().getEditorComponent();
            editorPlanNumberCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    String item = (String) update_planNumber_combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    try {

                        ArrayList<Land> simmilarPlanNumbers = LandController.getSimmilarPlanNumbers(item);
                        for (int i = 0; i < simmilarPlanNumbers.size(); i++) {
                            list.add(simmilarPlanNumbers.get(i).getPlanNumber());
                        }
                        ComboItemAdder.addItemToCombo(list, update_planNumber_combo);

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            //update gnd combo 
            JTextComponent editorUpdateGndCombo = (JTextComponent) update_gnd_combo.getEditor().getEditorComponent();
            update_gnd_combo.setEditable(true);
            editorUpdateGndCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    String item = (String) update_gnd_combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    try {

                        ArrayList<GramaNiladariDivision> simmilarGndDivisionNumbers = GramaNiladariDivisionController.getSimmilarGndDivisionNumbers(item);
                        for (int i = 0; i < simmilarGndDivisionNumbers.size(); i++) {
                            list.add(simmilarGndDivisionNumbers.get(i).getDivisionNumber());
                        }
                        ComboItemAdder.addItemToCombo(list, update_gnd_combo);

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

            Land lastAddedLand = LandController.getLastAddedLand();
            String planNumber = lastAddedLand.getPlanNumber();
            String generateNextPlanNumber = IdGenerator.generateNextPlanNumber(planNumber);
            JTextComponent editor = (JTextComponent) gnd_number_combo.getEditor().getEditorComponent();
            plan_nummber_test.setText(generateNextPlanNumber);
            gnd_number_combo.setEditable(true);
            editor.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    String item = (String) gnd_number_combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    try {

                        ArrayList<GramaNiladariDivision> simmilarGndDivisionNumbers = GramaNiladariDivisionController.getSimmilarGndDivisionNumbers(item);
                        for (int i = 0; i < simmilarGndDivisionNumbers.size(); i++) {
                            list.add(simmilarGndDivisionNumbers.get(i).getDivisionNumber());
                        }
                        ComboItemAdder.addItemToCombo(list, gnd_number_combo);

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
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

        LandTabbedPane = new javax.swing.JTabbedPane();
        AddNewLand = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        perches_test = new javax.swing.JTextField();
        rood_test = new javax.swing.JTextField();
        acre_test = new javax.swing.JTextField();
        lot_number_test = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        add_lot_buttun = new javax.swing.JToggleButton();
        gnd_name_test = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        plan_nummber_test = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        land_north_test = new javax.swing.JTextField();
        land_east_test = new javax.swing.JTextField();
        land_west_test = new javax.swing.JTextField();
        land_south_test = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lot_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        land_save_buttun = new javax.swing.JButton();
        gnd_number_combo = new javax.swing.JComboBox();
        land_name_test = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        EditLandDetails = new javax.swing.JPanel();
        AddNewLand1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        update_land_name = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        update_north_test = new javax.swing.JTextField();
        update_east_test = new javax.swing.JTextField();
        update_west_test = new javax.swing.JTextField();
        update_south_test = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        update_lot_table = new javax.swing.JTable();
        update_planNumber_combo = new javax.swing.JComboBox();
        update_gnd_combo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        AddNewLand2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        search_land_name = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        search_north_test = new javax.swing.JTextField();
        search_east_test1 = new javax.swing.JTextField();
        search_west_test = new javax.swing.JTextField();
        search_south_test = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        search_lot_table = new javax.swing.JTable();
        search_planNumber_combo = new javax.swing.JComboBox();
        search_gnd_test = new javax.swing.JTextField();
        ViewAllLands = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_all_table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        view_all_load_buttun = new javax.swing.JButton();

        setClosable(true);
        setTitle("Land");
        setPreferredSize(new java.awt.Dimension(868, 518));

        LandTabbedPane.setPreferredSize(new java.awt.Dimension(868, 518));

        AddNewLand.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setText("G.N.D No");

        jLabel2.setText("Grama Niladhari Division");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Details"));

        jLabel3.setText("Lot No");

        jLabel4.setText("Expected Extent");

        perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perches_testActionPerformed(evt);
            }
        });

        jLabel11.setText("Acre / Hectare");

        jLabel12.setText("Perches");

        jLabel13.setText("Roods");

        add_lot_buttun.setText("Add Lot");
        add_lot_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_lot_buttunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lot_number_test, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel4)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acre_test)
                    .addComponent(perches_test, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(rood_test, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(176, 176, 176))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_lot_buttun)
                        .addGap(52, 52, 52))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lot_number_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(acre_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rood_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_lot_buttun))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gnd_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnd_name_testActionPerformed(evt);
            }
        });

        jLabel5.setText("Plan No");

        jLabel6.setText("Bounded -");

        jLabel7.setText("On North By");

        jLabel8.setText("On East By");

        jLabel9.setText("On West By");

        jLabel10.setText("On South By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(2, 2, 2)))
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(land_south_test)
                    .addComponent(land_east_test)
                    .addComponent(land_west_test)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(land_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(land_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(land_east_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(land_west_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(land_south_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lot_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LotNo", "Extent (Acres/Hectare)", "Extent (Perches)", "Extent (Roods)"
            }
        ));
        jScrollPane2.setViewportView(lot_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jButton1.setText("Cancel");

        land_save_buttun.setText("Save");
        land_save_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                land_save_buttunActionPerformed(evt);
            }
        });

        gnd_number_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gnd_number_comboItemStateChanged(evt);
            }
        });

        jLabel27.setText("Land Name");

        javax.swing.GroupLayout AddNewLandLayout = new javax.swing.GroupLayout(AddNewLand);
        AddNewLand.setLayout(AddNewLandLayout);
        AddNewLandLayout.setHorizontalGroup(
            AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddNewLandLayout.createSequentialGroup()
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(AddNewLandLayout.createSequentialGroup()
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plan_nummber_test, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gnd_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gnd_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddNewLandLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(land_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddNewLandLayout.createSequentialGroup()
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewLandLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(land_save_buttun)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(88, 88, 88))
        );
        AddNewLandLayout.setVerticalGroup(
            AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddNewLandLayout.createSequentialGroup()
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(plan_nummber_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(land_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(gnd_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(gnd_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(land_save_buttun))
                .addGap(24, 24, 24))
        );

        LandTabbedPane.addTab("Add New Land", AddNewLand);

        jLabel14.setText("planNumber");

        jLabel15.setText("Grama Niladhari Division");

        jLabel21.setText("Land Name");

        jLabel22.setText("Bounded -");

        jLabel23.setText("On North By");

        jLabel24.setText("On East By");

        jLabel25.setText("On West By");

        jLabel26.setText("On South By");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(2, 2, 2)))
                    .addComponent(jLabel26))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(update_south_test)
                    .addComponent(update_east_test)
                    .addComponent(update_west_test)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(update_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(update_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(update_east_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(update_west_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(update_south_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Cancel");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        update_lot_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LotNo", "Extent (Acres/Hectare)", "Extent (Perches)", "Extent (Roods)"
            }
        ));
        jScrollPane4.setViewportView(update_lot_table);

        update_planNumber_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                update_planNumber_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout AddNewLand1Layout = new javax.swing.GroupLayout(AddNewLand1);
        AddNewLand1.setLayout(AddNewLand1Layout);
        AddNewLand1Layout.setHorizontalGroup(
            AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewLand1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3))
                    .addGroup(AddNewLand1Layout.createSequentialGroup()
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update_land_name)
                            .addComponent(update_planNumber_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update_gnd_combo, 0, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AddNewLand1Layout.setVerticalGroup(
            AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewLand1Layout.createSequentialGroup()
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_land_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(update_gnd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(AddNewLand1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(jButton3))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EditLandDetailsLayout = new javax.swing.GroupLayout(EditLandDetails);
        EditLandDetails.setLayout(EditLandDetailsLayout);
        EditLandDetailsLayout.setHorizontalGroup(
            EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
            .addGroup(EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EditLandDetailsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddNewLand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        EditLandDetailsLayout.setVerticalGroup(
            EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EditLandDetailsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddNewLand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        LandTabbedPane.addTab("Edit Land Details", EditLandDetails);

        jLabel16.setText("planNumber");

        jLabel17.setText("Grama Niladhari Division");

        jLabel28.setText("Land Name");

        jLabel29.setText("Bounded -");

        jLabel30.setText("On North By");

        jLabel31.setText("On East By");

        jLabel32.setText("On West By");

        jLabel33.setText("On South By");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel29)
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(2, 2, 2)))
                    .addComponent(jLabel33))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_south_test)
                    .addComponent(search_east_test1)
                    .addComponent(search_west_test)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(search_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(search_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(search_east_test1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(search_west_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(search_south_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Cancel");

        search_lot_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LotNo", "Extent (Acres/Hectare)", "Extent (Perches)", "Extent (Roods)"
            }
        ));
        jScrollPane5.setViewportView(search_lot_table);

        search_planNumber_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                search_planNumber_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout AddNewLand2Layout = new javax.swing.GroupLayout(AddNewLand2);
        AddNewLand2.setLayout(AddNewLand2Layout);
        AddNewLand2Layout.setHorizontalGroup(
            AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewLand2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(AddNewLand2Layout.createSequentialGroup()
                        .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_land_name)
                            .addComponent(search_planNumber_combo, 0, 115, Short.MAX_VALUE)
                            .addComponent(search_gnd_test))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AddNewLand2Layout.setVerticalGroup(
            AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewLand2Layout.createSequentialGroup()
                        .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_land_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(AddNewLand2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(search_gnd_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(AddNewLand2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddNewLand2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AddNewLand2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        LandTabbedPane.addTab("Search Land", jPanel4);

        view_all_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PlanNumber", "DivisionNumber", "LandName", "WestBound", "EastBound", "NorthBound", "SouthBound", "NumberOfLot"
            }
        ));
        jScrollPane1.setViewportView(view_all_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        view_all_load_buttun.setText("Load");
        view_all_load_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_all_load_buttunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(view_all_load_buttun, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(view_all_load_buttun)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewAllLandsLayout = new javax.swing.GroupLayout(ViewAllLands);
        ViewAllLands.setLayout(ViewAllLandsLayout);
        ViewAllLandsLayout.setHorizontalGroup(
            ViewAllLandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAllLandsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewAllLandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ViewAllLandsLayout.setVerticalGroup(
            ViewAllLandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewAllLandsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        LandTabbedPane.addTab("View All Lands", ViewAllLands);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LandTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LandTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perches_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perches_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perches_testActionPerformed

    private void gnd_name_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnd_name_testActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gnd_name_testActionPerformed

    private void gnd_number_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gnd_number_comboItemStateChanged
        try {
            GramaNiladariDivision searchGND = GramaNiladariDivisionController.searchGND((String) gnd_number_combo.getSelectedItem());
            if (searchGND != null) {
                gnd_name_test.setText(searchGND.getDivisionName());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GramaNiladhariForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_gnd_number_comboItemStateChanged

    private void add_lot_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_lot_buttunActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) lot_table.getModel();
        Object[] rawdata = {lot_number_test.getText(), acre_test.getText(), perches_test.getText(), rood_test.getText()};
        tableModel.addRow(rawdata);
        acre_test.setText("");
        perches_test.setText("");
        rood_test.setText("");
        lot_number_test.setText(IdGenerator.generateNextLotNumber(lot_number_test.getText()));

    }//GEN-LAST:event_add_lot_buttunActionPerformed

    private void land_save_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_land_save_buttunActionPerformed
        Land land = new Land(plan_nummber_test.getText(), land_name_test.getText(), (String) gnd_number_combo.getSelectedItem(), land_west_test.getText(), land_east_test.getText(), land_north_test.getText(), land_south_test.getText());
        ArrayList<Lot> lotList = new ArrayList();

        for (int i = 0; i < lot_table.getRowCount(); i++) {
            Lot lot = new Lot((String) lot_table.getValueAt(i, 0), Integer.parseInt((String) lot_table.getValueAt(i, 1)), Integer.parseInt((String) lot_table.getValueAt(i, 3)), Integer.parseInt((String) lot_table.getValueAt(i, 2)), land);
            lotList.add(lot);
        }
        land.setLotList(lotList);
        try {
            boolean addNewLand = LandController.addNewLand(land);
            if (addNewLand) {
                JOptionPane.showMessageDialog(this, "land add successsfully");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_land_save_buttunActionPerformed

    private void update_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_update_planNumber_comboItemStateChanged
        String selectedPlanNumber = (String) update_planNumber_combo.getSelectedItem();
        try {
            Land searchLand = LandController.searchLand(selectedPlanNumber);
            if (searchLand != null) {
                update_land_name.setText(searchLand.getLandName());
                update_east_test.setText(searchLand.getEastBound());
                update_north_test.setText(searchLand.getNorthBound());
                update_south_test.setText(searchLand.getSouthBound());
                update_west_test.setText(searchLand.getWestBound());
                update_gnd_combo.addItem(searchLand.getDivisionNumber());
                ArrayList<Lot> lotList = searchLand.getLotList();
                DefaultTableModel modelULT = (DefaultTableModel) update_lot_table.getModel();
                modelULT.getDataVector().removeAllElements();
                revalidate();
                for (Lot lot : lotList) {
                    Object[] rowdata = {lot.getLotNumber(), lot.getNumberOfAcres(), lot.getNumberOfPerches(), lot.getNumberofRoods()};
                    modelULT.addRow(rowdata);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_planNumber_comboItemStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "do you want to update");
        if (showConfirmDialog == 0) {
            Land land = new Land(String.valueOf(update_planNumber_combo.getSelectedItem()), update_land_name.getText(), (String) update_gnd_combo.getSelectedItem(), update_west_test.getText(), update_east_test.getText(), update_south_test.getText(), update_north_test.getText());
            ArrayList<Lot> lotList = new ArrayList();

            for (int i = 0; i < update_lot_table.getRowCount(); i++) {
                Lot lot = new Lot((String) update_lot_table.getValueAt(i, 0), Integer.parseInt(String.valueOf(update_lot_table.getValueAt(i, 1))),Integer.parseInt(String.valueOf( update_lot_table.getValueAt(i, 3))), Integer.parseInt(String.valueOf( update_lot_table.getValueAt(i, 2))),  land);
                lotList.add(lot);
            }
            land.setLotList(lotList);
            try {
                boolean updateLand = LandController.updateLand(land);
                if (updateLand) {
                    JOptionPane.showMessageDialog(this, "land update successsfully");
                } else {
                    JOptionPane.showMessageDialog(this, "land doesn't update successsfully");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void search_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_search_planNumber_comboItemStateChanged
         String selectedPlanNumber = (String) search_planNumber_combo.getSelectedItem();
        try {
            Land searchLand = LandController.searchLand(selectedPlanNumber);
            if (searchLand != null) {
                search_land_name.setText(searchLand.getLandName());
                search_east_test1.setText(searchLand.getEastBound());
                search_north_test.setText(searchLand.getNorthBound());
                search_south_test.setText(searchLand.getSouthBound());
                search_west_test.setText(searchLand.getWestBound());
                search_gnd_test.setText(searchLand.getDivisionNumber());
                ArrayList<Lot> lotList = searchLand.getLotList();
                DefaultTableModel modelULT = (DefaultTableModel) search_lot_table.getModel();
                modelULT.getDataVector().removeAllElements();
                revalidate();
                for (Lot lot : lotList) {
                    Object[] rowdata = {lot.getLotNumber(), lot.getNumberOfAcres(), lot.getNumberOfPerches(), lot.getNumberofRoods()};
                    modelULT.addRow(rowdata);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_planNumber_comboItemStateChanged

    private void view_all_load_buttunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_all_load_buttunActionPerformed
        try {
            DefaultTableModel viewAllModel=(DefaultTableModel) view_all_table.getModel();
            viewAllModel.getDataVector().removeAllElements();
            revalidate();
            ArrayList<Land> allLandDetail = LandController.getAllLandDetail();
            for (Land land : allLandDetail) {
                Object [] rowdata= {land.getPlanNumber(),land.getDivisionNumber(),land.getLandName(),land.getWestBound(),land.getEastBound(),land.getNorthBound(),land.getSouthBound(),land.getNumberOfLot()};
                viewAllModel.addRow(rowdata);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_view_all_load_buttunActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddNewLand;
    private javax.swing.JPanel AddNewLand1;
    private javax.swing.JPanel AddNewLand2;
    private javax.swing.JPanel EditLandDetails;
    private javax.swing.JTabbedPane LandTabbedPane;
    private javax.swing.JPanel ViewAllLands;
    private javax.swing.JTextField acre_test;
    private javax.swing.JToggleButton add_lot_buttun;
    private javax.swing.JTextField gnd_name_test;
    private javax.swing.JComboBox gnd_number_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField land_east_test;
    private javax.swing.JTextField land_name_test;
    private javax.swing.JTextField land_north_test;
    private javax.swing.JButton land_save_buttun;
    private javax.swing.JTextField land_south_test;
    private javax.swing.JTextField land_west_test;
    private javax.swing.JTextField lot_number_test;
    private javax.swing.JTable lot_table;
    private javax.swing.JTextField perches_test;
    private javax.swing.JTextField plan_nummber_test;
    private javax.swing.JTextField rood_test;
    private javax.swing.JTextField search_east_test1;
    private javax.swing.JTextField search_gnd_test;
    private javax.swing.JTextField search_land_name;
    private javax.swing.JTable search_lot_table;
    private javax.swing.JTextField search_north_test;
    private javax.swing.JComboBox search_planNumber_combo;
    private javax.swing.JTextField search_south_test;
    private javax.swing.JTextField search_west_test;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField update_east_test;
    private javax.swing.JComboBox update_gnd_combo;
    private javax.swing.JTextField update_land_name;
    private javax.swing.JTable update_lot_table;
    private javax.swing.JTextField update_north_test;
    private javax.swing.JComboBox update_planNumber_combo;
    private javax.swing.JTextField update_south_test;
    private javax.swing.JTextField update_west_test;
    private javax.swing.JButton view_all_load_buttun;
    private javax.swing.JTable view_all_table;
    // End of variables declaration//GEN-END:variables
}
