package DataStructure;

public class NodeLL<T> {
    // <T> this indicates that we use generic concept here
   public T data;
   public NodeLL<T> next;  // mtlb next usi node ko point krega jiska data type uske equal h jo hmne uper likha h i.e. NodeLL<T> me jo T ka data type h
    // let say uper hmare pass Integer h to niche next b usi node ko point krega jiska data type integer hoga

    public NodeLL(T data){
        this.data = data;
        next = null;
    }
}
