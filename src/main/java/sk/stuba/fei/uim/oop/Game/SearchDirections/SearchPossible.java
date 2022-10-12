package sk.stuba.fei.uim.oop.Game.SearchDirections;

import javax.swing.*;
import java.awt.*;

public abstract class SearchPossible {
    protected JLabel lbl, possible;
    protected int counter;
    public abstract int search(JPanel board, int position, int val,int x, int y, Color yourColor, Color enemyColor);
}