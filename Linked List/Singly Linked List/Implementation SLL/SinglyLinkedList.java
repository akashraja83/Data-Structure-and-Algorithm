/**
 * Singly Linked List Implementation
 
 * - Insert (beginning, middle, end)
 * - Delete (beginning, middle, end)
 * - Count nodes
 * - Search
 * - Reverse
 * - Find middle (single traversal)
 */
import java.util.*;

public class SLL{

    static class Node{
        int data;
        Node next;    
                                   //  =>  | data | next |
        Node(int data){
            this.data = data;
        }
    }

    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data){
        Node newNode = new Node(data); 
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert at position
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
          return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if(head != null){
            head = head.next;
        }
    }

    // Delete from end
    public void deleteFromEnd() {
        if(head == null || head.next == null){
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete at specific position
    public void deleteAtPosition(int pos){
    
        if(head == null){
            System.out.println("List is empty");
            return;
        }
    
        // Delete head
        if(pos == 0){
            head = head.next;
            return;
        }
    
        Node temp = head;
    
        // Traverse to (pos - 1)th node
        for(int i = 0;i < pos - 1 && temp != null;i++){
            temp = temp.next;
        }
    
        // Invalid position
        if(temp == null || temp.next == null){
            System.out.println("Invalid position");
            return;
        }
    
        temp.next = temp.next.next;
    }

    // Count nodes
    public int countNodes(){
        int count = 0;
        Node temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Search value
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

    // Reverse list
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Find middle (single traversal)
    public Node findMiddle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Display
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class SinglyLinkedList{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // -------------------- LIST 1 --------------------
        SLL list1 = new SLL();

        System.out.println("Enter size of list1:");
        int size = sc.nextInt();

        System.out.println("Enter elements for list1 (insert at beginning):");
        for(int i = 0; i < size; i++){
            int val = sc.nextInt();
            list1.insertAtBeginning(val);
        }

        System.out.println("List1:");
        list1.display();

        // Delete from beginning
        list1.deleteFromBeginning();
        System.out.println("After deleting from beginning:");
        list1.display();

        // Delete from end
        list1.deleteFromEnd();
        System.out.println("After deleting from end:");
        list1.display();

        // -------------------- LIST 2 --------------------
        SLL list2 = new SLL();

        System.out.println("Enter elements for list2 (insert at end, -1 to stop):");
        int val;
        do{
            val = sc.nextInt();
            if(val != -1){
                list2.insertAtEnd(val);
            }
        }while(val != -1);

        System.out.println("List2:");
        list2.display();

        // Insert at specific position
        System.out.println("Insert value 10 at position 2:");
        list2.insertAtPosition(10, 2);
        list2.display();

        // Delete at specific position
        System.out.println("Enter position to delete from list2:");
        int pos = sc.nextInt();
        list2.deleteAtPosition(pos);

        System.out.println("After deleting at position " + pos + ":");
        list2.display();

        // Count nodes
        System.out.println("Count of list2: " + list2.countNodes());

        // Search
        System.out.println("Enter value to search in list2:");
        int key = sc.nextInt();
        boolean found = list2.search(key);

        if(found){
            System.out.println("Value found in list");
        }
        else{
            System.out.println("Value not found");
        }

        // Find Middle
        SLL.Node middle = list1.findMiddle();
        if(middle != null){
            System.out.println("Middle Element: " + middle.data);
        }
        else{
            System.out.println("List is empty");
        }

        // Reverse List
        list1.reverse();

        System.out.println("Reversed List:");
        list1.display();

        sc.close();
    }
}
