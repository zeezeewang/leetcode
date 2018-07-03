package Construct.zeezee;

import java.util.Stack;

public class Test5 {
   public static void main(String[] args){
       Character[] cha = {};
       Stack<Character> s = new Stack<Character>();
       for(int i = 0; i < cha.length; i++){
           if(cha[i].equals("(")){
               s.push(cha[i]);
               continue;
           }if(cha[i].equals(")")){
               if(s.isEmpty()){
                   System.out.println("不匹配");
               }if(s.pop().equals(cha[i])){
                   System.out.println("不匹配");
               }
           }
       }
       if(s.isEmpty()){
           System.out.println("匹配成功");
       }else{
           System.out.println("不匹配");
       }


   }

}
