package DataStructure.Tree;

public class BinaryTreeNode<T> { // Binary tree node is of generic type

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data = data;
    }


}
