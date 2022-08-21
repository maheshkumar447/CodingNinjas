package DataStructure.Tree;

import DataStructure.Queue.QueueEmptyException;
import DataStructure.Queue.QueueUsingLL;

import java.util.*;

public class BinaryTreeUse {

    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data){

        if(root == null){  // root hee nhi h to return null
            return null;
        }

        if(root.data == data){  // hme jo data given h wo root pr hee mil gya to simple root hee return hogi arraylist me add hoke
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);

            return output;
        }

        ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);  // root pr data nhi mila to left me dhundenge
        if(leftOutput != null){ // left subtree se not null arraylist mili mtlb left side hee hmara data h
            leftOutput.add(root.data);  // root k data ko add kiya arraylist me
            return leftOutput;  // or wo list return krwa di
        }

        // same all thing done with right subtree, agar left subtree me data nhi mila to
        ArrayList<Integer> rightOutput = getRootToNodePath(root.right,data);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }else{  // ye case wo case h jb na to root me data mila na left me na right me mtlb hme jo data given h wo h he nhi tree me to return null
            return null;
        }


    }






    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        if( root.left!=null &&  root.right==null )
            System.out.print(root.left.data + " ");

        if( root.left==null &&  root.right!=null )
            System.out.print(root.right.data + " ");


        printNodesWithoutSibling(root.left);

        printNodesWithoutSibling(root.right);
    }






    public static void printZigZag(BinaryTreeNode<Integer> root){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Stack<BinaryTreeNode<Integer>> s1 = new Stack<BinaryTreeNode<Integer>>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<BinaryTreeNode<Integer>>();

        s1.push(root);
        s2.push(root);
        while(!s1.empty() && !s2.empty()){
            BinaryTreeNode<Integer> pp = s2.pop();
            while(!s1.empty()){
                if(s1.peek().left != null){
                    s2.push(s1.peek().left);
                }
                if(s1.peek().right != null){
                    s2.push(s1.peek().right);
                }
                System.out.print(s1.pop().data+" ");
            }
            System.out.println();

            while(!s2.empty()){
                if(s2.peek().right != null){
                    s1.push(s2.peek().right);
                }
                if(s2.peek().left != null){
                    s1.push(s2.peek().left);
                }
                System.out.print(s2.pop().data+" ");
            }
            System.out.println();
            s2.push(root);
        }


    }








    public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root==null)
            return null;

        if(root.right==null && root.left==null)
            return null;

        BinaryTreeNode<Integer> left= removeAllLeaves(root.left);
        BinaryTreeNode<Integer> right =   removeAllLeaves(root.right);

        if(left==null)
            root.left=null;


        if(right==null)
            root.right=null;


        return root;
    }







    public static void printLevelWiseAssignmentQuestion(BinaryTreeNode<Integer> root) {
        //Your code goes here
//        QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
//        QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();
//
//        primary.enqueue(root);
//
//        while(!primary.isEmpty())
//        {
//            BinaryTreeNode<Integer> current=null;
//            try {
//                current = primary.dequeue();
//            } catch (QueueEmptyException e) {
//                System.out.println("Not possible");
//            }
//
//            System.out.print(current.data + " ");
//
//            if(current.left != null)
//            {
//                secondary.enqueue(current.left);
//            }
//
//            if(current.right != null)
//            {
//                secondary.enqueue(current.right);
//            }
//
//            if(primary.isEmpty())
//            {
//                QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
//                secondary = primary;
//                primary = temp;
//                System.out.println();
//            }
//        }







    }







    public static boolean checkBalanced(BinaryTreeNode<Integer> root) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */


        if(root == null)
        {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight)>1)
        {
            return false;
        }

        boolean isLeftBalanced = checkBalanced(root.left);
        boolean isRightBalanced = checkBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }









    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here.
        if(root == null){
            return 0;
        }


       int  sum =root.data;

       sum+=getSum(root.left) + getSum(root.right);
        return sum;
    }






    public static BinaryTreeNode<Integer> buildTreehelper1(int[] postOrder, int[] inOrder, int startOfInorder, int endOfInorder, int startOfPostorder, int endOfPostorder){

        if(startOfInorder > endOfInorder){
            return null;
        }

        int root = postOrder[endOfPostorder];
        BinaryTreeNode<Integer> ans = new BinaryTreeNode<>(root);

        int index =-1;
        for(int i =0;i<inOrder.length;i++){
            if(inOrder[i] == root){
                index = i;
                break;
            }
        }
        if(index == -1){
            return null;
        }

        int leftInorderStartIndex = startOfInorder;
        int leftInorderEndIndex = index - 1;
        int leftPostorderStartIndex = startOfPostorder;
        int leftPostorderEndIndex = leftInorderEndIndex - leftInorderStartIndex + leftPostorderStartIndex;

        int rightInorderStartIndex = index +1 ;
        int rightInorderEndIndex = endOfInorder;
        int rightPostorderStartIndex =leftPostorderEndIndex +1;
        int rightPostorderEndIndex = endOfPostorder-1;

        ans.left = buildTreehelper1(postOrder,inOrder,leftInorderStartIndex,leftInorderEndIndex,leftPostorderStartIndex,leftPostorderEndIndex);
        ans.right = buildTreehelper1(postOrder,inOrder,rightInorderStartIndex,rightInorderEndIndex,rightPostorderStartIndex,rightPostorderEndIndex);

        return ans;


    }

    public static BinaryTreeNode<Integer> buildTree1(int[] postOrder, int[] inOrder) {
        //Your code goes here
       return  buildTreehelper1( postOrder, inOrder,0,inOrder.length-1,0,postOrder.length-1);
    }






    public static BinaryTreeNode<Integer> helperOfbuildTree(int[] preOrder, int[] inOrder,  int startOfInOrder, int endOfInOrder,int startOfPreOrder, int endOfPreOrder){
        
        if(startOfInOrder > endOfInOrder){  // mtlb startIndex bda ho endIndex se that means array null h
            return null;
        }

        int root = preOrder[startOfPreOrder];
        BinaryTreeNode<Integer> ans = new BinaryTreeNode<>(root);

        int index = -1;
        for(int i =0;i<inOrder.length;i++){
            if(inOrder[i] == root){
                index = i;
                break;
            }
        }
        if(index == -1){
            return null;
        }

        int leftInorderStartIndex = startOfInOrder;
        int leftInorderEndIndex = index-1;
        int leftPreorderStartIndex = startOfPreOrder+1;
        int leftPreorderEndIndex = leftPreorderStartIndex + leftInorderEndIndex - leftInorderStartIndex;  // niche equation h usse ye result aa jayega
        // leftPreorderEnd - leftPreorderStart = leftInorderEnd - leftInorderStart ......kyunnki length to same hee rhegi chahe traversal kaise b hua ho


        int rightInorderStartIndex  = index +1;
        int rightInorderEndIndex = endOfInOrder;
        int rightPreorderStartIndex = leftPreorderEndIndex + 1;
        int rightPreorderEndIndex = endOfPreOrder;

        ans.left = helperOfbuildTree(preOrder,inOrder,leftInorderStartIndex,leftInorderEndIndex,leftPreorderStartIndex,leftPreorderEndIndex);
        ans.right = helperOfbuildTree(preOrder, inOrder,rightInorderStartIndex,rightInorderEndIndex,rightPreorderStartIndex,rightPreorderEndIndex);

        return ans;

        
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        //Your code goes here
       return  helperOfbuildTree(preOrder, inOrder, 0,preOrder.length-1,0,inOrder.length-1);
    }







    public static void postOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }







    public static void preOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }








    public static void inorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }








    public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){  //ye pair class hmne bnayi h or wo generic type ki h , hmne yahan integer, integer le liye dono height as well as diameter
        if(root==null){
            Pair<Integer,Integer> output = new Pair<>();
            output.first = 0; // dono 0 , 0 set krdiye kyunki tree h hee nhi  or pair hee return krwana h to do cheese chyiea hongi return krwane k liye b
            output.second = 0;

            return output;
        }

        Pair<Integer,Integer> leftOutput = heightDiameter(root.left);  // ab recursion ka use krke hmne left se cheese nikali or hme cheese kitni chyiea 2 i.e. height or diameter
        Pair<Integer,Integer> rightOutput = heightDiameter(root.right); // same with right subtree

        // but i want overall height and overall diameter
        int height =  1 + Math.max(leftOutput.first,rightOutput.first); // mtlb left subtree ki height or right subtree ki height ka max

        // for diameter we have 3 options as we discuss earlier
        int option1 = leftOutput.first + rightOutput.first; // mtlb left output ki height or right output ki height
        int option2 = leftOutput.second; // diameter of left subtree
        int option3 = rightOutput.second; // diameter of right subtree
        int diameter = Math.max(option1,Math.max(option2,option3));

        // ab baari h return krwane ki, return krwayenge 2 cheese
        Pair<Integer,Integer> output = new Pair<>();
        output.first  =height;
        output.second =diameter;

        return output;
    }





    public static int diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        // ye teen option kaise h iski description notebook me likhi hui h
        int option1 = height(root.left) + height(root.right);

        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        int ans = Math.max(option1, Math.max(option2,option3));

        return ans;
    }





    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }
            BinaryTreeNode<Integer> temp = root.right;
            root.right = root.left;
            root.left = temp;

            mirrorBinaryTree(root.left);
            mirrorBinaryTree(root.right);

    }








    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here

        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);


        /*
        if (root==null)
            return 0;

        int left=height(root.left),right=height(root.right);


        if(left>right)
            return left+1;
        else
            return right+1;
         */


    }





    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root == null){
            return false;
        }

        if(root.data == x){
            return true;
        }

        boolean ans = true;
        if(root.left!=null ){
            ans = isNodePresent(root.left,x);
        }
        else if(root.right != null){
            ans = isNodePresent(root.right,x);
        }else{
            ans = false;
        }

        return ans;

    }






    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){ // this is a base case
            return 0;
        }
        int ans = 1;  // 1 isiliye kyunki agar root null nhi h to 1 node to km se km ho hee gyi hmare tree me
        ans += countNodes(root.left);  // left or right child dono k liye call hoga hee hoga hmesha
        ans +=countNodes(root.right);

        return ans;
    }




    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = null;
            temp = queue.remove();

            String toBePrinted = temp.data + ":";
            if (temp.left != null) {
                toBePrinted += "L:" + temp.left.data + ",";
                queue.add(temp.left);
            } else {
                toBePrinted += "L:" + "-1" + ",";
            }

            if (temp.right != null) {
                toBePrinted += "R:" + temp.right.data;
                queue.add(temp.right);
            } else {
                toBePrinted += "R:" + "-1";
            }

            System.out.println(toBePrinted);


        }

    }




    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); // pendingNodes wo nodes h jinke hmne child nhi puche h , node ka data as a input to aa chuka
        // but abhi tk us node k child nhi puche h jaise .....shuru me 1 as a inout liya or hmne 1 k child nhi puche to 1 ko queue me daal diya taaki next time m 1 k child puch sku

        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();
        if(rootData == -1){  // agar user hi input krna chahta to ye condition true ho jayegi
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root); // hmne root ko queue me insert krdiya kyunii hmne abhi tk user se root k child nhi mange

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();  // front Node bna denge ....jo hmne abhi abhi nikali h queue se usko kyunki jo sbse aage h hmne uske children puchne h
            } catch (QueueEmptyException e) {
               return null;
            }

            System.out.println("Enter left child of : " + front.data); // root ka left child pucha
            int leftChild = sc.nextInt();

            if(leftChild != -1){ // mtlb phle check kiya ki left me kuch h b ya nhi
                BinaryTreeNode<Integer> child  = new BinaryTreeNode<>(leftChild);  // agar h left me kuch to wo child node bnayi usme insert krwa liya
                pendingNodes.enqueue(child); // or usi child ko hmne queue me b insert krdiya kyunki ho skta h ki is child node k further aage children ho
                front.left = child;  // phle left liya jata h to is child ko hmne left me attach krdiya root k
            }

            // same thing done with right child also
            System.out.println("Enter right child of : " + front.data); // root ka right child pucha
            int rightChild = sc.nextInt();

            if(rightChild != -1){
                BinaryTreeNode<Integer> child  = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }

        return root;
    }




    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){  //yahan ye hmara edge case nhi h ye hmara base case h
            return;
        }
        String toBePrinted = root.data+" ";
        if(root.left != null){ // yahan check kiya ki root ka left null to nhi h
            toBePrinted += "L:" + root.left.data + ","; // agar null nhi h to left ka data print krwa diya
        }
        if(root.right != null){ // same done with right child of root
            toBePrinted += "R:" + root.right.data ;
        }

        System.out.println(toBePrinted); // print krwa diya   but isse sirf root node print hogi kyunki shuru wali line execute hui bs
        // ab child nodes ko print krne k liye ....recursion ka use kro
        printTree(root.left);
        printTree(root.right);

    }






    public static BinaryTreeNode<Integer> takeInput(Scanner sc){  // Scanner class ka object pass krdiya kyunki hum recursive call use krenge to har baar wo user se data le lega
        int rootData;
        System.out.println("Enter root data");
        rootData = sc.nextInt(); // rootData lenge shuru me user se
        if(rootData == -1){  // -1 hmne isiliye liYA kyunki maanlo agar user null tree bnana chahta h to ......it's our base case
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData); // agar -1 nhi h to hum root node bna denge us value se jo ki user ne scanner class ka use krke set kri h

        root.left = takeInput(sc);  // root k left k liye scanner ka use krke user se input krwa liya
        root.right = takeInput(sc);  // root k right k liye scanner ka use krke user se input krwa liya
        // or hmne aise isiliye kiya kyunki ye binary tree h or binary tree me ek root k max 2 child hee ho skte h so hum no of child nhi puchenge user se

        return root;  // at last we return the root


    }






    public static void main(String[] args) {

        // use this when you want to take input from user levelWise or iteratively
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);

//        System.out.println(countNodes(root));

//        System.out.println("Diameter is : " + diameter(root));  // uncomment when diameter function is called

        System.out.println("diameter: " + heightDiameter(root).second);
        System.out.println("height: " + heightDiameter(root).first);
/*
// use this when you want to take input from user recursively
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer>  root  = takeInput(sc);
        printTree(root);
        sc.close();


 */



        /*

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);  // root node bnayi

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2); // ek child bnaya
        root.left = node1; // node1 ko root k left me lgaya h

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
        root.right = node2; //node2 ko root k light me lgaya h

         */



    }
}
