package sk.stuba.fei.uim.oop.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import sk.stuba.fei.uim.oop.Game.HelpFunctions.CreateArrayLists;
import sk.stuba.fei.uim.oop.Game.TakeDirections.TakeOver;
import sk.stuba.fei.uim.oop.Game.SearchDirections.SearchPossible;

public class GameLogic {
    private final Color yourColor, enemyColor;
    private final CreateArrayLists createArrayLists;
    private int[] rocks;
    private JLabel lbl;
    private int position,x,y;
    private boolean enemyMove;

    public GameLogic(){
        this.yourColor = Color.red;
        this.enemyColor = Color.blue;
        this.rocks = new int[3];
        this.createArrayLists=new CreateArrayLists();
    }

    public void gameLogic(JPanel board, int val, MouseEvent e,JLabel infoText) {
        lbl = (JLabel) board.getComponentAt(e.getPoint());

        //players turn
        if (lbl.getBackground() == Color.gray) {
            this.take(board,val,lbl.getDisplayedMnemonic(),yourColor,enemyColor);
            this.deletePossible(board, val);
            enemyMove = true;
        }

        //enemys turn
        if (enemyMove) {
            this.enemysTurn(board,val);
            this.deletePossible(board, val);
            enemyMove = false;
        }

        //enemy will play, until player can make move
        while(true){
            this.search(board,val,yourColor,enemyColor);
            if(!(this.canPlay(board,val))){
                this.deletePossible(board, val);
                if(!(this.enemysTurn(board,val))){
                    break;
                }
                this.deletePossible(board, val);
            }
            else{
                break;
            }
        }

        rocks = this.getRocks(board, val);
        infoText.setText("RED:"+rocks[1]+"        Player's turn(RED)        BLUE:"+rocks[2]);
        this.evaluate(board,val,infoText);
    }


    private boolean enemysTurn( JPanel board, int val){
        this.position=this.search(board,val,this.enemyColor,this.yourColor);
        if (this.position != -1) {
            this.take(board,val,this.position,this.enemyColor,this.yourColor);
            return true;
        }
        return false;
    }


    private int search(JPanel board, int val, Color yourColor, Color enemyColor){
        int best;
        this.position=-1;
        int takenRocks = 0;
        for (int j=0;j<(val*val);j++) {
            best = 0;
            this.y = j / val;
            this.x = j - (val * this.y);
            for(SearchPossible i : createArrayLists.getSearchPossibles()){
                best += i.search(board, j, val, x, y, yourColor, enemyColor);
                if (best > takenRocks) {
                    this.position = j;
                    takenRocks = best;
                }
            }
        }
        return this.position;
    }


    private void take(JPanel board,int val,int position,Color yourColor, Color enemyColor){
        ArrayList<JLabel> labelList=new ArrayList<>();
        this.y=position/val;
        this.x=position-(val*y);
        for(TakeOver i:createArrayLists.getTakeOver()){
            i.take(board,position,val,this.x,this.y,yourColor,enemyColor,labelList);
        }
    }


    private void deletePossible(JPanel board,int val){
        for(int i=0;i<(val*val);i++){
            this.lbl = (JLabel) board.getComponent(i);
            if (this.lbl.getBackground() == Color.gray) {
                this.lbl.setBackground(Color.white);
                this.lbl.setIcon(null);
            }
        }
    }


    private boolean canPlay(JPanel board, int val){
        for(int i=0;i<(val*val);i++){
            this.lbl=(JLabel) board.getComponent(i);
            if(this.lbl.getBackground()== Color.gray){
                return true;
            }
        }
        return false;
    }


    private int[] getRocks(JPanel board,int val) {
        this.rocks=new int[3];
        for(int i=0;i<(val*val);i++){
            this.lbl=(JLabel) board.getComponent(i);
            if(this.lbl.getBackground()== java.awt.Color.gray){
                this.rocks[0]++;
            }
            else if(this.lbl.getBackground()==yourColor){
                this.rocks[1]++;
            }
            else if(this.lbl.getBackground()==enemyColor){
                this.rocks[2]++;
            }
        }
        return this.rocks;
    }

    private void evaluate(JPanel board, int val, JLabel infoText){
        if (this.rocks[0] == 0) {
            this.deletePossible(board, val);
            this.search(board,val,this.enemyColor,this.yourColor);
            this.rocks = this.getRocks(board, val);
            if (this.rocks[0]==0) {
                if (this.rocks[1] > this.rocks[2]) {
                    infoText.setText("RED:"+this.rocks[1]+"        Player wins        BLUE:"+this.rocks[2]);
                } else {
                    infoText.setText("RED:"+this.rocks[1]+"        Computer wins       BLUE:"+this.rocks[2]);
                }
            }
        }
    }
}