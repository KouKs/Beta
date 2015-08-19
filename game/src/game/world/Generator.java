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
        Map<String,Integer> room = new HashMap<>();
        
        for( int y = 0 ; y < 10 ; y++ )
        {
            
            for( int x = 0 ; x < 10 ; x++)
            {
                if( x == 0 || y == 0 || x == 9 || y == 9 )
                    room.put( x + ":" + y , 0 );
                else
                    room.put( x + ":" + y , 1 );
            }
        }
        return room;
    }
}
