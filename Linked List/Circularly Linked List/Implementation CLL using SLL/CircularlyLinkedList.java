/**
 * Circular Linked List Implementation
 *
 * - Insert at (beginning, end, specific position)
 * - Delete at (beginning, end, specific position)
 * - Count nodes
 * - Search value
 * - Display elements
 */

import java.util.*;
class CLL{

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Node head;

    // Insert at Beginning
    public void insertAtBeginning(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;

        while(temp.next != head){
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at End
    public void insertAtEnd(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;

        while(temp.next != head){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at Position
    public void insertAtPosition(int data, int pos){
    
        if(head == null){
            System.out.println("List is empty");
            return;
        }
    
        if(pos == 0){
            insertAtBeginning(data);
            return;
        }
    
        Node temp = head;
    
        for(int i = 0; i < pos - 1; i++){
    
            if(temp.next == head){
                System.out.println("Invalid position");
                return;
            }
    
            temp = temp.next;
        }
    
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from Beginning
    public void deleteFromBeginning(){

        if(head == null){
            return;
        }

        if(head.next == head){
            head = null;
            return;
        }

        Node temp = head;

        while(temp.next != head){
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;
    }

    // Delete from End
    public void deleteFromEnd(){

        if(head == null){
            return;
        }

        if(head.next == head){
            head = null;
            return;
        }

        Node temp = head;

        while(temp.next.next != head){
            temp = temp.next;
        }

        temp.next = head;
    }

    // Delete at Position
    public void deleteAtPosition(int pos){

        if(head == null){
            return;
        }

        if(pos == 0){
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for(int i = 0;i < pos - 1 && temp.next != head;i++){
            temp = temp.next;
        }

        if(temp.next == head){
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    // Count Nodes
    public int countNodes(){

        if(head == null){
            return 0;
        }

        int count = 0;
        Node temp = head;

        do{
            count++;
            temp = temp.next;
        }while(temp != head);

        return count;
    }

    // Search Value
    public boolean search(int key){

        if(head == null){
            return false;
        }

        Node temp = head;

        do{
            if(temp.data == key){
                return true;
            }

            temp = temp.next;

        }while(temp != head);

        return false;
    }

    // Display List
    public void display(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while(temp != head);

        System.out.println("(back to head)");
    }
}
public class CircularLinkedList{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        CLL list = new CLL();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for(int i = 0;i < n;i++){
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Circular Linked List:");
        list.display();

        System.out.println("Insert 100 at beginning:");
        list.insertAtBeginning(100);
        list.display();

        System.out.println("Insert 200 at position 2:");
        list.insertAtPosition(200, 2);
        list.display();

        System.out.println("Delete from beginning:");
        list.deleteFromBeginning();
        list.display();

        System.out.println("Delete from end:");
        list.deleteFromEnd();
        list.display();

        System.out.println("Total Nodes: " + list.countNodes());

        System.out.println("Enter value to search:");
        int key = sc.nextInt();

        if(list.search(key)){
            System.out.println("Value found");
        }
        else{
            System.out.println("Value not found");
        }

        sc.close();
    }
}
