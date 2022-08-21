package DataStructure;

public class DeleteNodeInLinkedList {

    public static NodeLL<Integer> deleteNode(NodeLL<Integer> head, int pos) {
        // Write your code here.
        NodeLL<Integer> temp = head;
        if(temp == null){
            return temp;
        }

        if(pos == 0){
            temp = temp.next;
            return temp;
        }
        else {
            int i =0;
            while (i < pos - 1 && temp != null) {
                temp = temp.next;
                i++;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
        }
            return head;




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

        NodeLL<Integer> head = deleteNode(node1,3);

        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
