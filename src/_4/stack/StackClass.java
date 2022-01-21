package _4.stack;

public class StackClass {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head;
        public  void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public  Boolean isEmpty(){
            return head == null;
        }
        public  int pop(){
            if (isEmpty()){
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }
        public  int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
        }


    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        //pushToBottomOfStack(s,6);
        reverseAStack(s);
        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void pushToBottomOfStack(Stack s,int data){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        int poppedData = s.pop();
        pushToBottomOfStack(s,data);
        s.push(poppedData);
    }
    public static void reverseAStack(Stack s){
        if (s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseAStack(s);
        pushToBottomOfStack(s,top);

    }

}
