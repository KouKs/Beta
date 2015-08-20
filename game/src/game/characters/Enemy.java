/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.characters;

import java.util.Map;

/**
 *
 * @author Michal
 */
public class Enemy extends Entity {
    
    public Enemy(int id) {
        super(id, 200, 150);
        this.images.put( "walkNorth" , this.getImage( "walk_back" ) );
        this.images.put( "walkSouth" , this.getImage( "walk_front" ) );
        this.images.put( "walkWest" , this.getImage( "walk_side" ) );
        this.images.put( "walkEast" , this.getImage( "walk_side" ) );
        this.images.put( "standNorth" , this.getImage( "stand_back" ) );
        this.images.put( "standSouth" , this.getImage( "stand_front" ) );
        this.images.put( "standWest" , this.getImage( "stand_side" ) );
        this.images.put( "standEast" , this.getImage( "stand_side" ) );
    }
    
    public void scout( Map<String,Integer> hero ) {
        float inRadius = (float)Math.pow(hero.get("x") - this.x, 2) / (500) + (float)Math.pow(hero.get("y") - this.y, 2) / (500);
        System.out.println(inRadius);
        if( inRadius <= 1 ) {
            
        }
    }
    
}