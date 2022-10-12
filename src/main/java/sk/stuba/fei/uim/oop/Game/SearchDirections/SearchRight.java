package sk.stuba.fei.uim.oop.Game.SearchDirections;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.LoadImage;

import javax.swing.*;
import java.awt.*;

public class SearchRight extends SearchPossible {
    public int search(JPanel board, int position, int val,int x, int y, Color yourColor, Color enemyColor){
        counter=0;
        possible =(JLabel) board.getComponent(position);
        if((x+1)<val && ((possible.getBackground()!=Color.red) && (possible.getBackground()!=Color.blue))){
            lbl=(JLabel) board.getComponent(position+1);
            if(lbl.getBackground()==enemyColor){
                position++;
                while((x+1)<val){
                    lbl=(JLabel) board.getComponent(position);
                    if(lbl.getBackground()==enemyColor){
                        position++;
                        x++;
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
