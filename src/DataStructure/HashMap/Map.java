package DataStructure.HashMap;

import java.util.ArrayList;

public class Map<K,V> {  // generic to both keys and values
    // now we need a bucket array and each element of this array is itself a linked list
    // we need to create a node of linked list for bucket array
    // this node stores two things key and value and this is again of generic type for both of the things i.e. Node<K,V> and we form an array of this tyoe
    // but there is problem that we can't form an array of generic type in java
    // so inplace of array we form an arraylist and treat this as array that is we gave size at first as like in array and assign each element as null in starting
    // hum shuru me hee isko size allocate kr rhe h or null assign kr rhe h kyunki maanlo hash code hmare pass compress hoke aaya 10 to hum direct 10th pr arraylist me nhi daal skte value
    // kyunki arraylist me insertion hmesha first node pr hoti h
    // hum apne hash code k acc value daal ske isi k liye hum arraylist ka size phle hee bta de rhe h
    // so now create a node that is MapNode



    ArrayList<MapNode<K,V>> buckets;
    int size; // size is basically no of entries you put into hashmap
    int numBuckets;  // bucket ka size mtlb arraylist ka size

    public Map(){
        numBuckets = 5;
        buckets = new ArrayList<>();
        for(int i =0;i<numBuckets;i++){
            buckets.add(null);  // har element ko null assign kra diya
        }
    }




    private void rehash(){
        System.out.println("Rehashing: buckets " + numBuckets + "size" + size);
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int i = 0;i<2*numBuckets ;i++){  // size double kiya or null add krdiya sbhi index me
            buckets.add(null);
        } // so now we have 40 entries in buckets

        size = 0;  // size 0 jho gya kyunki entry to ek b nhi h usme
        numBuckets *= 2;  // numBuckets 2 se multiply krdiya
        // so now our map behave like an empty map
        // so ab hum purani arraylist ko traverse krenge or har element ko nayi arraylist me daalte jayenge acc to new hash code
        for(int i =0;i<temp.size();i++){  //traverse kiya
            MapNode<K,V> head = temp.get(i);  // head node dhunda
            while(head != null){
                K key = head.key;
                V value = head.value;
                insert(key, value);  // ab ye insert function nayi arraylist me add krega
                head = head.next;
            }

        }
    }

    public double loadFactor(){
        return (1.0 *size)/numBuckets;
    }

    private int getBucketIndex(K key){
        // iske 2 parts h
        // 1st me hme hashcode chyiea
        //2nd me hme compressive function return krwana h

        int hashCode = key.hashCode();  // explanation k liye thoda niche dekho isi function me
        return hashCode % numBuckets;

        // now how to find hashCode.....hashCode find krne ki tension nhi leni kyunki har type k liye inbuilt hashCode hota h java me
        // agar inbuilt wala nhi sahi lg rha to hum apna b bna skte h
        // string k liye akag hota h
        // int k liye alag ad so on
    }

    // 1st function is insert
    public void insert(K key, V value){
        // insert krne k liye hme ye pta hona chyiea ki ye key kis index pr jauyegi and that we get to know by hash code so for that let makes a privcate function getBucketIndex()

        int bucketIndex = getBucketIndex(key);  // sbse phle wahi kiya index find krliya
        // ab index aa gya ab aage kya krna h
        // aage hmne us index pe jake head ko dhunda or jo key insert krni h usko phle dekhenge ki kya wo key phle se hee h ya nhi
        // agar wo key phle se he hui to hum update r denge value ko
//        otherwise hum new node bnake usme insert kr denge

        // so find head of linked list first
        MapNode<K,V > head = buckets.get(bucketIndex);
        // traverse linked list
        while(head != null){
            if(head.key.equals(key)){ // agar same key mil gyi to // yahan .equals() isiliye lgaya kyunki == hmara address compare krta h do objects ka
                // or ho skta h ki 2 adrresses pr same vakue pdi ho to ye usko b true de dega
                // .equals() compares actual value
                head.value = value;  // usi key pe jake value ko update krdenge
                return;
            }
            head = head.next;
        }

        // ab agar nhi mili key usi linked list me to hum new node bnayenge or usme key ko insert krdenge
        // new node jo bnayenge wo startig me bnegi or jo array ka asli index tha usse is node ko point krwa denge or isse usko jisko wo index phle kr rha tha


        head = buckets.get(bucketIndex); // hmne ye dobara isiliye kiya kyunki hum while loop se apne head ko null tk phuncha chuke h to dobara asli head nikalna pdega jo ki usi method se niklega jisse phle nikla tha
        MapNode<K,V> newElementNode = new MapNode<K,V>(key ,value);
        // nayi node insert krenge to size b to increase hoga
        size++;
        newElementNode.next =  head;  // head ko nayi node k next me rkh diya
        buckets.set(bucketIndex,newElementNode);   // nayi node ko array k index me store krwa diya


        // yahan tk insertion normal wala h ......load factor ka chkr yahan se pdega ab
        // to load factor ka lafda aate he hmne kya krna h ....rehashing
        // rehashing mtlb jo b arraylist hmne le rkhi h uska size double krna agar n/b ki ratio 0.7 se bdi ho rhi h to
        // n here is no of entries
        // b here is bucket size or no of boxes
        // agar entries jyada ho gyi to n bdhega or n/b ki ratio b bdhegi
        // so hme b bhi bdhana pdega
        // b bdhane k liye hee hum rehashing ka use krte h

        // ab kaise krni h rehashing
        // hum ek temp naam ki arraylist lenge or usme jo previous arraylist h wo store krwa denge
        // or bucket k naam se nayi arraylist lenge jiska size hum 2*size of temp rkhenge
        // ab hum direct isme jaise ki normal dynamic array k case me krte the ki phle wali array ko new array me as it is coyy krdo wo nhi kr skte kyunki jo nayi bni h arraylist uska compression function alag hoga
        // or wo new arraylist apne usi compression function k acc indexing kregi
        // agar as it is rkhdi purani arraylist to indexing me problem aayegi
        // for example :- hash code aaya 21 or 41 ...2 strings k liye(take string like abc and def)
        // to jb 20 tha size arraylist ka to sahi tha dono k liye compression funciton 1 dega
        // but jb size 40 ho gya to compression fucntion 41 k liye to 1 hee dega but 21 k liye 21 dega
        // so abc ko hona chyiea 21 pr but wo wahan nhi milegi wo hme 1 pr milegi ...that doesn't make a sense
        // so hme indexing b dobara krni pdegi

        // now code
        double loadFactor = (1.0 * size )/ numBuckets ;    // yahan 1.0 se multiply isiliye kiya kyunki size b ineteger h or numBuckets b to int/int ek int aata
        if(loadFactor  > 0.7){
            rehash();
        }




    }





    //2nd function is: search
    public  V getValue(K key){  // jo key search krni h uski value return krwani h is function se
        // is key k corresponding hum index nikalenge
        // jo index aaya us index pr jake us index wali puri linked list ko travserse krke check krenge ki h ya nhi wo key
        // agar hui then return value otherwise return null

        int bucketIndex = getBucketIndex(key);
        MapNode<K,V > head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value; // jb key se match ho gya to value return krwadi
            }
            head = head.next;
        }
        return null; // puri linked list ho chuki traverse or nhi mila to return null
    }





    //3rd is: delete
    public V removeKey(K key){  // jo key delete krni h uski value return hogi
        // first work is same index nikalo
        // phir uske baad jo node delete krni h uske previous ko khne pdega ki ty apna next change kr
        // ab uska next wo node honi chyiea jo no ki next tha us node ka jo hmne delete kri h

        int bucketIndex = getBucketIndex(key);
        MapNode<K,V > head = buckets.get(bucketIndex);

        MapNode<K,V> prev = null; // bcoz shuru me jb head first node hee h to uska prev null h

        while(head != null){
            if(head.key.equals(key)){
                // node present h jo delete krni h wo to size km b to hoga
                size--;
                if(prev == null){
                    // but there is one special case jahan ye galat hoga i.e. jb hme shuru me hee mil gyi node jo delete krni h to us acse me prev ka next or head ka next collapse kr jayege
                    // to us case me hme bucket ko khna pdega ki tu is node se next walo ko point krne lgja
                    buckets.set(bucketIndex,head.next); // bucketIndex pe jo tha usko htake head ka next wahan rkh dena h
                }else {
                    prev.next = head.next; // jb match kr gye us key se jo delete krni h to prev k next ko point krdo head k next se kyunki head usi node ko point kr rha h jo hmne delete krni h

                    return head.value;
                }
            }
            prev  = head; // kyunki suppose jo 2nd node h uska prev to head hee h to aise hee sbhi nodes k liye
            head = head.next;
        }
        return null;
    }




    //4th function is: size
    public int size(){
        return size;
    }

}
