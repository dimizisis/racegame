import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatisticsMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatisticsMenu extends World
{
    
    /**
     * Constructor for objects of class StatisticsMenu.
     * 
     */
    public StatisticsMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 840, 1);
        setBackground(new GreenfootImage("statistics_menu_" + Language.getInstance().getSelectedLanguage() + ".png"));
        showText(Language.getInstance().getSelectedLanguage().equals("en") ? "Violation Statistics" : "Στατιστικά Παραβάσεων", 305, 220);
        getBackground().drawImage(ChartCreator.getChartCreator().createBarChart(Statistics.getInstance().getTotalViolationsCount()+10, Statistics.getInstance().getStatsValuesAsArray(), 
            new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.BLACK, Color.CYAN}, 
            Statistics.getInstance().getStatsHeadersAsArray(), true, 300, 150, Color.WHITE, Color.BLACK, Color.BLACK, 5), 130, 250);
            
        Button backBtn = new Button("back_btn_" + Language.getInstance().getSelectedLanguage());
        addObject(backBtn, 310, 650);
    }
}
