
    import greenfoot.*;

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.2
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }
    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
         if (atWorldEdge())
        {
            turn(160);
        }
        if (atWater())
        {
            turn(160);
        }
        if (carryingTomato()) 
        {
            
            if (atShip()) {
                dropTomato();
            }
            else {
                move();
                turnHome();
                if (atWater())
                {
                    turn(-2);
                }
                move();
            }
        }
        else {
            
            checkFood();
        }
        if (isTouching(TomatoPile.class))
        {
            spit("red)");
            
        }
        else
        {
            move();
            //turnTowards(dq.getX(), dq.getY()));
            
            
        }
    }
    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            loadTomato();
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
        }
        else
        {
          
        }
    }

    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Zachary";  // write your name here!
    }

    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if (carryingTomato()) {
            return "greep-with-food.png";
        }
        else {
            return "greep.png";
        }
    }
}