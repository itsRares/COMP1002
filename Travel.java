 /***************************************************************************
 *  FILE: Travel.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Creates the travel object to hold values
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

public class Travel
{

    /*----------Classfields----------*/
    private String from, to, type, peak;
    private double kms, time, impairment;

    /*----------Classfields----------*/
    /*******************************************
 *  *SUBMODULE Travel
 *  *IMPORT: inFrom (String), inTo (String), inType (String), inKms (double), inTime (double), inPeak (String)
 *  *EXPORT: -
 *  *ASSERTION: Creates a Travel object with the values provided
 *  ******************************************/
    public Travel(String inFrom, String inTo, String inType, double inKms, double inTime, String inPeak)
    {
        if (validateKms(inKms) && validateTime(inTime))
        {
            from = new String(inFrom);
            to = new String(inTo);
            type = new String(inType);   
            peak = new String(inPeak);
            kms = inKms;
            time = inTime;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid Import Values");        //Throw error if invalid
        }
    }

    /*----------Accessors----------*/
    public String getFrom()
    {
        return new String(from);
    }
    
    public String getTo()
    {
        return new String(to);
    }
    
    public String getType()
    {
        return new String(type);
    }
    
    public String getPeak()
    {
        return new String(peak);
    }

    public double getKms()
    {
        return kms;
    }
    
    public double getTime()
    {
        return time;
    }
    
    public double getImpairment()
    {
        return impairment;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE setFrom
 *  *IMPORT: inFrom (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets from to inFrom
 *  ******************************************/
    public void setFrom(String inFrom)
    {
        if (inFrom != null)                                          //if not null then from equals inFrom
        {
          from = inFrom;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid from");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setTo
 *  *IMPORT: inTo (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets to to inTo
 *  ******************************************/
    public void setTo(String inTo)
    {
        if (inTo != null)                                          //if not null then to equals inTo
        {
          to = inTo;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid to");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setType
 *  *IMPORT: inType (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets type to inType
 *  ******************************************/
    public void setType(String inType)
    {
        if (inType != null)                                          //if not null then type equals inType
        {
          type = inType;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid type");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setPeak
 *  *IMPORT: inPeak (String)
 *  *EXPORT: none
 *  *ASSERTION: If not null sets peak to inPeak
 *  ******************************************/
    public void setPeak(String inPeak)
    {
        if (inPeak != null)                                          //if not null then peak equals inPeak
        {
          peak = inPeak;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid peak");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setKms
 *  *IMPORT: inKms (double)
 *  *EXPORT: none
 *  *ASSERTION: If valid sets kms to inKms
 *  ******************************************/
    public void setKms(double inKms)
    {
        if ((validateKms(inKms)))                                   //Validate position then set kms equal inKms
        {
          kms = inKms;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid kms");        //Throw error if invalid
        }
    }
    
    /*******************************************
 *  *SUBMODULE setTime
 *  *IMPORT: inTime (double)
 *  *EXPORT: none
 *  *ASSERTION: If valid sets time to inTime
 *  ******************************************/
    public void setTime(double inTime)
    {
        if ((validateTime(inTime)))                                  //Validate position then set time equal inTime
        {
          time = inTime;
        }
        else 
        {
          throw new IllegalArgumentException("Invalid time");        //Throw error if invalid
        }
    }
    
    /*----------Validation----------*/
    /*******************************************
 *  *SUBMODULE validateKms
 *  *IMPORT: inKms (double)
 *  *EXPORT: boolean
 *  *ASSERTION: Validates that inKms is above 0
 *  ******************************************/
    public boolean validateKms(double inKms)
    {
        return (inKms > 0.0);                                           //Check if above 0.0
    }
    
    /*******************************************
 *  *SUBMODULE validateTime
 *  *IMPORT: inTime (double)
 *  *EXPORT: boolean
 *  *ASSERTION: Validates that inTime is above 0
 *  ******************************************/
    public boolean validateTime(double inTime)
    {
        return (inTime > 0.0);                                          //Check if above 0.0
    }

}
