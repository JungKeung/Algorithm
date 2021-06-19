package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2667
 *  fail
 */
public class Jk_BackJoon_2667 {
    public static int SIZE;
    public static int[][] danji;
    public static boolean[][] visited;

    public static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SIZE = Integer.parseInt(br.readLine());

        danji = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];

        pq = new PriorityQueue<Integer>();

        for(int i=0; i < SIZE; i++) {
            String str = br.readLine();
            for(int j=0; j < SIZE; j++) {
                danji[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        // danji를 조회하면서 1이고 방문 기록이 없는 좌표는 새로운 단지의 시작 점
        for(int i=0; i < SIZE; i++) {
            for(int j=0; j < SIZE; j++) {
                if(danji[i][j] == 1 && !visited[i][j]) BFS(i, j);
            }
        }
        // 큐의 사이즈가 단지의 수이다.
        System.out.println(pq.size());

        // 우선순위 큐는 작은 수부터 우선적으로 나오기 때문에 큐가 빌때까지 값을 출력하면 된다.
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {y, x});

        int count = 0;
        while(!queue.isEmpty()) {
            int currY = queue.peek()[0];
            int currX = queue.peek()[1];
            queue.poll();

            // 좌표 범위를 초과했는지 확인한다.
            if(currY < 0 || currX < 0 || currY >= SIZE || currX >= SIZE) continue;
            // 해당 좌표가 0 이면 접근하면 안된다.
            if(danji[currY][currX] == 0) continue;

            // 방문 이력이 있는지 확인한다.
            if(visited[currY][currX]) continue;
            // 방문 이력을 남기고 카운트를 1 증가 시킨다.
            count += 1;
            visited[currY][currX] = true;

            // 근처 상하 좌우 좌표를 큐에 입력한다.
            queue.offer(new int[] {currY+1, currX});
            queue.offer(new int[] {currY-1, currX});
            queue.offer(new int[] {currY, currX+1});
            queue.offer(new int[] {currY, currX-1});
        }
        // 현재 단지의 수를 우선순위 큐에 삽입한다.
        pq.offer(count);
    }

}

