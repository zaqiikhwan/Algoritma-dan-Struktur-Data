package ASD_AOP.ASD.Graph_;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Graph {
    Node[] nodes;
    int length = 0;

    Graph(int length) {
        this.length = length;
        nodes = new Node[length];
    }

    void addEdge(int head, int adj) {
        Node node = new Node(adj, nodes[head]);
        nodes[head] = node;
    }

    void BFS(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[length];
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.print(source + " ");
            Node node = nodes[source];
            while (node != null) {
                if(!visited[node.data]) {
                    visited[node.data] = true;
                    queue.add(node.data);
                }
                node = node.next;
            }
        }
    }

//    void printAdjacents() {
//        for (int i = 0; i < length; i++) {
//            System.out.print("Adjacent " + i + ":\n");
//            Node node = nodes[i];
//            while (node != null) {
//                System.out.print(node.data + " ");
//                node = node.next;
//            }
//            System.out.println();
//        }
//    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph(sc.nextInt());
        int source = sc.nextInt();
        int jumlahInput = sc.nextInt();
        for (int i = 0; i < jumlahInput; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        graph.BFS(source);
    }
}
