package construct.zeezee;

import java.util.ArrayList;
import java.util.Random;

public class Test3 {
    public static void main(String[] args){
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        while(list.size() < 5){
            list.add((int)(r.nextInt(10) + 1));
        }
        System.out.println(list);

        for(int i = 0; i < list.size() -1; i++){
            for(int j = 0; j < list.size() - 1 - i;j++){
                if(list.get(j) > list.get(j + 1)){
                    int s = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, s);
                }
            }
        }
        System.out.println(list);
    }
}
