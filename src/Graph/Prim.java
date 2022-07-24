package Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2){
            return o1.weight - o2.weight;
        }
    }

    // 生成最小生成树
    public static Set<Edge> primMST(Graph graph){
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                new EdgeComparator());

        HashSet<Node> set = new HashSet<>();// 考察过的点在set里

        Set<Edge> result = new HashSet<>(); // 依次挑选的边在result里
        for(Node node : graph.nodes.values()){ //随便挑了一个点
            // node是开始点
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge: node.edges){ // 由一个点，解锁所有相连的边
                    Node toNode = edge.to; // 可能的一个新的点
                    if(!set.contains(toNode)){ // 不含有的时候，就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for(Edge nextEdge: toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return  result;
    }
}
