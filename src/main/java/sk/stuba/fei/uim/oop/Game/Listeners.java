package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class Listeners extends UniversalAdapter implements ChangeListener, ActionListener, KeyListener{
    private final JFrame frame;
    private final JPanel setup;
    private final JSlider slider;
    private final JLabel infoText, infoSizeText;
    private final Overline overline;
    private final ChangeSize changeSize;
    private final GameLogic gameLogic;
    private final CreateBoxes createBoxes;
    private final StartingGrid startingGrid;
    private int val;
    private JPanel board;
    private JLabel last;

    public Listeners(GenerateFrame generateFrame){
        this.val=generateFrame.getVal();
        this.frame=generateFrame.getFrame();
        this.board=generateFrame.getBoard();
        this.setup = generateFrame.getMenu();
        this.slider =generateFrame.getSlider();
        this.infoSizeText=generateFrame.getBoardSizeText();
        this.infoText=generateFrame.getInfoText();
        this.createBoxes=generateFrame.getCreateBoxes();
        this.startingGrid=generateFrame.getStartingGrid();
        last=new JLabel();
        overline=new Overline();
        changeSize =new ChangeSize();
        gameLogic=new GameLogic();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
            board= changeSize.changeSize(frame, setup,board,val,createBoxes, startingGrid);
            infoText.setText("RED:"+2+"        Player's turn(RED)        BLUE:"+2);
            board.addKeyListener(this);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            frame.dispose();
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        last=overline.overLine(e,board,last);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (!slider.getValueIsAdjusting()) {
            val=((JSlider)e.getSource()).getValue();
            infoSizeText.setText(val+" x"+val);
            infoText.setText("RED:"+2+"        Player's turn(RED)        BLUE:"+2);
            board= changeSize.changeSize(frame, setup,board,val,createBoxes, startingGrid);
            board.addKeyListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent l) {
        board= changeSize.changeSize(frame, setup,board,val,createBoxes, startingGrid);
        infoText.setText("RED:"+2+"        Player's turn(RED)        BLUE:"+2);
        board.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gameLogic.gameLogic(board,val,e,infoText);
    }
}
