package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import javax.swing.*;
import java.awt.*;

public class StartingGrid {
    private final LoadImage loadImage;

    public StartingGrid(){
        loadImage= new LoadImage();
    }

    public void startingGrid(JPanel board, int val){
        int n = (val / 2) - 1;
        int LUcenter = (val * n) + 2 + (n - 2);  //Left Up center

        JLabel lbl = (JLabel) board.getComponent(LUcenter);
        loadImage.loadimage(lbl, Color.red);

        lbl =(JLabel) board.getComponent(LUcenter +1);
        loadImage.loadimage(lbl,Color.blue);

        lbl =(JLabel) board.getComponent(LUcenter +val);
        loadImage.loadimage(lbl,Color.blue);

        lbl =(JLabel) board.getComponent(LUcenter +val+1);
        loadImage.loadimage(lbl,Color.red);

        lbl =(JLabel) board.getComponent(LUcenter -val+1);
        loadImage.loadimage(lbl, Color.gray);

        lbl =(JLabel) board.getComponent(LUcenter +2);
        loadImage.loadimage(lbl, Color.gray);

        lbl =(JLabel) board.getComponent(LUcenter +val-1);
        loadImage.loadimage(lbl, Color.gray);

        lbl =(JLabel) board.getComponent(LUcenter +(val*2));
        loadImage.loadimage(lbl, Color.gray);
    }
}
