import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that holds the game's data about available lives.
 * It is created using the Singleton Pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Lives  
{
    private static Lives livesInstance = null;
    private AtomicInteger lives;
    
    private static int TOTAL_LIVES_AVAILABLE = 4;
    
    /**
     * Constructor for object of class Lives.
     * Cannot be called outside the instance.
     */
    private Lives()
    {
        this.lives = new AtomicInteger(TOTAL_LIVES_AVAILABLE);
    }
    
    /**
     * Returns the (only) instance of class Lives.
     * 
     * @return  the instance of class Lives
     */
    public static Lives getInstance()
    {
        if (Objects.isNull(livesInstance))
            livesInstance = new Lives();
        return livesInstance;
    }
    
    /**
     * Returns the current count of lives available.
     * 
     * @return  the current count of lives available
     */
    public int getLivesCount()
    {
        return this.lives.getAcquire();
    }
    
    /**
     * Reduces the current count of lives available.
     * 
     * @return  the current count of lives available (after reduction)
     */
    public int reduceLives()
    {
        return this.lives.getAndDecrement();
    }
    
    /**
     * Resets the number of lives (4).
     * Triggers when the player ends a level (successfully or not)
     */
    public void resetLives()
    {
        this.lives.set(TOTAL_LIVES_AVAILABLE);
    }
}
