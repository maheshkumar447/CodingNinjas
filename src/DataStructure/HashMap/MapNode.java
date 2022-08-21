package DataStructure.HashMap;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K,V> next;  // linked list h isiliye hme ek next b rkhna pdega

    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
