import java.util.Objects;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;

/**
 * Class that holds the game's data about scores.
 * It is created using the Singleton Pattern.
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
    
    /**
     * Constructor for object of class Score.
     * Cannot be called outside the instance.
     */
    private Score() 
    {
        getScoresFromFile();
        if (Objects.isNull(levelScores))
        {
            levelScores = new ConcurrentHashMap<>();
            levelScores.put("crossings", 0);
            levelScores.put("speed_limits", 20);
            levelScores.put("stop_sign", 0);
            levelScores.put("cumulative", 0);
        }
        if (Objects.isNull(maxLevelScores))
        {
            maxLevelScores = new ConcurrentHashMap<>();
            maxLevelScores.put("crossings", 0);
            maxLevelScores.put("speed_limits", 0);
            maxLevelScores.put("stop_sign", 0);
            maxLevelScores.put("cumulative", 0);
        }
    }
    
    /**
     * Returns the (only) instance of class Score.
     * 
     * @return  the instance of class Score
     */
    public static Score getInstance()
    {
        if (Objects.isNull(scoreInstance))
            scoreInstance = new Score();
        return scoreInstance;
    }
    
    /**
     * Returns the maximum score, given a specific level.
     * 
     * @param  the string representation of level's name
     * @return  the integer representation of the level's maximum score.
     */
    public int getMaxScoreForLevel(String level)
    {
        return Objects.isNull(this.maxLevelScores.get(level)) ? 0 : this.maxLevelScores.get(level);
    }
    
    /**
     * Returns the current score, given a specific level.
     * 
     * @param  the string representation of level's name
     * @return  the integer representation of the level's score.
     */
    public int getScore(String level)
    {
        return levelScores.get(level);
    }
    
    /**
     * Sets the score, given a specific level.
     * 
     * @param  the string representation of level's name
     */
    public void setScore(String level)
    {
        levelScores.put(level, 20);
    }
    
    /**
     * Resets the score, given a specific level.
     * 
     * @param  the string representation of level's name
     */
    public void resetScore(String level)
    {
        levelScores.put(level, 0);
    }
    
    /**
     * Increases the score, given a specific level.
     * 
     * @param  the string representation of level's name
     */
    public void increaseLevelScore(String level)
    {
        this.levelScores.put(level, levelScores.get(level) + ADDING_POINTS);
    }
    
    /**
     * Reduces the score, given a specific level.
     * 
     * @param  the string representation of level's name
     */
    public void reduceLevelScore(String level)
    {   
        this.levelScores.put(level, levelScores.get(level) - ADDING_POINTS);
    }
    
    /**
     * Assigns saved (maximum) scores from file to instance's Map object.
     */
    public void getScoresFromFile() 
    {
        FileInputStream fi;
        try {
            fi = new FileInputStream(new File("./savedata/scores.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            this.maxLevelScores = (ConcurrentHashMap<String, Integer>) oi.readObject();
        }  catch (IOException | ClassNotFoundException ex) {
        }
    }
    
    /**
     * Saves (maximum) scores to score's file.
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
            FileOutputStream f = new FileOutputStream(new File("./savedata/scores.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(maxLevelScores);
            o.close();
            f.close();
        } catch (IOException ex) {
        }
    }
}
