package DataStructure.PriorityQueue;

import DataStructure.Queue.QueueEmptyException;

import java.util.ArrayList;

public class Priority_Queue {

    // Priority Queue internally store hoti h heap me or heap store hoti h in form of an array
    // array ka size fix hota h to hum use krenge arraylist

    private ArrayList<Integer> heap;  //meri heap ka access or kisi k pass na ho

    public Priority_Queue(){
        heap = new ArrayList<>();
    }


    boolean isEmpty(){
        return heap.size() == 0;   // agar PQ empty hui to heap ka size b 0 ho jayega
    }


    int size(){  // size chiyea PQ ka to heap k size ko return krwa denge
        return heap.size();
    }


    // WE WILL IMPLEMENT MIN HEAP HERE

    //  min heap h to minimum array k first index pr hee pda hoga
    int getMin() throws PriorityQueueException {
        if(heap.isEmpty()){  // wo case jb heap khali ho
            //throw exception
            throw new PriorityQueueException();
        }
        return heap.get(0);  //0th index wala return krwa diya
    }



    //INSERT function
    void insert(int element){
        heap.add(element); // element add krna h to wo to krdiya, or jo kiya h add wo last me jayega heap k mtlb array k b

        // now heap order property ko check kro
        // so heapify krna pdega   or heapify krne k liye swap krna pdega child se parent ko
        int childIndex = heap.size() - 1;  // child Index easyily nikal gya kyunki heap k last me jake store hua h
        int parentIndex = (childIndex - 1)/2;   // ye acc to formula in notebook

        // now compare both
        while(childIndex > 0) {  // jb tk hum root pr nhi phunche h tb tk hme ye kaam krte rhna pdega

            if (heap.get(childIndex) < heap.get(parentIndex)) {  // agar chota hua child wala to swap krwa do
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));  // child index pr set krna h jo parent index pr rkha h wo or wo get se hum pta kr skte h ki kya rkha h
                heap.set(parentIndex, temp);  // parent pr temp rkhna h
                childIndex = parentIndex; // kyunki swap k baad position chnge ho gyi to childIndex ko update b krna pdega kyunki ab uska parent chnge ho gya h
                parentIndex = (childIndex - 1) / 2; // ab parentIndex b dobara calcuate hoga kyunki parent ab badal chuka h
                // now swap is complete but heapify is not complete
                // so isko while loop me cover krdiya
            } else {  // agar child ki bdi hi h to hmne return krwa dena h bs or kuch nhi
                return;
            }
        }
    }




    //REMOVE function
    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parent = 0;
        int c1 = parent*2+1;		// left child
        int c2 = parent*2+2;		// right child
        // the base termination condition of the while loop will be => leftChildIndex < heap.size()
        while(c1<heap.size())
        {
            // using a temp variable that will hold the minimum priority of the root, left and right child
            // initializing that varaible to the parent index
            int min = parent;
            // checking whether min < leftChild
            if(heap.get(c1)<heap.get(min))
                min = c1;
            // first check whether the right child exists then compare for min
            if(c2 < heap.size() && heap.get(c2) < heap.get(min))
                min = c2;

            // if min is still holding the index of parent then parent is the smallest => break the loop
            if(min == parent)
                break;
            // else do the swapping between the min and parent
            int t2 = heap.get(parent);
            heap.set(parent, heap.get(min));
            heap.set(min, t2);
            // now update the required indexes
            parent = min;
            c1 = parent*2+1;
            c2 = parent*2+2;
        }
        return temp;
    }


}
