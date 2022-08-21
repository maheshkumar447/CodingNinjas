package DataStructure.Tree;

import java.util.ArrayList;

public class TreeNode <T>{
    public T data;
    //arraylist chyiea treenode type ki or treenode k jo element honge wo T type k honge mtlb agar root integer h to aage wale saare integer type k honge
    public ArrayList<TreeNode<T>> children;  //by default jo hmara children h wo null h

    public TreeNode(T data){  // aisa constructor bnaya jo ki data lega kuch n kuch ...bina data k koi node nhi bnegi
        this.data = data;
        children  = new ArrayList<>(); // children naam ki new arraylist bnayi


    }
}
