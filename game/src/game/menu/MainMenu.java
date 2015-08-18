/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.menu;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Pavel
 */
public class MainMenu {
    
    public void load( ) {
        JFrame frame = new JFrame("MainMenu");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( new Dimension( 1024 , 768 ) );
        frame.setVisible( true );
    }
}
