/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.world;

import game.materials.Material;
import game.characters.Hero;
import game.characters.Enemy;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Map;
import javax.swing.JFrame;
import java.util.Timer;
import java.awt.event.*;
import java.util.HashMap;
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
    
    private final Map<Integer,Image> images = new HashMap<>();
    
    public Map<String,Integer> room = g.getDefaultRoom();
    
    private final Hero hero = new Hero( 1 );
    
    private final Enemy enemy = new Enemy( 2 );
    
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
        
        for( Material value : Material.values( ) )
        {
            this.images.put( value.id( ) , value.getImage() );
        }
        
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
        
        if( bs == null )
        {
            this.createBufferStrategy(2);
            return;
        }
        
        Graphics gr = bs.getDrawGraphics(); 
        
        int sizeX = this.room.get( "sizeX" );
        int sizeY = this.room.get( "sizeY" );
        
        for( int y = 0 ; y < sizeY ; y++ )
        {
            for( int x = 0 ; x < sizeX ; x++)
            {
                int tile = this.room.get( x + ":" + y );
                
                if( tile == 4 || !this.room.containsKey( x + ":" + y ) ) {
                    continue;
                }
                gr.drawImage( this.images.get( tile ) , 32*x, 32*y , this );
            }
        }
        
        drawSprites( gr );
        
        gr.dispose();
        bs.show();
    }
    
    public void drawSprites( Graphics gr ) {
        Map<String,Integer> posHero = this.hero.getPosition();
        gr.drawImage( this.hero.getCurrentImage() , posHero.get("x"), posHero.get("y") , this );
        
        this.enemy.scout( this.hero.getPosition() );
        Map<String,Integer> posEnemy = this.enemy.getPosition();
        gr.drawImage( this.enemy.getCurrentImage() , posEnemy.get("x"), posEnemy.get("y") , this );
    }
    
    @Override
    public void keyPressed(KeyEvent e) { 
        if( e.getKeyCode() == KeyEvent.VK_W ) {
            this.hero.move( "walkNorth", 1);
        }
        if( e.getKeyCode() == KeyEvent.VK_S ) {
            this.hero.move( "walkSouth", 1);
        }
        if( e.getKeyCode() == KeyEvent.VK_A ) {
            this.hero.move( "walkWest", 1);
        }
        if( e.getKeyCode() == KeyEvent.VK_D ) {
            this.hero.move( "walkEast", 1);
        }     
    } 
    
    @Override
    public void keyReleased (KeyEvent e){
        this.hero.stop();
    }
    @Override
    public void keyTyped (KeyEvent e){}
}