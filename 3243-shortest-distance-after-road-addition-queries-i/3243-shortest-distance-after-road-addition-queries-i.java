class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
                
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i <n; i++) {
            adj.add(new ArrayList<>());
            if(i!=0){        
                adj.get(i-1).add(i);
            }
        }
    
        int m=queries.length;
        int[] res=new int[m];
        for(int i=0; i<m; i++){
            int u=queries[i][0];
            int v=queries[i][1];
            adj.get(u).add(v);
            res[i]=bfs(adj, 0, n-1);
        }

        return res;
    }

    int bfs(List<List<Integer>> adj, int s, int e){ 
        int n=adj.size();
        Queue<Integer> que=new LinkedList();
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> parentMap = new HashMap<>();

        int cnt=0;
        que.add(s);   
        visited[s] = true;
        while(!que.isEmpty()){
            int curr=que.poll();

            if (curr == e) {
                return reconstructPath(parentMap, s, e);
            }

            for(int x:adj.get(curr)){
                if(!visited[x]){
                    que.add(x);   
                    visited[x] = true;
                    parentMap.put(x, curr);
                }      
            }

        }

        return 0;
    }



    int reconstructPath(Map<Integer, Integer> parentMap, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;
        
        while (current != start) {
            path.add(current);
            current = parentMap.get(current);
        }
        
        path.add(start);
        
        return path.size()-1;
    }
    

}