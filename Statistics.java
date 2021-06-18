import java.util.Objects;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;
/**
 * Write a description of class Statistics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Statistics  
{
    private static Statistics statsInstance = null;
    private Map<String, Double> stats;
    
    /**
     * Constructor for objects of class Statistics
     */
    private Statistics()
    {
        getStatsFromFile();
        if (Objects.isNull(stats))
        {
            stats = new ConcurrentHashMap<>();
            stats.put("Total Violations", 0.0);
            stats.put("Crossing Violations", 0.0);
            stats.put("Speed Violations", 0.0);
            stats.put("Collisions", 0.0);
        }
    }
    
    public static Statistics getInstance()
    {
        if (Objects.isNull(statsInstance))
            statsInstance = new Statistics();
            
        return statsInstance;
    }
    
    public int getTotalViolationsCount()
    {
        double countD = this.stats.get("Total Violations");
        return (int) countD;
    }
    
    public void incrementCrossingViolations()
    {
        Double incrementedVal = stats.get("Crossing Violations");
        ++incrementedVal;
        stats.put("Crossing Violations", incrementedVal);
        incrementTotalMistakes();
    }
    
    public void incrementCollisions()
    {
        Double incrementedVal = stats.get("Collisions");
        ++incrementedVal;
        stats.put("Collisions", incrementedVal);
        incrementTotalMistakes();
    }
    
    public void incrementSpeedViolations()
    {
        Double incrementedVal = stats.get("Speed Violations");
        ++incrementedVal;
        stats.put("Speed Violations", incrementedVal);
        incrementTotalMistakes();
    }
    
    private void incrementTotalMistakes()
    {
        Double incrementedVal = stats.get("Total Violations");
        ++incrementedVal;
        stats.put("Total Violations", incrementedVal);
    }
    
    public String[] getStatsHeadersAsArray()
    {
        return stats.keySet().toArray(String[]::new);
    }
    
    public double[] getStatsValuesAsArray()
    {
        List<Double> valuesLst = new ArrayList<>(stats.values());
        double[] values = new double[valuesLst.size()];
        for (int i=0; i<values.length; ++i)
            values[i] = valuesLst.get(i);
        return values;
    }
    
    /**
     * Get saved scores from file.
     */
    public void getStatsFromFile() 
    {
        FileInputStream fi;
        try {
            fi = new FileInputStream(new File("./savedata/stats.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            this.stats = (ConcurrentHashMap<String, Double>) oi.readObject();
        }  catch (IOException | ClassNotFoundException ex) {
        }
    }
    
    /**
     * Save scores to file.
     */
    public void flushStatsToFile()
    {
        try {
            FileOutputStream f = new FileOutputStream(new File("./savedata/stats.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(stats);
            o.close();
            f.close();
        } catch (IOException ex) {
        }
    }

}
