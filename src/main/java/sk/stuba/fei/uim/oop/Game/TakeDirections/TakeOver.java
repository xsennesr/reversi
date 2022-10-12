package sk.stuba.fei.uim.oop.Game.TakeDirections;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.LoadImage;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class TakeOver {
    protected JLabel lbl;
    protected LoadImage loadImage;
    public TakeOver(){
        loadImage=new LoadImage();
    }
    public abstract void take(JPanel board, int position, int val, int x, int y, Color yourColor, Color enemyColor, ArrayList<JLabel> labelList);
}
