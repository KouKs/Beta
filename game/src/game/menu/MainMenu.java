/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.menu;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author Pavel
 */
public class MainMenu {
    
    public void load( ) {
        JFrame frame = new JFrame("MainMenu");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( new Dimension( 1024 , 768 ) );
        frame.getContentPane().setBackground(Color.WHITE);
        JLabel label = new JLabel("My label");
        label.setText("<html><style>ul { list-style-type: none; }</style><ul> <li><b>Menu</b> <li>Pavlik</li> <li>ma</li> <li>za usima</li></ul></html>");
        frame.add(label);
        frame.setVisible( true );
    }
}
