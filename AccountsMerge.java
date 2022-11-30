// https://leetcode.com/problems/accounts-merge/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int V = accounts.size();
        DisjointSet ds = new DisjointSet(V);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    ds.unionBySize(map.get(email), i);
                } else {
                    map.put(email, i);
                }
            }
        }

        List<List<String>> emailList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            emailList.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            String mail = mp.getKey();
            int node = ds.findParent(mp.getValue());
            emailList.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (emailList.get(i).size() == 0) {
                continue;
            }

            Collections.sort(emailList.get(i));

            emailList.get(i).add(0, accounts.get(i).get(0));
            ans.add(emailList.get(i));
        }
        return ans;
    }
}
