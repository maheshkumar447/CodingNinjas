package DataStructure;

public class AppendLastNNodeToFirst {

    public static NodeLL<Integer> appendLastNToFirst(NodeLL<Integer> head, int n) {
//        NodeLL<Integer> temp = head;
//
//        if(temp == null){
//            return null;
//        }
//
//        if(n==0){
//            return temp;
//        }
//        else{
//            int i =0;
//            while(temp!=null){
//                temp = temp.next;
//                i++;
//            }
//            int remaining = i-n;
//            NodeLL<Integer> temp1 = head;
//            int c = 0;
//            while(c<remaining){
//                temp1 = temp1.next;
//                c++;
//            }
//            NodeLL<Integer> newhead = temp1;
//            NodeLL<Integer> temp2 = newhead;
//
//            while(temp2 != null){
//                temp2 = temp2.next;
//            }
//            temp2.next = head;
//
//            NodeLL<Integer> temp3 = head;
//            int c1 =  0;
//            while(c1 <remaining-1){
//                temp3 = temp3.next;
//                c1++;
//            }
//            temp3.next = null;
//            return newhead;


        int totalelements = 0;
        NodeLL<Integer> count =head;
        if(head==null)
        {
            return null;
        }
        if(n==0)
        {
            return count;
        }
        while(count!=null)
        {
            totalelements++;
            count=count.next;
        }
        int sub = totalelements-n; //5-3=2
        NodeLL<Integer> nh = head;
        int c=0;
        while(c<sub)
        {
            c++;
            nh=nh.next;
        }
        NodeLL<Integer> newhead = nh;

        NodeLL<Integer> prev = newhead;
        while(prev.next!=null)
        {
            prev=prev.next;
        }
        prev.next = head;

        NodeLL<Integer> br = head;
        int co = 0;
        while(co<sub-1)
        {
            co++;
            br = br.next;
        }
        br.next=null;

        return newhead;

        }


    public static void main(String[] args) {

        NodeLL<Integer> node1 = new NodeLL<>(3);
        NodeLL<Integer> node2 = new NodeLL<>(4);
        NodeLL<Integer> node3 = new NodeLL<>(5);
        NodeLL<Integer> node4 = new NodeLL<>(2);
        NodeLL<Integer> node5 = new NodeLL<>(6);
        NodeLL<Integer> node6 = new NodeLL<>(1);
        NodeLL<Integer> node7 = new NodeLL<>(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        NodeLL<Integer> head = appendLastNToFirst(node1,4);
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
