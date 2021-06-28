package JK_LEE.Algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jk_BackJoon_13549 {
    static int N,K,cnt,min=Integer.MAX_VALUE;
    static int arr[] = new int[200001];
    static boolean visit[] = new boolean[200001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
    }
    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(N,0));

        while(!queue.isEmpty()) {
            Point po = queue.poll();
            visit[po.x] = true;

            if(po.x == K) {
                min = Math.min(min, po.y);
            }

            //  0초 후에 2*X
            if(po.x * 2 <= 100000 && !visit[po.x*2]) {
                queue.add(new Point(po.x*2, po.y));
            }
            //  1초 후에 X+1
            if(po.x + 1 <= 100000 && !visit[po.x+1]) {
                queue.add(new Point(po.x+1, po.y+1));
            }
            //  1초 후에 X-1
            if(po.x -1 >= 0 && !visit[po.x-1]) {
                queue.add(new Point(po.x-1, po.y+1));
            }

        }
    }

}