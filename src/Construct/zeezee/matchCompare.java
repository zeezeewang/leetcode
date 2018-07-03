package Construct.zeezee;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class matchCompare {

    private Map<Character, Character> pair;

    public matchCompare() {
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

    }

    /*public void addPair(Character bracketLeft,Character bracketRight){
        pair.put(bracketRight, bracketLeft);
    }*/

    public boolean isMatch(String s) {
        Stack<Character> sc = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (pair.containsValue(ch)) {
                sc.push(ch);
            } else if (pair.containsKey(ch)) {
                if (sc.empty()) {
                    return false;
                }
                if (sc.peek() == pair.get(ch)) {
                    sc.pop();
                } else {
                    return false;
                }
            }
        }
        return sc.empty();
    }

    public static void main(String[] args) {
        matchCompare mc = new matchCompare();
        System.out.println(mc.isMatch("(***)-[{-------}]"));
        System.out.println(mc.isMatch("(2+4)*a[5]"));
        System.out.println(mc.isMatch("({}[]]])"));
        System.out.println(mc.isMatch("())))"));
    }
}
