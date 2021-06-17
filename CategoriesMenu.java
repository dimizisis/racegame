import greenfoot.*;
import java.io.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CategoriesMenu extends World
{
    
    /**
     * Constructor for objects of class UI.
     */
    public CategoriesMenu()
    {    
        // Create a new world with 600x840 cells with a cell size of 1x1 pixels.
        super(600, 840, 1);
        setBackground("menu.png");
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        /* Adds buttons */
        Button crossingsBtn = new Button("crossings_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(crossingsBtn, 250, 280);
        
        Button crossingsInfoBtn = new Button("information_crossings_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(crossingsInfoBtn, 450, 280);
        
        Button speedLimitsBtn = new Button("speed_limits_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(speedLimitsBtn, 250, 390);
        
        Button speedLimitsInfoBtn = new Button("information_speed_limits_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(speedLimitsInfoBtn, 450, 390);
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);
        
        try {
            Score.getInstance().getScoresFromFile();
        } catch (Exception e) {}
        
    }
}
