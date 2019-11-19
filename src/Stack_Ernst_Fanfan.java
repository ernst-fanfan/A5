// Name: Ernst Fanfan
// Class: CS 5040
// Term: Fall 2019
// Instructor: Dr. Haddad
// Assignment: 5
// IDE: jGRASP
public class Stack_Ernst_Fanfan<E>
{
   public int size;
   public Node<E> head, tail;
   boolean empty = true;//initialize 
  
   public Stack_Ernst_Fanfan()//constructor
   {
      size = 0;
      head = null;
      tail = null;
   }
   
   public void push(E e)//push
   {
      //create new Node
      Node<E> newNode = new Node<E>(e);//declaring new node and set content to e
      //is stack empty?
      if (isEmpty() == true)
      {
         head = newNode;//set head too new node
         tail = newNode;//set tail too new node
         size();//size update
      }else//Stack is not empty push
      {
         tail.next = newNode;//adding new node to top
         tail = tail.next;//set tail to new top
         size();
      } 
   }
   
   public void pop()//pop
   {
      //is stack empty?
      if (isEmpty() == true)
         size=0;
      else if (head==tail)//is one node stack?
      {
         tail = null;
         head = null;
         size = 0;
      }else//two or more node stack
      { 
         Node<E> current = head;//declare and initialize current node to head
         for (int count=1; count < size()-1; count++)
            current = current.next;//move current through the list untill before last
         current.next = null;//disconnect last node
         tail = current;//set tail to current
      } 
   }
   
   public E top()//top
   {
      E topData;
      if (isEmpty() == true)//is empty?
         topData = (E)"empty";
      else
         topData = tail.data;
      return topData;//returns tail data
   }
   
   public int size()//size
   {
      if (isEmpty() == true)//is empty?
      {
         size = 0;
      }else if (head == tail)//is one node stack?
      {
         size = 1;
      }else//count nodes
      {
         int listSize= 1;//set to one because the for loop does not run current == tails
         //complete this method
         for (Node current = head; current != tail; current = current.next)//find indext
         {
            listSize++;//increments the list buy 1
         }
         size = listSize;
      }
      return size;//returns size
   }
   
   public boolean isEmpty()//isEmpty
   {
      if (head==null)
      {
         empty = true;
      }else
      {
         empty = false;
      }
      return empty;
   }
   
   public void printStack()//printStack
   {
      Node current;//declare current copy 
      current = head;//set to head of stack
      while (current != null)
      {
         System.out.print(current.data + "  ");//print node data
         current = current.next;//move to next node
      }
      System.out.println();
   }
   
      //class to create nodes as objects
   private class Node<E>
   {
      private E data;  //data field
      private Node next; //link field
       
      public Node(E item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}