import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VoortgangBalk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VoortgangBalk extends MenuObjecten
{
    /**
     * Act - do whatever the VoortgangBalk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int voortgang = 0;
    private GreenfootImage image1 = new GreenfootImage("images/VoortgangLeeg.png");
    private GreenfootImage image2 = new GreenfootImage("images/Voortgang30.png");
    private GreenfootImage image3 = new GreenfootImage("images/VoortGang60.png");
    private GreenfootImage image4 = new GreenfootImage("images/VoortGang90.png");
    private static boolean VrachtOverslaanGeslaagd = false;
    private static boolean ControleCentrumGeslaagd = false;
    private static boolean LoodsenEndlessRunnerGeslaagd = false;
    
    public VoortgangBalk(){
        
        if(VrachtOverslaanGeslaagd == true){
            voortgang += 33;
        }
        
        if(ControleCentrumGeslaagd == true){
            voortgang += 33;
        }
        
        if(LoodsenEndlessRunnerGeslaagd == true){
            voortgang += 34;
        }
        
        
        
        if(voortgang == 0){
            setImage(image1);
        }
        else if(voortgang == 33 ||voortgang == 34){
            setImage(image2);
        }
        else if(voortgang == 66 ||voortgang == 67){
            setImage(image3);
        }
        else if(voortgang == 100){
            setImage(image4);
            getWorld().addObject(new Win(), 421,187);
        }
    }
    
    public static  void setVoortgang(int game){
        if(game == 1){
            VrachtOverslaanGeslaagd = true;
        }
        else if(game == 2){
            ControleCentrumGeslaagd = true;
        }
        else if(game == 3){
            LoodsenEndlessRunnerGeslaagd = true;
        }
    }
}
