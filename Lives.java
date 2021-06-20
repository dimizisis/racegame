import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Write a description of class Lives here.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class Lives  
{
    private static Lives livesInstance = null;
    private AtomicInteger lives;
    
    private Lives() 
    {
        this.lives = new AtomicInteger(4);
    }
  
    public static Lives getInstance()
    {
        if (Objects.isNull(livesInstance))
            livesInstance = new Lives();
  
        return livesInstance;
    }
    
    public int getLivesCount()
    {
        return this.lives.getAcquire();
    }
    
    public int reduceLives()
    {
        return this.lives.getAndDecrement();
    }
    
    public void resetLives()
    {
        this.lives.set(4);
    }
}
