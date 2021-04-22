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
        lives = 2;
    }
  
    public static Lives getInstance()
    {
        if (Objects.isNull(livesInstance))
            livesInstance = new Lives();
  
        return livesInstance;
    }
    
    public int reduceLives()
    {
        return --lives;
    }
    
    public void resetLives()
    {
        lives = 2;
    }
}
