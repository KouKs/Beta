/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.sprites;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Pavel
 */
public enum Sprite {

    MAIN (1);
    
    private final int id;
    
    Sprite( int id )
    {
        this.id = id;
    }
    
    public int id()
    {
        return this.id;
    }
    
    public URL getUrl( )
    {
        return this.getClass().getResource( this.id + ".gif" );
    }
    
    public Image getImage( )
    {
        Image img = null;
        try {
                img = ImageIO.read( this.getUrl( ) );
        } catch( IOException e ) { }
        return img;
    }
}
