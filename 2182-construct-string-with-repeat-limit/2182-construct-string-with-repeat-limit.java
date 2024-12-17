class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] pr = pq.poll();
            int len = sb.length();
            int ct = 0;
            if(len > 0 && (sb.charAt(len-1) - 'a') == pr[0]) ct = countLast(sb);
            if(ct >= repeatLimit) {
                if(pq.isEmpty()) break;
                int[] next = pq.poll();
                sb.append((char)(next[0] + 'a'));
                next[1]--;
                if(next[1] > 0) pq.offer(next);
                pq.offer(pr);
            } else {
                int toAdd = Math.min(pr[1], repeatLimit - ct);
                for(int i = 0; i < toAdd; i++) {
                    sb.append((char)(pr[0] + 'a'));
                }
                pr[1] -= toAdd;
                if(pr[1] > 0) pq.offer(pr);
            }
        }
        
        return sb.toString();
    }
    
    private int countLast(StringBuilder sb) {
        int count = 1;
        int len = sb.length();
        for(int i = len-2; i >= 0; i--) {
            if(sb.charAt(i) != sb.charAt(len-1)) break;
            count++;
        }
        return count;
    }
}