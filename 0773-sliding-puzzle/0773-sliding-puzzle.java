class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        if (start.toString().equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        
        int[][] directions = {
            {1, 3},        
            {0, 2, 4},     
            {1, 5},        
            {0, 4},       
            {1, 3, 5},     
            {2, 4}         
        };
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return steps;
                }
                int zeroPos = current.indexOf('0');
                for (int nextPos : directions[zeroPos]) {
                    StringBuilder newConfig = new StringBuilder(current);
                    newConfig.setCharAt(zeroPos, current.charAt(nextPos));
                    newConfig.setCharAt(nextPos, '0');
                    
                    String newConfigStr = newConfig.toString();
                    
                    if (!visited.contains(newConfigStr)) {
                        visited.add(newConfigStr);
                        queue.offer(newConfigStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}