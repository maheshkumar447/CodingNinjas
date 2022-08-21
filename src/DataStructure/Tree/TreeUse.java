package DataStructure.Tree;

import DataStructure.LinkedListDemo;
import DataStructure.Queue.QueueEmptyException;
import DataStructure.Queue.QueueUsingLL;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    static int a=0;

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        //added 1st level here
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode = queue.remove();

            if(frontNode == null)
            {
                if(queue.isEmpty())
                {
                    break;
                }

                a++;
                queue.add(null);
            }
            else
            {
                frontNode.data=a;
                for(int i=0;i<frontNode.children.size();i++)
                {
                    queue.add(frontNode.children.get(i));
                }


            }

        }



    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        // Write your code here

        if(root.children.size() == 0){
            return null;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> fl=root,sl=null;
        int data = 0;
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode = queue.poll();

            for(int i=0;i<frontNode.children.size();i++){
                queue.add(frontNode.children.get(i));
            }

            if(frontNode.data >  data){
                if(frontNode.data > fl.data){
                    sl = fl;
                    data = fl.data;
                    fl = frontNode;
                }
                else if (frontNode.data < fl.data){
                    sl = frontNode;
                    data = sl.data;
                }
            }
        }


        return sl;



    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

        // Write your code here

        if(root==null){
            return null;
        }
        int rootdata=Integer.MIN_VALUE;
        TreeNode<Integer> ansnode=null;
        if(root.data>n){
            rootdata=root.data;
            ansnode=root;
        }
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> childnode=findNextLargerNode(root.children.get(i),n);
            if(childnode!=null  )
            {
                int childdata=childnode.data;
                if(childdata>n && (childdata<rootdata || rootdata==Integer.MIN_VALUE)){
                    ansnode=childnode;
                    rootdata=childdata;
                }
            }
        }
        return ansnode;


    }




    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        // Write your code here
        if(root1==null || root2 ==null){
            return false;
        }

        if(root1.children.size()!=root2.children.size() ){
            return false;
        }

        boolean ans = true;

        for(int i=0 ;i<root1.children.size(); i++){
            int data1 = root1.children.get(i).data;

            for(int j = 0;j<root2.children.size();j++){
                int data2 = root2.children.get(i).data;

                if(data1!=data2){
                    ans = false;
                }
            }
        }

        return ans;

    }




    public static int max(TreeNode<Integer> root) {
        int maxsum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            maxsum = maxsum + root.children.get(i).data;
        }
        return maxsum;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        if(root==null){
            return null;
        }

        int rootsum=max(root);
        TreeNode<Integer> max=root;
        TreeNode<Integer> child;
        int childsum;
        for(int i=0;i<root.children.size();i++){
            child=maxSumNode(root.children.get(i));
            childsum=max(root.children.get(i));
            if(childsum>rootsum){
                max=child;
            }
        }
        return max;

    }




    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

        if(root == null){
            return false;
        }

        boolean ans = true;

        for(int i =0;i<root.children.size();i++){
            boolean check = checkIfContainsX(root.children.get(i),x);

            if(ans !=  check){
                ans = false;
            }
        }

        return ans;

    }


    public static void printPostOrder(TreeNode<Integer> root){
       if(root == null){
           return;
       }

        for(int i =0;i<root.children.size();i++){
            printPostOrder(root.children.get(i));
        }

        System.out.print(root.data + " ");

    }

    public static void preOrderTraversal(TreeNode<Integer> root){

        if(root == null){
            return;
        }

        System.out.println(root.data + " ");

        for(int i =0;i<root.children.size();i++){
            preOrderTraversal(root.children.get(i));
        }

    }

    public static int countLeafNodes(TreeNode<Integer> root){

        if(root == null){
            return 0;
        }

        if(root.children.size()==0){
            return 1;
        }
        int count = 0;
        for(int i =0;i<root.children.size();i++){
            count+=countLeafNodes(root.children.get(i));

        }

        return count;

    }


    public static void printAtDepthK(TreeNode<Integer> root , int k){
        if (k<0){
            return;
        }

        if(k==0){
            System.out.println(root.data);
            return;
        }

        for(int i =0;i<root.children.size();i++){
            printAtDepthK(root.children.get(i),k-1);
        }
    }

    public static int getHeight(TreeNode<Integer> root){
       if(root == null){
           return  0;
       }

       int count = 0;
        int hgt = 0;
        for(int i  =0 ;i<root.children.size();i++){

           hgt = getHeight(root.children.get(i));

           if(hgt>count){
               count = hgt;
           }

       }


        return count+1;

    }


    public static int numNodeGreater(TreeNode<Integer> root,int x){

        if(root == null){
            return 0;
        }

        int count = 0;
        if(root.data > x){
            count++;
        }

        for(int i =0 ;i<root.children.size();i++){
                count = count + numNodeGreater(root.children.get(i),x);
            }

        return count;


    }

    public static int largestNode(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int ans = root.data;
        for(int i =0;i<root.children.size();i++){
            int childLargest = largestNode(root.children.get(i));

            if(childLargest > ans){
                ans = childLargest;
            }
        }

        return ans;
    }

    public static int sumOfAllNode(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int sum = root.data;
        for(int i = 0 ;i<root.children.size();i++){
            sum = sum + sumOfAllNode(root.children.get(i));
        }

        return sum;


    }

    public static int numNodes(TreeNode<Integer> root){

        if(root == null){  // ye base case nhi h ye edge case h , base case hmara loop me hee aa chuka h
            return 0;
        }

        int count =1;
        for(int i =0;i<root.children.size();i++){
            count = count + numNodes(root.children.get(i));
        }
        return count;

    }


    public static TreeNode<Integer> takeInput(Scanner sc){
        // phle root ka data puchnege phir user se puchenge ki kitne children h is root k
        // maanlo user ne kaha ki teen children h to hum teen baar takeInput call kreneg or mujhe teeno children ka data mil jayega (teen baar call krna mtlb use of recursion)
        int n;

        System.out.println("Enter next node data");
        n = sc.nextInt(); // ye root ka data hoga
        TreeNode <Integer> root = new TreeNode<Integer>(n);
        System.out.println("Enter number of children for " + n);
        int childCount = sc.nextInt();
        for(int i =0;i<childCount;i++){
            TreeNode<Integer> child = takeInput(sc);
            // ab ye yahan tk input b le liya children or root dono ka or ab link krna h child nodes ko
            root.children.add(child); // saare children add krdiye
        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + ":";
        for(int i =0;i<root.children.size();i++){  // root k har child tk jana h
            s = s+root.children.get(i).data+",";  // har child k data ko fetch krna h or append krna h with comma

        }

        System.out.println(s);

        for(int i =0;i<root.children.size();i++){
            print(root.children.get(i));
        }
    }

    public static void printLevelWise(TreeNode<Integer> root) {
//        Queue<TreeNode<Integer>> q = new LinkedList<>();
//        q.add(root);
//        q.add(null);
//        while(!q.isEmpty()){
//            TreeNode<Integer> frontNode = q.remove();
//            if(frontNode==null){
//                if(q.isEmpty()){
//                    break;
//                }
//                System.out.println();
//                q.add(null);
//            }
//            else{
//                System.out.print(frontNode.data + " ");
//                for(int i=0;i<frontNode.children.size();i++){
//                    q.add(frontNode.children.get(i));
//                }
//
//            }
//        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode<Integer> frontNode = q.remove();
            if (frontNode == null) {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println();
                q.add(null);
            } else {
                System.out.println(frontNode.data + " ");
                for (int i = 0; i < frontNode.children.size(); i++) {
                    q.add(frontNode.children.get(i));
                }
            }
        }
    }



    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter root data: ");
        int rootData = sc.nextInt();
        // abhi hum iske children nhi puch rhe....blki ek queue bna rhe h
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer>  root  = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        // jb tk nodes khali nhi ho jati tb tk kaam krenge mtlb element lo or uske child lo or nikalo vgera vgera ye kaam
        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue(); // mtlb phle wali node nikalte jao // ye line error de rhi thi isiliye hmne try catch me surround kiya h ise but wo error kbhi aayega nhi
                System.out.println("Enter number of children of " + frontNode.data); // jo uper node li h iske kitne children honge
                int numChildren = sc.nextInt(); // user se puch liye ki kitne child h
                for(int i =0;i<numChildren;i++){
                    System.out.println("Enter " + (i+1) + " th child of " +frontNode.data); // yahan wo har child k liye data mangega ki 1th chila ka data btao aise hee 2th ka and so on jitne b user btayega ki is particular node k itne chila h
                    int child = sc.nextInt(); // yahan actually pucha h user se data
                    TreeNode<Integer> childNode = new TreeNode<>(child);  // jo user se input liye unko node bnado
                    frontNode.children.add(childNode); // frontNode or childNode ko connect hi kiya tha to wo connect krdiye
                    pendingNodes.enqueue(childNode);  // pendingNodes me b childNode fill krdiya kyunki abhi hmne usse ye nhi oucha h ki tumahre kitne child h
                }
            } catch (QueueEmptyException e) {
                // shouldn't come here
                return  null;
            }

        }
        return root;
    }

    public static void main(String[] args) {

      /*

        // Node bnao
        TreeNode<Integer> root  = new TreeNode<>(4);
        TreeNode<Integer> node1  = new TreeNode<>(2);
        TreeNode<Integer> node2  = new TreeNode<>(3);
        TreeNode<Integer> node3  = new TreeNode<>(5);
        TreeNode<Integer> node4  = new TreeNode<>(6);
        //abhi tk hmne saari nodes ko individual bnaya h mtlb saari nodes bn to gyi pr ek dusre se Link nhi h

        // ab link kro by using niche wali line
        root.children.add(node1); // mtlb root k pass jo arrayList thi usme node1 add krdi mtlb node1 ab child node ho gyi root ki
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);// ye tb jb hme kisi node k further children bnane ho

        System.out.println(root);

       */



        // user se input lena ho tb
        Scanner sc = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(sc);  // uncomment this when u don't take want to take input levelwise
        TreeNode<Integer> root = takeInputLevelWise(); // executes when u want to take input levelwise

//        print(root);
        printLevelWise(root);
    }
}
