package JK_LEE;

/**
 * https://www.acmicpc.net/problem/1107
 * 기타 : 실패 , 분석 시작
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jk_BackJoon_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());  // 목표 채널
        int m = Integer.parseInt(br.readLine());  // 망가진 버튼 수
        boolean[] isBroken = new boolean[10];  // 버튼 고장 여부

        if(m != 0) {
            st = new StringTokenizer(br.readLine());
        }
        for(int i = 0; i < m; i++) {
            int brokenBtn = Integer.parseInt(st.nextToken());
            isBroken[brokenBtn] = true;
        }

        if(n == 100) {  // 예외처리
            System.out.println(0);
            return;
        }

        int ans = Math.abs(n - 100);  // 초기값은 숫자 없이 + or - 이동
        for(int i = 0; i <= 1000000; i++) {  // i까지 숫자버튼으로 이동 후 +,- 버튼으로 이동하는 수
            String strChan = String.valueOf(i);

            // 숫자 버튼으로 이동 가능한지 체크
            boolean isPossible = true;
            for(int j = 0; j < strChan.length(); j++) {
                int btn = strChan.charAt(j) - '0';
                if(isBroken[btn]) {
                    isPossible = false;
                    break;  // 고장난 버튼이 있으면 다이렉트로 접근 불가능
                }
            }

            if(isPossible) {
                int cnt = strChan.length() + Math.abs(i - n);  // 숫자 이동 후 +,- 이동
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}