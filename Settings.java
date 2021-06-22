import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * Class that holds the game's data about settings.
 * It is created using the Singleton Pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Settings  
{
    private static Settings settingsInstance = null;
    private String selectedCar;
    private Map<String, Boolean> carsAvailable;
    
    private static final String DEFAULT_CAR = "Car_1_01";
    
    /**
     * Constructor for object of class Settings.
     * Cannot be called outside the instance.
     */
    private Settings() 
    {
        this.carsAvailable = new HashMap();
        this.selectedCar = DEFAULT_CAR;
        this.updateCarAvailability();
    }
    
    /**
     * Returns the (only) instance of class Settings.
     * 
     * @return  the instance of class Settings
     */
    public static Settings getInstance()
    {
        if (Objects.isNull(settingsInstance))
            settingsInstance = new Settings();
  
        return settingsInstance;
    }
    
    /**
     * Updates car availability according to the scores.
     */
    public void updateCarAvailability()
    {
        this.carsAvailable.put("Car_1_01", true); // first car (basic red) always available
        this.carsAvailable.put("Car_2_01", Score.getInstance().getMaxScoreForLevel("cumulative") >= 10 ? true : false); // second car (yellow) available only if player scored 70 or more in the 2nd level
        this.carsAvailable.put("Car_3_01", Score.getInstance().getMaxScoreForLevel("cumulative") >= 20 ? true : false); // third car (police) available only if player scored 80 or more in the 3rd level
    }
    
    /**
     * Returns a Map containing all the available cars.
     * 
     * @return  the available cars
     */
    public Map<String, Boolean> getCarAvailability()
    {
        return this.carsAvailable;
    }
    
    /**
     * Returns a String with the selected car.
     * 
     * @return  a string representation of the selected car's image. 
     */
    public String getSelectedCar()
    {
        return this.selectedCar.replace("_selected", "") + ".png";
    }
    
    /**
     * Sets the selected car.
     * 
     * @param  a string representation of the selected car's image. 
     */
    public void setSelectedCar(String sc)
    {
        this.selectedCar = sc;
    }
}
