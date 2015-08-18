/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game;

import game.menu.MainMenu;

/**
 *
 * @author Pavel Koch, Michael Bausano
 */
public class Main {

    /**
     * @var MainMenu
     */
    private MainMenu m;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // loading screens...
        
        MainMenu m = new MainMenu( );
        m.load( );
    }
}
