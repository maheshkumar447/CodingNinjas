package DataStructure.DynamicProgramming;

public class Fibonaaci {
    public static int fibM(int n){
        int storage[] = new int[n+1];  // nth fibonacci k liye n+1 unique recursive call ho skti h to hmne n+1 size ka array le liya
        // for more explanation refer to notebook

        for(int i =0;i<=n;i++){ // har index pe shuru me -1 daal diya
            storage[i] = -1;
        }

        return fibM(n,storage);   // recursive call
    }

    private static int fibM(int n, int[] storage) {
        if(n==0||n==1){
            storage[n] = n;  // storage array k nth index pe n store kiya or rturn krwa diya
            return storage[n];
        }
        // ab recursive call krne se ohle check krege ki kya hum jo calculate krne wale h wo phle se calculated h ya nhi agar h to dobara call nhi krenge
        // hme kaise pta lgega ki answer calculate ho chuka h ya nhi
        // agar array k us index pr -1 nhi h to mtlb answer calculate ho chuka h or ab dobara krne ki jrurt nhi h
        if(storage[n] != -1){  // mtlb ans phle calculate hi chuka h
            return storage[n];  // to recursion call krne ki jrut nhi h hum siple retunr krwadenge
        }

        // agar ans nhi h to recursion krao
        storage[n] =  fibM(n-1,storage)+fibM(n-2,storage); // ye recurssive call hum store krenge taaki hum aage isko as a ans use kr ske
        return storage[n];  // return krwa diya

        // ab agar tum diff dekhna chahte ho jaise hum phle krte the usme or jo ab kiya isme to n ko bda leke dekho like 45 to apne aap faark pta chal jayega ki wo kitna jyada time leta h run hone me
    }






// yahan hum dynamic programming use krenge
    // DP hme khta h ki agar recursion ka use na ho to recursion use mt kro , use aviod kro
    public static int fibDP(int n){
        int storage[] = new int[n+1];
        storage[0] = 0;  // base case
        storage[1] = 1;// base case

        for(int i = 2;i<=n;i++){  // 2 se isisliye kyunki phle 2 cases to hum cover kr chuke h uper base case me
            storage[i] = storage[i-1] + storage[i-2];  // storage i-1 pr or storage[i-2] pr storage[i] ka result h
        }

        return storage[n];  // jb sara kaam ho jayega tb hum ye return krwa denge

    }
    public static void main(String[] args) {
        int n= 44;
        System.out.println(fibM(n));
        System.out.println(fibDP(n));
    }
}
