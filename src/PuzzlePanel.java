import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PuzzlePanel extends JPanel {
    GameWindow gameWin;
    int row,column;
    private Cell[][] cells;
    private ArrayList<Image> imageList;
    private Image[][] cellImages;
    BufferedImage image;

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

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Image[][] getCellImages() {
        return cellImages;
    }

    public void setCellImages(Image[][] cellImages) {
        this.cellImages = cellImages;
    }



    public GameWindow getGameWin() {
        return gameWin;
    }

    public void setGameWin(GameWindow gameWin) {
        this.gameWin = gameWin;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

//    BufferedImage image;
    public PuzzlePanel() {
        setBackground(Color.blue);
    }

    public PuzzlePanel(GameWindow gameWin) {
        this.gameWin = gameWin;
        setLayout(null);
    }

    public void initPanel() {
        removeAll();
        image = gameWin.getImage();
        row = gameWin.getRow();
        column = gameWin.getColumn();
        setSize(new Dimension(Cell.WIDTH * column,Cell.HEIGHT*row));


        cells = new Cell[row][column];
        SplitImage split = new SplitImage();
        cellImages = split.getImages(image,row,column);


        imageList = new ArrayList<Image>();
        for(int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                imageList.add(cellImages[i][j]);
            }
        }
        imageList.remove(row*column -1);

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                cells[i][j] = new Cell(cellImages[i][j],new Point(i,j));
                cells[i][j].setBorder(null);
                this.add(cells[i][j]);

//                this.add(new JButton("i" + "j"));
                cells[i][j].setLocation(j*Cell.WIDTH,i*Cell.HEIGHT);

            }
        }
    }
}
