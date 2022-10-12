package sk.stuba.fei.uim.oop.Game.SearchDirections;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.LoadImage;

import javax.swing.*;
import java.awt.*;

public class SearchLeftUp extends SearchPossible {
    public int search(JPanel board, int position, int val,int x, int y, Color yourColor, Color enemyColor){
        counter=0;
        possible =(JLabel) board.getComponent(position);
        if(((y-1)>=0) && ((x-1)>=0) && ((possible.getBackground()!=Color.red) && (possible.getBackground()!=Color.blue))){
            lbl=(JLabel) board.getComponent(position-val-1);
            if(lbl.getBackground()==enemyColor){
                position=position-val-1;
                while(((y-1)>=0) && ((x-1)>=0)){
                    lbl=(JLabel) board.getComponent(position);
                    if(lbl.getBackground()==enemyColor){
                        position=position-val-1;
                        y--;
                        x--;
                        counter++;
                    }
                    else if(lbl.getBackground()==yourColor){
                        LoadImage loadImage=new LoadImage();
                        loadImage.loadimage(possible,Color.gray);
                        return counter;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
