/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.world;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Map;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Pavel
 */
public class Renderer extends Canvas implements Runnable
{
    private final Generator g = new Generator( );
    private final JFrame frame;
    private final Dimension dimens = new Dimension(800,600);
    
    
    
    public Renderer( )
    {
        this.frame = new JFrame("Ingame");
        this.frame.setSize(dimens);
        this.frame.setMinimumSize(dimens);
        this.frame.setMaximumSize(dimens);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(this);
        this.frame.pack();
        this.frame.setVisible(true);
 
        //this.run( );
    }
    
    @Override
    public final void run() {
        // FPS: 10
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                public void run() {
                    render();
                }
            }, 100, 100);
        
        this.render( );
    }
    
    public void render( )
    {
        Map<String,Integer> room = g.getDefaultRoom();
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs==null)
        {
            this.createBufferStrategy(2);
            return;
        }
        
        Graphics gr = bs.getDrawGraphics();        
        for( int y = 0 ; y < 10 ; y++ )
        {
            
            for( int x = 0 ; x < 10 ; x++)
            {
                if( room.get( x + ":" + y ) == 0 )
                    gr.setColor(Color.BLACK);
                else
                    gr.setColor(Color.LIGHT_GRAY);
                gr.fillRect(32*x, 32*y, 32, 32);
            }
        }
        bs.show();
    }
}