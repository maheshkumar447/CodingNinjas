package DataStructure;

public class LengthOfLinkedList {

    public static int length(NodeLL<Integer> head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;

        }
        return count;
    }

    public static void printIthNode(NodeLL<Integer> head, int i){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
            if(count == i){
                System.out.println(head.data);
                break;
            }

        }

    }

    public static void main(String[] args) {
        NodeLL<Integer> node1 = new NodeLL<>(3);
        NodeLL<Integer> node2 = new NodeLL<>(4);
        NodeLL<Integer> node3 = new NodeLL<>(5);
        NodeLL<Integer> node4 = new NodeLL<>(2);
        NodeLL<Integer> node5 = new NodeLL<>(6);
        NodeLL<Integer> node6 = new NodeLL<>(1);
        NodeLL<Integer> node7 = new NodeLL<>(9);
//        NodeLL<Integer> node8 = new NodeLL<>(-1);



        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;

        int ans = length(node1);
        System.out.println(ans);

        printIthNode(node1,3);
    }
}
