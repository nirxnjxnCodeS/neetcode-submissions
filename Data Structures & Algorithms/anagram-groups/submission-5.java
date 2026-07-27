class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            int[] freq = new int[26];

            for (int j = 0; j < word.length(); j++) {

                char c = word.charAt(j);

                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            if (!map.containsKey(key)) {

                map.put(key, new ArrayList<String>());
            }

            List<String> list = map.get(key);

            list.add(word);
        }

        List<List<String>> result = new ArrayList<List<String>>(map.values());

        return result;
    }
}