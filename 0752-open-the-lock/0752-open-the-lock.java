class Solution {
    public static List<String> generateCombinations(String lockCode) {
        List<String> combinations = new ArrayList<>(8); 
        for (int i = 0; i < 4; i++) {
            char[] digits = lockCode.toCharArray(); 
            char currentDigit = digits[i];           
            digits[i] = rotateDigit(currentDigit, 1); 
            combinations.add(new String(digits)); 
            digits[i] = rotateDigit(currentDigit, -1); 
            combinations.add(new String(digits)); 
        }
        return combinations; 
    }
    private static char rotateDigit(char digit, int offset) {
        int currentDigit = digit - '0'; // convert char to int
        int newDigit = (currentDigit + offset + 10) % 10; // apply rotation
        return (char) ('0' + newDigit); // convert back to char
    } 
	public static int openLock(String[] deadends, String target) {     
		HashSet<String> set = new HashSet<String>(Arrays.asList(deadends));
        if(set.contains("0000"))return -1;
        else if(target.equals("0000")) return 0;
		Queue<String> qqq = new LinkedList<String>();
		qqq.add("0000");
		HashSet<String> visited = new HashSet<String>();
		int level = 1;
		while(qqq.size()!=0)
		{
			int size = qqq.size();
			while(size!=0)
			{
				size--;
				String pooled = qqq.poll();
				List<String> possibles = generateCombinations(pooled);
				for (String pos : possibles) {
					if(visited.contains(pos) || set.contains(pos))continue;
					if(pos.equals(target)){
						return level;
					}else {
						visited.add(pos);
						qqq.add(pos);
					}
				}
			}
			level++;
		}
		return -1;
    }
}