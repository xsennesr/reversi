package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Overline {
    private final Border redBorder, basicBorder;

    public Overline(){
        redBorder=BorderFactory.createLineBorder(Color.red, 3);
        basicBorder=BorderFactory.createLineBorder(Color.black, 1);
    }

    public JLabel overLine(MouseEvent e, JPanel board, JLabel last){
        last.setBorder(basicBorder);
        Component comp = board.getComponentAt(e.getPoint());
        if((comp instanceof JLabel) && (comp.getBackground()==Color.gray) ){
            ((JLabel) comp).setBorder(redBorder);
            last=((JLabel) comp);
        }
        return last;
    }
}

