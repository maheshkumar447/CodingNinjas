package DataStructure;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add(10);
        list1.add(20);
        list1.add(25);
        list1.add(2,50);
        System.out.println(list1.size());
        System.out.println(list1.get(2));

        for(int i =0;i<list1.size();i++ ){
            System.out.print(list1.get(i) + " ");
        }


        list1.remove(1);
        System.out.println();
        for(int i =0;i<list1.size();i++ ){
            System.out.print(list1.get(i) + " ");
        }

        list1.set(1,75);
        System.out.println();
        for(int i =0;i<list1.size();i++ ){
            System.out.print(list1.get(i) + " ");
        }

//        System.out.println(list1.get(5));   this is errorneous i.e. index out of bound exception

        System.out.println();
        for(int element:list1){
            System.out.print(element+" ");
        }

    }
}
