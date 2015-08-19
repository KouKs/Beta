/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.menu;

import java.awt.Dimension;
import javax.swing.JFrame;;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Pavel
 */
public class MainMenu extends Canvas implements Runnable {
    
    private final JFrame frame;
    private final static Dimension dimens = new Dimension(800, 600);
    private Graphics g;
    
    public MainMenu()
    {
        this.frame = new JFrame("MainMenu");
        this.frame.setSize(dimens);
        this.frame.setMinimumSize(dimens);
        this.frame.setMaximumSize(dimens);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.add(this);
        this.frame.setVisible(true);
    }
    
    /**
     * rewriting screen
     */
    @Override
    public void run() 
    {
        while(true)
        {
            load();
        }
    }
    
    public void load( ) {

        BufferStrategy bs = getBufferStrategy();
        
        if(bs==null)
        {
            createBufferStrategy(2);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 200, 200);
        g.dispose();

        bs.show();
    }
}
