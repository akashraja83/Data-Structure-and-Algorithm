import java.util.*;

class CDLL{

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            next = prev = null;
        }
    }

    Node head;

    // Insert at Beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at End
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node tail = head.prev;

        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    // Insert at Position
    public void insertAtPosition(int data, int pos){
        if(pos == 0){
            insertAtBeginning(data);
            return;
        }

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        for(int i = 0;i < pos - 1;i++){
            temp = temp.next;
            if(temp == head){
                System.out.println("Invalid position");
                return;
            }
        }

        Node newNode = new Node(data);
        Node nextNode = temp.next;

        temp.next = newNode;
        newNode.prev = temp;

        newNode.next = nextNode;
        nextNode.prev = newNode;
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

        Node tail = head.prev;
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    // Delete from End
    public void deleteFromEnd(){
        if (head == null){
            return;
        }

        if(head.next == head){
            head = null;
            return;
        }

        Node tail = head.prev;
        Node newTail = tail.prev;

        newTail.next = head;
        head.prev = newTail;
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
        for(int i = 0;i < pos;i++){
            temp = temp.next;
            if(temp == head){
                System.out.println("Invalid position");
                return;
            }
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
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
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("(back to head)");
    }
}

public class CircularDoublyLinkedList{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CDLL list = new CDLL();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for(int i = 0;i < n;i++){
            list.insertAtEnd(sc.nextInt());
        }

        System.out.println("Circular Doubly Linked List:");
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
