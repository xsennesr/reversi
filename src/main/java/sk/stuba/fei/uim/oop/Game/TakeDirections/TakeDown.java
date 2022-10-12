package sk.stuba.fei.uim.oop.Game.TakeDirections;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.LoadImage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class TakeDown extends TakeOver {
    public void take(JPanel board, int position, int val, int x, int y, Color yourColor, Color enemyColor, ArrayList<JLabel> labelList){
        loadImage.loadimage((JLabel) board.getComponent(position),yourColor);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        lbl=(JLabel) board.getComponent(position);
        lbl.setBorder(border);
        if((y+1)<val){
            lbl=(JLabel) board.getComponent(position+val);
            if(lbl.getBackground()==enemyColor){
                position=position+val;
                while((y+1)<val){
                    lbl=(JLabel) board.getComponent(position);
                    if(lbl.getBackground()==enemyColor){
                        position=position+val;
                        y++;
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
