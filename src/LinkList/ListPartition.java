package LinkList;

//题目：给定一个单链表的头结点head,节点的值类型是整型，再给定一个整数pivot。
// 实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。

public class ListPartition {
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
    public static Node listPartition2(Node head, int pivot){
        Node sH = null; //smail head
        Node sT = null; //smail tail
        Node eH = null; //equal head
        Node eT = null; //equal tail
        Node mH = null; //big head
        Node mT = null; //big tail
        Node next = null; //save next node
        //every node distributed to three lists
        while(head!=null){
            next = head.next;
            head.next = null;
            if(head.value<pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            } else{
                if(mH == null){
                    mH = head;
                    mT = head;
                }else{
                    mT.next = head;
                    mT = head;
                }

            }
            head = next;
        }
        // small and equal reconnect
        if(sT != null){//如有有小于区域
            sT.next = eH;
            eT = eT == null? sT:eT; //下一步,谁去连大于区域的头，谁就变成eT
        }

        if(eT!=null){
            eT.next = mH;
        }
        return sH!=null ? sH : (eH!=null ? eH: mH);
    }
}
