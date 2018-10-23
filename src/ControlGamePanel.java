import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlGamePanel extends JPanel {
    JButton buttonStart, buttonPreview, buttonSave, buttonDraw, buttonExit;
    int row, column;
    ArrayList<Image> imageList;
    Cell[][] cells;
    Cell lastCell, noImageCell;
    PuzzlePanel puzzlePanel;
    GameWindow gameWin;
    private JPanel imagePanel;

    public ControlGamePanel(GameWindow gameWin) {
        this.gameWin = gameWin;

        buttonStart = new JButton("开始新游戏");
        buttonPreview = new JButton("预览全图");
        buttonSave = new JButton("保存游戏");
        buttonDraw = new JButton("提取游戏");
        buttonExit = new JButton("结束当前游戏");

        add(buttonStart);
        add(buttonPreview);
        add(buttonSave);
        add(buttonDraw);
        add(buttonExit);


    }


}