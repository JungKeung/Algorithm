package JK_LEE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * https://www.acmicpc.net/problem/15661
 * fail
 */
public class Jk_BackJoon_15661 {
    static int N;
    static int[][] ability;

    static int[] startTeam;
    static int[] linkTeam;
    static boolean[] isStartTeam;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        ability = new int[N+1][N+1];

        for(int n1 = 1; n1<=N; n1++){
            st = new StringTokenizer(br.readLine()," ");
            for(int n2 = 1; n2<=N; n2++){
                ability[n1][n2] = Integer.parseInt(st.nextToken());
            }
        }

        for(int pickCount = 1; pickCount<=N-1; pickCount++){
            startTeam = new int[pickCount];
            linkTeam = new int[N-pickCount];
            isStartTeam = new boolean[N+1];
            pickStartTeam(pickCount, 0  , 0);
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

    public static void pickStartTeam(int pickCount, int beforePickedNum, int index){
        if(index>=pickCount){
            //링크팀 구하기
            int i = 0;
            for(int number = 1; number<=N; number++){
                if(!isStartTeam[number]){
                    linkTeam[i] = number;
                    ++i;
                }
            }

            // 능력 차 구하기
            int startTeamAbility = 0;
            int linkTeamAbility = 0;
            for(int k = 0; k<startTeam.length;k++){
                for(int j = 0; j<startTeam.length; j++){
                    startTeamAbility+= ability[startTeam[k]][startTeam[j]];
                }
            }

            for(int k = 0; k<linkTeam.length; k++){
                for(int j = 0; j<linkTeam.length; j++){
                    linkTeamAbility+= ability[linkTeam[k]][linkTeam[j]];
                }
            }

            int gap = Math.abs(startTeamAbility-linkTeamAbility);
            min = Math.min(min, gap);

        }
        else{
            for(int number = beforePickedNum+1; number<=N; number++){
                startTeam[index] = number;
                isStartTeam[number] = true;

                pickStartTeam(pickCount, number, index+1);
                isStartTeam[number] = false;
            }
        }
    }
}

