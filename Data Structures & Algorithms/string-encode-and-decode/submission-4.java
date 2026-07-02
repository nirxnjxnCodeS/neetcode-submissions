class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String item : strs){
            sb.append(item.length());
            sb.append("#");
            sb.append(item);
        }
        String encoded_str = sb.toString();
        return encoded_str;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i<str.length()){
            //Step 1 : find the '#'
            int j = str.indexOf("#",i);

            //Step 2 : get the length (from i to j)
            int len = Integer.parseInt(str.substring(i,j));

            //Step 3 : extract the word
            String word = str.substring(j + 1, j + 1 + len);
            result.add(word);

            //Step 4 : move iteration forward
            i = j + 1 + len;
        }
        return result;
    }
}