import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * Settings class using singleton pattern.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class Settings  
{
    private static Settings settingsInstance = null;
    private static final String DEFAULT_CAR = "Car_1_01";
    private String selectedCar;
    private Map<String, Boolean> carsAvailable;
    
    private Settings() 
    {
        this.carsAvailable = new HashMap();
        this.selectedCar = DEFAULT_CAR;
        this.updateCarAvailability();
    }
  
    public static Settings getInstance()
    {
        if (Objects.isNull(settingsInstance))
            settingsInstance = new Settings();
  
        return settingsInstance;
    }
    
    public void updateCarAvailability()
    {
        this.carsAvailable.put("Car_1_01", true); // first car (basic red) always available
        this.carsAvailable.put("Car_2_01", Score.getInstance().getMaxScoreForLevel("level2") >= 70 ? true : false); // second car (yellow) available only if player scored 70 or more in the 2nd level
        this.carsAvailable.put("Car_3_01", Score.getInstance().getMaxScoreForLevel("level3") >= 80 ? true : false); // third car (police) available only if player scored 80 or more in the 3rd level
    }
    
    public Map<String, Boolean> getCarAvailability()
    {
        return this.carsAvailable;
    }
    
    public String getSelectedCar()
    {
        return this.selectedCar.replace("_selected", "") + ".png";
    }
    
    public void setSelectedCar(String sc)
    {
        this.selectedCar = sc;
    }
}
