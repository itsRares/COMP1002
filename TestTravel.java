 /***************************************************************************
 *  FILE: TestTravel.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Unit test for Travel
 *  LAST MOD: 19/10/17
 ***************************************************************************/
 
import java.util.*;
 
public class TestTravel
{
    public static void main(String args[])
    {
        String from, to, type, peak;
        double kms, time;
        Travel l;
        
        System.out.println("    Testing Normal");
        System.out.println("-----------------------");
        
        try
        {
            System.out.println("Testing: Creating Travel");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            System.out.println("Passed\n");
            
            System.out.println("Testing: Setters/Getters");
            
            System.out.println("------Getters------");
            System.out.println("> getFrom()");
            from = l.getFrom();
            if (!from.equals("Perth Airport"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getTo()");
            to = l.getTo();
            if (!to.equals("Darwin Airport"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getType()");
            type = l.getType();
            if (!type.equals("car"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getPeak()");
            peak = l.getPeak();
            if (!peak.equals("PEEK=1.8"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getKms()");
            kms = l.getKms();
            if (kms != 50)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> getTime()");
            time = l.getTime();
            if (time != 1.2)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
        
            System.out.println("------Setters------");
            System.out.println("> setFrom()");
            l.setFrom("London Airport");
            from = l.getFrom();
            if (!from.equals("London Airport"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setTo()");
            l.setTo("Melbourne Airport");
            to = l.getTo();
            if (!to.equals("Melbourne Airport"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setType()");
            l.setType("Plane");
            type = l.getType();
            if (!type.equals("Plane"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setPeak()");
            l.setPeak("PEEK=10.8");
            peak = l.getPeak();
            if (!peak.equals("PEEK=10.8"))
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setKms()");
            l.setKms(1000);
            kms = l.getKms();
            if (kms != 1000.0)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            System.out.println("> setTime()");
            l.setTime(10.1);
            time = l.getTime();
            if (time != 10.1)
            {
                throw new IllegalArgumentException("Error");
            }
            System.out.println("Passed\n");
            
            
        } catch(Exception e) {System.out.println("Failed");}
        
        
        
        
        
        System.out.println("    Testing Error");
        System.out.println("-----------------------");
        
        try
        {
            System.out.println("Testing: Creating Travel");
            l = new Travel("Perth Airport", null, "car", 50, 1.2, "PEEK=1.8");
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        System.out.println("Testing: Setters");
            
        System.out.println("------Setters------");
        try{
            System.out.println("> setFrom()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setFrom(null);
            System.out.println("failed\n");            
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setTo()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setTo(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setType()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setType(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setPeak()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setPeak(null);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setKms()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setKms(0);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
        
        try{
            System.out.println("> setTime()");
            l = new Travel("Perth Airport", "Darwin Airport", "car", 50, 1.2, "PEEK=1.8");
            l.setTime(0);
            System.out.println("failed\n");
        } catch(Exception e) {System.out.println("Passed\n");}
    }
}