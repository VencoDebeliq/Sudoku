package sudoku;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import Stack.Stack;
import Stack.Action;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 *
 * @author Ventsislav Peychev
 */
public class Game extends javax.swing.JFrame
{
    private Sudoku sudoku = new Sudoku(SudokuLevels.EASY); // object from class Sudoku used for generating the puzzle
    private int selectedFieldX = -1; // keeps track of the X coordinate of the selected field
    private int selectedFieldY = -1; // keeps track of the Y coordinate of the selected field
    private Stack <Action> actions;
    
    /**
     * Creates new form Game
     */
    public Game()
    {
        init();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Initialization">
    /**
     * This method is called from within the constructor to initialize the fields and the form.
     */
    private void init()
    {
        initComponents();
        initLevelPanels();
        initField();
        initNumbers();
        actions = new Stack<>();
        
        tglBtnNotes.setFocusable(false);
        btnUndo.setFocusable(false);
        btnErase.setFocusable(false);
        btnHint.setFocusable(false);
        lblNotes.setFocusable(false);
        this.setFocusable(false);
        framePanel.setFocusable(false);
        
        setLocationRelativeTo(null);
        setTitle("Sudoku");
        
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                grid[i][j] = sudoku.getNumberAt(i, j);
            }
        }
        Sudoku.solve(grid);
        Sudoku.print(grid);
    }
    
    /**
     * This method is called from within the init method to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        btnUndo = new javax.swing.JButton();
        btnErase = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        tglBtnNotes = new javax.swing.JToggleButton();
        lblNotes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnUndo.setText("Undo");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnErase.setText("Erase");
        btnErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEraseActionPerformed(evt);
            }
        });

        btnHint.setText("Hint");

        tglBtnNotes.setText("Notes");
        tglBtnNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglBtnNotesActionPerformed(evt);
            }
        });

        lblNotes.setForeground(new java.awt.Color(255, 0, 0));
        lblNotes.setText("Off");

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, framePanelLayout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnErase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tglBtnNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(btnUndo)
                .addGap(137, 137, 137)
                .addComponent(btnErase)
                .addGap(128, 128, 128)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglBtnNotes)
                    .addComponent(lblNotes))
                .addGap(111, 111, 111)
                .addComponent(btnHint)
                .addGap(170, 170, 170))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(framePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tglBtnNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglBtnNotesActionPerformed
        if (tglBtnNotes.isSelected())
        {
            lblNotes.setText("On");
            lblNotes.setForeground(Color.green);
        }
        else
        {
            lblNotes.setText("Off");
            lblNotes.setForeground(Color.red);
        }
    }//GEN-LAST:event_tglBtnNotesActionPerformed

    private void btnEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEraseActionPerformed
        if (selectedFieldX == -1 || selectedFieldY == -1) return;
        if (field[selectedFieldY][selectedFieldX].getComponentCount() == 1) return;
        
        boolean isNote = false;
        int number = 0;
        
        JLabel eraseLabel = new JLabel();
        eraseLabel = (JLabel) field[selectedFieldY][selectedFieldX].getComponent(0);
        if (eraseLabel.getText().equals("") || eraseLabel.getText().equals(" ")) isNote = true;
        else number = Integer.parseInt(eraseLabel.getText());
        eraseLabel.setText("");
        eraseLabel.setVisible(false);
        eraseLabel.setForeground(Color.black);
        
        boolean visibleNumbers[] = new boolean[10];
        int i = 0;
        
        for(Component c : field[selectedFieldY][selectedFieldX].getComponents())
        {
            visibleNumbers[i++] = c.isVisible(); 
            c.setVisible(false);
        }
        
        visibleNumbers[number] = true;
        
        actions.push(new Action(selectedFieldX, selectedFieldY, visibleNumbers,
                isNote, Action.ActionType.DELETE_CELL));
        
        //System.out.println(actions);
        
        sudoku.setNumberAt(selectedFieldY, selectedFieldX, 0);
        unselect();
    }//GEN-LAST:event_btnEraseActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        if (actions.isEmpty()) return;
        Action action = actions.peek();
        int x = action.getX();
        int y = action.getY();
        if (action.getType() == Action.ActionType.ADD)
        {
            if (action.isNote())
            {
                int i = 0;
                int number = 0;
                for (boolean b: action.getNumberArr())
                {
                    if (b)
                        number = i;
                    ++i;
                }
                Component c = field[y][x].getComponent(number);
                c.setVisible(false);
            }
            else
            {
                JLabel num = (JLabel)(field[y][x].getComponent(0));
                num.setText("");
                num.setForeground(Color.black);
                sudoku.setNumberAt(y, x, 0);
            }
        }
        else if (action.getType() == Action.ActionType.DELETE_CELL)
        {  
            boolean[] numbers = action.getNumberArr();
            for (int i = 0; i < numbers.length; ++i)
            {
                if (numbers[i])
                {
                    if (!action.isNote())
                    {
                        ((JLabel)field[y][x].getComponent(0)).setText(i + "");
                        field[x][y].getComponent(0).setVisible(true);
                        if (!sudoku.isPlaceable(sudoku.getGrid(), x, y, i))
                            ((JLabel)field[y][x].getComponent(0)).setForeground(Color.red);
                        sudoku.setNumberAt(y, x, i);
                    }
                    else
                        field[y][x].getComponent(i).setVisible(true);
                }
            }
        }
        else if (action.getType() == Action.ActionType.DELETE_NUMBER)
        {
            if (action.isNote())
            {
                int i = 0;
                int number = 0;
                for (boolean b: action.getNumberArr())
                {
                    if (b) number = i;
                    ++i;
                }
                field[y][x].getComponent(number).setVisible(true);
            }
            else
            {
                sudoku.setNumberAt(y, x, 0);
                JLabel num = (JLabel)field[y][x].getComponent(0);
                num.setText("");
                boolean[] numbers = action.getNumberArr();
                for (int i = 0; i < numbers.length; ++i)
                {
                    if (numbers[i])
                    {
                        field[y][x].getComponent(i).setVisible(true);
                    }
                }
            }
        }
        actions.pop();
        unselect();
    }//GEN-LAST:event_btnUndoActionPerformed

    /*
     * This method is called from within the init method to initialize the field array.
     */
    private void initField()
    {
        field = new javax.swing.JPanel[Sudoku.GRID_SIZE][Sudoku.GRID_SIZE];
        for (int i = 0; i < Sudoku.GRID_SIZE; ++i)
        {
            for (int j = 0; j < Sudoku.GRID_SIZE; ++j)
            {
                field[i][j] = new javax.swing.JPanel();
                framePanel.add(field[i][j]);
                
                /**
                 * initializing the size and coordinates of each number field
                 * such that they have size 70 and are equally apart from the
                 * ends of the parent panel
                 */
                int size = 70;
                field[i][j].setBounds(65 + j * size, 100 + i * size, size, size);
                field[i][j].setBackground(Color.white);
                int thiknessSide = 3, thiknessNotSide = 1;
                
                /** 
                 * setting the field borders such as the outlines and the lines
                 * between the 3x3 sub grids are darker and thicker                
                */
                Border side = BorderFactory.createMatteBorder(
                        ((i % 3) == 0 ? thiknessSide : 0),
                        ((j % 3) == 0 ? thiknessSide : 0),
                        (i == 8 ? thiknessSide : 0),
                        (j == 8 ? thiknessSide : 0),
                        Color.black);
                Border notSide = BorderFactory.createMatteBorder(
                        ((i % 3) == 0 ? 0 : thiknessNotSide),
                        ((j % 3) == 0 ? 0 : thiknessNotSide),
                        (i == 8 ? 0 : thiknessNotSide),
                        (j == 8 ? 0 : thiknessNotSide),
                        Color.gray);
                field[i][j].setBorder(BorderFactory.createCompoundBorder(side, notSide));
                
                /**
                 * adding a label representing the number of each field and 
                 * revealing the clues according to the level of the sudoku object
                 */
                javax.swing.JLabel centralNumber;
                centralNumber = new javax.swing.JLabel();
                field[i][j].add(centralNumber);
                centralNumber.setFont(new Font("", Font.PLAIN, 45));
                if (sudoku.getNumberAt(i, j) != 0) 
                    centralNumber.setText(sudoku.getNumberAt(i, j) + "");
                
                /**
                 * creating effectively final variables
                 */
                final int curri = i;
                final int currj = j;
                
                /**
                 * adding mouseListener to each field handled in
                 * fieldMouseActionPerformed method
                 */
                field[i][j].addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        fieldMouseClickedActionPerformed(curri, currj, e);
                    }
                    
                });
                
                /**
                 * adding keyListener to each field handled in
                 * fieldKeyActionPerformed method
                 */
                field[i][j].addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyTyped(KeyEvent e)
                    {
                        fieldKeyActionPerformed(e);
                    }
                });
                field[i][j].setFocusable(true);
            }
        }
        
    }
    
    private void initNumbers()
    {
        
        for (int i = 0; i < Sudoku.GRID_SIZE; ++i)
        {
            for (int j = 0; j < Sudoku.GRID_SIZE; ++j)
            {
                if (sudoku.getNumberAt(i, j) != 0) continue;
                for (int k = 0; k < 9; ++k)
                {
                    javax.swing.JLabel number = new javax.swing.JLabel();
                    field[i][j].add(number);
                    number.setForeground(Color.gray);
                    number.setFont(new Font("", Font.PLAIN, 12));
                    if (k == 0)
                        number.setText("" + (k + 1) + "");
                    else
                        number.setText("   " + (k + 1) + "");
                    number.setVisible(false);
                }
                
            }
        }
    }
    
    private void initLevelPanels()
    {
        javax.swing.JLabel txtDifficulty = new javax.swing.JLabel();
        framePanel.add(txtDifficulty);
        txtDifficulty.setBounds(70, 5, 100, 100);
        txtDifficulty.setFont(new Font("", Font.PLAIN, 20));
        txtDifficulty.setText("Difficulty:");
        txtDifficulty.setForeground(Color.gray);
        
        for (int i = 0; i < 4; ++i)
        {
            javax.swing.JPanel lvl = new javax.swing.JPanel();
            framePanel.add(lvl);
            int sizeY = 40;
            int sizeX = 100;
            lvl.setBounds(70 + (i + 1) * (sizeX + 30), 35, sizeX, sizeY);
            
            javax.swing.JLabel txtLvl = new javax.swing.JLabel();
            lvl.add(txtLvl);
            txtLvl.setFont(new Font("", Font.PLAIN, 20));
            if (i == 0) txtLvl.setText("EASY");
            else if (i == 1) txtLvl.setText("MEDIUM");
            else if (i == 2) txtLvl.setText("HARD");
            else if (i == 3) txtLvl.setText("EXPERT");
            
            lvl.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e)
                {
                    difficultyMousePressedActionPerformed(lvl, e);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    lvl.setBackground(new Color(203, 203, 203));
                }
                
                @Override
                public void mouseExited(MouseEvent e)
                {
                    lvl.setBackground(new Color(238, 238, 238));
                }
                
            });
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Field Listeners">
    /**
     * This method is called in the initialization methods in order to perform action after mouse is clicked.
     * @param i used for representing the index of the row on which the panel was clicked
     * @param j used for representing the index of the column on which the panel was clicked
     * @param e used for getting the MouseEvent that occurred
     */
    private void fieldMouseClickedActionPerformed(int i, int j, MouseEvent e)
    {
        if (e.getButton() != 1) return;
        
        int boxI = i - i % 3, boxJ = j - j % 3;
        
        unselect();
        
        for (int row = boxI; row < boxI + 3; ++row)
        {
            for (int col = boxJ; col < boxJ + 3; ++col)
            {
                field[row][col].setBackground(new Color(230, 248, 255)); // Alice Blue color
            }
        }
        
        for (int row = 0; row < Sudoku.GRID_SIZE; ++row)
        {
            for (int col = 0; col < Sudoku.GRID_SIZE; ++col)
            {
                String currNum = ((javax.swing.JLabel)field[row][col].getComponent(0)).getText();
                String pressedNum = ((javax.swing.JLabel)field[i][j].getComponent(0)).getText();
                if (currNum.equals(pressedNum) && !currNum.equals(""))
                {
                    field[row][col].setBackground(new Color(155, 221, 255));
                }
            }
        }
        
        for (int k = 0; k < 9; ++k)
        {
            field[i][k].setBackground(new Color(230, 248, 255));
            field[k][j].setBackground(new Color(230, 248, 255));
        }
        field[i][j].setBackground(new Color(102, 153, 204)); // Columbia Blue color
        
        selectedFieldX = j;
        selectedFieldY = i;
    }

    /**
     * This method is called in the initialization methods in order to perform action after a key is typed
     * @param e used for getting the pressed Key's Character
     */
    private void fieldKeyActionPerformed(KeyEvent e)
    {
        if (selectedFieldX == -1 || selectedFieldY == -1) return;
        char c = e.getKeyChar();
        if (c < '1' || c > '9') return;
        if (sudoku.getNumberAt(selectedFieldY, selectedFieldX) != 0) return;
        if (lblNotes.getText().equals("Off"))
        {
            Action.ActionType actionT = Action.ActionType.ADD;
            boolean[] arr = new boolean[10];
            int i = 0;
            for (Component comp: field[selectedFieldY][selectedFieldX].getComponents())
            {
                if (comp.isVisible() && i != 0)
                {
                    actionT = Action.ActionType.DELETE_NUMBER;
                    arr[i] = true;
                }
                comp.setVisible(false);
                i++;
            }
            javax.swing.JLabel number = (javax.swing.JLabel)field[selectedFieldY][selectedFieldX].getComponent(0);
            number.setText(c + "");
            number.setVisible(true);
            if (!sudoku.isPlaceable(sudoku.getGrid(), selectedFieldX, selectedFieldY, (c - '0')))
                number.setForeground(Color.red);
            sudoku.setNumberAt(selectedFieldY, selectedFieldX, Integer.parseInt(c + ""));
            
            if (actionT == Action.ActionType.ADD)
            {
                actions.push(new Action(selectedFieldX, selectedFieldY, (c - '0'), true,
                        false, Action.ActionType.ADD));
            }
            else
            {
                actions.push(new Action(selectedFieldX, selectedFieldY, arr,
                        false, Action.ActionType.DELETE_NUMBER));
            }
            
            unselect();
            checkIfWon();
        }
        else
        {
            javax.swing.JLabel smallNum = (javax.swing.JLabel)field[selectedFieldY][selectedFieldX].getComponent(c - '0');
            if (smallNum.isVisible())
            {
                smallNum.setVisible(false);
                actions.push(new Action(selectedFieldX, selectedFieldY, (c - '0'), true,
                true, Action.ActionType.DELETE_NUMBER));
            }
            else
            {
                smallNum.setVisible(true);
                actions.push(new Action(selectedFieldX, selectedFieldY, (c - '0'), true,
                true, Action.ActionType.ADD));
            }
        }
    }

    /**
     * This method is called in the initialization methods in order to perform action after mouse is pressed.
     * @param lvl indicates which level panel was clicked
     * @param e indicates the click type
     */
    private void difficultyMousePressedActionPerformed(javax.swing.JPanel lvl, MouseEvent e)
    {
        for (int i = 6; i < 10; ++i)
        {
            javax.swing.JPanel lvli = (javax.swing.JPanel)framePanel.getComponent(i);
            javax.swing.JLabel txtLvl = (javax.swing.JLabel)lvli.getComponent(0);
            txtLvl.setForeground(Color.black);
        }
        javax.swing.JLabel txtLvl = (javax.swing.JLabel)lvl.getComponent(0);
        txtLvl.setForeground(Color.BLUE);
        switch (txtLvl.getText())
        {
            case "EASY":
                sudoku = new Sudoku(SudokuLevels.EASY);
                break;
            case "MEDIUM":
                sudoku = new Sudoku(SudokuLevels.MEDIUM);
                break;
            case "HARD":
                sudoku = new Sudoku(SudokuLevels.HARD);
                break;
            case "EXPERT":
                sudoku = new Sudoku(SudokuLevels.EXPERT);
                break;
        }
        dispose();
        new Game().setVisible(true);
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Unselect field">
    /**
     * This method is called whenever the field needs to deselect the previously selected field(s)
     */
    private void unselect()
    {
        selectedFieldX = -1;
        selectedFieldY = -1;
        for (int row = 0; row < 9; ++row)
        {
            for (int col = 0; col < 9; ++col)
            {
                field[row][col].setBackground(Color.white);
            }
        }
    }
    // </editor-fold>
    
    private void checkIfWon()
    {
        if (sudoku.isSolved())
        {
            dispose();
            JOptionPane.showMessageDialog(this, "Congratulations, you won!", "Good Game!", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnErase;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnUndo;
    private javax.swing.JPanel framePanel;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JToggleButton tglBtnNotes;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel[][] field;
}
