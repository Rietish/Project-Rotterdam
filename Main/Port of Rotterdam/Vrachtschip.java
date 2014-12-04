import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vrachtschip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vrachtschip extends LoodsenEndlessRunnerObjecten
{
    /**
     * Act - do whatever the Vrachtschip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double currentX;
    double currentY;
    private static double vaarSnelheid = 0.1;
    private static boolean kwetsbaar = true;
    public Vrachtschip(double x, double y)
    {
        currentX = x;
        currentY = y;
    }
    
    public void act() 
    {
        beweegRichtingSleepboot();
        setLocation((int)currentX, (int)currentY);
    }    
    
    public void beweegRichtingSleepboot()
    {
        Loodsboot sleepboot = (Loodsboot) getWorld().getObjects(Loodsboot.class).get(0);
        int yRichting = (int) Math.signum(sleepboot.getY() - this.getY());
        int xRichting = (int) Math.signum(sleepboot.getX() - (this.getX()+8));
        
        currentY += yRichting * vaarSnelheid;
        currentX += xRichting * vaarSnelheid;
    } 
    
    public static void setVaarSnelheid(double snelheid){
        vaarSnelheid = snelheid;
    }
    
    public static void setKwetsbaar(boolean statement){
        kwetsbaar = statement;
    }
    
    public static boolean getKwetsbaar(){
        return kwetsbaar;
    }
    
    
}
