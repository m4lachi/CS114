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

    public boolean isEmpty() {
        return head == null;
    }

    public static boolean isBalancedParentheses(String parentheses) {
        Stack stack = new Stack();
        char[] openingSymbols = {'(', '[', '{'};
        char[] closingSymbols = {')', ']', '}'};

        for (char symbol : parentheses.toCharArray()) {
            if (contains(openingSymbols, symbol)) {
                // If the symbol is an opening parenthesis, push it onto the stack
                stack.push(symbol);
            } else if (contains(closingSymbols, symbol)) {
                // If the symbol is a closing parenthesis, check if the stack is not empty
                if (stack.isEmpty()) {
                    return false;  // No matching opening parenthesis found
                }
                // Pop the top element from the stack and check if it matches the current closing parenthesis
                char topElement = (char) stack.pop();
                if (topElement != getMatchingOpeningSymbol(symbol)) {
                    return false;  // Mismatched opening and closing parentheses
                }
            }
        }

        // After processing all symbols, the stack should be empty for the parentheses to be balanced
        return stack.isEmpty();
    }

    private static boolean contains(char[] symbols, char symbol) {
        for (char s : symbols) {
            if (s == symbol) {
                return true;
            }
        }
        return false;
    }

    private static char getMatchingOpeningSymbol(char closingSymbol) {
        switch (closingSymbol) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return '\0'; // Invalid case
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalancedParentheses("(()()()())"));  // true
        System.out.println(isBalancedParentheses("((((()))))"));   // true
        System.out.println(isBalancedParentheses("(()((())()))"));  // true

        System.out.println(isBalancedParentheses("((((((())"));  // false
        System.out.println(isBalancedParentheses("(()))"));       // false
        System.out.println(isBalancedParentheses("(()()(()"));    // false
    }
}
