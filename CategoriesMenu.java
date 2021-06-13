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
    public CategoriesMenu(int score)
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        Button crossingsBtn = new Button("crossings_btn_" + Language.getInstance().getCurrLanguage());
        addObject(crossingsBtn, 310, 280);
        
        Button roundAboutsBtn = new Button("roundabouts_btn_" + Language.getInstance().getCurrLanguage());
        addObject(roundAboutsBtn, 310, 390);
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getCurrLanguage());
=======
=======
>>>>>>> Stashed changes
        Button crossingsBtn = new Button("crossings_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(crossingsBtn, 310, 280);
        
        Button roundAboutsBtn = new Button("speed_limits_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(roundAboutsBtn, 310, 390);
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        addObject(backBtn, 310, 500);
        
        Button infoBtn = new Button("info");
        addObject(infoBtn, 120, 650);
        
        Button soundBtn = new Button("sound");
        addObject(soundBtn, 485, 650);
        
        Button settingsBtn = new Button("settings");
        addObject(settingsBtn, 300, 650);
        
        try {
            Score.getInstance().getScoresFromFile();
        } catch (Exception e) {}
        
    }
}
