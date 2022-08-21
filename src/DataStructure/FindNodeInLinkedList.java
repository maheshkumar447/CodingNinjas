package DataStructure;

public class FindNodeInLinkedList {

    public static int findNode(NodeLL<Integer> head, int n) {
        NodeLL<Integer> temp = head;
        int count = 0;
        if(head == null){
            return -1;
        }

        else if(temp.data == n){
            return 0;
        }

        NodeLL<Integer> temp1 = head;

        while(temp!=null){
            if(temp.data != n){
                temp = temp.next;
                count++;
            }else{
                return count;
            }
        }
        return -1;
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

        int ans = findNode(node1, 5);
        System.out.println(ans);
    }
}
