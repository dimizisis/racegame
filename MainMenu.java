
import greenfoot.*;
import java.io.*;
import java.util.List;

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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        Button categoriesBtn = new Button("categories_btn_" + Language.getInstance().getCurrLanguage());
        addObject(categoriesBtn, 310, 280);

        Button statsBtn = new Button("stats_btn_" + Language.getInstance().getCurrLanguage());
        addObject(statsBtn, 310, 390);

        Button exitBtn = new Button("exit_btn_" + Language.getInstance().getCurrLanguage());
=======
=======
>>>>>>> Stashed changes
        Button categoriesBtn = new Button("categories_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(categoriesBtn, 310, 280);

        Button statsBtn = new Button("stats_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(statsBtn, 310, 390);

        Button exitBtn = new Button("exit_btn_" + Language.getInstance().getSelectedLanguage());
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        addObject(exitBtn, 310, 500);

        Button infoBtn = new Button("info");
        addObject(infoBtn, 120, 650);

        Button soundBtn = new Button("sound");
        addObject(soundBtn, 485, 650);

        Button settingsBtn = new Button("settings");
        addObject(settingsBtn, 300, 650);
<<<<<<< Updated upstream
=======
        
        LanguageSelector greekFlag = new LanguageSelector("gr_flag");
        addObject(greekFlag, 210, 770);
        
<<<<<<< Updated upstream
=======
        LanguageSelector greekFlag = new LanguageSelector("gr_flag");
        addObject(greekFlag, 210, 770);
        
>>>>>>> Stashed changes
        LanguageSelector enFlag = new LanguageSelector("en_flag");
        addObject(enFlag, 390, 770);
        
        selectLastSelectedLang();
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

        try {
            Score.getInstance().getScoresFromFile();
        } catch (Exception e) {}

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
    }
    
    private void selectLastSelectedLang()
    {
        for (LanguageSelector ls : (List<LanguageSelector>)(getObjects(LanguageSelector.class)))
            if (ls.getLangImage().startsWith(Language.getInstance().getSelectedLanguage()))
                ls.select();
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }
}
