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
    
    private int imgWidth;
    private int imgHeight;
    private int txtWidth;
    private int txtHeight;
    private float fontSize;
    
    public InformationWindow(String type, int imgWidth, int imgHeight, int txtWidth, int txtHeight, float fontSize)
    {
        super(600, 840, 1);
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.txtWidth = txtWidth;
        this.txtHeight = txtHeight;
        this.fontSize = fontSize;
        
        setBackground(new GreenfootImage("info_menu_" + Language.getInstance().getSelectedLanguage() + ".png"));
        ExplanatoryGIF explanatoryGIF = new ExplanatoryGIF(type);
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        try
        {
            GreenfootImage image = new GreenfootImage(500, 600);
            image.setColor(new Color(255, 255, 255, 128));
            Font font = image.getFont();
            font = font.deriveFont(fontSize);
            image.setFont(font);
            image.setColor(Color.WHITE);
            image.drawString(Files.readString(Paths.get("./text/" + type + "_info_" + Language.getInstance().getSelectedLanguage() + ".txt")), 10, 10);
            getBackground().drawImage(image, txtWidth, txtHeight);
        } catch (IOException e) {}
        addObject(backBtn, 310, 650);
        addObject(explanatoryGIF, imgWidth, imgHeight);
    }
}
