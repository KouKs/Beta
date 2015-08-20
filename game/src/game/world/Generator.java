/*
 * Copyright 2015 Michael Bausano & Pavel Koch
 * This is a beta version of some random game
 */
package game.world;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pavel
 */
public class Generator
{
    
    
    public Generator()
    {
        
    }
    
    public Map<String,Integer> getDefaultRoom( )
    {
        int sizeX = 8 + (int)(Math.random() * ((17 - 8) + 1));
        int sizeY = 8 + (int)(Math.random() * ((17 - 8) + 1));
        
        Map<String,Integer> room = new HashMap<>();
        
        Map<String,Boolean> doors = new HashMap<>();
        doors.put( sizeX/2 + ":" + (sizeY-1) , true);
        doors.put( sizeX-1 + ":" + sizeY/2 , true);
        
        for( int y = 0 ; y < sizeY ; y++ )
        {
            
            for( int x = 0 ; x < sizeX ; x++)
            {
                if( doors.containsKey( x + ":" + y ) == true ) {
                    room.put( x + ":" + y , 0 );
                } else if( x == 0 || y == 0 || x == sizeX - 1 || y == sizeY - 1 )
                    room.put( x + ":" + y , 1 );
                else
                    room.put( x + ":" + y , 0 );
            }
        }
        
        room.put("sizeY", sizeY);
        room.put("sizeX", sizeX);
        
        return room;
    }
}
