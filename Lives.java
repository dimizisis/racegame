import java.util.Objects;
/**
 * Write a description of class Lives here.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class Lives  
{
    private static Lives livesInstance = null;
    private int lives;
    
    private Lives() 
    {
        this.lives = 4;
    }
  
    public static Lives getInstance()
    {
        if (Objects.isNull(livesInstance))
            livesInstance = new Lives();
  
        return livesInstance;
    }
    
    public int getLivesCount()
    {
        return this.lives;
    }
    
    public int reduceLives()
    {
        --this.lives;
        return this.lives;
    }
    
    public void resetLives()
    {
        this.lives = 4;
    }
}
