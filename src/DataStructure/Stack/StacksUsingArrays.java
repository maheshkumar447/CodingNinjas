package DataStructure.Stack;

public class    StacksUsingArrays {

    int data[];
    int top; // topmostb element of stack
    // in dono elemnt ko private krdo agar aap chahte ho ki or khin access nhi dena....majorly private hee bnaya kro

    public StacksUsingArrays(){
        data = new int[10];
        top=-1;  // shuru me -1 ...kyunki shuru me maan rhe h ki stack khali h
    }

    public StacksUsingArrays(int capacity){  // this is used when you want to take size of array from user
        data = new int[capacity];
        top =-1;
    }

    public boolean isEmpty(){  // ye fucntion static nhi hoga kyunki ye shared property nhi h saare stacks ki.....har stack ki apni apni property hoti h
//        if(top == -1){
//            return true;
//        }else{
//            return false;
//        }

        return (top == -1);
    }

    public int size(){
        return top+1;
    }   // size mtlb no of elem in stack  // top+1 isiliye kyunki hmne shuru me -1 liya tha top me ..so agar staack khali h to -1+1 = 0



    public int top() throws StackEmptyException {  // stack k top pe jo hoga

        if(size() == 0){
            // StackEmptyException throw krdega
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        return data[top];
    }

    public void push(int elem) throws StackFullException {

        // ye exception aayegi jb hmari array dynamic nhi h mtlb fix size ki h
//        if(size() == data.length){
//            // throw  StackFullException
//            StackFullException e = new StackFullException();
//            throw e;
//        }

        top++;  // top ko increase kro phle kyunki maanlo hmari stack me 2 element h or insert krna h to 3rd pr hoga to uske liye top ko increase kiya
        data[top] = elem;  // top an jis index pe phunch gya us pe elem dal do





        // agar array dynamic h to niche wala funtion call hoga

        doubleCapacity();

    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];

        for(int i =0;i<=top;i++){
            data[i] = temp[i];
        }

    }

    public int pop() throws StackEmptyException {  // agar iska return type int krdiya to ye hme ye b bta dega ki remove kya kiya h mtlb top pe tha kya , nhi to iska return type void b ho skta h

        // agar stack empty h to b exception aayegi
        if(size() == 0){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        int temp = data[top];
        top -- ; // top hmne ek se km krdiya to top se aage kuch rhe ya na rhe hme kuch b farak nhi pdta kyunki hmari stack top tk hee hoti h
        return temp;


    }

    public static void main(String[] args) {

    }
}
