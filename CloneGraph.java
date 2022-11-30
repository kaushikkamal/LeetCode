// https://leetcode.com/problems/clone-graph/

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node clone(Node cur, HashMap<Node, Node> map) {
        List<Node> neighbors = new ArrayList<>();
        Node cloneNode = new Node(cur.val);
        map.put(cur, cloneNode);

        for (Node adjNode : cur.neighbors) {
            if (map.containsKey(adjNode)) {
                neighbors.add(map.get(adjNode)); // cloned version of adjacent node
            } else {
                Node neighbourNode = clone(adjNode, map);
                neighbors.add(neighbourNode);
            }
        }
        cloneNode.neighbors = neighbors;
        return cloneNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }
}
