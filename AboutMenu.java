import greenfoot.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutMenu extends World
{
    
    /**
     * Constructor for objects of class UI.
     */
    public AboutMenu()
    {    
        // Create a new world with 600x840 cells with a cell size of 1x1 pixels.
        super(600, 840, 1);
        setBackground("about_" + Language.getInstance().getSelectedLanguage() + ".png");
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        try 
        {
            showText(Files.readString(Paths.get("./text/gameinfo_" + Language.getInstance().getSelectedLanguage() + ".txt"), StandardCharsets.UTF_8), 310, 385);
        } catch (IOException e)
        {
        }
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);
    }
}
