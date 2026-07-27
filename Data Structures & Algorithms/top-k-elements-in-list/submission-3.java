public class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (count.containsKey(num)) {

                int frequency = count.get(num);

                count.put(num, frequency + 1);

            } else {

                count.put(num, 1);
            }
        }

        // Step 2: Create buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        // Step 3: Put each number into its frequency bucket
        List<Map.Entry<Integer, Integer>> entries =
                new ArrayList<Map.Entry<Integer, Integer>>(count.entrySet());

        for (int i = 0; i < entries.size(); i++) {

            Map.Entry<Integer, Integer> entry = entries.get(i);

            int number = entry.getKey();

            int frequency = entry.getValue();

            if (buckets[frequency] == null) {

                buckets[frequency] = new ArrayList<Integer>();
            }

            buckets[frequency].add(number);
        }

        // Step 4: Collect the top k frequent numbers
        int[] result = new int[k];

        int index = 0;

        for (int frequency = buckets.length - 1; frequency >= 0; frequency--) {

            if (buckets[frequency] != null) {

                for (int j = 0; j < buckets[frequency].size(); j++) {

                    result[index] = buckets[frequency].get(j);

                    index++;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}