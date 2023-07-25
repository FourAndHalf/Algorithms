import java.util.Stack;

public class validParanthesis {
    public static boolean isValidParanthesis(String s) {
        s = s.replaceAll("[^(){}\\[\\]]", "");
        Stack<Character> map = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(') {
                map.push(')');
            } else if(c == '{') {
                map.push('}');
            } else if(c == '[') {
                map.push(']');
            } else if(map.isEmpty() || map.pop() != c) {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}[asas]";

        System.out.println(isValidParanthesis(s));
    }    
}
