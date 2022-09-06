https://leetcode.com/problems/n-ary-tree-level-order-traversal/

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        if(root == null) {
            return ans;
        }
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = q.size();
            
            while(size-- > 0) {
                Node temp = q.poll();
                levelList.add(temp.val);
                
                for(Node eachNode : temp.children) {
                    q.offer(eachNode);
                }
            }
            ans.add(levelList);
        }
        return ans;
    }