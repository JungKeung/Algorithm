package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576
 * fail
 */

class Point{
    int row, col;
    public Point(int row, int col){this.row = row; this.col = col;}
}

public class Jk_BackJoon_7576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][], m, n;
    static Queue<Point> queue = new LinkedList<>();
    // 상하좌우를 나타내기 위한 배열
    static int xArr[] = {-1, 0, 1, 0}, yArr[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // bfs를 시작하는 노드를 큐에 추가
                if(arr[i][j] == 1) queue.add(new Point(i, j));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 4; i++){
                // 상하좌우로 토마토가 익을 수 있는지 여부 확인
                if(checkLocation(row + xArr[i], col + yArr[i])){
                    // 익은 토마토를 큐에 추가
                    queue.add(new Point(row + xArr[i],col + yArr[i]));
                    // 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
                    arr[row + xArr[i]][col + yArr[i]] = arr[row][col] + 1;
                }
            }
        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                if(arr[i][j] == 0) return -1;
                // 토마토가 익는데 걸리는 시간을 구함
                result = Math.max(result, arr[i][j]);
            }
        }
        // 최대 값이 1이라면 원래부터 모두 익어있었다는 것
        if(result == 1) return 0;
        // 최대 값 - 1 --> 걸린 일수
        return (result - 1);
    }

    private static boolean checkLocation(int row, int col) {
        // 주어진 범위 밖인지 검사
        if(row < 1 || row > n || col < 1 || col > m) return false;
        // 아직 익지 않은 토마토라면 true 반환
        if(arr[row][col] == 0) return true;
        // 이미 익어있거나 빈 자리라면 false 반한
        return false;
    }
}