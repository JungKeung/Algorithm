package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Jk_BackJoon_1967{
    public static boolean visit[];
    public static int n, maxDist;
    public static Node maxDistNode;
    public static LinkedList<Node> tree[];
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, parent, child, dist;
        String line[];
        n = Integer.parseInt(in.readLine());
        tree = new LinkedList[n];
        visit = new boolean[n];
        for(i=0;i<n;i++) tree[i] = new LinkedList<>();
        for(i=1;i<n;i++){
            line = in.readLine().split(" ");
            parent = Integer.parseInt(line[0])-1; //노드번호 인덱스로 취급해 -1함
            child = Integer.parseInt(line[1])-1; //상동
            dist = Integer.parseInt(line[2]);
            tree[parent].add(new Node(child, dist)); //부모->자식
            tree[child].add(new Node(parent, dist)); //자식->부모
        }
        //루트로 부터 최대거리 노드(maxDistNode) 탐색
        for(Node root : tree[0]){
            visit[0] = true;
            dfs(root, root.dist);
            visit[0] = false;
        }
        maxDist = 0; //다음 탐색을 위해 0으로 초기화
        //maxDistNode로 부터 최대거리 노드 탐색. maxDist에 최대 거리값이 담긴다.
        dfs(maxDistNode, 0);
        out.write(String.valueOf(maxDist));
        out.close();
        in.close();
    }

    private static void dfs(Node curNode, int dist){
        /* 현재 노드 재탐색 방지(양방향 그래프이기 때문)
         * 만일 안해주면 1->2->3->2 와 같이 중복탐색하게 됨 */
        visit[curNode.num] = true;

        for(Node tmp : tree[curNode.num]){
            if(!visit[tmp.num]){
                visit[tmp.num] = true;
                dfs(tmp, dist+tmp.dist);
                visit[tmp.num] = false;
            }
        }
        if(dist > maxDist){
            maxDistNode = curNode;
            maxDist = dist;
        }
        visit[curNode.num] = false;
    }
}

class Node{
    int num, dist; //노드 번호, 거리
    public Node(int num, int dist){
        this.num = num;
        this.dist = dist;
    }
}