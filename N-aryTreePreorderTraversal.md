https://leetcode.com/problems/n-ary-tree-preorder-traversal/

# Recursive

    private void order(Node root, List<Integer> ans) {
        if(root == null) {
            return;
        }
        
        ans.add(root.val);
        
        for(Node temp: root.children) {
            order(temp, ans);
        }        
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        
        order(root, ans);
        
        return ans;
    }

# Iterative

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            ans.add(temp.val);
            
            for(int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }
        
        return ans;
    }