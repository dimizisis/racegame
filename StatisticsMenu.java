import greenfoot.*;

/**
 * Class that represents the statistics window
 * of the game. Player can be informed on his
 * progress.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class StatisticsMenu extends World
{
    
    /**
     * Constructor for objects of class StatisticsMenu.
     * 
     */
    public StatisticsMenu()
    {    
        super(600, 840, 1);
        setBackground(new GreenfootImage("statistics_menu_" + Language.getInstance().getSelectedLanguage() + ".png"));
        showText(Language.getInstance().getSelectedLanguage().equals("en") ? "Violation Statistics" : "Στατιστικά Παραβάσεων", 305, 210);
        getBackground().drawImage(ChartCreator.getChartCreator().createBarChart(Statistics.getInstance().getTotalViolationsCount()+10, Statistics.getInstance().getStatsValuesAsArray(), 
            new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.BLACK, Color.CYAN}, 
            Statistics.getInstance().getStatsHeadersAsArray(), true, 250, 150, Color.WHITE, Color.BLACK, Color.BLACK, 5), 160, 230);
        
        Button resetBtn = new Button("reset_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(resetBtn, 315, 550);    
        
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);
    }
}
