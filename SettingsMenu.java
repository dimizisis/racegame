import greenfoot.*;
import java.util.Map;
import java.util.List;

/**
 * Class that represents the settings menu
 * of the game. Player can choose his/her
 * car, if available.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class SettingsMenu extends World
{

    /**
     * Constructor for objects of class SettingsUI.
     * 
     */
    public SettingsMenu()
    {    
        super(600, 840, 1);
        setBackground("settings_ui_" + Language.getInstance().getSelectedLanguage() + ".png");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int y = 330;
        for (Map.Entry<String, Boolean> entry : Settings.getInstance().getCarAvailability().entrySet())
        {
            String carName = entry.getKey() + (entry.getValue() ? "" : "_disabled");
            CarSelector car = new CarSelector(carName);
            addObject(car, 315, y);
            y += 100;
        }
        Button okBtn = new Button("ok");
        addObject(okBtn, 315, 650);
        
        selectLastSelected();
        
    }
    
    /**
    * Selects the last selected car by the user.
    * Triggers every time the user opens settings menu.
    */
    private void selectLastSelected()
    {
        for (CarSelector cs : (List<CarSelector>)(getObjects(CarSelector.class)))
            if (Settings.getInstance().getSelectedCar().contains(cs.getCarImage().replace("_selected", "")))
                cs.select();
    }
}
