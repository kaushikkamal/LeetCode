package LeetCode;

import java.util.ArrayList;
// https://leetcode.com/problems/most-profit-assigning-work
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class MostProfitAssigningWork {
    static class Info {
        int difficulty;
        int profit;

        Info() {

        }

        Info(int d, int p) {
            this.difficulty = d;
            this.profit = p;
        }
    }

    // public static int maxProfitAssignment(int[] difficulty, int[] profit, int[]
    // worker) {
    // Info[] arr = new Info[difficulty.length];
    // for (int i = 0; i < difficulty.length; i++) {
    // arr[i] = new Info(difficulty[i], profit[i]);
    // }

    // Arrays.sort(arr, (a, b) -> a.difficulty == b.difficulty ? a.profit - b.profit
    // : a.difficulty - b.difficulty);
    // Arrays.sort(worker);

    // if (worker[worker.length - 1] < arr[0].difficulty) {
    // return 0;
    // }

    // int i = 0;
    // int res = 0;
    // int temp = 0;

    // for (int w : worker) {
    // while (i < arr.length && w >= arr[i].difficulty) {
    // temp = Math.max(temp, arr[i].profit);
    // i++;
    // }
    // res += temp;
    // }
    // return res;
    // }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, best = 0;
        for (int j = 0; j < N; ++j)
            jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < N && ability >= jobs.get(i).getKey())
                best = Math.max(jobs.get(i++).getValue(), best);
            res += best;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] difficulty = { 13, 37, 58 };
        int[] profit = { 4, 90, 96 };
        int[] worker = { 34, 73, 45 };

        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }
}
