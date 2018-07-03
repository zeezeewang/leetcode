package construct.zeezee;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("bc");
        list.add("abc");
        list.add("abc");
        list.add("abc");
        list.add("bc");
        System.out.println(list);

        /*for(int i = list.size() - 1; i > 0; i--){
            if(list.get(i).equals("abc")){
                list.remove(list.get(i));
            }
        }*/

        for(int j = 0;j < list.size(); j++){
            if(list.get(j).equals("abc")){
                list.remove(list.get(j));
                j--;

            }
        }

        System.out.println(list);
    }
}