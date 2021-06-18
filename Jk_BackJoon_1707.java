package JK_LEE.Algorithm;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1707
 * fail
 */

public class Jk_BackJoon_1707 {

    static ArrayList<Integer>[] ConnectionList;
    static int[] group;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            int node = sc.nextInt();
            int edge = sc.nextInt();

            ConnectionList = new ArrayList[node + 1];
            // group 번호를 아래와 같이 나눈다
            //  - 0번: 방문안함
            //  - 1번: 1번 그룹
            //  - 2번: 2번 그룹
            // 이 경우는 group이 check 처럼 사용되는 동시에 group 관리도 할 수 있다
            // 어떻게 보면 가중치 1, 가중치 2라고도 생각할 수 있다.
            group = new int[node + 1];
            boolean ok = true;

            for (int j = 1; j <= node; j++) {
                ConnectionList[j] = new ArrayList<>();
            }

            for (int j = 1; j <= edge; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                ConnectionList[from].add(to);
                ConnectionList[to].add(from);
            }

            // dfs를 돌면서 group를 채운다
            for (int start = 1; start <= node; start++) {
                if(group[start] == 0) {
                    dfs(start, 1);
                }
            }
            // 채워진 group를 비교
            // 즉 하나의 노드와 그 자식들을 돌면서 비교한다
            // 이분 그래프에서는 부모와 자식사이의 관계가 이분이 되어야 한다
            for (int x = 1; x <= node; x++) {
                for (int j : ConnectionList[x]) {
                    if(group[x] == group[j]) {
                        ok = false;
                    }
                }
            }
            if(ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int start, int visit) {
        // 1. 처음이 1이면
        group[start] = visit;
        for (int node: ConnectionList[start]) {
            // 만약 처음일 경우는 group에 무조건 0이 들어가 있으므로
            if(group[node] == 0) {
                // 2. 그 다음은 2가 된다
                dfs(node, 3 - visit);
            }
        }
    }
}