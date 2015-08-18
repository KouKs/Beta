/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.menu;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Pavel
 */
public class MainMenu {
    
    public void load( ) throws FileNotFoundException {
        JFrame frame = new JFrame("MainMenu");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        // TODO: load default sizes from config
        frame.setSize( new Dimension( 800 , 600 ) );
        frame.getContentPane().setBackground(Color.WHITE);
        
        // Getting the menu XML file and printing it out
        // TODO: path, layout?? 
        String content = new Scanner( new File(
                "X:/UwAmp/www/roguelike/Beta/game/build/classes/game/menu.xml"
        )).useDelimiter("\\Z").next();
        JLabel menuHTML = new JLabel("menuHTML");
        menuHTML.setText( content );
        frame.add( menuHTML );        
        
        frame.setVisible( true );
    }
}
