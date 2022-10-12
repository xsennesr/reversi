package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import javax.swing.*;
import java.awt.*;

public class ChangeSize {
    public JPanel changeSize(JFrame frame, JPanel setup, JPanel board, int val, CreateBoxes createBoxes, StartingGrid startingGrid){
        board.removeAll();
        board = new JPanel(new GridLayout(0, val));
        board= createBoxes.createBoxes(val,board);
        board.revalidate();
        setup.add(board);
        frame.add(setup);
        frame.setVisible(true);
        startingGrid.startingGrid(board,val);
        board.requestFocus();
        return board;
    }
}
