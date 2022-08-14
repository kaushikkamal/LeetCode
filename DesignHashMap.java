// https://leetcode.com/problems/design-hashmap/

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignHashMap {
    class Info {
        int key;
        int value;

        Info() {
        }

        Info(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    ArrayList<LinkedList<Info>> list;
    int size = 100;

    public DesignHashMap() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<Info>());
        }
    }

    public int hash(int key) {
        return key % size;
    }

    public int search(int key) {
        int i = hash(key);

        LinkedList<Info> temp = list.get(i);

        int ans = -1;

        for (int j = 0; j < temp.size(); j++) {
            if (key == temp.get(j).key) {
                return j;
            }
        }
        return ans;
    }

    public void put(int key, int value) {
        int i = hash(key);
        if (search(key) != -1) {
            remove(key);
        }
        list.get(i).add(new Info(key, value));
    }

    public int get(int key) {
        int i = hash(key);
        int pos = search(key);

        if (pos == -1) {
            return -1;
        }
        return list.get(i).get(pos).value;
    }

    public void remove(int key) {
        int i = hash(key);

        if (search(key) == -1) {
            return;
        }

        list.get(i).removeIf(t -> t.key == key);
    }
}
