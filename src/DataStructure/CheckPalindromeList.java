package DataStructure;

public class CheckPalindromeList {

    public static boolean isPalindrome(NodeLL<Integer> head) {
        //Your code goes here
        if(head == null)
            return true;

        NodeLL p = head;
        NodeLL prev =new NodeLL(head.data);

        while(p.next != null){
            NodeLL temp =new NodeLL(p.next.data);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        NodeLL p1 = head;
        NodeLL p2 = prev;

        while(p1!=null){
            if(p1.data != p2.data)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
