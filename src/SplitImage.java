import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by simao on 2018/6/5.
 */
public class SplitImage {
    public SplitImage(){
        super();
    }

    public Image[][] getImages(BufferedImage image,int rows,int columns){
        Image[][] cellImages = new Image[rows][columns];
        int imageCellWidth = image.getWidth()/columns;
        int imageCellHeight = image.getHeight()/rows;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                cellImages[i][j] = image.getSubimage(
                        j*imageCellWidth,i*imageCellHeight,imageCellWidth,imageCellHeight
                );
            }
        }
        return cellImages;
    }
}

