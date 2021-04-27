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
        
        Button levelTwoBtn = new Button("level2");
        addObject(levelTwoBtn, 300, 400);
        
        Button levelThreeBtn = new Button("level3");
        addObject(levelThreeBtn, 300, 510);
        
        Button infoBtn = new Button("info");
        addObject(infoBtn, 225, 650);
        
        Button soundBtn = new Button("sound");
        addObject(soundBtn, 385, 650);
        
        try {
            Score.getInstance().getScoresFromFile();
        } catch (Exception e) {}
        
        //Button buttonUpgrade = new Button("Upgrade");
        //addObject(buttonUpgrade,40,60);
        //buttonUpgrade.getImage().scale(60, 40);
        
        // gets progress from file
        // if no progress starts new
        /* Progress progress = getProgressFromFile();
        if(progress==null){
            addObject(new Score(0), 50, 20);
            this.progress.setArrowDamage(50);
            this.progress.setArrowSpeed(11);
            this.progress.setTotalMoney(0);
            saveProgressToFile();
        } 
        // if there is previus progress 
        else{
            addObject(new Score(progress.getTotalMoney()), 50, 20);
                this.progress.setTotalMoney(progress.getTotalMoney());
                this.progress.setArrowDamage(progress.getArrowDamage());
                this.progress.setArrowSpeed(progress.getArrowSpeed());
                saveProgressToFile();
        } */
    }
}
