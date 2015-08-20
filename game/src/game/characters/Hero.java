/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.characters;

/**
 *
 * @author Michal
 */
public class Hero extends Entity {

    public Hero(int id) {
        super(id);
        this.images.put( "walkNorth" , this.getImage( "walk_back" ) );
        this.images.put( "walkSouth" , this.getImage( "walk_front" ) );
        this.images.put( "walkWest" , this.getImage( "walk_side" ) );
        this.images.put( "walkEast" , this.getImage( "walk_side" ) );
        this.images.put( "standNorth" , this.getImage( "stand_back" ) );
        this.images.put( "standSouth" , this.getImage( "stand_front" ) );
        this.images.put( "standWest" , this.getImage( "stand_side" ) );
        this.images.put( "standEast" , this.getImage( "stand_side" ) );
    }
    
}
