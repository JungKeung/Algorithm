package JK_LEE.Algorithm;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16940
 * fail
 */
public class Jk_BackJoon_16940 {
    static private class Node {
        int parent;
        int childSize;

        public Node (int parent, int childSize) {
            this.parent = parent;
            this.childSize = childSize;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();
        Node[] node = new Node[n+1];

        for (int i=0; i<n+1; i++) {
            arr.add(new ArrayList<>());
            node[i] = new Node(0, 0);
        }

        for (int i=0; i<n-1; i++) {
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);

            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }

        String[] order = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.add(1);
        visited[1] = true;

        // BFS 돌면서 부모 노드, 자식 노드 갯수 구하기
        while (!queue.isEmpty()) {
            int now = queue.poll();

            arr.get(now).forEach(it -> {
                if (!visited[it]) {
                    visited[it] = true;
                    node[it].parent = now;
                    node[now].childSize++;
                    queue.add(it);
                }
            });
        }

        // 노드가 A -> B 순서대로 나왔다면 뒤에서 A 자식노드 -> B 자식노드 순서대로 나와야한다
        // parentQueue 에는 order 순서대로 담으면서 자식노드가 전부 나올때까지 기다렸다가 부모노드를 교체해준다
        Queue<Integer> parentQueue = new LinkedList<>();
        int parent = 1;
        for(int i=1; i<n; i++) {
            int now = Integer.parseInt(order[i]);
            if (parent != node[now].parent) {
                System.out.println(0);
                return;
            }

            if (node[now].childSize > 0) parentQueue.add(now);
            node[parent].childSize--;
            if (node[parent].childSize == 0 && i < n-1) parent = parentQueue.poll();
        }

        System.out.println(1);
    }
}
