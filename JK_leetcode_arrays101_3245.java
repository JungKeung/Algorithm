package JK_LEE.LeetCode;

class JK_leetcode_arrays101_3245 {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;

        for (int a : arr) {
            if (a == 0) zeroCount++;
        }

        int n = arr.length;

        for (int i = n-1; i >= 0; i--) {
            int j = i + zeroCount;

            if (arr[i] == 0) {
                if (j < n) arr[j] = 0;
                zeroCount--;
                j--;
            }

            if (j < n) arr[j] = arr[i];
        }
    }
}
