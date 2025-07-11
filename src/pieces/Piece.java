package pieces;


import main.Board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Piece {

    public int col, row;
    public int xPos, yPos;

    public boolean isWhite;
    public String name;
    public int value;

    public boolean isFirstMove;


    BufferedImage sheet;
    {
        try{
            sheet = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("pieces.png")));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    protected int sheetScale = sheet.getWidth()/6;

    Image sprite;

    Board board;

    //constructor
    public Piece(Board board){
        this.board = board;
    }


    public boolean isValidMovement(int col, int row){return true;}
    public boolean moveCollidesWithPiece(int col, int row){return false;}


    public void paint(Graphics2D g2d){
        g2d.drawImage(sprite, xPos, yPos, null);
    }

}
