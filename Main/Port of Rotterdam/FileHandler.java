import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class FileHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileHandler
{
        private static String tekst;
        private static String returnTekst;
        static File yourFile = new File("yourFileName.txt");
        public static void writeHighscore(){
            try{
            yourFile.delete();
            yourFile.createNewFile();
            
            FileWriter fileWriter =
            new FileWriter(yourFile);
                
            BufferedWriter writer =
            new BufferedWriter(fileWriter);
            writer.write(tekst,0,tekst.length());
            writer.close();
        }
        
        catch(IOException ex) {
           ex.printStackTrace();
        }
        }
        
        public static void setTekst(String input){
            tekst = input;
        }
        
        public static void readHighscore(){
          try {
            
            FileReader fileReader = 
                new FileReader(yourFile);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            while(line!= null) {
                returnTekst = line;
            }	

            
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                yourFile + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + yourFile + "'");					
            
        }
        }
        
        public static String readTekst(){
            return returnTekst;
        }
    
}
