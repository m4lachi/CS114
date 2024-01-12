import java.util.Scanner;

public class MichelleZambrano_BinaryLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public void insert(int value) {
            Node newNode = new Node(value);
            if (head == null || value < head.value) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.value < value) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }

        public boolean binarySearch(int target) {
            Node current = head;
            while (current != null) {
                if (current.value == target) {
                    return true;
                } else if (current.value > target) {
                    return false;
                }
                current = current.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Insert at least 10 sorted integers into the linked list
        int[] sortedValues = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        for (int value : sortedValues) {
            linkedList.insert(value);
        }

        // Asks the user to input a target value
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the target value to search for: ");
        int targetValue = scan.nextInt();

        // Call the binarySearch method to determine if the target value is present
        boolean result = linkedList.binarySearch(targetValue);

        // The result
        if (result) {
            System.out.println(targetValue + " is present in the linked list.");
        } else {
            System.out.println(targetValue + " is not present in the linked list.");
        }
        // Close the Scanner
        scan.close();
    }
}
