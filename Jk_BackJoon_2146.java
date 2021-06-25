package JK_LEE.Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * https://www.acmicpc.net/problem/2146
 * fail
 */


class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Jk_BackJoon_2146 {
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};
    public static int[][] inputAry;
    public static int[][] group;
    public static int[][] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        inputAry = new int[n][n];
        //섬의 번호가 매겨져 저장된 2차원 배열
        group = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                inputAry[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(inputAry[i][j] == 1 && group[i][j] == 0) {
                    dfs(i,j,n,++cnt);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= cnt; i++) {
            answer = Math.min(answer, bfs(i, n));
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int n, int cnt) {
        group[x][y] = cnt;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(inputAry[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx,ny,n,cnt);
                }
            }
        }
    }
    // 반환값 : 섬 번호가 cnt일 때, 나머지 섬들에 다리를 놓을 때 최단 거리
    public static int bfs(int cnt, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //현재 섬의 번호가 cnt일 때는 거리에 0을 넣어주고, 다른 섬일 때는 -2, 그리고 바다 일때는 -1
                if(group[i][j] == cnt) {
                    dist[i][j] = 0;
                    q.add(new Pair(i,j));
                } else if (group[i][j] == 0) {
                    dist[i][j] = -1;
                } else {
                    dist[i][j] = -2;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // cnt번의 섬에서 다른 섬에 접근되었을 때 타게 되는 분기
                    // dist[x][y]에 최단거리가 담기므로 이전 다리길이와 비교해 최소값을 갱신해준다
                    if(dist[nx][ny] == -2) {
                        min = Math.min(min, dist[x][y]);
                        continue;
                    } else if(dist[nx][ny] == -1) {
                        q.add(new Pair(nx,ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        return min;
    }
}
