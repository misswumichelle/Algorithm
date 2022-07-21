package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //宽度优先遍历
    public static void w(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public static int preValue = Integer.MAX_VALUE;

    // 判断是否是二叉搜索树的函数。二叉搜索树所有的左子树都比根节点小，所有的右子树都比根节点大
    public static boolean checkBST(Node head){
        if(head == null){
            return true;
        }
        boolean isLeftBst = checkBST(head.left); // 检查左子树是不是二叉搜索树
        if(!isLeftBst){
            return false; // 左子树不是二叉搜索树，整棵树就不是
        }
        if(head.value <= preValue){  // 如果当前节点的值比上一个节点的值要小，则不是二叉搜索树
            return false;
        }else {
            preValue = head.value;
        }
        return checkBST(head.right); // 检查右子树
    }

    // 判断是否是完全二叉树
    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null, r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if(
                    (leaf && (l !=null || r != null)) //发现了左右孩子不双全的节点后，该节点后面的节点不是叶子节点（居然有孩子）
                    ||
                    (l == null && r != null)   //无左孩子，有右孩子
            ){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

}
