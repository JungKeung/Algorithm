package JK_LEE;

import java.io.*;
import java.util.*;
/**
 * https://www.acmicpc.net/problem/15651
 * fail
 */
public class Jk_BackJoon_15651 {

    // 수열을 저장 할 배열
    static int m,n;
    static int list[];
    //BufferedWriter 객체, static선언을 한 이유는 DFS메소드 내에서 출력을 하기 때문이다.
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //DFS메소드, 출력부가 있기 때문에 bw객체를 사용할 때에는 입출력 예외처리가 필수
    static void dfs(int cnt) throws IOException {

        if(cnt == m) {
            for(int i=0;i<m;i++) {
                bw.write(String.valueOf(list[i])+" ");	//bw.write()를 이용한 출력
            }
            bw.newLine(); // 개행
            return;
        }

        for(int i =1;i<=n;i++) { // 중복이 허용되므로 1부터 n까지 계속반복한다.
            //방문배열을 처리해주는 부분이 사라졌다.
            list[cnt]=i;
            dfs(cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        //마찬가지로 main부에 입력 처리가 있으므로 입출력 예외처리가 필수

        //BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //공백을 기준으로 입력받기 때문에 공백 구분을 위해 StringTokenizer 객체를 함께 사용한다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 공백을 구분으로 입력
        m = Integer.parseInt(st.nextToken()); // 공백을 구분으로 입력


        list = new int [m];
        dfs(0);
        // BufferedWriter클래스의 경우 프로그램이 종료하기 전에 flush()를 수행해주어야
        // 올바르게 출력값이 나온다고 한다. 왜 그런지는 자세히는 모르겠다..

        br.close();
        bw.flush();
        bw.close();
    }

}