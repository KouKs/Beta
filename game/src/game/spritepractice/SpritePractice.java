package game.spritepractice;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class SpritePractice extends Canvas implements Runnable { 

private JFrame frame;
private final static Dimension dimens = new Dimension(400, 400);
private Graphics g;

    public SpritePractice()
    {
        frame = new JFrame("MainMenu");
        frame.setSize(dimens);
        frame.setMinimumSize(dimens);
        frame.setMaximumSize(dimens);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(this);
        frame.setVisible(true);
        run();
    }
    

    
    public void run() 
    {
        while(true)
        {
            render();
        }
    }

    public void render()
    {
        BufferStrategy bs = getBufferStrategy();
        if(bs==null)
        {
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.BLACK);
        g.dispose();
        bs.show();
        
    }

}