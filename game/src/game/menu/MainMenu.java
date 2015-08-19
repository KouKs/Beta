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

/**
 *
 * @author Pavel
 */
public class MainMenu extends Canvas {
    private final BufferStrategy strategy;
    
    // performance settings. 
    static {
        System.setProperty("sun.java2d.transaccel", "True");
        // System.setProperty("sun.java2d.trace", "timestamp,log,count");
        // System.setProperty("sun.java2d.opengl", "True");
        System.setProperty("sun.java2d.d3d", "True");
        System.setProperty("sun.java2d.ddforcevram", "True");
    }
    
    public MainMenu( ) {
        this.createBufferStrategy(3);
        this.strategy = this.getBufferStrategy();        
    }
    
    public void load( ) {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // TODO: load default sizes from config
        frame.setSize( new Dimension( 800 , 600 ) );
        
        // the back buffer graphics object
        Graphics2D bkG = (Graphics2D) strategy.getDrawGraphics(); 

        // clear the backbuffer, this could be substituted for a background
        // image or a tiled background.
        bkG.setPaint(Color.WHITE);
        bkG.fillRect(0, 0, getWidth(), getHeight());

        // TODO: Draw your game world, or scene or anything else here.

        // Rectangle2D is a shape subclass, and the graphics object can render
        // it, makes things a little easier.
        bkG.setColor(Color.green.darker());
        // bkG.fill( new Shape( ) {} );

        // properly dispose of the backbuffer graphics object. Release resources
        // and cleanup.
        bkG.dispose();

        // flip/draw the backbuffer to the canvas component.
        strategy.show();

        // synchronize with the display refresh rate.
        Toolkit.getDefaultToolkit().sync();
    }
}
