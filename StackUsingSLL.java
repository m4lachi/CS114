public class Stack {
    public class Node {
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
        }
    }
    
    Node head;
   
    public void push (int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head=newNode;
    }

    public int pop(){
        if(head ==null){
            System.out.println("Stack is empty :( )");
            return 0;
        }
        else{
            Node popped = head;
            head = head.next;
            popped.next=null;
            return popped.data;
        }
    }

    public int peek(){
        if(head == null){
            System.out.println("Stack is empty :( )");
            return 0;
        }
        return head.data;
    }

    public static void main(String[] args){
        Stack sll = new Stack();

        sll.push(10);
        sll.push(20);
        sll.push(30);

        System.out.println(sll.pop() + " popped");
        System.out.println(sll.pop() + " popped");
        System.out.println(sll.pop() + " popped");
        
    }
}


