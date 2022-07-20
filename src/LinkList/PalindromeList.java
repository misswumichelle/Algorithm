package LinkList;

import java.util.Stack;

//回文链表
public class PalindromeList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
        public Node(int data, Node next){
            this.value = data;
            this.next = next;
        }
    }

    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next!=null && cur.next.next!=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(right!=null){
            stack.push(right);
            right= right.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head; //慢指针
        Node n2 = head; //快指针
        while(n2.next !=null && n2.next.next!=null){ //find mid code
            n1 = n1.next;  //n1 -> mid
            n2 = n2.next.next; //n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; //mid.next -> null
        Node n3 = null;
        while(n2!=null){ //right part reverse
            n3 = n2.next; //n3 -> save next node
            n2.next = n1; //next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; //n3 -> save last node
        n2 = head; //n2 -> left first node
        boolean res = true;
        while(n1 !=null && n2!=null){  //n1 -> right part fist node, n2 -> left part first node
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while(n1 !=null){ //recover list, recover right part
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void main(String[] args) {
//        Node l1 = new Node(1,l2);
        Node l7 = new Node(1,null);
        Node l6 = new Node(2,l7);
        Node l5 = new Node(3,l6);
        Node l4 = new Node(4,l5);
        Node l3 = new Node(3,l4);
        Node l2 = new Node(2,l3);
        Node l1 = new Node(1,l2);

        System.out.println(isPalindrome3(l1));

    }

}
