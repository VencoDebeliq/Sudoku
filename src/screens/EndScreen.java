/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import data.Data;
import data.User;
import java.awt.Color;
import java.awt.Font;
import javax.swing.WindowConstants;
import sudoku.SudokuLevels;

/**
 *
 * @author damyanlh
 */
public class EndScreen extends javax.swing.JFrame {

    private SudokuLevels dificulty;
    private Data scoreboardData = new Data();

    public EndScreen(SudokuLevels dificulty) {
        this.dificulty = dificulty;

        initComponents();
        this.setResizable(false);
        this.revalidate();
        setLocationRelativeTo(null);

        scoreboard.setEditable(false);
        scoreboard.setColumns(10);
        scoreboard.setOpaque(false);
        scoreboard.setForeground(Color.black);
        scoreboard.setFont(new Font("Fira Sans", Font.BOLD, 13));
        
        

        scoreboardDisplayer();

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wonLabel = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreboard = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wonLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        wonLabel.setText("You won!");

        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        scoreboard.setColumns(20);
        scoreboard.setRows(5);
        jScrollPane1.setViewportView(scoreboard);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(wonLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel)
                            .addComponent(restartButton))
                        .addGap(68, 68, 68)
                        .addComponent(quitButton)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wonLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartButton)
                    .addComponent(quitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        new Game().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_restartButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        scoreboardData.saveData(nameField.getText() + "," + dificulty.toString() + "," + "0" + "\n");
        scoreboardDisplayer();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void scoreboardDisplayer() {
        
        scoreboard.setText("");
        scoreboard.revalidate();
        String scoreboardText = "";
        

        //compiling the stats from the ScoreboardEntry array and displaying them
        for (User u: scoreboardData.returnData()) {
            scoreboardText += "Name: " + u.getName() + " Dificulty: " +  u.getDifficulty() + " Score: " + u.getScore() + "\n";
        }
        System.out.println(scoreboardText);
        scoreboard.setText(scoreboardText);
        scoreboard.setCaretPosition(0);
    }
    
    public double scoreCalculator(double time, double mistakes) {
        time = 3000.0;
        mistakes = 10.0;
        double score;
        score = time + mistakes * 5;
        score = (1 - (1 / (1 + Math.exp(-0.001 * score)))) * 2.0;
        score = score * 100.0;
        System.out.println("Score = " + score);

        return score;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea scoreboard;
    private javax.swing.JLabel wonLabel;
    // End of variables declaration//GEN-END:variables
}