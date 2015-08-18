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
import las.common_classes.GUIitemsValidator;
//import las.common_classes.ComboItemAdder;
import las.common_classes.IdGenerator;
import las.common_classes.PatternChecker;
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
        landnotvalidlabel.setVisible(false);
        acresnotvalidlabel.setVisible(false);
        perchesnotvalidlabel.setVisible(false);
        roodsnotvalidlabel.setVisible(false);
        gnd_name_test.setEditable(false);
        boundednorthnotvalidlabel.setVisible(false);
        boundedeastnotvalidlabel.setVisible(false);
        boundedwestnotvalidlabel.setVisible(false);
        boundedsouthnotvalidlabel.setVisible(false);
        land_south_test.setVisible(false);
        boundedwestnotvalidlabel.setVisible(false);
        editbounednorthnotvalidlabel.setVisible(false);
        editbounedeastnotvalidlabel.setVisible(false);
        editbounedwestnotvalidlabel.setVisible(false);
        editbounedsouthnotvalidlabel.setVisible(false);
        editlandnamenotvalidlabel.setVisible(false);
        add_lot_buttun.setEnabled(false);
        //updateButton.setEnabled(false);
        search_land_name.setEditable(false);
        search_gnd_test.setEditable(false);
        search_north_test.setEditable(false);
        search_east_test1.setEditable(false);
        search_south_test.setEditable(false);
        search_west_test.setEditable(false);
        search_lot_table.setEnabled(false);
        
        
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
                        GUIitemsValidator.addItemToCombo(list,search_planNumber_combo);

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
                        GUIitemsValidator.addItemToCombo(list, update_planNumber_combo);

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
                        GUIitemsValidator.addItemToCombo(list, update_gnd_combo);

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
                        GUIitemsValidator.addItemToCombo(list, gnd_number_combo);

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
        gndnolabel = new javax.swing.JLabel();
        gndlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lotnolabel = new javax.swing.JLabel();
        extentlabel = new javax.swing.JLabel();
        perches_test = new javax.swing.JTextField();
        rood_test = new javax.swing.JTextField();
        acre_test = new javax.swing.JTextField();
        lot_number_test = new javax.swing.JTextField();
        acreorhectarelabel = new javax.swing.JLabel();
        percheslabel = new javax.swing.JLabel();
        roodslabel = new javax.swing.JLabel();
        add_lot_buttun = new javax.swing.JToggleButton();
        acresnotvalidlabel = new javax.swing.JLabel();
        perchesnotvalidlabel = new javax.swing.JLabel();
        roodsnotvalidlabel = new javax.swing.JLabel();
        gnd_name_test = new javax.swing.JTextField();
        plannolabel = new javax.swing.JLabel();
        plan_nummber_test = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        boundedlabel = new javax.swing.JLabel();
        boundedonnorthlabel = new javax.swing.JLabel();
        boundedoneastlabel = new javax.swing.JLabel();
        boundedonwestlabel = new javax.swing.JLabel();
        boundedonsouthlabel = new javax.swing.JLabel();
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
        landnamelabel = new javax.swing.JLabel();
        landnotvalidlabel = new javax.swing.JLabel();
        boundednorthnotvalidlabel = new javax.swing.JLabel();
        boundedeastnotvalidlabel = new javax.swing.JLabel();
        boundedwestnotvalidlabel = new javax.swing.JLabel();
        boundedsouthnotvalidlabel = new javax.swing.JLabel();
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
        editbounednorthnotvalidlabel = new javax.swing.JLabel();
        editbounedeastnotvalidlabel = new javax.swing.JLabel();
        editbounedwestnotvalidlabel = new javax.swing.JLabel();
        editbounedsouthnotvalidlabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        update_lot_table = new javax.swing.JTable();
        update_planNumber_combo = new javax.swing.JComboBox();
        update_gnd_combo = new javax.swing.JComboBox();
        editlandnamenotvalidlabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
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

        gndnolabel.setText("G.N.D No");

        gndlabel.setText("Grama Niladhari Division");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lot Details"));

        lotnolabel.setText("Lot No");

        extentlabel.setText("Expected Extent");

        perches_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perches_testActionPerformed(evt);
            }
        });
        perches_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                perches_testKeyReleased(evt);
            }
        });

        rood_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rood_testActionPerformed(evt);
            }
        });
        rood_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rood_testKeyReleased(evt);
            }
        });

        acre_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acre_testActionPerformed(evt);
            }
        });
        acre_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                acre_testKeyReleased(evt);
            }
        });

        acreorhectarelabel.setText("Acre / Hectare");

        percheslabel.setText("Perches");

        roodslabel.setText("Roods");

        add_lot_buttun.setText("Add Lot");
        add_lot_buttun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_lot_buttunActionPerformed(evt);
            }
        });
        add_lot_buttun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                add_lot_buttunKeyReleased(evt);
            }
        });

        acresnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        acresnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        acresnotvalidlabel.setText("Not Valid");

        perchesnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        perchesnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        perchesnotvalidlabel.setText("Not Valid");

        roodsnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        roodsnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        roodsnotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lotnolabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lot_number_test, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(extentlabel)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acre_test)
                    .addComponent(perches_test, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(rood_test, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(roodslabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roodsnotvalidlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_lot_buttun)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(acreorhectarelabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(acresnotvalidlabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(percheslabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(perchesnotvalidlabel)))
                        .addGap(128, 128, 128))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lotnolabel)
                    .addComponent(lot_number_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extentlabel)
                    .addComponent(acre_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acreorhectarelabel)
                    .addComponent(acresnotvalidlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perches_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percheslabel)
                    .addComponent(perchesnotvalidlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roodslabel)
                    .addComponent(rood_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_lot_buttun)
                    .addComponent(roodsnotvalidlabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gnd_name_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnd_name_testActionPerformed(evt);
            }
        });
        gnd_name_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gnd_name_testKeyReleased(evt);
            }
        });

        plannolabel.setText("Plan No");

        boundedlabel.setText("Bounded -");

        boundedonnorthlabel.setText("On North By");

        boundedoneastlabel.setText("On East By");

        boundedonwestlabel.setText("On West By");

        boundedonsouthlabel.setText("On South By");

        land_north_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                land_north_testKeyReleased(evt);
            }
        });

        land_east_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                land_east_testKeyReleased(evt);
            }
        });

        land_west_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                land_west_testKeyReleased(evt);
            }
        });

        land_south_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                land_south_testKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(boundedlabel)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boundedonnorthlabel)
                            .addComponent(boundedoneastlabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(boundedonwestlabel)
                            .addGap(2, 2, 2)))
                    .addComponent(boundedonsouthlabel))
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
                    .addComponent(boundedlabel)
                    .addComponent(boundedonnorthlabel)
                    .addComponent(land_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boundedoneastlabel)
                    .addComponent(land_east_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boundedonwestlabel)
                    .addComponent(land_west_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boundedonsouthlabel)
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        gnd_number_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnd_number_comboActionPerformed(evt);
            }
        });
        gnd_number_combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gnd_number_comboKeyReleased(evt);
            }
        });

        land_name_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                land_name_testKeyReleased(evt);
            }
        });

        landnamelabel.setText("Land Name");

        landnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        landnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        landnotvalidlabel.setText("Not Valid");

        boundednorthnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        boundednorthnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        boundednorthnotvalidlabel.setText("Not Valid");

        boundedeastnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        boundedeastnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        boundedeastnotvalidlabel.setText("Not Valid");

        boundedwestnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        boundedwestnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        boundedwestnotvalidlabel.setText("Not Valid");

        boundedsouthnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        boundedsouthnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        boundedsouthnotvalidlabel.setText("Not Valid");

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
                                    .addComponent(plannolabel)
                                    .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(gndnolabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gndlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plan_nummber_test, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gnd_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gnd_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddNewLandLayout.createSequentialGroup()
                                .addComponent(landnamelabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(land_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(landnotvalidlabel)
                                .addGap(68, 68, 68)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boundednorthnotvalidlabel)
                            .addComponent(boundedeastnotvalidlabel)
                            .addComponent(boundedwestnotvalidlabel)
                            .addComponent(boundedsouthnotvalidlabel))
                        .addGap(79, 79, 79))
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
                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewLandLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddNewLandLayout.createSequentialGroup()
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plannolabel)
                                    .addComponent(plan_nummber_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(landnamelabel)
                                    .addComponent(land_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(landnotvalidlabel))
                                .addGap(21, 21, 21)
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gndnolabel)
                                    .addComponent(gnd_number_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gndlabel)
                                    .addComponent(gnd_name_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(AddNewLandLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(boundednorthnotvalidlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boundedeastnotvalidlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boundedwestnotvalidlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boundedsouthnotvalidlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(AddNewLandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(land_save_buttun))
                .addGap(24, 24, 24))
        );

        LandTabbedPane.addTab("Add New Land", AddNewLand);

        jLabel14.setText("planNumber");

        jLabel15.setText("Grama Niladhari Division");

        jLabel21.setText("Land Name");

        update_land_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_land_nameKeyReleased(evt);
            }
        });

        jLabel22.setText("Bounded -");

        jLabel23.setText("On North By");

        jLabel24.setText("On East By");

        jLabel25.setText("On West By");

        jLabel26.setText("On South By");

        update_north_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_north_testKeyReleased(evt);
            }
        });

        update_east_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_east_testKeyReleased(evt);
            }
        });

        update_west_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_west_testKeyReleased(evt);
            }
        });

        update_south_test.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_south_testKeyReleased(evt);
            }
        });

        editbounednorthnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        editbounednorthnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editbounednorthnotvalidlabel.setText("Not Valid");

        editbounedeastnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        editbounedeastnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editbounedeastnotvalidlabel.setText("Not Valid");

        editbounedwestnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        editbounedwestnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editbounedwestnotvalidlabel.setText("Not Valid");

        editbounedsouthnotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        editbounedsouthnotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editbounedsouthnotvalidlabel.setText("Not Valid");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editbounednorthnotvalidlabel)
                    .addComponent(editbounedeastnotvalidlabel)
                    .addComponent(editbounedwestnotvalidlabel)
                    .addComponent(editbounedsouthnotvalidlabel))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(update_north_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbounednorthnotvalidlabel))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(update_east_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbounedeastnotvalidlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(update_west_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbounedwestnotvalidlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(update_south_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbounedsouthnotvalidlabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cancelButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cancelButtonKeyReleased(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        updateButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateButtonKeyReleased(evt);
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
        update_planNumber_combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_planNumber_comboKeyReleased(evt);
            }
        });

        update_gnd_combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_gnd_comboKeyReleased(evt);
            }
        });

        editlandnamenotvalidlabel.setBackground(new java.awt.Color(204, 0, 0));
        editlandnamenotvalidlabel.setForeground(new java.awt.Color(204, 0, 0));
        editlandnamenotvalidlabel.setText("Not Valid");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AddNewLand1Layout = new javax.swing.GroupLayout(AddNewLand1);
        AddNewLand1.setLayout(AddNewLand1Layout);
        AddNewLand1Layout.setHorizontalGroup(
            AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewLand1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(34, 34, 34)
                        .addComponent(cancelButton))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editlandnamenotvalidlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AddNewLand1Layout.setVerticalGroup(
            AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddNewLand1Layout.createSequentialGroup()
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddNewLand1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_planNumber_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_land_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editlandnamenotvalidlabel))
                        .addGap(13, 13, 13)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(update_gnd_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddNewLand1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddNewLand1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(cancelButton))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EditLandDetailsLayout = new javax.swing.GroupLayout(EditLandDetails);
        EditLandDetails.setLayout(EditLandDetailsLayout);
        EditLandDetailsLayout.setHorizontalGroup(
            EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditLandDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddNewLand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        EditLandDetailsLayout.setVerticalGroup(
            EditLandDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddNewLand1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
                .addComponent(LandTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        add_lot_buttun.setEnabled(false); 

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
                plan_nummber_test.setText(null);
                land_name_test.setText(null);
                gnd_name_test.setText(null);
                lot_number_test.setText(null);
                acre_test.setText(null);
                perches_test.setText(null);
                rood_test.setText(null);
                land_north_test.setText(null);
                land_east_test.setText(null);
                land_west_test.setText(null);
                land_south_test.setText(null);
                gnd_number_combo.setSelectedItem(null);
               lot_table.setModel(new DefaultTableModel());
               
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_land_save_buttunActionPerformed

    private void update_planNumber_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_update_planNumber_comboItemStateChanged
        EnableUpdate();
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
public void EnableUpdate(){
    if(update_land_name.getText().trim().length()!=0 && update_planNumber_combo.getSelectedItem()!=null && update_gnd_combo.getSelectedItem()!=null){
        updateButton.setEnabled(true);
    }
    else{
        updateButton.setEnabled(false);
    }
}
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       
        if(!PatternChecker.checkStringdirect(update_land_name.getText())){
           editlandnamenotvalidlabel.setVisible(true);
       }
       else if(update_land_name.getText().trim().length()==0){
           editlandnamenotvalidlabel.setVisible(true);
       }
       else{
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
                    update_planNumber_combo.setSelectedItem(null);
                    update_gnd_combo.setSelectedItem(null);
                    update_land_name.setText(null);
                    update_north_test.setText(null);
                    update_west_test.setText(null);
                    update_south_test.setText(null);
                    update_east_test.setText(null);
                    update_lot_table.setModel(new DefaultTableModel());
                } else {
                    JOptionPane.showMessageDialog(this, "land doesn't update successsfully");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LandForm.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private void land_name_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_land_name_testKeyReleased
        // TODO add your handling code here:
        landnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(land_name_test.getText());
        land_name_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(land_name_test.getText())){
                gnd_number_combo.requestFocus();
            }
            else{
                landnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            gnd_number_combo.requestFocus();
        }
       else if(evt.getKeyCode()==KeyEvent.VK_UP){
            
        }
        
    }//GEN-LAST:event_land_name_testKeyReleased

    private void gnd_number_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnd_number_comboActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_gnd_number_comboActionPerformed

    private void acre_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acre_testActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_acre_testActionPerformed

    private void acre_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acre_testKeyReleased
        // TODO add your handling code here:
       if(acre_test.getText().trim().length()!=0 && perches_test.getText().trim().length()!=0 && rood_test.getText().trim().length()!=0){
            add_lot_buttun.setEnabled(true);        
        }
        if(acre_test.getText().trim().length()==0 || perches_test.getText().trim().length()==0 || rood_test.getText().trim().length()==0){
            add_lot_buttun.setEnabled(false);        
        }
        acresnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkDecimal(acre_test.getText());
        acre_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkDecimaldirect(acre_test.getText())){
                perches_test.requestFocus();
            }
            else{
               acresnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            perches_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            land_south_test.requestFocus();
        }
    }//GEN-LAST:event_acre_testKeyReleased

    private void perches_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_perches_testKeyReleased
        // TODO add your handling code here:
         if(acre_test.getText().trim().length()!=0 && perches_test.getText().trim().length()!=0 && rood_test.getText().trim().length()!=0){
            add_lot_buttun.setEnabled(true);        
        }
          if(acre_test.getText().trim().length()==0 || perches_test.getText().trim().length()==0 || rood_test.getText().trim().length()==0){
            add_lot_buttun.setEnabled(false);        
        }
        perchesnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkDecimal(perches_test.getText());
        perches_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkDecimaldirect(perches_test.getText())){
                rood_test.requestFocus();
            }
            else{
                 perchesnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            rood_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            acre_test.requestFocus();
        }
    }//GEN-LAST:event_perches_testKeyReleased

    private void rood_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rood_testActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_rood_testActionPerformed

    private void gnd_number_comboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gnd_number_comboKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            land_north_test.requestFocus();
        }
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            land_name_test.requestFocus();
        }
    }//GEN-LAST:event_gnd_number_comboKeyReleased

    private void gnd_name_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gnd_name_testKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_gnd_name_testKeyReleased

    private void land_north_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_land_north_testKeyReleased
        // TODO add your handling code here:
        boundednorthnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(land_north_test.getText());
        land_north_test.setText(newtext);
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             if(PatternChecker.checkStringdirect(land_north_test.getText())){
            land_east_test.requestFocus();}
             else{
                 boundednorthnotvalidlabel.setVisible(true);
             }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            land_east_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            gnd_number_combo.requestFocus();
        }
    }//GEN-LAST:event_land_north_testKeyReleased

    private void land_east_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_land_east_testKeyReleased
        // TODO add your handling code here:
         boundedeastnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(land_east_test.getText());
        land_east_test.setText(newtext);
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             if(PatternChecker.checkStringdirect(land_east_test.getText())){
            land_west_test.requestFocus();}
             else{
                 boundedeastnotvalidlabel.setVisible(true);
             }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            land_west_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            land_north_test.requestFocus();
        }
       
    }//GEN-LAST:event_land_east_testKeyReleased

    private void land_west_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_land_west_testKeyReleased
        // TODO add your handling code here:
        boundedwestnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(land_west_test.getText());
        land_west_test.setText(newtext);
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             if(PatternChecker.checkStringdirect(land_west_test.getText())){
            land_south_test.requestFocus();}
             else{
                 boundedwestnotvalidlabel.setVisible(true);
             }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            land_south_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            land_east_test.requestFocus();
        }
    }//GEN-LAST:event_land_west_testKeyReleased

    private void land_south_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_land_south_testKeyReleased
        // TODO add your handling code here:
         boundedsouthnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(land_south_test.getText());
        land_south_test.setText(newtext);
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             if(PatternChecker.checkStringdirect(land_south_test.getText())){
            acre_test.requestFocus();}
             else{
                 boundedsouthnotvalidlabel.setVisible(true);
             }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            acre_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            land_west_test.requestFocus();
        }
    }//GEN-LAST:event_land_south_testKeyReleased

    private void rood_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rood_testKeyReleased
        // TODO add your handling code here:
         if(acre_test.getText().trim().length()!=0 && perches_test.getText().trim().length()!=0 && rood_test.getText().trim().length()!=0){
            add_lot_buttun.setEnabled(true);        
        }
         if(acre_test.getText().trim().length()==0 || perches_test.getText().trim().length()==0 || rood_test.getText().trim().length()==0){
            add_lot_buttun.setEnabled(false);        
        }
        roodsnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkDecimal(rood_test.getText());
        rood_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkDecimaldirect(rood_test.getText())){
                add_lot_buttun.requestFocus();
            }
            else{
                 perchesnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            add_lot_buttun.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            perches_test.requestFocus();
        }
    }//GEN-LAST:event_rood_testKeyReleased

    private void update_planNumber_comboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_planNumber_comboKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_land_name.requestFocus();
        }
    }//GEN-LAST:event_update_planNumber_comboKeyReleased

    private void update_land_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_land_nameKeyReleased
         EnableUpdate();
        editlandnamenotvalidlabel.setVisible(false);        
        String newtext=PatternChecker.checkstring(update_land_name.getText());
        update_land_name.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(update_land_name.getText())){
            update_gnd_combo.requestFocus();}
            else{
                editlandnamenotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_gnd_combo.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_planNumber_combo.requestFocus();
        }
    }//GEN-LAST:event_update_land_nameKeyReleased

    private void update_gnd_comboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_gnd_comboKeyReleased
       
         if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_north_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_land_name.requestFocus();
        }
    }//GEN-LAST:event_update_gnd_comboKeyReleased

    private void update_north_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_north_testKeyReleased

        editbounednorthnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(update_north_test.getText());
        update_north_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(update_north_test.getText())){
            update_east_test.requestFocus();}
            else{
                editbounednorthnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_east_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_gnd_combo.requestFocus();
        }
        
    }//GEN-LAST:event_update_north_testKeyReleased

    private void update_east_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_east_testKeyReleased
        // TODO add your handling code here:
        editbounedeastnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(update_east_test.getText());
        update_east_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(update_east_test.getText())){
            update_west_test.requestFocus();}
            else{
                editbounedeastnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_west_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_north_test.requestFocus();
        }
    }//GEN-LAST:event_update_east_testKeyReleased

    private void update_west_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_west_testKeyReleased
        // TODO add your handling code here:
        editbounedwestnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(update_west_test.getText());
        update_west_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(update_west_test.getText())){
            update_south_test.requestFocus();}
            else{
                editbounedwestnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            update_south_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_east_test.requestFocus();
        }
    }//GEN-LAST:event_update_west_testKeyReleased

    private void update_south_testKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_south_testKeyReleased
        // TODO add your handling code here:
        editbounedsouthnotvalidlabel.setVisible(false);
        String newtext=PatternChecker.checkstring(update_south_test.getText());
        update_south_test.setText(newtext);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(PatternChecker.checkStringdirect(update_south_test.getText())){
            updateButton.requestFocus();}
            else{
                editbounedsouthnotvalidlabel.setVisible(true);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            updateButton.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_west_test.requestFocus();
        }
    }//GEN-LAST:event_update_south_testKeyReleased

    private void updateButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateButtonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_south_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
            cancelButton.requestFocus();
        }
    }//GEN-LAST:event_updateButtonKeyReleased

    private void cancelButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelButtonKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            update_south_test.requestFocus();
        }
        else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            updateButton.requestFocus();
        }
    }//GEN-LAST:event_cancelButtonKeyReleased

    private void add_lot_buttunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_lot_buttunKeyReleased
        // TODO add your handling code here
         if(evt.getKeyCode()==KeyEvent.VK_UP){
            rood_test.requestFocus();
        }
    }//GEN-LAST:event_add_lot_buttunKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        search_land_name.setText(null);
        search_gnd_test.setText(null);
        search_north_test.setText(null);
        search_east_test1.setText(null);
        search_south_test.setText(null);
        search_west_test.setText(null);
        search_lot_table.setModel(new DefaultTableModel());
        search_planNumber_combo.setSelectedItem(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
         int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Are You Sure?");
        if (showConfirmDialog == 0) {
        update_planNumber_combo.setSelectedItem(null);
        update_gnd_combo.setSelectedItem(null);
        update_land_name.setText(null);
        update_north_test.setText(null);
        update_west_test.setText(null);
        update_south_test.setText(null);
        update_east_test.setText(null);
        update_lot_table.setModel(new DefaultTableModel());}
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        plan_nummber_test.setText(null);
        land_name_test.setText(null);
        gnd_name_test.setText(null);
        lot_number_test.setText(null);
        acre_test.setText(null);
        perches_test.setText(null);
        rood_test.setText(null);
        land_north_test.setText(null);
        land_east_test.setText(null);
        land_west_test.setText(null);
        land_south_test.setText(null);
        gnd_number_combo.setSelectedItem(null);
        lot_table.setModel(new DefaultTableModel());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddNewLand;
    private javax.swing.JPanel AddNewLand1;
    private javax.swing.JPanel AddNewLand2;
    private javax.swing.JPanel EditLandDetails;
    private javax.swing.JTabbedPane LandTabbedPane;
    private javax.swing.JPanel ViewAllLands;
    private javax.swing.JTextField acre_test;
    private javax.swing.JLabel acreorhectarelabel;
    private javax.swing.JLabel acresnotvalidlabel;
    private javax.swing.JToggleButton add_lot_buttun;
    private javax.swing.JLabel boundedeastnotvalidlabel;
    private javax.swing.JLabel boundedlabel;
    private javax.swing.JLabel boundednorthnotvalidlabel;
    private javax.swing.JLabel boundedoneastlabel;
    private javax.swing.JLabel boundedonnorthlabel;
    private javax.swing.JLabel boundedonsouthlabel;
    private javax.swing.JLabel boundedonwestlabel;
    private javax.swing.JLabel boundedsouthnotvalidlabel;
    private javax.swing.JLabel boundedwestnotvalidlabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel editbounedeastnotvalidlabel;
    private javax.swing.JLabel editbounednorthnotvalidlabel;
    private javax.swing.JLabel editbounedsouthnotvalidlabel;
    private javax.swing.JLabel editbounedwestnotvalidlabel;
    private javax.swing.JLabel editlandnamenotvalidlabel;
    private javax.swing.JLabel extentlabel;
    private javax.swing.JTextField gnd_name_test;
    private javax.swing.JComboBox gnd_number_combo;
    private javax.swing.JLabel gndlabel;
    private javax.swing.JLabel gndnolabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField land_east_test;
    private javax.swing.JTextField land_name_test;
    private javax.swing.JTextField land_north_test;
    private javax.swing.JButton land_save_buttun;
    private javax.swing.JTextField land_south_test;
    private javax.swing.JTextField land_west_test;
    private javax.swing.JLabel landnamelabel;
    private javax.swing.JLabel landnotvalidlabel;
    private javax.swing.JTextField lot_number_test;
    private javax.swing.JTable lot_table;
    private javax.swing.JLabel lotnolabel;
    private javax.swing.JTextField perches_test;
    private javax.swing.JLabel percheslabel;
    private javax.swing.JLabel perchesnotvalidlabel;
    private javax.swing.JTextField plan_nummber_test;
    private javax.swing.JLabel plannolabel;
    private javax.swing.JTextField rood_test;
    private javax.swing.JLabel roodslabel;
    private javax.swing.JLabel roodsnotvalidlabel;
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
