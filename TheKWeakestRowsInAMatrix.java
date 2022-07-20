import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

public class TheKWeakestRowsInAMatrix {
    static class Info {
        int row;
        int sol;

        Info() {
        }

        Info(int r, int s) {
            this.row = r;
            this.sol = s;
        }
    }

    private static int numOfSoldier(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == 1) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] == 0) {
                end = mid - 1;
            }
        }
        return res + 1;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Info> list = new ArrayList<>(); // use max heap concept
        int i = 0;

        for (int[] arr : mat) {
            list.add(new Info(i, numOfSoldier(arr)));
            i++;
        }

        for (Info info : list) {
            System.out.println(String.format("Row %d, Soldier %d", info.row, info.sol));
        }

        Collections.sort(list, (a, b) -> a.sol - b.sol);

        int[] res = new int[k];

        for (int j = 0; j < k; j++) {
            res[j] = list.get(j).row;
        }

        return res;
    }
}
