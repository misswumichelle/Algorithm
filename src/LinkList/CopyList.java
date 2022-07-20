package LinkList;

import java.util.HashMap;

//复制含有随机指针节点的链表
//一种特殊的单链表节点类描述如下
/*
  class Node {
  int value;
  Node next;
  Node rand;
  Node(int val){
   value = val;
   }
  }
  rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null.
  给定一个由Node节点组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
*/

public class CopyList {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int val){
            value = val;
        }
        public Node (int val, Node next, Node rand){
            value = val;
            this.next = next;
            this.rand = rand;
        }
    }

    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //空间复杂度O(1)
    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        /*
        copy node and link to every nod
        1 -> 2
        1 -> 1' -> 2
         */
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //set copy node rand
        //1 -> 1' -> 2 -> 2'
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //split
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next !=null? next.next : null;
            cur = next;
        }
        return res;


    }
}
