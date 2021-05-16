package JK_LEE;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1476
 *  기타: 성공
 */

public class Jk_BackJoon_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] esm = br.readLine().split(" ");
        //주어지는 날짜
        int E = Integer.parseInt(esm[0]);
        int S = Integer.parseInt(esm[1]);
        int M = Integer.parseInt(esm[2]);
        // 1,1,1 은 1년이기 떄문에 1
        int count = 1;
        //시작하는 날짜
        int e = 1;
        int s = 1;
        int m = 1;


        //해당 숫자가 나올떄까지 while문
        while(true) {
            if(E==e && S==s && M==m) break;
            e++; s++; m++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;

            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
