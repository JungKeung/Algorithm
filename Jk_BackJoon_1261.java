package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1261
 * fail
 */
public class Jk_BackJoon_1261{

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int res = 0;
    // 좌표를 저장하는 class
    static class pos implements Comparable<pos>{
        int x;
        int y;
        int dist;

        public pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(pos o) {
            return Integer.compare(this.dist, o.dist);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());    // 가로
        int N = Integer.parseInt(st.nextToken());    // 세로
        int[][] map = new int[N][M];    // 미로 정보
        boolean[][] visited = new boolean[N][M];    // 부순 벽의 개수 정보

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // 최소 비용의 경로를 구해야 하므로 BFS 적용
        PriorityQueue<pos> q = new PriorityQueue<>();
        // 시작은 (1,1), 이동거리는 0
        q.add(new pos(0, 0, 0));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            pos now = q.poll();
            // 도착지점에 도착했을 경우 종료
            if(now.x == N-1 && now.y == M-1) {
                res = now.dist;
                break;
            }
            // 인접한 길을 확인
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                // 범위를 벗어날 경우 pass
                if(xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
                // 이미 왔던 길이면 pass
                if(visited[xx][yy]) continue;
                // 처음 오는 길이면 방문처리
                visited[xx][yy] = true;
                // 인접한 길이 빈 방이라면
                if(map[xx][yy] == 0) {
                    // 큐에 넣어주고
                    q.add(new pos(xx, yy, now.dist));
                }
                else {
                    // 빈 방이 아니라면 벽을 부수고 큐에 넣자
                    q.add(new pos(xx, yy, now.dist + 1));
                }
            }
        }

        System.out.println(res);
    }

}