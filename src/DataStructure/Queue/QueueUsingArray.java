package DataStructure.Queue;

public class QueueUsingArray {
    private int data[];
    private int front;  // index at which front end is stored
    private int rear;   // index at which rear end is stored
    private int size;
    // all 4 are private

    //now initialize all four variables using constructor
    public QueueUsingArray(){
        data = new int[10];
        front = -1;  // shuru me front khali h to -1 and same with rear
        rear = -1;
        size = 0; // kuch h hee nhi queue me to size b 0 aayega
    }

    public QueueUsingArray(int capacity){ // whe user wants to create his own size of queue
        data = new int[capacity];
        front = -1;
        rear =-1;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return (size()==0);
    }

    int front() throws QueueEmptyException { // Queue k front me jo hoga wo return krega

        if(size==0){ // agar queue khali h or hum usk front access krna chahe
             throw new QueueEmptyException();
        }

        return data[front];
    }

    void enqueue(int element) throws QueueFullException {

        // ab maanlo queue full ho or hum usme element dalne ki soche to exception aani chyiea to usko handle kro
        if(size == data.length){
//            throw new QueueFullException();

                doubleCapacity();
        }


        if(size==0){ // hme shuru me front b  bdhana pdega kyunki shuru me front -1 tha or ab queue me element dal gya to front phle element ko point krega to front =0 kro
            front = 0;
        }


        // shuru me rear -1 hoga to phle to rear ko 0 index pr phunchao i.e. by incrementing by 1
        size++; // jitne element dalte jayenge size utna hee bdhta jayega

  //      rear = rear+1; // yahan rear bdha diya
//        if(rear ==  data.length){ // ye wo case h jb insertion krke deletion krdi or phir se insert krne ki koshish kr rhe h or jagah to h hmare pass
//            // but wo index no out of range h to hum aise case me rear ko wapis ghuma k 0 pr le aayenge
//            // iski better explanation k liye refer to notebook
//            rear=0;
//        }

        // in uper wali teen lines (if wali conditions or rear++ ) ki jagah ye jo niche likha hua ye b likh skte h
        rear = (rear+1)%data.length; // ab rear ki range 0 se data.length tk rhegi

        data[rear] = element; // ab rear point kr rha h 0 index ko to data array k 0th index pr element daaldo


    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2*temp.length];
        int index = 0;
        for(int i =front;i<temp.length;i++){
            data[index] = temp[i];
            index++;
        }
        for(int i =0;i<=front-1;i++){
            data[index] = temp[i];
            index++;

        }
        front = 0;
        rear = temp.length-1;

    }

    int dequeue() throws QueueEmptyException {
        // agar queue khali h to emptyException ko handle kro
        if(size==0){
            throw new QueueEmptyException();
        }

        // front wala delete hoga element to front pr jo element h usko temp me daal do
        int temp = data[front];

//        front++; // ab 0 index wala delete ho chuka  to front ko bdha do
//        if(front == data.length){ // ye waise hee spcl case h jaise enqueue me tha (see commented lines)
//            front = 0;
//        }

        // agar uper wali lines nhi likhna chahte to niche wali line likhdo
        front = (front+1)%data.length;

        size--; // size b ek se km ho jayega

        if(size == 0){ // agar size 0 ho gya to front or rear dono -1 ho jane chyiea to bs wahi kiya h
            front =-1;
            rear = -1;
        }
        return temp;  // jo elemet delete kiya wo return krwa diya
    }
}
