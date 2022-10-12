package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CreateBoxes {
    private final Border basicBorder;

    public CreateBoxes(){
        basicBorder=BorderFactory.createLineBorder(Color.black, 1);
    }

    public JPanel createBoxes(int val, JPanel board){
        for(int i=0;i<(val*val);i++){
            JLabel lbl = new JLabel();
            lbl.setBorder(basicBorder);
            lbl.setDisplayedMnemonic(i);
            board.add(lbl);
        }
        return board;
    }
}
