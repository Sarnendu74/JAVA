class Co {
    public static void main(String[] args) {
        String str = "I worrrk ignittte";
        String s = "";  
        int count = 1;  

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;  // Increment count for consecutive characters
            } else {
                s += str.charAt(i);  // Append character
                
                if (count > 1) {
                    s += count;  // Append count if there were consecutive occurrences
                }
                
                count = 1;  // Reset count for next character sequence
            }
        }
        
        System.out.println(s);
    }
}
