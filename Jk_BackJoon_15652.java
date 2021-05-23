package JK_LEE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15652
 *  success!
 */

class Jk_BackJoon_15652 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n,m;

    static void dfs(int[] a,int v,int cnt) throws IOException {
        if(cnt == m) {
            for(int i=0;i<m;i++) {
                bw.write(String.valueOf(a[i]+" "));
            }
            bw.newLine();

            return;
        }

        // 중복을 고려하지 않기 위해 check배열을 사용하지 않고,
        // 앞선 숫자 뒤에 오는 숫자는 자신보다 크거나 같은 숫자들이 위치해야 하므로 인자를 하나 더 넘겨준다.
        // 넘겨받은 인자부터 반복문을 수행하면 해결.
        for(int i=v;i<=n;i++) {
            a[cnt] = i;
            dfs(a,i,cnt+1);
        }
    }

    public static void main(String[] args) throws IOException  {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int a[] = new int[m];


        dfs(a,1,0);

        bw.flush();
        bw.close();
        br.close();

    }
}
