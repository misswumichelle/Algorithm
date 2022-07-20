package LinkList;
//两个单链表相交，找到第一个相交的节点
/*
 题目：给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，
 如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null.
 */
public class IntersectionList {
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

    //找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next; //n1 -> slow
        Node n2 = head.next.next; //n2 -> fast
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n2 -> walk again from head
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        // n: 链表1长度减去链表2长度的值
        cur1 = n > 0 ? head1 : head2;//谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;//谁短，谁的头变成cur2
        n = Math.abs(n);
        while(n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

}
