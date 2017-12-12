/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Gui extends javax.swing.JFrame {

    public static String rainbowtable = "RainbowTable.ser";
    public static FileToTable deserializer = new FileToTable();
    public RainbowTable globalTable = deserializer.loadRainbowTable(rainbowtable);
    public Reduction reduceMan = new Reduction(globalTable.alphabet, globalTable.maxLength, globalTable.chainLength);

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        crackHash = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        hashText = new javax.swing.JTextField();
        plainText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        results = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plainToHash = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        alphabetText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chainLengthText = new javax.swing.JTextField();
        maxLengthText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chainResults = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rainbow Table Password Crack");

        crackHash.setText("Crack Hash");
        crackHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crackHashActionPerformed(evt);
            }
        });

        jLabel3.setText("Results of Crack");

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearPasswordForm(evt);
            }
        });

        plainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainTextActionPerformed(evt);
            }
        });

        results.setColumns(20);
        results.setRows(5);
        jScrollPane1.setViewportView(results);

        jLabel1.setText("Enter Plain Text : (check table details for valid input)");

        jLabel2.setText("Enter Hash Text");

        plainToHash.setText("Plain to Hash");
        plainToHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainToHashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hashText, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(crackHash))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(plainText, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(plainToHash))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(254, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plainText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plainToHash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hashText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crackHash))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clear)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(405, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Crack Password", jPanel1);

        alphabetText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alphabetTextActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Alphabet As String eg 0123456789");

        jLabel5.setText("Enter Max Password Length");

        jLabel6.setText("Enter Chain Length");

        chainLengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chainLengthTextActionPerformed(evt);
            }
        });

        maxLengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxLengthTextActionPerformed(evt);
            }
        });

        jLabel7.setText("Results");

        chainResults.setColumns(20);
        chainResults.setRows(5);
        jScrollPane2.setViewportView(chainResults);

        jButton1.setText("Create Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateTable(evt);
            }
        });

        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearTableForm(evt);
            }
        });

        jButton2.setText("View Table Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDetails(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alphabetText)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxLengthText, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chainLengthText, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alphabetText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(maxLengthText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chainLengthText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create Table", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plainToHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plainToHashActionPerformed

        String s = plainText.getText();
        String hashed = "Error";
        if (s.length() <= globalTable.maxLength) {
            try {
                hashed = Sha_1.SHA1(s);
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

            hashText.setText(hashed);
        } else {
            results.setText("Password larger than tables max password length");
        }
    }//GEN-LAST:event_plainToHashActionPerformed

    private void plainTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plainTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plainTextActionPerformed

    private void ClearPasswordForm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearPasswordForm

        plainText.setText("");
        hashText.setText("");
        results.setText("");
    }//GEN-LAST:event_ClearPasswordForm

    private void crackHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crackHashActionPerformed
        HashMap pairs = globalTable.getPairs();
     //   TableGenerator table = new TableGenerator();
        try {
            if (pairs.size() > 0) {
                String cypherText = hashText.getText();
                String result = "Not Found";
                Boolean found = false;

                int chainLength = globalTable.chainLength;
                String reduString = "";

                long timer = System.currentTimeMillis();

                //Hash last item in a chain  to check 
                Set last = pairs.keySet();
                Iterator iter = last.iterator();
                String test = "", temp = "";
                while (iter.hasNext()) {
                    temp = (String) iter.next();
                    test = Sha_1.SHA1(temp);
                    if (test.equals(cypherText)) {
                        result = temp;
                        found = true;
                        break;
                    }
                }

                // Checks everything after the last value in chain
                if (found == false) {
                    for (int i = chainLength - 1; i >= 0; i--) {
                        reduString = reduceMan.chainReduce(cypherText, i, chainLength);
                        if (pairs.containsKey(reduString)) {
                            String nextInChain = pairs.get(reduString).toString();
                            for (int j = 0; j <= chainLength; j++) {
                                String hashed = Sha_1.SHA1(nextInChain);
                                if (hashed.equals(cypherText)) {
                                    result = nextInChain;
                                    i = 0;
                                    break;
                                } else {
                                    nextInChain = reduceMan.reduce(hashed, j);
                                }
                            }
                        }
                    }
                }

                //times to complete in milliseconds
                timer = System.currentTimeMillis() - timer;
                //Conver time to minutes:seconds:milliseconds
                String times = new SimpleDateFormat("mm:ss:SSS").format(new Date(timer));

                //Display hash, decyrpted text and time in results box.
                results.setText("Hash:    " + cypherText + "\nDecryped: " + result + "\nRun Time:   "
                        + times + "\nAlphabet: " + globalTable.alphabet + "\nMax password legnth: " + globalTable.maxLength);
            } else {
                results.setText("No Table on file. Please create table.");
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_crackHashActionPerformed

    private void alphabetTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alphabetTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alphabetTextActionPerformed

    private void chainLengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chainLengthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chainLengthTextActionPerformed

    private void maxLengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxLengthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxLengthTextActionPerformed

    private void ClearTableForm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearTableForm
        alphabetText.setText("");
        maxLengthText.setText("");
        chainLengthText.setText("");
        chainResults.setText("");
    }//GEN-LAST:event_ClearTableForm

    private void CreateTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateTable
        
        // Remove all duplicate entried in entered alphabet
        String alphabet = alphabetText.getText();
        char[] chars = alphabet.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        alphabet = sb.toString(); // clean alphabet
        // Set lethgns of password and chain
        String chainLengthString = chainLengthText.getText();
        String maxLengthString = maxLengthText.getText();

        // verification all three have been enterd
        if ((alphabet.equals(""))
                || (chainLengthString.equals(""))
                || (maxLengthString.equals(""))) {
            chainResults.setText("Please enter all the fields");
        } else {
            long timer = System.currentTimeMillis();// timer for table creation
            int chainLength = Integer.parseInt(chainLengthString);
            int maxLength = Integer.parseInt(maxLengthString);
            //      
            try {
                // Set the recution object to the new peras 
                // create Table generator with these paras
                reduceMan = new Reduction(alphabet, maxLength, chainLength);
                TableGenerator tableManager = new TableGenerator(reduceMan);
                // Update global HashMap
                globalTable.setPairs(tableManager.createMap(maxLength, chainLength));
                globalTable.setAlphabet(alphabet);
                globalTable.setMaxLength(maxLength);
                globalTable.setChainLength(chainLength);
                FileToTable.saveHashMapToFile(globalTable, rainbowtable);

            } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                Logger.getLogger(Gui.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            //times to complete in milliseconds
            timer = System.currentTimeMillis() - timer;
            //Conver time to minutes:seconds:milliseconds
            String times = new SimpleDateFormat("mm:ss:SSS").format(new Date(timer));
            //Display hash, decyrpted text and time in results box. 
            chainResults.setText("Table created.\nRun Time:   " + times);
        }
    }//GEN-LAST:event_CreateTable

    private void ViewDetails(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDetails

        chainResults.setText("Alphabet: " + globalTable.alphabet + "\nMax password legnth: "
                + globalTable.maxLength + "\nLength of chains: " + globalTable.chainLength
                + "\nNumber of chains: " + globalTable.pairs.size() + "\nPairs: " + globalTable.pairs.toString());

    }//GEN-LAST:event_ViewDetails

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FileToTable.fileAvailble(rainbowtable);
        RainbowTable start = deserializer.loadRainbowTable(rainbowtable);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alphabetText;
    private javax.swing.JTextField chainLengthText;
    private javax.swing.JTextArea chainResults;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton crackHash;
    private javax.swing.JTextField hashText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField maxLengthText;
    private javax.swing.JTextField plainText;
    private javax.swing.JButton plainToHash;
    private javax.swing.JTextArea results;
    // End of variables declaration//GEN-END:variables
}
