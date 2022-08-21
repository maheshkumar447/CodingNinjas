package DataStructure.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


class MedianComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer first, Integer second) {
        return (second-first);
    }
}




// this class and comparator is for question k  array merge  sort
class Triplet{
    int value;   // kya value h wo
    int rowIndex;  // jis array me se wo value aayi h uska index
    int colIndex;   // hmari arrayList me kis index pr wo value dalegi wo index
}
class TripletComparator implements Comparator<Triplet>{

    @Override
    public int compare(Triplet a, Triplet b) {
        if(a.value <= b.value){
            return -1;
        }
        return 1;
    }
}




class MinPQComparator implements Comparator<Integer>{  // ye class last me bnani h ....ye last video ka part h or ye class Comparator interface ko implements krti h
    // Comparator interface ka mtlb h ki PQ me jo  b elements insert honga wo ek order me honge wo order kuch b ho skta h inc , dec ya koi or b , ye sb depend krta h is comparator pr
    // Comparator order decide krta h or comparator ko hum btate h order kya chyiea agar nhi btayenge to comparator by default Integers k liye unke natural order ko hee apna order maan leta h

    @Override
    public int compare(Integer o1, Integer o2) { // ye inbuilt method h Comparator interface me or ye method btata h ki hum 2 integers ko compare kaise krenge
        // is compare ka result -ve , 0, +ve hota h
        if(o1<o2){  // so agar hmne min pq bnani h to -1 tb aayega jb hmara phla wala element chota ho
            // agar hum max PQ bna rhe h to hum swap tb krenge jb hmara child bda ho
            return -1;
        }else if(o1>o2){
            return 1;
        }
        return 0;

    }
}



class MaxPQComparator implements Comparator<Integer> {  // ye class last me bnani h ....ye last video ka part h or ye class Comparator interface ko implements krti h
    // Comparator interface ka mtlb h ki PQ me jo  b elements insert honga wo ek order me honge wo order kuch b ho skta h inc , dec ya koi or b , ye sb depend krta h is comparator pr
    // Comparator order decide krta h or comparator ko hum btate h order kya chyiea agar nhi btayenge to comparator by default Integers k liye unke natural order ko hee apna order maan leta h

    @Override
    public int compare(Integer o1, Integer o2) { // ye inbuilt method h Comparator interface me or ye method btata h ki hum 2 integers ko compare kaise krenge
        // is compare ka result -ve , 0, +ve hota h
        if (o1 < o2) {    // agar phle wala chota h to positive otherwise negative Max PQ k case me
            return 1;
        } else if (o1 > o2) {
            return -1;
        }
        return 0;

    }
}










class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {

        if(o1.length() < o2.length()){
            return -1;
        }else if(o1.length()>o2.length()){
            return 1;
        }else {
            return 0;
        }
    }
}
// agar max height k liye comparator chyiea to sign chnge krdo






public class PriorityQueueUse {

    private static void insertIntoVirtualHeap(int [] arr, int i){
        int childIndex = i;  // jo index insert hoga wahi childIndex hoga isiliye i
        int parentIndex = (childIndex-1)/2;   // parent ka index formulae se nikal liya

        // now compare there priority
        while(childIndex > 0){

            if(arr[childIndex] < arr[parentIndex]){  // agar chota h child wala to swap krenge  // compare (o1,o2) < 0
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                // yahan tk swap ho gya
                // ab aage hme childIndex or parentIndex ko update b krna h
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;

            }else{ // agar child wala chota nhi h to update krne ki jrurt nhi si return
                return;
            }
        }
    }

// abhi tk hmare element virtual heap me store ho gye
    // ab hme heap se nikal kr array me store krwane h jo b elements remove honge wo
    // or wo store krwane h either descending order or ascemding order but here we store them in descending order

    private static int removeMinFromVirtualHeap(int [] arr, int heapSize){
        int temp = arr[0]; // jo element delete hoga
        arr[0]  = arr[heapSize-1];  // last element ko first pe daal diya
        heapSize--;  // heap ka size km krdiya ek se

        int index = 0;
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = 2*index + 2;

        while(leftChildIndex < heapSize){

            int minIndex = index;

            if(arr[leftChildIndex] < arr[index]){
                minIndex = leftChildIndex;
            }
            if( rightChildIndex  < heapSize &&arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }

            if(minIndex == index){
                break;
            }

            if(minIndex != index){  // mtlb shuru me minINdex ko index maana tha but wo chnge(left ya right min mil gya) ho gya to hum swap krenge
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;

                index = minIndex;
                leftChildIndex = 2*index +1;
                rightChildIndex = 2*index+2;

            }else{
                    break;
            }
        }
        return temp;
    }







    public static  void sortKSortedArray(int arr[],int k){  // is question ki explanantion k liye refer to notebook , wahan pta lgega ki ques h kya
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i =0;
        for( i =0;i<k;i++){  // shuru wala step jo k ki value h utne elements hmne pq me daal diye
            pq.add(arr[i]);
        }

        for(;i<arr.length;i++) {
//            arr[0] = pq.remove(); // jo minimum hoga element in k elements me se wo arr k 0th index pr jaega
//            pq.add(arr[k + 1]); //ek element nikal gya to hme ek element pq me add b to krna pdega or add konsa krenge jitni ki value usse agla
            // phir unme se jo min hoga wo 2nd index pr aayega or hmne ye process baar baar krna h isiliye loop chlayenge

            // uper jo likha h usko generalize krdiya
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }

        // hmne input array se k elements nikale the but last wale k elements bach gye to unko nikalne k liye
        for(int j = arr.length-k;j<arr.length;j++){  // jo elements bache hue the wahan se lekr puri array tk
            arr[j]= pq.remove();  // saare remove kiye
        }

    }









    public static ArrayList<Integer> kLargest(int input[], int k) {

//        logic:  hum shuru me first k element daal denge arraylist me phir hum dekhenge (k+1)th element ko agar ye element un teeno element me se
        // sbse minimum wale se bda h to us minimum element ko replace krdenge is (k+1)th element k sath

        // example : 2,15,8,9,12,13,20   and k =3
        // to shuru me 2,15,8 ko daal diya or ab 9 ko compare krenge un teeno k minimum se i.e. 2
        // 9 bda h 2 se to replace krdenge 9 and 2 ko
        // phir 12 aaya or minimum h 8 to hum 8 ki jagah 12 rkh denge

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i =0;

        for(;i<k;i++){
            pq.add(input[i]);
        }

        for(;i<input.length;i++){
            int min = pq.element();  // minimum value nikal k de dega jitne b elements honge pq me unme se
            if(min < input[i]){
                pq.remove(); // agar chota hua to remove krdiya use
                pq.add(input[i]); // ith element add krdiya
            }
        }

        // ab mere pass sirf k largest element hee pde honge pq me to inko nikalo or print krwao
        int j =0;
        while(!pq.isEmpty()){
            ans.add(j,pq.remove());
            j++;
        }

        return ans;


    }







    //ASSIGNMENT QUESTION
    public static boolean checkMaxHeap(int arr[]) {

        int n = arr.length;
        for(int i =0; 2*i+1 < n ; i++){
            int leftChildIndex = 2*i+1;
            int rightChildIndex = 2*i+2;

            if(arr[i] < arr[leftChildIndex]){
                return false;
            }

            if(rightChildIndex < n  && arr[i] < arr[rightChildIndex]){  // phle check kiya ki rightchild exist b krta h ya nhi
                return false;
            }
        }
        return true;

    }





    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here

        //logic: k largest wala logic lgaya phle (jo question uper kr rkha h)
        // phir last me pq.element() krdiya jisse ki ye hoga ki jitne b element bche h wo k element bche h or un k element me se jo b minimum hoga wo kth largest element b hoga or wahi ye fucntion return krega
        // or usko ans variable me store krwake hmne ans ko return krwa diya
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i =0;
        for(;i<k;i++){
            pq.add(input[i]);
        }
        for(;i<input.length;i++){
            int min = pq.element();
            if(min<input[i]){
                pq.remove();
                pq.add(input[i]);
            }
        }

        int ans = pq.element();
        return ans;
    }







    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

       TripletComparator tripletComparator = new TripletComparator();
       PriorityQueue<Triplet> pq = new PriorityQueue<>(tripletComparator);

       for(int i =0;i<input.size();i++){
           if(input.get(i) != null){
               Triplet a = new Triplet();
               a.value = input.get(i).get(0);   // value get krli
               a.rowIndex = i;  // jo value get hui h uska index
               a.colIndex = 0;  // hmare ans me 0th indx pr aayegi wo value
               pq.add(a);
           }
       }

       ArrayList<Integer> al = new ArrayList<>();
       while(!pq.isEmpty()){
           Triplet a = pq.remove();
           al.add(a.value);

           if(a.colIndex+1 < input.get(a.rowIndex).size()){
               Triplet b = new Triplet();
               b.value = input.get(a.rowIndex).get(a.colIndex+1);
               b.rowIndex = a.rowIndex;
               b.colIndex = a.colIndex+1;
               pq.add(b);


           }
       }

        return al;

    }







    public static void findMedian(int arr[]) {

        // median: elements ko sort kro or agar no of elements odd h to middle wala median hoga or agar no of elements even h to sum of middle two elements divide by two median hoga hmara

        //logic: hum stream ko sort nhi krenge blki hum usko 2 parts me divide krlenge or left part ka max nikaal lenge or right part ka min or un dono ko add krke divide by 2 krdenge
        // max or min hmara heap se niklega so we will implement heap here and we will implement both types of heap
        // bs is baat ka dhyan rkhe ki hmara atmost diff dono heap size me 1 ka hona chyiea
        // more explanation is in notebook

        int n = arr.length;

        MedianComparator medianComparator = new MedianComparator();
        PriorityQueue<Integer> firstHalf = new PriorityQueue<>(medianComparator);
        PriorityQueue<Integer> secondHalf = new PriorityQueue<>();

        int median;

        for (int i = 1; i <= n; i++) {
            if (!firstHalf.isEmpty() && firstHalf.peek() > arr[i - 1]) {
                firstHalf.add(arr[i - 1]);
                if (firstHalf.size() > secondHalf.size() + 1) {
                    secondHalf.add(firstHalf.poll());
                }
            } else {
                secondHalf.add(arr[i - 1]);
                if (secondHalf.size() > firstHalf.size() + 1) {
                    firstHalf.add(secondHalf.poll());
                }
            }
            if (i % 2 == 1) {
                if (secondHalf.size() > firstHalf.size()) {
                    median = secondHalf.peek();
                } else {
                    median = firstHalf.peek();
                }
            } else {
                median = (firstHalf.peek() + secondHalf.peek()) / 2;
            }
            System.out.print(median + " ");

        }



    }









    public static int buyTicket(int input[], int k) {

        if(k>=input.length)
            return Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:input)
        {
            list.add(i);
            q.add(i);
        }
        int time = 0;


        for(int i = 0;i<list.size();i++)
        {
            if(list.get(i)>=q.peek())
            {
                time++;
                if(i == k)
                    break;
                q.remove();

            }
            else {
                list.add(list.get(i));
                list.remove(i);
                if(k==i)
                    k = list.size()-1;
                else
                    k--;
                i--;

            }
        }
        return time;
    }










    public static void main(String[] args) throws PriorityQueueException {

        // hmne string type ki array bnayi h or yahan hum ek comparator bna rhe h jo ki string ko uski length k base pe compare krega or hme min length wali string ko phle lake dega
        String arr[] = {"this","at","a","their","queues"};
        StringLengthComparator stringComparator = new StringLengthComparator();
        PriorityQueue<String> pq= new PriorityQueue<>(stringComparator);

        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]); // ye inbuilt method h pq ka jo ki array k har element ko pq me insert krdega
        }
        while (! pq.isEmpty()){  // jb tk pq khali nhi hoti tb tk hum nikalege element pq se
            System.out.print(pq.remove() + " ");
        }



        /*

//        MaxPQComparator maxComparator = new MaxPQComparator();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(maxComparator); // comparator pass krdiya i.e. maxComparator
        // ye maxComparator hmne khud bnaya h agar hum na bnaye to b hmare pass hota h ek inbulit maxComparator


        // inbuilt maxCompartor
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // ye b kaam maxComparator ki tarah hee krta h or same result lake dega
        int arr[] = {9,1,0,4,7,3};
        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]); // ye inbuilt method h pq ka jo ki array k har element ko pq me insert krdega
        }
        while (! pq.isEmpty()){  // jb tk pq khali nhi hoti tb tk hum nikalege element pq se
            System.out.print(pq.remove() + " ");
        }

         */






/*
        MinPQComparator minComparator = new MinPQComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(minComparator); // comparator pass krdiya i.e. minComparator
        int arr[] = {9,1,0,4,7,3};
        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]); // ye inbuilt method h pq ka jo ki array k har element ko pq me insert krdega
        }
        while (! pq.isEmpty()){  // jb tk pq khali nhi hoti tb tk hum nikalege element pq se
            System.out.print(pq.remove() + " ");
        }


 */




        /*

        int arr[] = {2,15,8,9,12,20};
        ArrayList<Integer> ans = kLargest(arr,3);
        int i =0;
        while (!ans.isEmpty()){
            System.out.println(ans.get(i));
            i++;
        }

         */



        /*
        int arr[] = {2,4,1,9,6,8};
        int k =3;
        sortKSortedArray(arr,k);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

         */






      /*

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // jo inbuilt priority key h wo use kr rhe h hum yahan
        int arr[] = {9,1,0,4,7,3};
        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]); // ye inbuilt method h pq ka jo ki array k har element ko pq me insert krdega
        }

//        System.out.println(pq.element()); // pq.element hme minimum element laake deta h
        // minimum element hme peek se b milta h but peek or element oe ye diff h ki peek exception throw nhi krta jb pq empty ho or element krta h exception throw

        while (! pq.isEmpty()){  // jb tk pq khali nhi hoti tb tk hum nikalege element pq se
            System.out.print(pq.remove() + " ");
        }


       */




/*
        int arr[] = {5,1,9,2,0,6};
        for(int i =0;i<arr.length;i++){
            insertIntoVirtualHeap(arr, i);   // is array ka i index hme virtual heap me store krna h to hmne do argument pass kiye arr and jo index dalna wo
        }

        for(int i =0;i< arr.length;i++){
         arr[arr.length-1-i] =    removeMinFromVirtualHeap(arr,arr.length-i);  // is function ko chlane k liye hme 2 argument chyiea i.e. array  or heap ka size
            // heap ka size shuru me array k size k brabar hoga or baad me jaise jaise elements niklege usi k acc km hota jayega
            // yahan hmne array ka first element arr.length-1 index me store krwana h or 2nd element mtlb 1 index pr jo h wo arr.length-2 pr jo formula nikala hmne arr.length-1-i
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

 */




//        Priority_Queue pq = new Priority_Queue();
//        int arr[] = {5,1,9,2,0};
//        for(int i =0;i<arr.length;i++){
//            pq.insert(arr[i]);
//        }
//
//        while(!pq.isEmpty()){
//            System.out.print(pq.removeMin() + " ");
//        }
//        System.out.println();
    }
}
