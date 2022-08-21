package DataStructure.Stack;

public class StackUse {
    public static void main(String[] args) throws StackFullException {  // yahan b exception isiliye kyunki agar maanlo stack ki capacity 5 ki thi or 5 bhar diye to 5 k baad exception aa jayegi

        // ye tb uncomment kro jb stack ko array ki form me access krna ho

        StacksUsingArrays stack = new StacksUsingArrays();
        for(int i =0;i<5;i++){
            stack.push(i);
        }


        while(!stack.isEmpty()){
            try {
                System.out.println(stack.pop());
            } catch (StackEmptyException e) {  // is exception pr hhum kbhi nhi phunch skte kyunki hmne uper while me condition lga rkhi h ki jb tk pop kro jb tk stack empty a ho jaye

                // never reached

                // ye try catch hme phir b bnana pda kyunki error aa rha tha sirf stack.pop() likhne se to try catch me surround kr diya
            }
        }




        // stack using linked list yahan se
//        StackUsingLL<Integer> stack = new StackUsingLL<>();





    }
}
