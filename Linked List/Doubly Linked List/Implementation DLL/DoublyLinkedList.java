/**
 * Doubly Linked List Implementation
 *
 * - Insert at (beginning, end, specific position)
 * - Delete at (beginning, end, specific position)
 * - Count nodes
 * - Search value
 * - Display forward
 * - Display backward
 */

class DLL{

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    // Insert at Beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);

        if(head != null){
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    // Insert at End
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at Position (0-based)
    public void insertAtPosition(int data, int pos){
        if(pos == 0){
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for(int i = 0;i < pos - 1 && temp != null;i++){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp.next != null){
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Delete from Beginning
    public void deleteFromBeginning(){
        if(head == null){
          return;
        }

        head = head.next;

        if(head != null){
            head.prev = null;
        }
    }

    // Delete from End
    public void deleteFromEnd(){
        if(head == null){
          return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.prev.next = null;
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
        for(int i = 0;i < pos && temp != null;i++){
            temp = temp.next;
        }
      
        if(temp == null){
            System.out.println("Invalid position");
            return;
        }

        if(temp.next != null){
            temp.next.prev = temp.prev;
        }

        if(temp.prev != null){
            temp.prev.next = temp.next;
        }
    }

    // Count Nodes
    public int countNodes(){
        int count = 0;
        Node temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Search
    public boolean search(int key){
        Node temp = head;

        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }


    // Display Forward
    public void displayForward(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display Backward
    public void displayBackward() {
        if(head == null){
          return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
import java.util.Scanner;

public class DoublyLinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DLL list = new DLL();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements (insert at end):");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Forward Display:");
        list.displayForward();

        System.out.println("Backward Display:");
        list.displayBackward();

        System.out.println("Delete at position 1:");
        list.deleteAtPosition(1);
        list.displayForward();

        System.out.println("Total Nodes: " + list.countNodes());

        sc.close();
    }
}
