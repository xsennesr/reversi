package sk.stuba.fei.uim.oop.Game;

import sk.stuba.fei.uim.oop.Game.HelpFunctions.CreateBoxes;
import sk.stuba.fei.uim.oop.Game.HelpFunctions.StartingGrid;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import lombok.*;

@Getter @Setter
public class GenerateFrame {
    private int val;
    private JFrame frame;
    private JPanel menu, board;
    private JSlider slider;
    private JButton reset;
    private JLabel boardSizeText, infoText;
    private Listeners listen;
    private StartingGrid startingGrid;
    private CreateBoxes createBoxes;

    public GenerateFrame(){
        val=6;
        createBoxes=new CreateBoxes();
        startingGrid=new StartingGrid();

        this.generateFrame();
        this.generateMenu();
        this.generateBoard();
        this.generateSlider();
        this.generateButton();
        this.generateText();
        menu.add(board);
        frame.add(menu);

        listen=new Listeners(this);
        board.addMouseListener(listen);
        board.addMouseMotionListener(listen);
        board.addKeyListener(listen);
        slider.addChangeListener(listen);
        reset.addActionListener(listen);

        frame.setFocusable(true);
        frame.setVisible(true);
        startingGrid.startingGrid(board,val);
    }

    private void generateFrame(){
        frame=new JFrame("Reversi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,760);
        frame.setResizable(false);
    }

    private void generateMenu(){
        menu =new JPanel(new BorderLayout());
        menu.setBorder(new EmptyBorder(0,0,120,0));
    }

    private void generateBoard() {
        board = new JPanel(new GridLayout(0, val));
        board = createBoxes.createBoxes(val, board);
        menu.add(board);
    }

    private void generateSlider(){
        slider =new JSlider(JSlider.HORIZONTAL,6,12,6);
        slider.setBounds(175,660,300,40);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        menu.add(slider);
    }

    private void generateButton(){
        reset=new JButton("Reset");
        reset.setBounds(30,660,120,40);
        menu.add(reset);
    }

    private void generateText(){
        boardSizeText =new JLabel(val+" x"+val);
        boardSizeText.setBounds(500,660,50,30);
        menu.add(boardSizeText);

        infoText =new JLabel("RED:"+2+"        Player's turn(RED)        BLUE:"+2);
        infoText.setBounds(20,615,300,30);
        menu.add(infoText);
    }
}
