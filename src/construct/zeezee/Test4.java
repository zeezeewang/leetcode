package construct.zeezee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args){

        String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] color = {"红桃","黑桃","方片","梅花"};
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> list  = new ArrayList<>();
        int index = 0;
        for(String s1 : num){
            for(String s2 : color){
                hm.put(index, s2.concat(s1));
                list.add(index);
                index++;
            }
        }
        hm.put(index, "大鬼");
        list.add(index);
        index++;
        hm.put(index, "小鬼");
        list.add(index);

        Collections.shuffle(list);

        TreeSet<Integer> aaa = new TreeSet<>();
        TreeSet<Integer> bbb = new TreeSet<>();
        TreeSet<Integer> me = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();
        for(int i = 0; i < list.size(); i++){
            if(i >= list.size() - 3){
                dipai.add(list.get(i));
            }else if(i % 3 == 0){
                aaa.add(list.get(i));
            }else if(i % 3 == 1){
                bbb.add(list.get(i));
            }else{
                me.add(list.get(i));
            }

        }
        lookPoker(hm, aaa, "嗷嗷");
        lookPoker(hm, bbb, "宝宝");
        lookPoker(hm, me, "我");
        lookPoker(hm, dipai, "底牌");

     }
    public static void lookPoker(HashMap<Integer, String> hm, TreeSet<Integer> ts,String name){
        System.out.print(name + "的牌是：");
        for(Integer i : ts){
            System.out.print(hm.get(i) + "  ");
        }
        System.out.println();
    }
}
