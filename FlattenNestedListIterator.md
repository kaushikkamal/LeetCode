https://leetcode.com/problems/flatten-nested-list-iterator/

    public class NestedIterator implements Iterator<Integer> {

        private Queue<Integer> q = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            helper(nestedList);
        }

        public void helper(List<NestedInteger> nestedList) {
            if (nestedList == null) {
                return;
            }

            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    q.offer(ni.getInteger());
                } else {
                    helper(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return q.poll();
            } else {
                return -1;
            }
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

