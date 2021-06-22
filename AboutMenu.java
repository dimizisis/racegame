import greenfoot.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
 * Class that represents the about screen
 * of the game.
 * 
 * @author Dimitrios Zisis 
 * @version 1.0
 */
public class AboutMenu extends World
{

    /**
     * Constructor for objects of class AboutMenu.
     */
    public AboutMenu()
    {    
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
            GreenfootImage image = new GreenfootImage(500, 600);
            image.setColor(new Color(255, 255, 255, 128));
            Font font = image.getFont();
            font = font.deriveFont(14.0f);
            image.setFont(font);
            image.setColor(Color.WHITE);
            image.drawString(Files.readString(Paths.get("./text/gameinfo_" + Language.getInstance().getSelectedLanguage() + ".txt")), 10, 10);
            getBackground().drawImage(image, 100, 220);
        } catch (IOException e) {}
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);
    }
}
