package DataStructure.Tree;

import java.util.ArrayList;

public class Test3 {

  /*
  Remove leaf nodes in Tree
Send Feedback
Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
Input format :
Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `
Output Format :
Elements are printed level wise, each level in new line (separated by space)
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 : (Level wise, each level in new line)
10
20
   */

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root == null)
            return null;
        // when there are no children of the given root
        if(root.children.size()==0)
            return null;
        for(int i = 0;i<root.children.size();i++)
        {
            TreeNode<Integer> temp = removeLeafNodes(root.children.get(i));
            if(temp == null)
            {
                root.children.remove(i);
                i--;
            }
        }
        return root;
    }














/*
Longest Leaf to root path
Send Feedback
Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 1 : Binary Tree 1 (separated by space)

Sample Input 1 :
 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5
 */


    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root==null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> leftArrayList = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightArrayList = longestRootToLeafPath(root.right);

        if(leftArrayList.size()>=rightArrayList.size()) {

            leftArrayList.add(root.data);
            return leftArrayList;

        }
        else {
            rightArrayList.add(root.data);
            return rightArrayList;
        }


    }














/*
Check cousins
Send Feedback
Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2 : integer value of p
Line 3 : Integer value of q
Output format :
true or false
Constraints :
1 <= N <= 10^5
Sample Input :
5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
2
4
Sample Output :
true
 */


    public static boolean isCousin(BinaryTreeNode<Integer> root,int node1,int node2) {


        return !isSiblings(root, node1, node2) && level(root, 0, node1) == level(root, 0, node2);



    }
    public static boolean isSiblings(BinaryTreeNode<Integer> root,int node1,int node2) {

        if(root==null) {
            return false;
        }
        if(root.left!=null && root.right!=null) {

            if(root.left.data == node1 && root.right.data == node2) {
                return true;
            }

        }
        return isSiblings(root.left, node1, node2) || isSiblings(root.right, node1, node2);

    }
    public static int level(BinaryTreeNode<Integer> root,int k,int node1) {

        if(root==null)
            return -1;
        if(root.data == node1) {
            return k;
        }
        int left  = level(root.left, k+1, node1);
        int right = level(root.right, k+1, node1);
        if(left==-1) {
            return right;
        }
        if(right==-1) {
            return left;
        }

        return -1;

    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);  // root node bnayi

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(6); // ek child bnaya
        root.left = node1; // node1 ko root k left me lgaya h

        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(10);
        root.right = node2; //node2 ko root k light me lgaya h

        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(2);
        node1.left=node3; //node2 ko root k light me lgaya h


        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(3);
        node1.right = node4; //node2 ko root k light me lgaya h

        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(4);
        node2.right = node5; //node2 ko root k light me lgaya h

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(9);
        node4.right = node6; //node2 ko root k light me lgaya h

        boolean ans = isCousin(root,2,4);
        System.out.println(ans);



    }
}
