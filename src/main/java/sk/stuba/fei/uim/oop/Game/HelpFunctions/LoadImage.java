package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class LoadImage  {

    public void loadimage(JLabel lbl,Color color){
        BufferedImage pic = null;
        ImageIcon imageicon;
        if(color==Color.red) {
            try {
                pic = ImageIO.read(Objects.requireNonNull(LoadImage.class.getResourceAsStream("/red.png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            imageicon = new ImageIcon(Objects.requireNonNull(pic));
            imageicon = resize(imageicon, lbl.getWidth(), lbl.getHeight());
            lbl.setIcon(imageicon);
            lbl.setBackground(Color.red);
        }
        else if(color==Color.blue) {
            try {
                pic = ImageIO.read(Objects.requireNonNull(LoadImage.class.getResourceAsStream("/blue.png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            imageicon = new ImageIcon(Objects.requireNonNull(pic));
            imageicon = resize(imageicon, lbl.getWidth(), lbl.getHeight());
            lbl.setIcon(imageicon);
            lbl.setBackground(Color.blue);
        }
        else if(color==Color.gray) {
            try {
                pic = ImageIO.read(Objects.requireNonNull(LoadImage.class.getResourceAsStream("/possible.png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            imageicon = new ImageIcon(Objects.requireNonNull(pic));
            imageicon = resize(imageicon, lbl.getWidth(), lbl.getHeight());
            lbl.setIcon(imageicon);
            lbl.setBackground(Color.gray);
        }

    }

    private ImageIcon resize(ImageIcon image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = bi.createGraphics();
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }
}
