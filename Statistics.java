import java.util.Objects;
/**
 * Write a description of class Statistics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Statistics  
{
    private static Statistics statsInstance = null;
    private Integer crossingMistakes;
    private Integer totalMistakes;

    /**
     * Constructor for objects of class Statistics
     */
    private Statistics()
    {
        crossingMistakes = 0;
        totalMistakes = 0;
    }
    
    public static Statistics getInstance()
    {
        if (Objects.isNull(statsInstance))
            statsInstance = new Statistics();
            
        return statsInstance;
    }
    
    public Integer getCrossingMistakes()
    {
        return crossingMistakes;
    }
    
    public Integer getTotalMistakes()
    {
        return totalMistakes;
    }

}
