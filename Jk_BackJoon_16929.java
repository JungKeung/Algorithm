package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/16929
 * fail
 */

public class Jk_BackJoon_16929 {
    public static class Graph{
        int[] di= {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        int n,m;
        //map 배열
        char [][] map;
        public Graph(int n, int m) {
            map = new char[n][m];
            this.n=  n;
            this.m = m;
        }
        //싸이클탐색
        public void cycle() {
            //배열 전체 순환하면서 체크
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    char c = map[i][j];//탐색할 문자 찾기
                    boolean [][] visited = new boolean[n][m];
                    int k=0;
                    DFS(i,j,i,j,c,visited,k);
                }
            }
            System.out.println("No");
        }
        //깊이탐색
        public void DFS(int si, int sj, int i,int j, char c,boolean[][] visited, int k) {
            //현재 방문한 값 체크
            visited[i][j]=true;
            //새로 방문했으니 k증가
            k++;
            //주변 배열 값 체크
            //주변 배열 값이 시작 지점인지 체크
            for(int x=0;x<4;x++) {
                int ni = i+di[x];
                int nj = j+dj[x];
                //사이클 지점이면 yes로 끝
                if(ni>=0 && nj>=0 && ni<n && nj<m) {
                    if(ni == si && nj == sj && visited[ni][nj]==true && k>=4) {
                        System.out.println("Yes");
                        System.exit(0);
                    }
                    if(visited[ni][nj]!=true && c == map[ni][nj]) {
                        DFS(si,sj,ni,nj,c,visited,k);
                    }
                }
            }
        }
        //map 생성 함수
        public void addmap(int index, String array) {
            for(int i=0;i<array.length();i++) {
                map[index][i] = array.charAt(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        Graph g = new Graph(n,m);

        for(int i=0;i<n;i++) {
            String array = br.readLine();
            g.addmap(i,array);
        }

        //사이클 깊이탐색
        g.cycle();

        br.close();
        bw.flush();
        bw.close();
    }
}