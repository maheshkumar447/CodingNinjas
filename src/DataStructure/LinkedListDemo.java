package DataStructure;

import java.util.Scanner;

public class LinkedListDemo {

    public static void reverseLinkedList (NodeLL<Integer> head){
//        NodeLL<Integer> temp = head;

        if(head == null){
            return;
        }

        reverseLinkedList(head.next);
        System.out.print(head.data + " ");
    }

    public static NodeLL<Integer> insert (NodeLL<Integer> head, int data , int pos){
        NodeLL<Integer> newNode = new NodeLL<>(data);
        if(pos == 0){
            newNode.next = head;
            return newNode;

        }
        int i =0;
        NodeLL<Integer> temp = head;
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;

    }


    public static NodeLL<Integer> takeInput(){

        NodeLL<Integer> head = null , tail = null;  // ye tail hmne liya kyunki time complexity hmari ja rhi thi n*n ki
        // to hum last node ka refrnce bhi rkh lenge jo ki tail hmare liye krega or jisse hoga ye ki hme baar baar traverse nhi krni pdegi puri list

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        while(data != -1){
            NodeLL<Integer> newNode = new NodeLL<>(data); // jo user data dega usko node me convert kiya

            if(head == null){
                head = newNode;  // shuru me jb head null tha or hmne ek node bnadi to ab head us node ko point krega jo hmne ab bnayi thi
                tail = newNode;  // shuru me to head b null hee hota h or tail b null hee hoga
            }else{
                // yahan hum wo case consider kr rhe h jb hmari linked list empty nhi h
                // to hmne kya krna h
                // hmne last elemnt tk jana h or uske next me node ko inser krna h

//                NodeLL<Integer> temp = head;  // first node se start kra traverse krna or first node ka refernce head k pass h hee
//                while(temp.next != null){  // loop chlaya , jb tk temp null tk nhi jata tb tk
//                    temp = temp.next; // temp ek ek step aage bdh rha h
//                }
//                temp.next = newNode;  // temp k next me wo jo node input li h wo attach krdi

                // ye uper jo 4...5 line comment kr rkhi h wo tb k liye h jb hm tail nhi le rhe the ...agar tail h hamre pass to traverse krna hee kyu h

                tail.next = newNode;  // jb hmare pass tail h to direct usi k next me enter krdo ....kaam khtm
                tail = newNode; // tail = tail.next; ye b likha ja skta h yahan pr
                // yahan pr hmne ye isiliye kiya kyunki jb hmne tail k next pr kuch insert krdiya to
                // to tail b to update hona chyiea taaki hme agar or elmnt insert krne ho to hum kr ske...isiliye tail ko b update kr diya

                // ab tail lene se time complexity ho gyi O(n) ...jo ki sahi h

            }
            data = sc.nextInt();  // hmne user se phir se input liya data
        }
        return head;  // first node return krni h to hum first node ka refernce ka return kr denge



    }

    public static void print(NodeLL<Integer> head){

        NodeLL<Integer> temp = null;

        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
        head = temp;
//        while(head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//        ye commented kaam ka nhi h kyunki dusri baari tk head null ho chuka hota h
        //agar 2 baar print krwana chahte ho to see commented ines with four slashes in this function
        }

    public static void main(String[] args) {

        NodeLL<Integer> head = takeInput();

//        head = insert(head,80,3);

        print(head);

        reverseLinkedList(head);


//        NodeLL<Integer> node1 = new NodeLL<Integer>(10);// yqhan hmne size dena pda bcz of hmne constructor bnaya h
//        System.out.println(node1.data);
//        System.out.println(node1.next);
//
//        NodeLL<Integer> node2 = new NodeLL<Integer>(20);
//
//        // node1 me b data ki jagah 10 aaya or refernce ki jagah null or aise hee node2 me data ki jagah 20 or refernce ki jagah null hee h
//        // but hum chchte h ki hum inko link krde i.e. inke beech me link bnade to kaise bnega
//
//        node1.next = node2;
////        System.out.println(node2);
////        System.out.println(node1.next);
//
//        NodeLL<Integer> node3 = new NodeLL<Integer>(30);
//        node2.next = node3;
//
//
//        // to store head node of linked list
//        NodeLL<Integer> head = node1; // head is just a reference to first node
//
//        while(head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//
//        print(head);

    }
}
