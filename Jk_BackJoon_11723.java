package JK_LEE.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11723
 * fail
 */
public class Jk_BackJoon_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");


            switch (input[0]) {
                //s를 {1~20}으로 바꾼다.
                case "all":
                    s = (1 << 21) - 1;
                    break;
                    //s를 공집합으로 바꾼다.
                case "empty":
                    s = 0;
                    break;
                default:
                    int x = Integer.parseInt(input[1]);
                    switch (input[0]) {
                        //s에 x를 추가한다 s에 x 가 이미 있을 경우에는 연산을 무시한다.
                        case "add":
                            s |= (1 << x);
                            break;
                            //s에 x를 제거한다. s에 x가 없는 경우에는 연산을 무시한다
                        case "remove":
                            s &= ~(1 << x);
                            break;
                            //s에 x가 있으면 1을, 없으면 0을 출력한다.
                        case "check":
                            sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');
                            break;
                            //s에 x가 있으면 x를 제거하고, 없으면 x를 추가한다.
                        case "toggle":
                            s ^= (1 << x);
                            break;
                    }
            }
        }

        System.out.println(sb);
    }
}
