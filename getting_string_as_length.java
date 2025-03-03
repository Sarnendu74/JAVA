public class SubstringExample {
    public static void main(String[] args) {
        String text = "Hello";
        int substringLength = 3;

        for (int i = 0; i <= text.length() - substringLength; i++) {
            String sub = text.substring(i, i + substringLength);
            System.out.println(sub);
        }
    }
}