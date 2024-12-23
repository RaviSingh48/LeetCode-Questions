class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int swaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                values.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            swaps += countSwaps(values);
        }
        return swaps;
    }

    private int countSwaps(List<Integer> values) {
        int swaps = 0;
        List<Integer> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            indexMap.put(values.get(i), i);
        }

        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i).equals(sorted.get(i))) {
                swaps++;
                int existingPos = indexMap.get(sorted.get(i));
                indexMap.put(values.get(i), existingPos);
                indexMap.put(sorted.get(i), i);
                Collections.swap(values, i, existingPos);
            }
        }
        return swaps;
    }
}