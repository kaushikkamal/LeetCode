package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            int prev = i;
            sb.setLength(0);
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            if (i == prev) {
                sb.append(nums[prev]);
            } else {
                sb.append(nums[prev]);
                sb.append("->");
                sb.append(nums[i]);
            }

            list.add(sb.toString());
        }

        return list;
    }
}
