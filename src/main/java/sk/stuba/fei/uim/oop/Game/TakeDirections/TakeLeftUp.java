package sk.stuba.fei.uim.oop.Game.TakeDirections;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.LoadImage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TakeLeftUp extends TakeOver {
    public void take(JPanel board, int position, int val, int x, int y, Color yourColor, Color enemyColor, ArrayList<JLabel> labelList){
        if(((y-1)>=0) && ((x-1)>=0)){
            lbl=(JLabel) board.getComponent(position-val-1);
            if(lbl.getBackground()==enemyColor){
                position=position-val-1;
                while(((y-1)>0) && ((x-1)>=0)){
                    lbl=(JLabel) board.getComponent(position);
                    if(lbl.getBackground()==enemyColor){
                        position=position-val-1;
                        y--;
                        x--;
                        labelList.add(lbl);
                    }
                    else if(lbl.getBackground()==yourColor){
                        LoadImage loadImage=new LoadImage();
                        for(JLabel lbl : labelList){
                            loadImage.loadimage(lbl,yourColor);
                        }
                        labelList.clear();
                        break;
                    }
                    else{
                        labelList.clear();
                        break;
                    }
                }
            }
        }
        labelList.clear();
    }
}
