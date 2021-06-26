package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1697
 * success
 */
public class Jk_BackJoon_1697 {

    static int dx[] = { -1, 1 };
    static int N, K, max = 100000;
    static boolean visited[];

    static class info {
        int pos;
        int time;

        public info(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static int bfs() {
        // 동일한 지점에서 시작했다면
        if(N == K) return 0;
        int xx;
        Queue<info> q = new LinkedList<>();
        // 시작점
        q.add(new info(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            info now = q.poll();
            // -1 or +1 or x2 로 이동
            for (int i = 0; i < 3; i++) {
                if(i==2) xx = now.pos * 2;    // 순간이동
                else xx = now.pos + dx[i];
                // 다음 지점이 동생이 있는 곳이라면
                // 현재 시간 + 1 을 return
                if(xx == K) return now.time + 1;
                // 범위를 초과하거나, 왔던 곳이면 pass
                if (xx < 0 || xx > max || visited[xx]) continue;
                q.add(new info(xx, now.time + 1));
                visited[xx] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max+1];
        System.out.println(bfs());
    }

}