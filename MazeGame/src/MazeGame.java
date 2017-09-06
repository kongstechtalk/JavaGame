import javax.swing.*;
import java.awt.*;

/**
 * Kong Lor
 * CSci 1130
 * Simple Game
 * Fall 2016
 */
public class MazeGame extends JApplet {
    JPanel titlePanel, bottomPanel;
    JLabel title, bottomLabel;

    GameSetup g;

    public void init(){
        setLayout(new BorderLayout());
        setupTitle();
        setupBottom();
        g=new GameSetup();
        add(g, BorderLayout.CENTER);

    }
    public void setupTitle() {
        titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(Color.BLACK);
        title = new JLabel("<html><h1 style=\"font-family:comic sans ms;\"><font size=+10 color=red><b><i>Kong's Maze " +
                "Game</i></b></font></h1></html>");;
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }
    public void setupBottom(){
        bottomPanel=new JPanel(new FlowLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomLabel = new JLabel("<html><h1 style=\"font-family:comic sans ms;\"><font size=+2 color=red><b><i>Reach the <font color=yellow>YELLOW</font> box to WIN!</i></b></font></h1></html>");
        bottomPanel.add(bottomLabel);
        add(bottomPanel, BorderLayout.SOUTH);
    }


}






