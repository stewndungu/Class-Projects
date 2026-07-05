/** 
* 
* Student name:  Stewart Ndung'u
* Completion date: 7/5/2026
*
* LineList.txt: the template file of LineList.java
* Student tasks: implement tasks as specified in this file
*
* LineList class is a linked-base list that represents the contents of a document
*
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class LineList{
   
   private Node head;
   
   public LineList(){   //constructor  
      head=null;
   }
   //Don't modify anything before this line. 
   //Do not add any other instance variables.
   

   // *** Student tasks: implement the following methods *** 
  
   public void empty(){
      	// delete all lines in the editor
         head = null;
   }

   public void load(String fileName, boolean append){
      	// append is true, read lines and add to existing list, 
      	// otherwise, create new list.
	// Each line is stored in a Node.
	// You may need to handle exception within this method
	// or throw runtime exception only.
         if (!append) {
            head = null; // Create a new list if append is false
         }
         else
         {
               try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                  String line;
                  while ((line = br.readLine()) != null) {
                        addLine(line);
                  }
               } catch (IOException e) {

                  throw new RuntimeException("Could not load file", e);
               }
         }
   }
   
   public void save(String fileName){
      	// Save all lines represented with Nodes to a file. 
	// Each line (Node) occupies a line in the saved file.
	// You may need to handle exception within this method
	// or throw runtime exception only.
      try(PrintWriter out = new PrintWriter(new FileWriter(fileName)))
         {
            Node current = head;
               while (current != null) {  
                  // Write the line to the file 
                   out.println(current.getLine());
                  current = current.getNext();
               }
         }
      catch(IOException e)
         {
            throw new RuntimeException("Error saving the file: " + e.getMessage());
         }  
        

   }
   
   public void addLine(String line){
      	//append the line to the end of the list
         Node newNode = new Node(line);
         if (head == null) {
            head = newNode;
         }
         else
         {
            Node current = head;
            while (current.getNext() != null) {
               current = current.getNext();
            }
            current.setNext(newNode);
         }
   }

   public void addLine(String line, int n){
      	//insert new line to nth line, if n > total number of line, 
      	//append to the end of the list.
         Node newNode = new Node(line);
         if (n <= 1) {

            // If n is less than or equal to 1, insert at the beginning
            // Depending on if the head is null or not 
            if(head != null) {
               newNode.setNext(head);
               head = newNode;
            } else {
               head = newNode;
            }
           
         } 
         else {
            Node current = head;
            int count = 1;
            while (current != null && count < n - 1) {
               current = current.getNext();
               count++;
            }
            if (current == null) {
               // If n is greater than the number of lines, append to the end
               current.setNext(newNode);
            } 
            else {
               newNode.setNext(current.getNext());
               current.setNext(newNode);
            }
         }
   }
   
   public int words(){
      	// count number of words, word may be separated with 
      	// \t,;.?!-@spaces ' * and "
         int count = 0;
         Node current = head;
         while (current != null) {
            String line = current.getLine();
            String[] words = line.split("[\\s\\t,;.?!\\-@'\"*]+");
            count += words.length;
            current = current.getNext();
         }
         return count;
      
   }

   public int lines(){ 
      	// count number of lines, which is the same as the number of
      	// nodes in the list.
         int count = 0;
         Node current = head;
         while (current != null) {
            count++;
            current = current.getNext();
         }
         return count;
   }

   public void delete(int n){
      	//delete nth line if exists. Otherwise do nothing.
         int count = 1;
         Node current = head;

         //if the number is the first line, we need to update the head to the next node
         if (n == 1) {
         
            // if the head is not null, we set the head to the next node
            if(head != null) {
               head = head.getNext();
            }
            // if the head is null, we set the head to null
            else
            {
                head = null;
            }
           
         }
         //if the number is greater than 1, we need to traverse the list to find the nth node
         else
         {
            //traverse the list until we reach the node before the nth node or the end of the list
            while (current != null && count < n - 1) {
               current = current.getNext();
               count++;
            }
            //if the current node is null or the next node is null, we do nothing. Meaning the nth line doesn't exist
            if (current == null || current.getNext() == null) {
               return;
            } 
            // delete the nth node by setting the next of the current node to the next of the next node
            current.setNext(current.getNext().getNext());
         }
   }

   public String toString(){
      	// Return all lines represented by Nodes in the list. All lines
      	// are in the same order as their corresponding nodes in the list.
      	// All lines are separated with \n. No newline character should be 
	// added after the last line.
         Node current = head;
         StringBuilder sb = new StringBuilder();
         while (current != null) {
            sb.append(current.getLine());
            if (current.getNext() != null) {
               sb.append("\n");
            }
            current = current.getNext();
         }
         return sb.toString();
     
   }

   public void print(){
      	// Print each line. Each line is proceeded with its corresponding line 
      	// numbers. Please refer to sample output.
         Node current = head;
         int lineNumber = 1;
         while (current != null) {
            System.out.println(lineNumber + ". " + current.getLine() + "\n");
            current = current.getNext();
            lineNumber++;
         }

   }
   
   public void replace(String s1, String s2){
      	// Replace all occurrences of s1 with s2.
         Node current = head;
         while (current != null) {
            current.replace(s1, s2);
            current = current.getNext();
         }

   }
   
   public void line(int n){
      	// Print nth line in the document. (The nth node in the list)
      	// If nth line does not exists, print �Line n does not exist.�
         int count = 1;
         Node current = head;

         //traverse the list until we reach the nth node or the end of the list
         while (current != null && count < n) {
            current = current.getNext();
            count++;
         }
         //if the current node is null, the nth line doesn't exist
         if (current == null) {
            System.out.println("Line " + n + " does not exist.");
         }
         //otherwise, print the nth line
         else {
            System.out.println(current.getLine());
         }

   }
}
