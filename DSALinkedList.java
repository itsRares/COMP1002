 /***************************************************************************
 *  FILE: DSALinkedList.java
 *  AUTHOR: Rares Popa - 19159700
 *  UNIT: COMP1002 - Assignment
 *  PURPOSE: Basic Linked List class
 *  LAST MOD: 19/10/17
 ***************************************************************************/

import java.util.*;

public class DSALinkedList<E> implements Iterable<E>
{
    //DSAListNode.java
    private class DSAListNode<E> {
        
        /*----------Classfields----------*/
        private E value;
        private DSAListNode<E> next;
        private DSAListNode<E> prev;
        
        /*----------Constructors----------*/
        /*******************************************
    *  *SUBMODULE DSAListNode
    *  *IMPORT: inValue (E)
    *  *EXPORT: -
    *  *ASSERTION: Creates a DSAListNode (node) object with the values provided
    *  ******************************************/
        public DSAListNode(E inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }
        
        /*----------Mutators----------*/
        /*******************************************
    *  *SUBMODULE setValue
    *  *IMPORT: inValue (E)
    *  *EXPORT: none
    *  *ASSERTION: Sets listnode value to inValue (What the user provided)
    *  ******************************************/
        public void setValue(E inValue)
        {
            value = inValue;
        }
        
        /*******************************************
    *  *SUBMODULE setNext
    *  *IMPORT: newNext (DSAListNode<E>)
    *  *EXPORT: none
    *  *ASSERTION: Sets next value of the listNode to newNext
    *  ******************************************/
        public void setNext(DSAListNode<E> newNext) 
        { 
            next = newNext;
        }

        /*******************************************
    *  *SUBMODULE setPrev
    *  *IMPORT: newPrev (DSAListNode<E>)
    *  *EXPORT: none
    *  *ASSERTION: Sets prev value of the listNode to newPrev
    *  ******************************************/
        public void setPrev(DSAListNode<E> newPrev)
        {
            prev = newPrev;
        }
        
        /*----------Accessors----------*/     
        public E getValue()
        {
            return value;
        }
        
        public DSAListNode<E> getNext()
        {
            return next;
        }

        public DSAListNode<E> getPrev()
        {
            return prev;
        }
    }
    
    /*----------Iterator----------*/
    private class MyLinkedListIterator<E> implements Iterator<E>
    {
        /*----------Classfields----------*/
        private DSALinkedList<E>.DSAListNode<E> iterNext;
        
        /*----------Constructor----------*/
        /*******************************************
    *  *SUBMODULE MyLinkedListIterator
    *  *IMPORT: theList (DSAListNode<E>)
    *  *EXPORT: -
    *  *ASSERTION: Creates a MyLinkedListIterator object to iterate through list
    *  ******************************************/
        public MyLinkedListIterator(DSALinkedList<E> theList) {
            iterNext = theList.head; 
        }
        
        /*----------Accessors----------*/
        public boolean hasNext()
        {
            return (iterNext != null);
        }
        
        /*----------Mutators----------*/
        /*******************************************
    *  *SUBMODULE next
    *  *IMPORT: none
    *  *EXPORT: aValue (E)
    *  *ASSERTION: gets the next value/label
    *  ******************************************/
        public E next() {
            E aValue;
            if (iterNext == null)                    //If no more values return null
            {
                aValue = null;
            }
            else
            {
                aValue = iterNext.getValue();        //Get next value
                iterNext = iterNext.getNext();       //Get next node
            }
            return aValue;
        }
    }
    
    /*----------Classfields----------*/
    private DSALinkedList<E>.DSAListNode<E> head;
    private DSALinkedList<E>.DSAListNode<E> tail;
    
    /*----------Constructors----------*/
    /*******************************************
    *  *SUBMODULE DSALinkedList
    *  *IMPORT: none
    *  *EXPORT: -
    *  *ASSERTION: Creates a DSALinkedList (list) object with head and tail both at null
    *  ******************************************/
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }
    
    /*----------Mutators----------*/
    /*******************************************
 *  *SUBMODULE insertFirst
 *  *IMPORT: newValue (E)
 *  *EXPORT: none
 *  *ASSERTION: If not empty import newValue to the start of the Linked List and
 *  *           set the head prev to newNd, next to head and head to newNd
 *  *           else set head and tail both to newNd
 *  ******************************************/
    public void insertFirst(E newValue)
    {
        DSAListNode<E> newNd = new DSAListNode<E>(newValue);
        if(isEmpty()) {                 //If empty just make head and tail equal newNd
            head = newNd;
            tail = newNd; 
        }
        else                    
        {
            head.setPrev(newNd);        //Set head prev to newNd
            newNd.setNext(head);        //Set newNd next to head value (null)
            head = newNd;               //Make head equal newNd
        }
    }
    
    /*******************************************
 *  *SUBMODULE insertLast
 *  *IMPORT: newValue (E)
 *  *EXPORT: none
 *  *ASSERTION: Insert the node into the end of the Linked list
 *  ******************************************/
    public void insertLast(E newValue)
    {
        DSAListNode<E> newNd = new DSAListNode<E>(newValue);
        
        if(tail != null) {tail.setNext(newNd);}
        tail = newNd;
        if(head == null) { head = newNd;}
        
    }
    
    /*******************************************
 *  *SUBMODULE removeFirst
 *  *IMPORT: none
 *  *EXPORT: nodeValue (E)
 *  *ASSERTION: Removes the first node from the linked list
 *  ******************************************/
    public E removeFirst()
    {
        E nodeValue;
        if (isEmpty()) { 
            throw new IllegalArgumentException("Linked List is empty");       //Throw error if Linked List is empty
        }
        
        nodeValue = head.getValue();  
        if (head == tail)                //If head is also tail (same value) reset linked list to default values
        {
            tail = null;
            head = null;
        } 
        else
        {
            head = head.getNext();       //Else set head value to the next node along
            head.setPrev(null);          //Set the value node prev to null as its the first one    
        } 
        return nodeValue;
    }

    /*******************************************
 *  *SUBMODULE removeLast
 *  *IMPORT: none
 *  *EXPORT: nodeValue (E)
 *  *ASSERTION: Removes the last node from the linked list
 *  ******************************************/
    public E removeLast()
    {
        E nodeValue;
        if (isEmpty()) {
            throw new IllegalArgumentException("Linked List is empty");       //Throw error if Linked List is empty
        }

        nodeValue = tail.getValue();
        if (head == tail)                //If head is also tail (same value) reset linked list to default values
        {
            tail = null;
            head = null;
        }
        else
        {
            tail = tail.getNext();       //Else set tail value to the next node along
            tail.setNext(null);          //Set the value node next to null as its the last one 
        }
        return nodeValue;
    }
    
    /*----------Accessors----------*/
    public boolean isEmpty()
    {
        return (head == null) && (tail == null);          //Check to make sure linked list not empty
    }
    
    /*******************************************
 *  *SUBMODULE peekFirst
 *  *IMPORT: none
 *  *EXPORT: nodeValue (E)
 *  *ASSERTION: Peeks to see what the first value of the linked list is
 *  ******************************************/
    public E peekFirst()
    {
        E nodeValue;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Linked List is empty");       //Throw error if linked list is empty      
        }
        else
        {
            nodeValue = head.getValue();       //return the head value of the linked list    
        }
        return nodeValue;
    }
    
    /*******************************************
 *  *SUBMODULE peekLast
 *  *IMPORT: none
 *  *EXPORT: nodeValue (E)
 *  *ASSERTION: Peeks to see what the last value of the linked list is
 *  ******************************************/
    public E peekLast()
    {
        E nodeValue;
        if(isEmpty()) {
            throw new IllegalArgumentException("Linked List is empty");       //Throw error if Linked List is empty     
        }
        else
        {
            nodeValue = tail.getValue();       //return the tail value of the linked list
        }
        return nodeValue;
    }
    
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<E>(this);
    }
}
