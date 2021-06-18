import greenfoot.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
 * Write a description of class InformationWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InformationWindow extends World
{

    /**
     * Constructor for objects of class InformationWindow.
     * 
     */
    public InformationWindow(String type)
    {
        super(600, 840, 1);
        setBackground(new GreenfootImage("info_menu_" + Language.getInstance().getSelectedLanguage() + ".png"));
        ExplanatoryGIF explanatoryGIF = new ExplanatoryGIF(type);
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        try
        {
            GreenfootImage image = new GreenfootImage(500, 600);
            image.setColor(new Color(255, 255, 255, 128));
            Font font = image.getFont();
            font = font.deriveFont(13.0f);
            image.setFont(font);
            image.setColor(Color.WHITE);
            image.drawString(Files.readString(Paths.get("./text/" + type + "_info_" + Language.getInstance().getSelectedLanguage() + ".txt")), 10, 10);
            getBackground().drawImage(image, 80, 400);
        } catch (IOException e) {}
        addObject(backBtn, 310, 650);
        addObject(explanatoryGIF, 310, 290);
    }
}
