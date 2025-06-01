import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and process each line until end-of-file (EOF)
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (isBalanced(line)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

        sc.close();
    }

    // Function to check if the input string has balanced brackets
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for corresponding opening bracket
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            // Ignore all other characters
        }

        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }
}
