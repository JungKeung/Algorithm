package JK_LEE.Algorithm;

import java.io.*;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2250
 * success!
 */
public class Jk_BackJoon_2250
{
    static Node tree[] = null;
    static int parent[] = null;
    static int left[] = null;
    static int right[] = null;
    static int root = 0;
    static int nodeIndex = 1;

    static class Node
    {
        int left;
        int right;
    }

    // 중위순회
    private static void dfs(int s, int height)
    {

        // 왼쪽 서브트리
        if (tree[s].left != -1)
        {
            dfs(tree[s].left, height + 1);
        }

        // 해당 높이에서 가장 좌측 노드, 가장 우측 노드의 x축 값 업데이트
        left[height] = Math.min(left[height], nodeIndex);
        right[height] = Math.max(right[height], nodeIndex);

        System.out.println(left[height] + " ~ " + right[height]);

        // 중위순회로 x축 값 +1
        nodeIndex += 1;

        // 오른쪽 서브트리
        if (tree[s].right != -1)
        {
            dfs(tree[s].right, height + 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        parent = new int[N + 1];
        left = new int[N + 1];
        right = new int[N + 1];

        for (int i = 0; i <= N; i++)
            tree[i] = new Node();

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rt = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 루트를 찾기위해 쓰이는 배열
            parent[rt] += 1;
            if (l != -1)
                parent[l] += 1;
            if (r != -1)
                parent[r] += 1;

            tree[rt].left = l;
            tree[rt].right = r;
        }

        // 루트 탐색 (노드가 한번 나타난 것을 기준)
        for (int i = 1; i <= N; i++)
        {
            if (parent[i] == 1)
            {
                root = i;
            }
        }

        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MIN_VALUE);

        // 루트에서 탐색,
        dfs(root, 1);

        // 최대길이 획득
        int result = right[1] - left[1] + 1;
        int level = 1;

        for (int i = 2; i <= N; i++)
        {

            int temp = right[i] - left[i] + 1;

            if (temp > result)
            {
                result = temp;
                level = i;
            }
        }

        System.out.println(level + " " + result);
        br.close();
    }
}