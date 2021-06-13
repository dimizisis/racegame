import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

/**
 * Score class using singleton pattern.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class Score  
{
    private static Score scoreInstance = null;
    private Map<String, Integer> levelScores = null;
    private Map<String, Integer> maxLevelScores = null;
    private final static int ADDING_POINTS = 5;
    
    private Score() 
    {
        getScoresFromFile();
        if (Objects.isNull(levelScores))
        {
            levelScores = new HashMap<>();
            levelScores.put("crossings", 100);
            levelScores.put("speed_limits", 100);
            //levelScores.put("level3", 100);
        }
        if (Objects.isNull(maxLevelScores))
        {
            maxLevelScores = new HashMap<>();
            maxLevelScores.put("crossings", 0);
            maxLevelScores.put("speed_limits", 0);
           //maxLevelScores.put("level3", 0);
        }
    }
  
    public static Score getInstance()
    {
        if (Objects.isNull(scoreInstance))
            scoreInstance = new Score();
  
        return scoreInstance;
    }
    
    public int getMaxScoreForLevel(String level)
    {
        return Objects.isNull(this.maxLevelScores.get(level)) ? 0 : this.maxLevelScores.get(level);
    }
    
    public int getScore(String level)
    {
        return levelScores.get(level);
    }
    
    public void resetScore(String level)
    {
        levelScores.put(level, 100);
    }
    
    public void increaseLevelScore(String level)
    {
        this.levelScores.put(level, levelScores.get(level) + ADDING_POINTS);
    }
    
    public void reduceLevelScore(String level)
    {   
        this.levelScores.put(level, levelScores.get(level) - ADDING_POINTS);
    }
    
    /**
     * Get saved scores from file.
     */
    public void getScoresFromFile() 
    {
        FileInputStream fi;
        try {
            fi = new FileInputStream(new File("scores.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            this.maxLevelScores = (HashMap<String, Integer>) oi.readObject();
        }  catch (IOException | ClassNotFoundException ex) {
        }
    }
    
    /**
     * Save scores to file.
     */
    public void flushScoreToFile(String level) 
    {
        try
        {
            if (this.maxLevelScores.get(level) > this.levelScores.get(level))
                return;
        } catch (NullPointerException e)
        {
            return;
        }
        this.maxLevelScores.put(level, this.levelScores.get(level));
        try {
            FileOutputStream f = new FileOutputStream(new File("scores.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(maxLevelScores);
            o.close();
            f.close();
        } catch (IOException ex) {
        }
    }
}
