import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {
    int row = 3,column =3;
    private JLabel playerName;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    BufferedImage image;
    JMenuBar menuBar = new JMenuBar();
    private PuzzlePanel puzzlePanel;
    private JPanel imagePanel;
    ControlGamePanel controlPanel;
    JPanel messagePanel;
    JMenu menu1 = new JMenu("文件");
    JMenu menu2 = new JMenu("编辑");
    JMenu menu3 = new JMenu("资源");
    public GameWindow() throws HeadlessException {
        this.setSize(800,700);
        //加载默认图片
        try{
            //URI uri = GameWindow.class.getClassLoader().getResource("image/qq.jpg").toURI();
            //File file = new File(uri);
            image = ImageIO.read(GameWindow.class.getClassLoader().getResourceAsStream("image/qq.jpg"));
        }catch (Exception e){
            e.printStackTrace();

        }
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        puzzlePanel = new PuzzlePanel(this);
        puzzlePanel.initPanel();
        imagePanel = new JPanel();
        controlPanel = new ControlGamePanel(this);
        creatMessagePanel();
        //messagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(240,120));
        add(controlPanel,BorderLayout.SOUTH);
        add(messagePanel,BorderLayout.NORTH);
        add(puzzlePanel,BorderLayout.CENTER);
        add(imagePanel,BorderLayout.EAST);

        messagePanel.setBackground(Color.CYAN);
        imagePanel.setBackground(Color.magenta);
        //设置菜单栏
        this.setJMenuBar(menuBar);


        setSize(new Dimension(Cell.WIDTH * column + 240,Cell.HEIGHT*row + 100));
        setVisible(true);
        setResizable(false);
        validate();
    }

    private void creatMessagePanel(){
        messagePanel = new JPanel();
        playerName = new JLabel("你完成走过的步数");
        messagePanel.add(playerName);
        playerName.setBackground(Color.yellow);
    }
}
