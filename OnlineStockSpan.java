// https://leetcode.com/problems/online-stock-span/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    public class Info {
        int price;
        int index;

        Info() {
        }

        Info(int p, int i) {
            this.price = p;
            this.index = i;
        }
    }

    Deque<Info> s;
    int count;

    public OnlineStockSpan() {
        count = 1;
        s = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!s.isEmpty() && price >= s.peek().price) {
            s.pop();
        }

        int res = s.isEmpty() ? count : count - s.peek().index;
        s.push(new Info(price, count));
        count++;

        return res;
    }
}
