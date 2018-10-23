import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;
    private Point buttonPoint;
    private Image buttonImage;

    public Cell(Image image,Point point){
        this(image);
        buttonPoint = point;
    }

    public Cell(Image image){
        buttonImage = image;
        setSize(WIDTH,HEIGHT);
//        setBackground(Color.ORANGE);
        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(buttonImage,0,0,WIDTH,HEIGHT,this);

    }
}
