/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.characters;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
/**
 *
 * @author Michal
 */
public class Entity {
    protected final int id;
    protected String currentImage;
    
    protected Map<String,Image> images = new HashMap<>();
    
    protected int hp, dmg, moveDirection, x, y;
    public boolean display, moving;
    
    Entity( int id ) {
        this.id = id;
        this.display = true;
        this.hp = 10;
        this.dmg = 2;
        this.moving = false;
        this.moveDirection = 3;
        this.x = 280;
        this.y = 230;
        this.currentImage = "walkNorth";
       
    }
    
    public Map<String,Integer> getPosition() {
        Map<String,Integer> coords = new HashMap<>();
        coords.put( "x", this.x );
        coords.put( "y", this.y );
        return coords;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Image getCurrentImage( ) {
        return this.images.get( this.currentImage );
    }
    
    public int getHp( ) {
        return this.hp;
    }
    
    public boolean wound( int dmg ) {
        this.hp -= dmg;
        return this.hp <= 0;
    }
    
    public void move( String dir, int speed ) {
        switch( dir ) {
            case "walkNorth":
                this.y -= speed;
                this.moveDirection = 1;
                break;
            
            case "walkSouth":
                this.y += speed;
                this.moveDirection = 3;
                break;
            
            case "walkWest":
                this.x -= speed;
                this.moveDirection = 4;
                break;
            
            case "walkEast":
                this.x += speed;
                this.moveDirection = 2;
                break;
        }
        this.currentImage = dir;
        this.moving = true;
    }
    
    public void stop() {
        this.moving = false;
        switch( moveDirection ) {
            case 1:
                this.currentImage = "standNorth";
                break;
            case 2:
                this.currentImage = "standEast";
                break;
            case 3:
                this.currentImage = "standSouth";
                break;
            case 4:
                this.currentImage = "standWest";
                break;
            default:
                this.currentImage = "standSouth";
        }
    }
    
    public final URL getUrl( String imgId )
    {
        return this.getClass().getResource( this.id + "_" + imgId + ".gif" );
    }
    
    public final Image getImage( String imgId )
    {
        Image img = null;
        try {
                img = ImageIO.read( this.getUrl( imgId ) );
        } catch( IOException e ) { }
        return img;
    }
    
}
