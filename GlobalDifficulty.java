import java.util.Objects;
/**
 * Write a description of class GlobalDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GlobalDifficulty  
{

    private static GlobalDifficulty difficultyInstance = null;
    private String difficulty = "easy"; // default

    /**
     * Constructor for objects of class GlobalDifficulty
     */
    private GlobalDifficulty()
    {
        
    }
    
    public static GlobalDifficulty getInstance()
    {
        if (Objects.isNull(difficultyInstance))
            difficultyInstance = new GlobalDifficulty();
            
        return difficultyInstance;
    }
    
    public String getDifficulty()
    {
        return this.difficulty;
    }
    
    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }
}
