/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.materials;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Pavel
 */
public enum Material {

    FLOOR (0),
    WALL (1),
    BRICK_WALL(2);
    
    private final int id;
    
    Material( int id )
    {
        this.id = id;
    }
    
    public int id()
    {
        return this.id;
    }
    
    public URL getUrl( )
    {
        return this.getClass().getResource( this.id + ".png" );
    }
    
    public Image getImage( )
    {
        Image img = null;
        try {
                img = ImageIO.read( this.getClass().getResource( this.id + ".png" ) );
        } catch( IOException e ) { }
        return img;
    }
}
