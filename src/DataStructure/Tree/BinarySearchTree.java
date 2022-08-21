package DataStructure.Tree;

import DataStructure.NodeLL;

import java.util.ArrayList;

public class BinarySearchTree<T> {

    static void pairSum(BinaryTreeNode<Integer> root, int sum) {

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            return;
        }



    }







    public static int getLCAforBST(BinaryTreeNode<Integer> root, int a, int b) {
        if(root == null){
            return -1;
        }

        if(root.data==a || root.data==b) {
            return root.data;
        }

        if(a<root.data && b>root.data){
            return root.data;
        }else if(a<root.data&&b<root.data){
            return getLCAforBST(root.left, a,b);
        }else{
            return getLCAforBST(root.right, a,b);
        }
    }








    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if(root == null){
            return -1;
        }

        if(root.data==a || root.data==b) {
            return root.data;
        }

        if(a<root.data && b>root.data){
            return root.data;
        }else if(a<root.data&&b<root.data){
            return getLCA(root.left, a,b);
        }else{
            return getLCA(root.right, a,b);
        }

    }






    public void insertDuplicateNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);

        BinaryTreeNode<Integer> temp = root.left;

        root.left = newNode;
        newNode.left = temp;
    }







   private BinaryTreeNode<Integer>  root;


    private  void printTreeHelper(BinaryTreeNode<Integer> root){
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
        printTreeHelper(root.left);
        printTreeHelper(root.right);

    }

    public void printTree(){
        printTreeHelper(root);
    }







    private BinaryTreeNode<Integer> insertDataHelper(int data,BinaryTreeNode<Integer> root){
       if(root == null){
           BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
           return newNode;
       }

       if(data < root.data){
          root.left =  insertDataHelper(data, root.left);
       }else{
           root.right = insertDataHelper(data, root.right);
       }
       return root;
   }

    public void insertData(int data){

        // insert k case me hme root b return krwana pdega kyunki there is a case when root changes which is:
        // maanlo hum right me insert kr rhe h or right side null h to jo new node insert hogi wo ek root hee bnegi
        // or is root ko main root ko return krna pdega ki ye ek new root bni h

        insertDataHelper(data, root);

    }





private BinaryTreeNode<Integer>  deleteDataHelper(int data, BinaryTreeNode<Integer> root){
    if(root ==  null){
        return null;
    }

    if(data < root.data){
        root.left =  deleteDataHelper(data, root.left);
        return root;
    }else if(data> root.data){
        root.right =  deleteDataHelper(data,root.right);
        return root;
    }else{
        if( root.left == null && root.right == null){
            return null;
        }else if(root.left == null){
             return root.right;
        }else if(root.right ==  null){
            return root.left;
        }else{ // mtlb wo case jisme root delete krni h or left and right me b subtree h  , to hme bachi hui nodes me se ek ko root node bnana pdega
            // replacement chyiea hme root ki to uski replacement k liye 2 possibilities h
            // one is that ki left subtree ka maximum jo hoga usko root bnado
            // second is that jo right subtree ka minimum hoga usko root bnado

            // hum second possibilities ko lekr chal rhe h
            BinaryTreeNode<Integer> minNode = root.right;  // ek nayi node  bnayi usme abhi hmne root ka right daal diya or hum abhi k liye usi ko minimum maan rhe h
            // ab strategy kya h hmari...... strategy ye h ki root k left me chlte jao jb tk node ka left null nhi ho jata or hum left me isiliye ja rhe h kyunki left me hee hme minimum milega na ki right me
            // jahan null mil gya mtlb jis node ka left null hoga wahi node hmari sbse minimum hogi

            // agar hmne first possibility k acc chlna h to hme right traverse krna pdega till right k null tk

            // so abhi to second possibility k acc hee
            while(minNode.left != null){
                minNode = minNode.left;
            }
            root.data = minNode.data;
            root.right = deleteDataHelper(minNode.data, root.right);

            return root;
        }
    }
}

    public void deleteData(int data){

        System.out.println(deleteDataHelper(data,root));

    }




    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root){  // this is private kyunki hum user se ye chupana chahte h kyunki user se bs data puchenge ki bta konsa data search krna tune
        if(root == null){
            return false;
        }

        if(root.data ==  data){
            return true;
        }

        if(data < root.data){
            return hasDataHelper(data,root.left);
        }else{
            return hasDataHelper(data, root.right);
        }

    }

    public boolean hasData(int data){  // yahan hum root pass nhi kr rhe but hmne uper define krdi to hum use kr skte h use apne code me

        // hme helper function ki jrurt kyhu pdi
        // kyunki agar hum helper function na bnate to hme isi function pr recursive call krni pdti or usme hum sirf data bta skte the ki ye data search krna h
        // or data pr to condition hoti h BST me ki bda h to right me chota h to left me or agar hum aise krke recursive call krte to hum usko ye nhi bta pate ki tujhe search kahan krna h
        // kyuki ye function ek hee argument le rha h or isiliye hmne do functio  bnaye h taaki dusre function me hum node b pass kr ske


            return hasDataHelper(data, root);

    }






    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){

        if(root == null){
            return null;
        }

        if(root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);

            return output;
        }

        ArrayList<Integer> leftOutput = getPath(root.left,data);

        if(data < root.data){
            if(leftOutput != null){
                leftOutput.add(root.data);

                return leftOutput;
            }
        }
        ArrayList<Integer> rightOutput = getPath(root.right,data);
        if(data > root.data){

            if(rightOutput != null){

                rightOutput.add(root.data);

                return rightOutput;
            }else{
                return null;
            }
        }else {
            return null;
        }


    }






    public static HelpNode<NodeLL<Integer>> constructLinkedListHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            return new HelpNode<NodeLL<Integer>>();
        }

        if(root.left == null && root.right == null){
            HelpNode<NodeLL<Integer>> helpNode = new HelpNode<NodeLL<Integer>>();
            helpNode.head = new NodeLL<>(root.data);
            helpNode.tail = new NodeLL<>(root.data);
            return helpNode;
        }

        HelpNode<NodeLL<Integer>> leftHelpNode = constructLinkedListHelper(root.left);
        HelpNode<NodeLL<Integer>> rightHelpNode = constructLinkedListHelper(root.right);

        HelpNode<NodeLL<Integer>> helpNode = new HelpNode<NodeLL<Integer>>();

        NodeLL<Integer> node = new NodeLL<>(root.data);

        if(leftHelpNode.head == null){
            helpNode.head = node;
        }else{
            helpNode.head = leftHelpNode.head;
        }

        if(leftHelpNode.tail == null){
            helpNode.head.next = node;
            helpNode.tail = node;
        }else{
            leftHelpNode.tail.next = node;
            helpNode.tail = node;
        }

        if(rightHelpNode.head != null){
            helpNode.tail.next = rightHelpNode.head;
            helpNode.tail  = rightHelpNode.head;
        }

        if(rightHelpNode.tail != null){
            helpNode.tail = rightHelpNode.tail;
        }

        return helpNode;
    }

    public static NodeLL<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

        HelpNode<NodeLL<Integer>> helpNode = constructLinkedListHelper(root);
        return helpNode.head;
    }









    public static BinaryTreeNode<Integer> SortedArrayToBSThelper(int [] arr, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return null;
        }

        int mid = (startIndex + endIndex)/2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);

        root.left = SortedArrayToBSThelper(arr, startIndex,mid-1);
        root.right = SortedArrayToBSThelper(arr,mid+1,endIndex);

        return root;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){

        return SortedArrayToBSThelper(arr,0,n-1);


    }








    public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.data<min || root.data>max){
            return false;
        }

        boolean isLeftOk = isBST3(root.left,min, root.data-1);  // left ki maximum rane root k data se 1 km tk hee ho skti h kyunki agar wo usse bdi hui to wo BST nhi rhega
        boolean isRightOk = isBST3(root.right, root.data, max);   // right ki minimum range ye hogi ki wo root k data tk hee hoga

        if(isLeftOk && isRightOk){
            return true;
        }else{
            return false;
        }
    }





    public static Pair<Boolean , Pair<Integer,Integer>> isBSToptimize(BinaryTreeNode<Integer> root) {

        // yahan hme teen cheeze chyiea thi ....maximum or minimum or isBST
        // ab in teen cheezo k liye hmare pass 2 option the
        // first is that hum ek triplet class bnate as like Pair class
        // second is that hum pair class me hee ek cheez add krde jisme se ek cheez pair hogi itself or ek boolean jo btayega ki BST h ya nhi
        // hum Pair<Integer, Integer>  me first ko minimum assume kr rhe h or second ko maximum
        if (root == null) {   // this is our base case
            Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
            output.first = true;  // boolean tha pair ka first to agar root null hui to hmne true return krwa diya
            output.second = new Pair<Integer, Integer>();  // second itself ek pair the minimum or maximum jisme store tha to hmne ek pair bna diya yahan jo ki store krwa diya iutput k second me
            output.second.first = Integer.MAX_VALUE;   // second k first me hmne minimum store krwa diya or minimum k liye hum left ka max dekh rhe h to isiliye hmne Integer.MAX_VALUE store krwaya h
            output.second.second = Integer.MIN_VALUE;  // second k second me similarly Integer.MIN_VALUE
            return output;  // wo output return krwa diya
        }

        Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBSToptimize(root.left);
        Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBSToptimize(root.right);

        int min = Math.min(root.data, Math.min(leftOutput.second.first,rightOutput.second.first));
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));

        // now condition for BST .... root ka data bda hona chyiea left k max se i.e. left k second k second se and root ka data chota hona chyiea ya brabar hona chyiea right k minimum se i.e. right k second k first se
        // dusri condition is that whole left subtree should be BST
        // third is that whole right subtree should be BST
        boolean isBST = (root.data >leftOutput.second.second) && (root.data<= rightOutput.second.first) && leftOutput.first && rightOutput.first;

        Pair<Boolean,Pair<Integer,Integer>> output = new Pair<Boolean,Pair<Integer,Integer>>();
        output.first = isBST;
        output.second = new Pair<Integer,Integer>();
        output.second.first = min;
        output.second.second = max;
        return output;


    }









    public static int maximum(BinaryTreeNode<Integer> root) {
        if (root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));


    }
    public static int minimum(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return Integer.MAX_VALUE;

        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root==null)
            return true;


        int leftmax= maximum(root.left);
        int rightmin=minimum(root.right);


        if(root.data<=leftmax)
            return false;


        if(root.data>rightmin)
            return false;

        boolean	isLeftBst=isBST(root.left);

        boolean	isRightBst=isBST(root.right);

        if(isLeftBst && isRightBst)
            return true;
        else
            return false;

    }








    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){

        if(root == null){
            return;
        }
        if(k1 < root.data){
            elementsInRangeK1K2(root.left,k1,k2);
        }
        if(k1<=root.data && k2>= root.data){
            System.out.print(root.data +" ");
        }
        if(k2>root.data){
            elementsInRangeK1K2(root.right,k1,k2);
        }


    }





    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

        if(root == null){
            return false;
        }

        if(root.data == k){
            return true;
        }

        boolean ans = false;

        if(k<root.data){
            ans = searchInBST(root.left,k);

        }else if(k>root.data){
            ans =  searchInBST(root.right,k);
        }

        return ans;


    }



    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insertData(10);
        bst.insertData(20);
        bst.insertData(5);
        bst.insertData(15);
        bst.insertData(3);
        bst.insertData(7);
        bst.printTree();
    }
}
