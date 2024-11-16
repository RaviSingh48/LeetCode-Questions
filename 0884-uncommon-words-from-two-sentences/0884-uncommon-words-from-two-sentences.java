class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        return Arrays.stream((s1 + " " + s2).split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}