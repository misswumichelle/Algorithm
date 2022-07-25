package GreedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o2.p - o1.p;
        }
    }

    // k: 最多选几个项目， W: 初始资金  Profits: 收益  Capital：花费
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 所有项目扔到被锁池中，花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }
        for(int i = 0; i< k; i++){ // 进行k轮
            // 能力所及的项目，全解锁
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= W){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
