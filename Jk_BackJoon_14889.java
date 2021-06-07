package JK_LEE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 * https://www.acmicpc.net/submit/14889
 * fail
 */
public class Jk_BackJoon_14889 {
    static int N;
    static int[][] S;
    static int DIFF = Integer.MAX_VALUE;
    static HashSet<Integer> allPlayer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.valueOf(br.readLine());
        S = new int[N][N];
        // 참석한 사람을 모두 집합에 넣음
        allPlayer = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            allPlayer.add(i);
            S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        pickTeam(new HashSet<Integer>(), 0, 0);
        bw.write(DIFF + "\n");
        bw.flush();
        bw.close();
    }

    static void pickTeam(HashSet<Integer> startTeam, int current, int pick) {
        if (pick == N / 2) {
            // 전체 인원 - 스타트 팀의 인원
            HashSet<Integer> linkTeam = new HashSet<Integer>(allPlayer);
            // = 차집합 = 링크 팀 인원
            linkTeam.removeAll(startTeam);

            // 각 팀의 능력치 구함
            int startStats = calcTeamStats(startTeam);
            int linkStats = calcTeamStats(linkTeam);

            // 어떤 팀의 능력치가 클지 모르니 차이의 절댓값으로 비교
            DIFF = Math.min(DIFF, (int) Math.abs(startStats - linkStats));

            return;
        }

        // 현재 넣을 값을 가리키고 있는 current가 뽑을 수 있는 범위 안일 때 뽑음
        if (current < N) {
            // 백트레킹 - 현재 사람을 뽑았을 때
            startTeam.add(current);
            pickTeam(startTeam, current + 1, pick + 1);
            // - 뽑지 않고 그냥 넘어갔을 때
            startTeam.remove(current);
            pickTeam(startTeam, current + 1, pick);
        }

    }

    static int calcTeamStats(HashSet<Integer> team) {
        int stats = 0;
        ArrayList<Integer> player = new ArrayList<Integer>(team);

        for (int i = 0; i < player.size() - 1; i++) {
            for (int j = i + 1; j < player.size(); j++) {
                int p1 = player.get(i);
                int p2 = player.get(j);

                stats += S[p1][p2] + S[p2][p1];
            }
        }

        return stats;
    }

}