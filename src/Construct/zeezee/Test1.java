package Construct.zeezee;

import java.util.HashMap;

public class Test1 {
    public static void main(String[] args){
        String s = "aaaaaaaaaabbbsddddssedfffsdedesesd";
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(Character cha : arr){
            /*if(!hashmap.containsKey(cha)){
                hashmap.put(cha, 1);
            }else {
                hashmap.put(cha, hashmap.get(cha) + 1 );
            }*/

            hashmap.put(cha, !hashmap.containsKey(cha)? 1 : hashmap.get(cha) + 1);
        }
        for(Character key : hashmap.keySet()){
            System.out.print(key + "=" + hashmap.get(key) + "   ");
        }
    }
}
