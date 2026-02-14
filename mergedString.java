class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int min = Math.min(word1.length(),word2.length());
        for(int i=0;i<min;i++){
            mergedString.append(word1.charAt(i));
            mergedString.append(word2.charAt(i));
        }  
        if(word1.length()>word2.length()){
            mergedString.append(word1.substring(word2.length()));
        }
        else{
            mergedString.append(word2.substring(word1.length()));
        }
        return mergedString.toString();
    }
}