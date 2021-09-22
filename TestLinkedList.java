 /***************************************************************************
 *  FILE: TestLinkedList.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Unit test for linked list
 *  LAST MOD: 19/10/17
 ***************************************************************************/
 
import java.util.*;
 
public class TestLinkedList
{
    public static void main(String args[])
    {
        DSALinkedList l = null;
        
        //Create constructor
        try
        {
            System.out.println("Test: Constructor");
            l = new DSALinkedList();
            if (!l.isEmpty())
            {
                throw new IllegalArgumentException("No values must be in Linked List");
            }
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed");}
        
        //Queue
        System.out.println("------Testing Queue------");
        //Insert Last
        try
        {
            System.out.println("Test: insertLast()");
            l.insertLast("Train");
            l.insertLast("Car");
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed");}
        
        //Peek Last
        try
        {
            System.out.println("Test: peekFirst()");
            String peekFirst = (String)l.peekFirst();
            if (!peekFirst.equals("Train"))
            {
                throw new IllegalArgumentException("Error not correct");
            }
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed\n");}
        
        //Remove Last
        try
        {
            String remove;
            System.out.println("Test: removeFirst()");
            remove = (String)l.removeFirst();
            if (!remove.equals("Train"))
            {
                throw new IllegalArgumentException("Error not correct1");
            }
            remove = (String)l.removeFirst();
            if (!remove.equals("Car"))
            {
                throw new IllegalArgumentException("Error not correct2");
            }
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed\n");}
        
        //Is empty
        try
        {
            System.out.println("Test: isEmpty()");
            String remove = (String)l.removeLast();
            System.out.println("Failed");
        } catch(Exception e) {System.out.println("passed");}
        
        //Stack
        System.out.println("------Testing Stack------");
        //Insert first
        try
        {
            System.out.println("Test: insertFirst()");
            l.insertFirst("Train");
            l.insertFirst("Car");
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed");}
        
        //Peek Last
        try
        {
            System.out.println("Test: peekLast()");
            String peekLast = (String)l.peekLast();
            if (!peekLast.equals("Train"))
            {
                throw new IllegalArgumentException("Error not correct");
            }
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed");}
        
        //Remove first
        try
        {
            String remove;
            System.out.println("Test: removeFirst()");
            remove = (String)l.removeFirst();
            if (!remove.equals("Car"))
            {
                throw new IllegalArgumentException("Error not correct1");
            }
            remove = (String)l.removeFirst();
            if (!remove.equals("Train"))
            {
                throw new IllegalArgumentException("Error not correct2");
            }
            System.out.println("Passed\n");
        } catch(Exception e) {System.out.println("Failed" + e.getMessage());}
        
        //Is empty
        try
        {
            System.out.println("Test: isEmpty()");
            String remove = (String)l.removeFirst();
            System.out.println("Failed");
        } catch(Exception e) {System.out.println("passed");}
    }
}