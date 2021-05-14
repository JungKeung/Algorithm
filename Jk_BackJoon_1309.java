package JK_LEE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jk_BackJoon_1309{


    public static void main(String args[]) throws IOException{
        int n;
        int d[][]=new int[100001][3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        //사자가 첫 열에 있는 경우 시작
        d[1][0]=1;
        d[1][1]=1;
        d[1][2]=1;

        for(int i = 2 ; i <= n ;i++){
            d[i][0]=(d[i-1][1]+d[i-1][2])%9901;           //사자가 i번째 줄에 없어도 되는 경우
            d[i][1]=(d[i-1][0]+d[i-1][2])%9901;           //사자가 i번째 1번칸에 사자가 있는 경우
            d[i][2]=(d[i-1][1]+d[i-1][2]+d[i-1][0])%9901; //i번쨰 줄에 2번쨰 칸에 사자가 있는경우
        }

        System.out.println((d[n][0]+d[n][1]+d[n][2])%9901);

    }
}
