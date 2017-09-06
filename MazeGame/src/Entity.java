/**
 * Kong Lor
 * CSci 1130
 * Simple Game
 * Fall 2016
 */
public class Entity {

    int locX, locY , width, height;

    public Entity(int x, int y , int w , int h){
        locX=x;
        locY=y;
        width=w;
        height=h;
    }
    public int getLocX(){return locX;}

    public int getLocY(){return locY;}

    public int getWidth(){return width;}

    public int getHeight(){return height;}


    public void move(int x, int y){
        locX+=x;
        locY+=y;
    }
}
