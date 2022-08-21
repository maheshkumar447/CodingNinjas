package DataStructure.Stack;

import DataStructure.NodeLL;

public class StackUsingLL<T> {

    private NodeLL<T> head;

    private int size; // stack ka size
    // jb b kuch dalenge stack me to size++ or jb b juch nikalenge to size--
    // hmne dono variables ko private bnaya h taaki koi b access na kr ske

    public StackUsingLL(){
        head= null;
        size = 0;
    }
    int size(){
        return size;
    }

//    T top(){ // hum sirf top ki value btayenge na ki ye ki top pe konsi node rkhi h
//    if(head == null){
//        return -1;
//    }

////        return head.data;  // ye sahi h bs vaise hee comment kr rkha h
//    }

    boolean isEmpty(){
        return (size() == 0);
    }

    void push(T element){
//        Node temp = new Node(element);
//        temp.next = head;
//        head = temp;
//        size++;
    }
//    T pop(){ // return type jo pop krna h wo element
////        if(head == null){
////            return -1;
////        }
////        int temp = head.data;
////        head = head.next;
////        size--;
////        return temp;
//    }





}
