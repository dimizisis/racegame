import java.util.Objects;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
 * Class that holds the game's data about statistics.
 * It is created using the Singleton Pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
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
    
    /**
     * Returns the (only) instance of class Statistics.
     * 
     * @return  the instance of class Statistics
     */
    public static Statistics getInstance()
    {
        if (Objects.isNull(statsInstance))
            statsInstance = new Statistics();
        return statsInstance;
    }
    
    /**
     * Resets all statistics' variables to zero (0.0).
     * Triggered when the 'Reset' button is clicked.
     */
    public void resetAll()
    {
        stats.put("Total Violations", 0.0);
        stats.put("Crossing Violations", 0.0);
        stats.put("Speed Violations", 0.0);
        stats.put("Collisions", 0.0);
        flushStatsToFile();
    }
    
    /**
     * Returns the integer representation of total violations count.
     * 
     * @return  the integer representation of total violations count
     */
    public int getTotalViolationsCount()
    {
        double countD = this.stats.get("Total Violations");
        return (int) countD;
    }
    
    /**
     * Increments the crossing violations count.
     */
    public void incrementCrossingViolations()
    {
        Double incrementedVal = stats.get("Crossing Violations");
        ++incrementedVal;
        stats.put("Crossing Violations", incrementedVal);
        incrementTotalViolations();
    }
    
    /**
     * Increments the collisions count.
     */
    public void incrementCollisions()
    {
        Double incrementedVal = stats.get("Collisions");
        ++incrementedVal;
        stats.put("Collisions", incrementedVal);
        incrementTotalViolations();
    }
    
    /**
     * Increments the speed violations count.
     */
    public void incrementSpeedViolations()
    {
        Double incrementedVal = stats.get("Speed Violations");
        ++incrementedVal;
        stats.put("Speed Violations", incrementedVal);
        incrementTotalViolations();
    }
    
    /**
     * Increments the total violations count.
     */
    private void incrementTotalViolations()
    {
        Double incrementedVal = stats.get("Total Violations");
        ++incrementedVal;
        stats.put("Total Violations", incrementedVal);
    }
    
    /**
     * Returns statistics' headers as a string array.
     * 
     * @return  the statistics' headers as a string array.
     */
    public String[] getStatsHeadersAsArray()
    {
        return stats.keySet().toArray(String[]::new);
    }
    
    /**
     * Returns statistics' values as a doubles array.
     * 
     * @return  the statistics' values as a doubles array.
     */
    public double[] getStatsValuesAsArray()
    {
        List<Double> valuesLst = new ArrayList<>(stats.values());
        double[] values = new double[valuesLst.size()];
        for (int i=0; i<values.length; ++i)
            values[i] = valuesLst.get(i);
        return values;
    }
    
    /**
     * Assigns saved statistics values from file to instance's Map object.
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
     * Saves statistics to stat's file.
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
