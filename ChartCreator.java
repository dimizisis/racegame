import greenfoot.*;

import java.awt.Point;

/**
 * Write a description of class Charts here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChartCreator extends Actor
{
    private static ChartCreator chartCreator = new ChartCreator();
    
    public static ChartCreator getChartCreator() {
        return chartCreator;
    }
    
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors) {
        return createPieChart(radius, percentValues, colors, new String[0], false, Color.WHITE, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the legend.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend) {
        return createPieChart(radius, percentValues, colors, legend, true, Color.WHITE, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the legend.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend, Color backgroundColor) {
        return createPieChart(radius, percentValues, colors, legend, true, backgroundColor, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the legend.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend, Color backgroundColor, Color textColor) {
        return createPieChart(radius, percentValues, colors, legend, true, backgroundColor, textColor, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the legend.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend, boolean displayValues, Color backgroundColor) {
        return createPieChart(radius, percentValues, colors, legend, displayValues, backgroundColor, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the legend.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend, boolean displayValues, Color backgroundColor, Color textColor) {
        return createPieChart(radius, percentValues, colors, legend, displayValues, backgroundColor, textColor, Color.BLACK, 5);
    }
    /**
     * Create a pie chart with the given values for the radius, the percentValues, the colors...
     * 
     * @param radius
     *      The radius of the pie chart that is created.
     * 
     * @param percentValues
     *      The values for each part of the pie chart as percent values.
     * 
     * @param colors
     *      The colors for each part of the pie chart.
     * 
     * @param legend
     *      The names of each field for the chart.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @param frameColor
     *      The color of the frame (if there is one).
     * 
     * @param frameWidth
     *      The width of the frame (0 = no frame).
     * 
     * @return
     *      Returns a GreenfootImage with a pie chart calculated by the given values.
     */
    public GreenfootImage createPieChart(int radius, double[] percentValues, Color[] colors, String[] legend, boolean displayValues, Color backgroundColor, Color textColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage legendImg;
        GreenfootImage legendField = new GreenfootImage(10, 10);
        GreenfootImage[] pieParts = new GreenfootImage[percentValues.length];
        Color removingColor;
        Color transparency = new Color(0, 0, 0, 0);
        double startingDegrees = -90.0;
        double[] degreeValues = new double[percentValues.length];
        int[] polygonX;
        int[] polygonY;
        double[] temp;
        String legendText = "";
        for (int i = 0; i < legend.length; i++) {
            legendText += legend[i] + (displayValues ? ": " + round(percentValues[i], 2) + "%" : "");
            legendText += "\n";
        }
        legendImg = new GreenfootImage(legendText, 20, textColor, transparency);
        img = new GreenfootImage((radius*2 > (legendImg.getWidth() + 30) ? radius*2 : (legendImg.getWidth() + 30)) + frameWidth*2 + 30, radius*2 + legendImg.getHeight() + frameWidth*2 + 50);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth*2), img.getHeight() - (frameWidth*2));
        img.drawImage(legendImg, frameWidth + 30, frameWidth + radius*2 + 40);
        for (int i = 0; i < legend.length; i++) {
            legendField.setColor(colors[i]);
            legendField.fill();
            img.drawImage(legendField, frameWidth + 10, frameWidth + radius*2 + 45 + 20*i);
        }
        for (int i = 0; i < degreeValues.length; i++) {
            degreeValues[i] = percentValues[i]*3.6;
        }
        for (int i = 0; i < pieParts.length; i++) {
            pieParts[i] = new GreenfootImage(radius*2, radius*2);
            polygonX = new int[4];
            polygonY = new int[4];
            pieParts[i].setColor(colors[i]);
            pieParts[i].fillOval(0, 0, radius*2, radius*2);
            removingColor = (Color.BLACK.equals(colors[i]) ? Color.WHITE : Color.BLACK);
            pieParts[i].setColor(removingColor);
            if (degreeValues[i] <= 180) {
                temp = move(radius, radius, startingDegrees, radius*2);
                polygonX[0] = (int) temp[0];
                polygonY[0] = (int) temp[1];
                temp = move(temp[0], temp[1], startingDegrees - 90, radius*2);
                polygonX[1] = (int) temp[0];
                polygonY[1] = (int) temp[1];
                temp = move(radius, radius, startingDegrees + 180, radius*2);
                polygonX[3] = (int) temp[0];
                polygonY[3] = (int) temp[1];
                temp = move(temp[0], temp[1], startingDegrees - 90, radius*2);
                polygonX[2] = (int) temp[0];
                polygonY[2] = (int) temp[1];
                pieParts[i].fillPolygon(polygonX, polygonY, 4);
                startingDegrees += degreeValues[i];
                temp = move(radius, radius, startingDegrees, radius*2);
                polygonX[0] = (int) temp[0];
                polygonY[0] = (int) temp[1];
                temp = move(temp[0], temp[1], startingDegrees + 90, radius*2);
                polygonX[1] = (int) temp[0];
                polygonY[1] = (int) temp[1];
                temp = move(radius, radius, startingDegrees + 180, radius*2);
                polygonX[3] = (int) temp[0];
                polygonY[3] = (int) temp[1];
                temp = move(temp[0], temp[1], startingDegrees + 90, radius*2);
                polygonX[2] = (int) temp[0];
                polygonY[2] = (int) temp[1];
                pieParts[i].fillPolygon(polygonX, polygonY, 4);
            }
            else {
                polygonX[0] = radius;
                polygonY[0] = radius;
                temp = move(radius, radius, startingDegrees, radius*2);
                polygonX[1] = (int) temp[0];
                polygonY[1] = (int) temp[1];
                temp = move(radius, radius, startingDegrees + degreeValues[i], radius*2);
                polygonX[3] = (int) temp[0];
                polygonY[3] = (int) temp[1];
                temp = calculateCrossingPointByAngle(new Point(polygonX[1], polygonY[1]), new Point(polygonX[3], polygonY[3]), startingDegrees - 90, startingDegrees + degreeValues[i] + 90);
                polygonX[2] = (int) temp[0];
                polygonY[2] = (int) temp[1];
                pieParts[i].fillPolygon(polygonX, polygonY, 4);
                startingDegrees += degreeValues[i];
            }
            for (int x = 0; x < radius*2; x++) {
                for (int y = 0; y < radius*2; y++) {
                    if (pieParts[i].getColorAt(x, y).equals(removingColor)) {
                        pieParts[i].setColorAt(x, y, transparency);
                    }
                }
            }
        }
        for (GreenfootImage piePart : pieParts) {
            img.drawImage(piePart, frameWidth + 15, frameWidth + 15);
        }
        return img;
    }
    
    /**
     * The position of an Actor that is moved the given distance into the given direction.
     * 
     * @param currentX
     *      The current x coordinate of the actor.
     * 
     * @param currentY
     *      The current y coordinate of the actor.
     * 
     * @param angle
     *      The angle to which the actor should be moved.
     * 
     * @param distance
     *      The distance the actor should be moved.
     * 
     * @return 
     *      Returns the new coordinates of the actor as a double array.
     */
    public double[] move(double currentX, double currentY, double angle, double distance) {
        double[] coordinates = new double[2];
        angle = Math.toRadians(angle);
        coordinates[0] = currentX + Math.cos(angle) * distance;
        coordinates[1] = currentY + Math.sin(angle) * distance;
        return coordinates;
    }
    
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, int width, int height) {
        return createBarChart(maxValue, absoluteValues, colors, legend, true, width, height, Color.WHITE, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, int width, int height, Color textColor) {
        return createBarChart(maxValue, absoluteValues, colors, legend, true, width, height, Color.WHITE, textColor, Color.BLACK, 5);
    }
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, boolean displayValues, int width, int height) {
        return createBarChart(maxValue, absoluteValues, colors, legend, displayValues, width, height, Color.WHITE, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, boolean displayValues, int width, int height, Color backgroundColor) {
        return createBarChart(maxValue, absoluteValues, colors, legend, displayValues, width, height, backgroundColor, Color.BLACK, Color.BLACK, 5);
    }
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, boolean displayValues, int width, int height, Color backgroundColor, Color textColor) {
        return createBarChart(maxValue, absoluteValues, colors, legend, displayValues, width, height, backgroundColor, textColor, Color.BLACK, 5);
    }
    /**
     * Creates a bar chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the bar chart can reach.
     * 
     * @param absoluteValues
     *      The values for each bar of the bar chart as absolute values.
     * 
     * @param colors
     *      The colors for each bar of the bar chart.
     * 
     * @param legend
     *      The names of each bar for the chart.
     * 
     * @param displayValues
     *      You can choose whether the values should be displayed or not.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param textColor
     *      The text color of the legend.
     * 
     * @param frameColor
     *      The color of the frame (if there is one).
     * 
     * @param frameWidth
     *      The width of the frame (0 = no frame).
     * 
     * @return
     *      Returns a GreenfootImage with a bar chart calculated by the given values.
     */
    public GreenfootImage createBarChart(double maxValue, double[] absoluteValues, Color[] colors, String[] legend, boolean displayValues, int width, int height, Color backgroundColor, Color textColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage barChart;
        GreenfootImage legendImg;
        GreenfootImage legendField = new GreenfootImage(10, 10);
        String legendText = "";
        double[] barHeight = new double[absoluteValues.length];
        double barWidth = ((double) width) / absoluteValues.length;
        for (int i = 0; i < legend.length; i++) {
            legendText += legend[i] + (displayValues ? ": " + round(absoluteValues[i], 2) : "");
            legendText += "\n";
        }
        for (int i = 0; i < absoluteValues.length; i++) {
            barHeight[i] = (height / maxValue) * absoluteValues[i];
        }
        legendImg = new GreenfootImage(legendText, 20, (backgroundColor.equals(Color.BLACK) ? Color.WHITE : Color.BLACK), new Color(0, 0, 0, 0));
        barChart = new GreenfootImage(width + 27, height + 20);
        barChart.setColor(Color.BLACK);
        barChart.fillRect(25, 10, width + 2, height + 2);
        barChart.setColor(Color.LIGHT_GRAY);
        barChart.fillRect(27, 10, width, height);
        for (int i = 0; i < 5; i++) {
            barChart.setColor(Color.BLACK);
            barChart.drawLine(25, height - height/4 * i + 10, width + 27, height - height/4 * i + 10);
            barChart.drawImage(new GreenfootImage(Integer.toString((int) Math.round(maxValue/4 * i)), 18, Color.BLACK, new Color(0, 0, 0, 0)), 0, height - height/4 * i + 3);
        }
        for (int i = 0; i < absoluteValues.length; i++) {
            barChart.setColor(colors[i]);
            barChart.fillRect((int) (27 + (barWidth * i)), (int) (height - barHeight[i]) + 10, (int) barWidth, (int) barHeight[i]);
        }
        img = new GreenfootImage((width > (legendImg.getWidth() + 30) ? width : (legendImg.getWidth() + 30)) + frameWidth*2 + 50, height + frameWidth*2 + legendImg.getHeight() + 50);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth*2), img.getHeight() - (frameWidth*2));
        img.drawImage(legendImg, frameWidth + 30, frameWidth + height + 45);
        for (int i = 0; i < legend.length; i++) {
            legendField.setColor(colors[i]);
            legendField.fill();
            img.drawImage(legendField, frameWidth + 10, frameWidth + height + 50 + 20*i);
        }
        img.drawImage(barChart, frameWidth + 10, frameWidth + 15);
        return img;
    }
    
    /**
     * Creates a line chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the line chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point of the line chart as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @return
     *      Returns a GreenfootImage with a line chart calculated by the given values.
     */
    public GreenfootImage createLineChart(double maxValue, Point[] absoluteValues, int width, int height) {
        return createLineChart(maxValue, absoluteValues, width, height, Color.WHITE, Color.BLACK, Color.BLACK, 0);
    }
    /**
     * Creates a line chart with the given values for the max height, absolute values, colors, ...
     * 
     * @param maxValue
     *      The maximum value that the line chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point of the line chart as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param lineColor
     *      The color of the line.
     * 
     * @return
     *      Returns a GreenfootImage with a line chart calculated by the given values.
     */
    public GreenfootImage createLineChart(double maxValue, Point[] absoluteValues, int width, int height, Color lineColor) {
        return createLineChart(maxValue, absoluteValues, width, height, Color.WHITE, lineColor, Color.BLACK, 0);
    }
    /**
     * Creates a line chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the line chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point of the line chart as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param lineColor
     *      The color of the line.
     * 
     * @return
     *      Returns a GreenfootImage with a line chart calculated by the given values.
     */
    public GreenfootImage createLineChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color lineColor) {
        return createLineChart(maxValue, absoluteValues, width, height, backgroundColor, lineColor, Color.BLACK, 0);
    }
    /**
     * Creates a line chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the line chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point of the line chart as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param lineColor
     *      The color of the line.
     * 
     * @param frameColor
     *      The color of the frame (if there is one).
     * 
     * @param frameWidth
     *      The width of the frame (0 = no frame).
     * 
     * @return
     *      Returns a GreenfootImage with a line chart calculated by the given values.
     */
    public GreenfootImage createLineChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color lineColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage lineChart;
        double maxValueX = absoluteValues[absoluteValues.length-1].getX() + 0.1 * absoluteValues[absoluteValues.length-1].getX();
        lineChart = new GreenfootImage(width + 40, height + 35);
        lineChart.setColor(Color.BLACK);
        lineChart.fillRect(25, 10, width + 2, height + 2);
        lineChart.setColor(Color.LIGHT_GRAY);
        lineChart.fillRect(27, 10, width, height);
        for (int i = 0; i < 5; i++) {
            lineChart.setColor(Color.BLACK);
            lineChart.drawLine(25, height - height/4 * i + 10, width + 27, height - height/4 * i + 10);
            lineChart.drawImage(new GreenfootImage(Integer.toString((int) Math.round(maxValue/4 * i)), 18, Color.BLACK, new Color(0, 0, 0, 0)), 0, height - height/4 * i + 3);
            lineChart.drawLine(26 + width/4 * i, 10, 26 + width/4 * i, height + 10);
            lineChart.drawImage(new GreenfootImage((Integer.toString((int) Math.round(maxValueX/4 * i))), 18, Color.BLACK, new Color(0, 0, 0, 0)), width/4 * i + 15, height + 15);
        }
        img = new GreenfootImage(width + 70 + frameWidth*2, height + 55 + frameWidth*2);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth*2), img.getHeight() - (frameWidth*2));
        lineChart.setColor(lineColor);
        for (int i = 0; i < absoluteValues.length-1; i++) {
            lineChart.drawLine((int) (absoluteValues[i].getX() * (width / maxValueX) + 27), (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i].getY())), 
                (int) (absoluteValues[i+1].getX() * (width / maxValueX) + 27), (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i+1].getY())));
        }
        img.drawImage(lineChart, frameWidth + 20, frameWidth + 10);
        return img;
    }
    
    /**
     * Creates a point chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @return
     *      Returns a GreenfootImage with a point chart calculated by the given values.
     */
    public GreenfootImage createPointChart(double maxValue, Point[] absoluteValues, int width, int height) {
        return createPointChart(maxValue, absoluteValues, width, height, Color.WHITE, Color.BLACK, Color.BLACK, 0);
    }
    /**
     * Creates a point chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param pointColor
     *      The color of the points.
     * 
     * @return
     *      Returns a GreenfootImage with a point chart calculated by the given values.
     */
    public GreenfootImage createPointChart(double maxValue, Point[] absoluteValues, int width, int height, Color pointColor) {
        return createPointChart(maxValue, absoluteValues, width, height, Color.WHITE, pointColor, Color.BLACK, 0);
    }
    /**
     * Creates a point chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param pointColor
     *      The color of the points.
     * 
     * @return
     *      Returns a GreenfootImage with a point chart calculated by the given values.
     */
    public GreenfootImage createPointChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color pointColor) {
        return createPointChart(maxValue, absoluteValues, width, height, backgroundColor, pointColor, Color.BLACK, 0);
    }
    /**
     * Creates a point chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param pointColor
     *      The color of the points.
     * 
     * @param frameColor
     *      The color of the frame (if there is one).
     * 
     * @param frameWidth
     *      The width of the frame (0 = no frame).
     * 
     * @return
     *      Returns a GreenfootImage with a point chart calculated by the given values.
     */
    public GreenfootImage createPointChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color pointColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage pointChart;
        double maxValueX = absoluteValues[absoluteValues.length-1].getX() + 0.1 * absoluteValues[absoluteValues.length-1].getX();
        pointChart = new GreenfootImage(width + 40, height + 35);
        pointChart.setColor(Color.BLACK);
        pointChart.fillRect(25, 10, width + 2, height + 2);
        pointChart.setColor(Color.LIGHT_GRAY);
        pointChart.fillRect(27, 10, width, height);
        for (int i = 0; i < 5; i++) {
            pointChart.setColor(Color.BLACK);
            pointChart.drawLine(25, height - height/4 * i + 10, width + 27, height - height/4 * i + 10);
            pointChart.drawImage(new GreenfootImage(Integer.toString((int) Math.round(maxValue/4 * i)), 18, Color.BLACK, new Color(0, 0, 0, 0)), 0, height - height/4 * i + 3);
            pointChart.drawLine(26 + width/4 * i, 10, 26 + width/4 * i, height + 10);
            pointChart.drawImage(new GreenfootImage((Integer.toString((int) Math.round(maxValueX/4 * i))), 18, Color.BLACK, new Color(0, 0, 0, 0)), width/4 * i + 15, height + 15);
        }
        img = new GreenfootImage(width + 70 + frameWidth*2, height + 55 + frameWidth*2);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth*2), img.getHeight() - (frameWidth*2));
        pointChart.setColor(pointColor);
        for (int i = 0; i < absoluteValues.length; i++) {
            pointChart.fillOval((int) (absoluteValues[i].getX() * (width / maxValueX) + 27) - 2, (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i].getY())) - 2, 5, 5);
        }
        img.drawImage(pointChart, frameWidth + 20, frameWidth + 10);
        return img;
    }
    
    /**
     * Creates a surface chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @return
     *      Returns a GreenfootImage with a surface chart calculated by the given values.
     */
    public GreenfootImage createSurfaceChart(double maxValue, Point[] absoluteValues, int width, int height) {
        return createSurfaceChart(maxValue, absoluteValues, width, height, Color.WHITE, Color.BLACK, Color.BLACK, 0);
    }
    /**
     * Creates a surface chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param surfaceColor
     *      The color of the surface.
     * 
     * @return
     *      Returns a GreenfootImage with a surface chart calculated by the given values.
     */
    public GreenfootImage createSurfaceChart(double maxValue, Point[] absoluteValues, int width, int height, Color surfaceColor) {
        return createSurfaceChart(maxValue, absoluteValues, width, height, Color.WHITE, surfaceColor, Color.BLACK, 0);
    }
    /**
     * Creates a surface chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param surfaceColor
     *      The color of the surface.
     * 
     * @return
     *      Returns a GreenfootImage with a surface chart calculated by the given values.
     */
    public GreenfootImage createSurfaceChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color surfaceColor) {
        return createSurfaceChart(maxValue, absoluteValues, width, height, backgroundColor, surfaceColor, Color.BLACK, 0);
    }
    /**
     * Creates a surface chart with the given values for the max height, absolute values, ...
     * 
     * @param maxValue
     *      The maximum value that the point chart can reach.
     * 
     * @param absoluteValues
     *      The values for each point as absolute values.
     * 
     * @param width
     *      The width of the chart itselves. This value is not the width of the whole image.
     * 
     * @param height
     *      The height of the chart itselves. This value is not the height of the whole image.
     * 
     * @param backgroundColor
     *      The background color of the whole chart.
     * 
     * @param surfaceColor
     *      The color of the surface.
     * 
     * @param frameColor
     *      The color of the frame (if there is one).
     * 
     * @param frameWidth
     *      The width of the frame (0 = no frame).
     * 
     * @return
     *      Returns a GreenfootImage with a surface chart calculated by the given values.
     */
    public GreenfootImage createSurfaceChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color surfaceColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage surfaceChart;
        double maxValueX = absoluteValues[absoluteValues.length-1].getX() + 0.1 * absoluteValues[absoluteValues.length-1].getX();
        int[] valuesX = new int[absoluteValues.length + 2];
        int[] valuesY = new int[absoluteValues.length + 2];
        surfaceChart = new GreenfootImage(width + 40, height + 35);
        surfaceChart.setColor(Color.BLACK);
        surfaceChart.fillRect(25, 10, width + 2, height + 2);
        surfaceChart.setColor(Color.LIGHT_GRAY);
        surfaceChart.fillRect(27, 10, width, height);
        for (int i = 0; i < 5; i++) {
            surfaceChart.setColor(Color.BLACK);
            surfaceChart.drawLine(25, height - height/4 * i + 10, width + 27, height - height/4 * i + 10);
            surfaceChart.drawImage(new GreenfootImage(Integer.toString((int) Math.round(maxValue/4 * i)), 18, Color.BLACK, new Color(0, 0, 0, 0)), 0, height - height/4 * i + 3);
            surfaceChart.drawLine(26 + width/4 * i, 10, 26 + width/4 * i, height + 10);
            surfaceChart.drawImage(new GreenfootImage((Integer.toString((int) Math.round(maxValueX/4 * i))), 18, Color.BLACK, new Color(0, 0, 0, 0)), width/4 * i + 15, height + 15);
        }
        img = new GreenfootImage(width + 70 + frameWidth*2, height + 55 + frameWidth*2);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth*2), img.getHeight() - (frameWidth*2));
        surfaceChart.setColor(surfaceColor);
        for (int i = 0; i < absoluteValues.length; i++) {
            surfaceChart.fillOval((int) (absoluteValues[i].getX() * (width / maxValueX) + 27) - 2, (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i].getY())) - 2, 5, 5);
            valuesX[i] = (int) (absoluteValues[i].getX() * (width / maxValueX) + 27);
            valuesY[i] = (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i].getY()));
        }
        valuesX[valuesX.length-2] = (int) (absoluteValues[absoluteValues.length-1].getX() * (width / maxValueX) + 27);
        valuesY[valuesX.length-2] = (int) (height + frameWidth + 5);
        valuesX[valuesX.length-1] = (int) (absoluteValues[0].getX() * (width / maxValueX) + 27);
        valuesY[valuesX.length-1] = (int) (height + frameWidth + 5);
        surfaceChart.setColor(surfaceColor);
        surfaceChart.fillPolygon(valuesX, valuesY, valuesX.length);
        img.drawImage(surfaceChart, frameWidth + 20, frameWidth + 10);
        return img;
    }
    
    /**
     * Round a double value to a variable number of decimal plases.
     * 
     * @param value
     *      The double value that should be rounded.
     * 
     * @param decimalPlaces
     *      The number of decimal places you want to round the double value to.
     * 
     * @return
     *      The double value roundet to the given number of decimal places.
     */
    public double round(double value, int decimalPlaces) {
        return (((double) Math.round(value * Math.pow(10, decimalPlaces))) / Math.pow(10, decimalPlaces));
    }
    
    /**
     * Calculates the crossing point of two lines that are calculated by a point of each line and the angle of each line.
     * 
     * @param p1
     *      Any point of the first line.
     * 
     * @param p2
     *      Any point of the second line.
     * 
     * @param angle1
     *      The angle of the first line in degrees (0 => vertical line, 90 => horizontal line).
     * 
     * @param angle2
     *      The angle of the second line in degrees (0 => vertical line, 90 => horizontal line).
     * 
     * @return
     *      The coordinates of the crossing point of the two lines as a double array.
     */
    public double[] calculateCrossingPointByAngle(Point p1, Point p2, double angle1, double angle2) {
        double[] crossingPoint = new double[2];
        double[] coordinatesP2 = {p2.getX() - p1.getX(), p2.getY() - p1.getY()};
        double slope1 = (angle1 == 90 ? Math.pow(10, 10) : (angle1 == 270 ? -Math.pow(10, 10) : Math.tan(Math.toRadians(angle1))));
        double slope2 = (angle2 == 90 ? Math.pow(10, 10) : (angle2 == 270 ? -Math.pow(10, 10) : Math.tan(Math.toRadians(angle2))));
        double yAxisSectionP2 = coordinatesP2[1] - (coordinatesP2[0] * slope2);
        crossingPoint[0] = yAxisSectionP2 / (slope1 - slope2);
        crossingPoint[1] = slope1 * crossingPoint[0];
        return crossingPoint;
    }
    /**
     * Calculates the crossing point of two lines that are calculated by a point of each line and the slope of each line.
     * 
     * @param p1
     *      Any point of the first line.
     * 
     * @param p2
     *      Any point of the second line.
     * 
     * @param angle1
     *      The slope of the first line.
     * 
     * @param angle2
     *      The slope of the second line.
     * 
     * @return
     *      The coordinates of the crossing point of the two lines as a double array.
     */
    public double[] calculateCrossingPointBySlope(Point p1, Point p2, double slope1, double slope2) {
        double[] crossingPoint = new double[2];
        double[] coordinatesP2 = {p2.getX() - p1.getX(), p2.getY() - p1.getY()};
        double yAxisSectionP2 = coordinatesP2[1] - (coordinatesP2[0] * slope2);
        crossingPoint[0] = yAxisSectionP2 / (slope1 - slope2);
        crossingPoint[1] = slope1 * crossingPoint[0];
        return crossingPoint;
    }
}