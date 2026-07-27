class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Count frequency of each letter
            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Convert frequency array to a String key
            String key = Arrays.toString(freq);

            // Create list if key doesn't exist, then add word
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}