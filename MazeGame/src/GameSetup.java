import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Kong Lor
 * CSci 1130
 * Simple Game
 * Fall 2016
 */
public class GameSetup extends JPanel implements KeyListener{

    Entity player;
    final int WALL_HEIGHT=30, WALL_WIDTH=30;






    public int [][] map = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,1,0,0,1,1,0,1,0,1,1,1,0,0,1},
            {1,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,1,0,1,1,1,1,0,0,0,0,1},
            {1,1,0,1,1,1,1,1,0,1,0,0,0,0,1,1,1,1,0,1},
            {1,0,0,0,0,1,0,0,0,1,1,0,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,1},
            {1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,0,1,0,1,1},
            {1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1},
            {1,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
            {1,1,0,1,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1},
            {1,1,0,1,1,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1},
            {1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,3,1}, //prize is at [13][18]
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    public GameSetup(){
        setFocusable(true);
        addKeyListener(this);
        player=new Entity(30, WALL_HEIGHT*13,30,30);
        setPreferredSize(new Dimension(500,600));
        setBackground(Color.BLACK);
    }

    public void paint (Graphics g){
        super.paint(g);
        for (int row = 0; row < map.length; row++){
            for (int col = 0; col < map[0].length; col++){
                Color color;
                switch (map[row][col]){
                    case 1: color = Color.BLUE; break;
                    case 3: color = Color.YELLOW;break;
                    default: color = Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(WALL_WIDTH*col, WALL_HEIGHT*row,WALL_WIDTH,WALL_HEIGHT);
                g.setColor(Color.BLACK);
                g.drawRect(WALL_WIDTH*col, WALL_HEIGHT*row,WALL_WIDTH,WALL_HEIGHT);
            }

        }
        setupRedPlayer(g);
    }
    public void setupRedPlayer(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(player.getLocX(), player.getLocY(), player.getWidth(), player.getHeight());

    }
    public boolean validMove(int x, int y){
        boolean validLeft=(player.getLocX()+x>=0) && ((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==0);//||((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==9 );
        boolean validTop=(player.getLocY()+y>=0)&& (map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==0;//||((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==9);
        boolean validBottom=(player.getLocY()+player.getHeight())+y<=this.getHeight()&& (map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==0;//||((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==9);
        boolean validRight=(player.getLocX()+player.getWidth())+x<=this.getWidth()&& (map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==0;//||((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==9);
        return validTop&&validBottom&&validLeft&&validRight;
    }
    public boolean winnerWinner(int x, int y){
        boolean validWinner=((map[player.locY/WALL_WIDTH][player.locX/WALL_HEIGHT])==3);
        return  validWinner;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_UP){
            if(validMove(0,-player.getHeight())){
                player.move(0,-30);
            }
            if(!validMove(0,player.getHeight())){
                player.move(0,30);
            }
        }
        if(key==KeyEvent.VK_DOWN){
            if(validMove(0,player.getHeight())){
                player.move(0,30);
                if(winnerWinner(0,player.getHeight())){
                    JOptionPane.showMessageDialog(this, "You've Won!");
                }
            }
            if(!validMove(0,-player.getHeight())){
                player.move(0,-30);
            }
        }
        if(key==KeyEvent.VK_LEFT){
            if(validMove(-player.getWidth(),0)) {
                player.move(-30, 0);
            }
            if(!validMove(-player.getWidth(),0)){
                player.move(30,0);
            }
        }
        if(key==KeyEvent.VK_RIGHT){
            if(validMove(player.getWidth(),0)){
                player.move(30,0);
            } if(!validMove(-player.getWidth(),0)){
                player.move(-30,0);
            }

        }
        repaint();

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}



