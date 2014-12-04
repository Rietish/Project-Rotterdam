import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loodsboot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loodsboot extends LoodsenEndlessRunnerObjecten
{
    /**
     * Act - do whatever the Loodsboot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double currentX;
    double currentY;
    double vaarSnelheid = 0.2;
    static boolean  boost = false;
    int boostteller = 0;
    private static boolean kwetsbaar = true;
    int immuneteller = 0;
    public Loodsboot(double x, double y)
    {
        currentX = x;
        currentY = y;
    }
    
    public void act() 
    {
        sturen();
        setLocation((int)currentX, (int)currentY);
        
        if(boost == true){
            boost();
        }
        else{
            vaarSnelheid = 0.2;
        }
        if(kwetsbaar == false){
            immune();
        }
    }    
    
   private void sturen(){
        if(Greenfoot.isKeyDown("down") && getY() < 35){
            currentY += vaarSnelheid;
        }
        else if(Greenfoot.isKeyDown("up") && getY() > 6){
            currentY -= vaarSnelheid;
        }
        else if(Greenfoot.isKeyDown("left") && getX() > 13){
            currentX -= vaarSnelheid* 0.5;
        }
        else if(Greenfoot.isKeyDown("right") && getX() < 45){
            currentX += vaarSnelheid* 0.5;
        }
    }
    
    public static void setSpeedboost(boolean sneller){
        boost = sneller;
    }
    
    public void boost(){
        setImage("images/Speedboot.png");
        boostteller++;
        vaarSnelheid = 0.4;
        Vrachtschip.setVaarSnelheid(0.2);
        if(boostteller == 300){
            boost = false;
            setImage("images/sleepboot_loodsen.png");
            Vrachtschip.setVaarSnelheid(0.1);
            boostteller = 0;
        }
    }
    
    public void immune(){
        setImage("images/sleepboot_loodsen_armored.png");
        immuneteller++;
        Vrachtschip.setKwetsbaar(false);
        if(immuneteller == 300){
            kwetsbaar = true;
            setImage("images/sleepboot_loodsen.png");
            Vrachtschip.setKwetsbaar(true);
            immuneteller = 0;
        }
        
    }
    
    public static void setKwetsbaar(boolean statement){
        kwetsbaar = statement;
    }
    
    public static boolean getKwetsbaar(){
        return kwetsbaar;
    }


}
        

    

