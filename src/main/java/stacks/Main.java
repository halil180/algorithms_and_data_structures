package stacks;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());//true
        stack.push("GTA 6");
        stack.push("Last of us 3");
        stack.push("Fifa 2027");
        System.out.println(stack.isEmpty());//false
        String worstGameEver = stack.pop();// Fifa 2027
        System.out.println(worstGameEver); // :)
        System.out.println(stack);//[GTA 6, Last of us 3]
        System.out.println(stack.peek());// Last of us 3
    }
}
