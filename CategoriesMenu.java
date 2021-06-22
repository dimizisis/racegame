import greenfoot.*;
import java.io.*;

/**
 * Class that represents the information window
 * of the game. Player can be informed on how to
 * play and behave in general.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class CategoriesMenu extends World
{
    
    /**
     * Constructor for objects of class CategoriesMenu.
     */
    public CategoriesMenu()
    {    
        super(600, 840, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setBackground("menu.png");
        /* Adds buttons */
        Button crossingsBtn = new Button("crossings_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(crossingsBtn, 250, 250);

        Button crossingsInfoBtn = new Button("information_crossings_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(crossingsInfoBtn, 450, 250);

        Button speedLimitsBtn = new Button("speed_limits_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(speedLimitsBtn, 250, 340);

        Button speedLimitsInfoBtn = new Button("information_speed_limits_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(speedLimitsInfoBtn, 450, 340);
        
        Button stopSignBtn = new Button("stop_sign_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(stopSignBtn, 250, 430);
        
        Button stopSignInfoBtn = new Button("information_stop_sign_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(stopSignInfoBtn, 450, 430);
        
        Button cumulativeBtn = new Button("cumulative_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(cumulativeBtn, 310, 520);

        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);

        try {
            Score.getInstance().getScoresFromFile();
        } catch (Exception e) {}

    }
}
