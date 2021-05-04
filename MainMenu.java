import greenfoot.*;
import java.io.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    
    /**
     * Constructor for objects of class UI.
     */
    public MainMenu()
    {    
        // Create a new world with 600x840 cells with a cell size of 1x1 pixels.
        super(600, 840, 1);
        setBackground("menu.png");

        prepare();
    }
    public MainMenu(int score)
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
        Button levelOneBtn = new Button("level1");
        addObject(levelOneBtn, 300, 290);
        
        Button levelTwoBtn = new Button("level2" + (Score.getInstance().getMaxScoreForLevel("level1") >= 70 ? "" : "-disabled"));
        addObject(levelTwoBtn, 300, 400);
        
        Button levelThreeBtn = new Button("level3" + (Score.getInstance().getMaxScoreForLevel("level2") >= 70 ? "" : "-disabled"));
        addObject(levelThreeBtn, 300, 510);
        
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
