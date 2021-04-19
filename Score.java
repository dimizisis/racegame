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
    private final static int ADDING_POINTS = 10;
    
    private Score() 
    {
        levelScores = getScoresFromFile();
        if (Objects.isNull(levelScores))
        {
            levelScores = new HashMap<>();
            levelScores.put("level1", 0);
            levelScores.put("level2", 0);
            levelScores.put("level3", 0);
        }
    }
  
    public static Score getInstance()
    {
        if (Objects.isNull(scoreInstance))
            scoreInstance = new Score();
  
        return scoreInstance;
    }
    
    public int getScore(String level)
    {
        return levelScores.get(level);
    }
    
    public void incrementLevelScore(String level)
    {
        levelScores.put(level, levelScores.get(level) + ADDING_POINTS);
        flushScoreToFile(levelScores);
    }
    
    /**
     * Get saved scores from file.
     */
    public Map<String, Integer> getScoresFromFile() {
        FileInputStream fi;
        try {
            fi = new FileInputStream(new File("scores.dat"));

            ObjectInputStream oi = new ObjectInputStream(fi);
            Map<String, Integer> levelScores = (HashMap<String, Integer>) oi.readObject();
            return levelScores;
        }  catch (IOException | ClassNotFoundException ex) {
            System.out.println("getScoresFromFile()");
        }
        return null;
    }
    
    /**
     * Save scores to file.
     */
    public void flushScoreToFile(Map<?, ?> levelScores){
        try {
            FileOutputStream f = new FileOutputStream(new File("scores.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(levelScores);
            o.close();
            f.close();
        } catch (IOException ex) {
            System.out.println("flushScoreToFile()");
        }
    }
}
