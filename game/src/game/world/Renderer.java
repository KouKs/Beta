/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.world;

import game.materials.Material;
import game.sprites.Sprite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Map;
import javax.swing.JFrame;
import java.util.Timer;
import java.awt.event.*;
import java.util.TimerTask;

/**
 *
 * @author Pavel
 */
public class Renderer extends Canvas implements Runnable, KeyListener
{
    private final Generator g = new Generator( );
    private final JFrame frame;
    private final Dimension dimens = new Dimension(800,600);
    
    private int sy = 200, sx = 200;
    
    public Map<String,Integer> room = g.getDefaultRoom();
    public Image wall = Material.WALL.getImage( );
    public Image floor = Material.FLOOR.getImage( );
    
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
        this.addKeyListener(this);
        
        // FPS: 10
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                @Override
                public void run() {
                    render();
                }
            }, 50, 50);
    }
    
    public void render( )
    {
        
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs==null)
        {
            this.createBufferStrategy(2);
            return;
        }
        
        Graphics gr = bs.getDrawGraphics();        
        for( int y = 0 ; y < 15 ; y++ )
        {
            gr.setColor(Color.LIGHT_GRAY);
            for( int x = 0 ; x < 15 ; x++)
            {                
                if( room.get( x + ":" + y ) == 0 )
                    gr.drawImage( wall , 32*x, 32*y , this );
                else
                    gr.drawImage( floor , 32*x, 32*y , this );
            }
        }
        drawSprite( gr );
        
        gr.dispose();
        bs.show();
    }
    
    public void drawSprite( Graphics gr ) {
        gr.drawImage( Sprite.MAIN.getImage( ) , sx, sy , this );
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                this.sy -= 1;
                break;
            case KeyEvent.VK_DOWN:
                this.sy += 1;
                break;
            case KeyEvent.VK_LEFT:
                this.sx -= 1;
                break;
            case KeyEvent.VK_RIGHT :
                this.sx += 1;
                break;
         }
    
    } 
    
    @Override
    public void keyReleased (KeyEvent e){}
    @Override
    public void keyTyped (KeyEvent e){}
}