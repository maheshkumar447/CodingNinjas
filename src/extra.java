import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//import static java.lang.System.out;

//abstract class Myclass{
//    void init(){
//
//    }
//    abstract int cal();
//}
//class My extends  Myclass{
//    int cal(){
//        System.out.println("invoing cal");
//        return 1;
//    }
//}

//class Base{
//    Base(){
//        System.out.println("Base cons invoked");
//    }
//}

//class B{
//    int m=7;
//
//}
//
//class D extends B{
//    int m=9;
//}



//class A{
//    public void bag(){
//        System.out.println("A");
//    }
//}



public class extra {


//    public static int findKey(int input1, int input2, int input3){
//        int key1 =0;
//
//        int key2 =0;
//
//        int key33 = 0;
//
//        int KEY;
//
//        int[] key3 = new int[4];
//
//
//        while(input1 >= 1000)
//
//        {
//
//            input1 = input1 - 1000;
//
//            input1 = input1;
//
//        }
//
//        while(input1 >= 100)
//
//        {
//
//            input1 = input1 - 100;
//
//            key1 = key1 + 1;
//
//        }
//
//        while(input2 >= 100)
//
//        {
//
//            input2 = input2 - 100;
//
//            input2 = input2;
//
//        }
//
//        while(input2 >= 10)
//
//        {
//
//            input2 = input2 - 10;
//
//            key2 = key2 + 1;
//
//        }
//
//        key3[0]=input3/1000;
//
//        input3=input3-(1000*key3[0]);
//
//        key3[1]=input3/100;
//
//        input3=input3-(100*key3[1]);
//
//        key3[2]=input3/10;
//
//        input3=input3-(10*key3[2]);
//
//        key3[3]=input3;
//
//        key33 = Arrays.stream(key3).max().getAsInt();
//
//        KEY = (key1 * key2) - key33;
//
//        System.out.println("Hundreds digit of input1 = " + key1);
//
//        System.out.println("Tens digit of input2 = " + key2);
//
//        System.out.println("Largest digit of input3 = " + key33);
//
//        System.out.println("KEY = " + KEY);
//
//
//    }

    public static int sum(int arr[]){
        int add=0;
        for(int i=0; i<arr.length; i++){
            add += arr[i];
        }
        return add;
    }
//
//    public static int ethan(int arr[], int n, int k ,int index){
//        int ans = 0;
//
//        if((sum(arr)) == 0){
//            return ans;
//        }
//        if(index >= arr.length){
//            return ans;
//        }
//        arr[index] = arr[index] - n;
//
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] == index){
//                continue;
//            }
//            arr[i] = arr[i] - k;
//
//        }
//        ans = 1 + ethan(arr, n, k, index+1);
//        return ans;
//
//    }

//    public static int min(int[] arr, int[] arr1){
//        int index = -1;
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] == 1){
//                index=i;
//                break;
//            }
//        }
//        int sum=0;
//        int index=0;
//        int min=Integer.MAX_VALUE;
//        for(int j=0; j<arr1.length; j++){
//            if(arr[j] == 0){
//                for(int i=0; i<arr1.length; i++){
//                    if(i==j){
//                        continue;
//                    }else if(arr[i] == 1) {
//                        int diff = Math.abs(arr1[j] - arr1[i]);
//                        if (diff <= min) {
//                            min = diff;
//                            arr[j] = 1;
//                        }
//                    }
//
//                }
//                sum += min;
//            }
//
//        }
//
//        return sum;
//    }


//    public static int findKey(int i1, int i2, int i3){
//        int answer=0;
//        int t = i1/1000;
//        int d1 = t%10;
////        System.out.println(d1);
//        int temp = i2/100;
//        int d2 = temp%10;
//
////        System.out.println(d2);
//
//        int temp1 = i3;
//        int small = Integer.MAX_VALUE;
////        int d3 = 0;
//        while(temp1>0){
//            int digit = temp1%10;
//            if(digit < small){
//                small = digit;
//            }
//
//            temp1 = temp1/10;
//        }
//
//        answer = (d1*d2) + small;
//
//        return answer;
//
//    }

//    extra(){
//        System.out.println("derived cons");
//    }


//    public static int findKey(int i1,int i2, int i3){
//        String ans="";
////        int ans = 0;
//
//        int o1 = i1%10;
//        int o2 = i2%10;
//        int o3 = i3%10;
//
//        int maxO = Math.max(o1, Math.max(o2,o3));
//        int minO = Math.min(o1, Math.min(o2,o3));
//
//        int temp1 = i1/10;
//        int temp2 = i2/10;
//        int temp3 = i3/10;
//        int t1 = temp1%10;
//        int t2 = temp2%10;
//        int t3 = temp3%10;
//
//        int maxT = Math.max(t1, Math.max(t2,t3));
//        int minT = Math.min(t1, Math.min(t2,t3));
//
//        int temp11 = i1/100;
//        int temp22 = i2/100;
//        int temp33 = i3/100;
//        int h1 = temp11%10;
//        int h2 = temp22%10;
//        int h3 = temp33%10;
//
//        int maxH = Math.max(h1, Math.max(h2,h3));
//        int minH = Math.min(h1, Math.min(h2,h3));
//
//        int temp111 = i1/1000;
//        int temp222 = i2/1000;
//        int temp333 = i3/1000;
//        int th1 = temp111%10;
//        int th2 = temp222%10;
//        int th3 = temp333%10;
//
//        int maxTH = Math.max(th1, Math.max(th2,th3));
//        int minTH = Math.min(th1, Math.min(th2,th3));
//
//
//        ans += (maxTH - minTH);
//        ans += (maxH-minH);
//        ans += (maxT - minT);
//        ans += (maxO - minO);
//
//        int ans1 = Integer.valueOf(ans);
//
//        return ans1;
//    }

//    public static int findKey(int input1, int input2, int input3){
//        int answer = 0;
//
//        int temp = input1/100;
//        int d1 = temp%10;
//
//        int temp1 = input2/10;
//        int d2 = temp1%10;
//
//        int d3 = Integer.MIN_VALUE;
//        while(input3>0){
//            int digit = input3%10;
//            if(digit > d3){
//                d3 = digit;
//            }
//            input3 = input3/10;
//        }
//        answer = (d1 * d2) * d3;
//
//        return answer;
//
//    }

//    static int distance(int Ax, int Ay, int Bx, int By){
//        int d1 = ((Ax*Ax) + (Ay*Ay));
//        int d2 = ((Bx*Bx) + (By*By));
//
//        if(d1 < d2){
//            return d1;
//        }
//        else{
//            return d2;
//        }
//    }

//    public static int max(int input){
//        int maximum = Integer.MIN_VALUE;
//        while(input!=0){
//            int digit = input%10;
//            if(digit > maximum){
//                maximum = digit;
//            }
//
//            input = input/10;
//        }
//
//        return maximum;
//    }
//
//    public static int min(int input){
//        int minimum = Integer.MAX_VALUE;
//        while(input!=0){
//            int digit = input%10;
//            if(digit < minimum){
//                minimum = digit;
//            }
//
//            input = input/10;
//        }
//
//        return minimum;
//    }
//
//    public static int findKey(int input1, int input2, int input3, int input4){
//        int max1 = max(input1);
//        int max2 = max(input2);
//        int max3 = max(input3);
//
//        int min1 = min(input1);
//        int min2 = min(input2);
//        int min3 = min(input3);
//
//        int answer = ((max1*min1) * (max2*min2) * (max3*min3)) - input4;
//
//        return answer;
//    }

//    public static int findRepeated(int arr[], int n){
//        int count=0;
//        for(int i=0; i<n; i++){
//            if(arr[i] <= 0){
//                count++;
//            }
//        }
//
//        if(count == n){
//            return 0;
//        }
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        int answer =0;
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                if(arr[i] == arr[j] && arr[i] > 0){
//                    ans.add(j);
//                }
//            }
//        }
//
//
//        int index=Integer.MAX_VALUE;
//        for(int i=0; i<ans.size(); i++){
//            if(index > ans.get(i)){
//                index = ans.get(i);
//            }
//        }
//
//
//        if(ans.size() == 0){
//            answer = arr[0];
//        }
//        else{
//            answer = arr[index];
//        }
//
//        return answer;
//    }

//    public static int frindRepArray(int input1[],int input2){
//        int minIndex = -1;
//        int count=0;
//        for(int i=0;i<input2;i++){
//            if (input1[i] <= 0) {
//                count++;
//            }
//        }
//        if(count == input2){
//            return 0;
//        }
//        HashSet<Integer> set = new HashSet<>();
//            for (int i = 0; i < input2; i++) {
//                if (set.contains(input1[i])) {
//                    minIndex = i;
//                } else if(input1[i]>0) {
//                    set.add(input1[i]);
//                }
//            }
//
//            if (minIndex != -1) {
//                return input1[minIndex];
//            } else {
//                return input1[input2 - 1];
//            }
//
//    }

//    public static int sumofNonPrime(int input1[], int input2){
//        int sum=0;
//        for(int i=0;i<input1.length;i++){
//            sum+=input1[i];
//        }
//        int ans = sumofPrime(input1,input2);
//        int res = sum - ans;
//        return res;
//    }
//
//    public static int sumofPrime(int input1[], int input2){
//        if(input2<=2){
//            return 0;
//        }
//        if(input2 == 3){
//            return input1[2];
//        }
//        int sum = 0;
//        for(int i=1;i<input2;i++){
//            if(isPrime(i)){
//                sum+=input1[i];
//            }
//        }
//        return sum;
//    }

    public static boolean isPrime(int a){
        if(a<2) return false;
        if(a==2) return true;
        if(a%2 == 0) return false;

        for(int i=2;i*i<=a;i++){
            if(a%i==0) return false;
        }
        return true;
    }
    public static int sumOfPrime(int arr[]){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(isPrime(arr[i])){
                sum+=arr[i];
            }
        }

        Arrays.sort(arr);
        int temp=0;
        for(int i=arr.length-1; i>=0; i--){
            if(isPrime(arr[i])){
                temp=arr[i];
                break;
            }
        }

        sum = sum-temp;

        return sum;
    }


//    private static int minDays(int[][] grid) {
//        Queue<int[]> q = new LinkedList<>();
//        int target = grid.length * grid[0].length;
//        int cnt = 0, res = 0;
//        for(int i=0;i<grid.length;i++) {
//            for(int j=0;j<grid[0].length;j++) {
//                if(grid[i][j] == 1) {
//                    q.offer(new int[] {i,j});
//                    cnt++;
//                }
//            }
//        }
//        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        while(!q.isEmpty()) {
//            int size = q.size();
//            if(cnt == target)
//                return res;
//            for(int i=0;i<size;i++) {
//                int[] cur = q.poll();
//                for(int[] dir : dirs) {
//                    int ni = cur[0] + dir[0];
//                    int nj = cur[1] + dir[1];
//                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
//                        cnt++;
//                        q.offer(new int[] {ni, nj});
//                        grid[ni][nj] = 1;
//                    }
//                }
//            }
//            res++;
//        }
//        return -1;
//    }



    public static void main(String[] args) {

        // Initialization of a Hashtable
        // using Generics


        // Inserting the Elements
        // using put() method


        int arr[] = {10,41,18,50,43,31,29,25,59,96,67};
        int ans = sumOfPrime(arr);
        System.out.println(ans);

//        ArrayList<String> list = new ArrayList<String>() ;
//        list.add( "apple" );
//        list.add( "banana" );
//        list.add( "carrot" );
//        list.add( 0, "mango" );
//
//        System.out.println(list.get(2));
//        int i1 = 3521;
//        int i2 = 2452;
//        int i3 = 1352;
//        int i4 = 38;
//        int ans = findKey(i1, i2, i3, i4);
//        System.out.println(ans);

//        int arr[] ={1,2,3,0};
//        int input2 = 4;
//        int ans = findRepeated(arr, input2);
//        System.out.println(ans);


//        int i;
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader bf = new BufferedReader(isr);
//        String s = bf.readLine();

//        int Ax = 12;
//        int Ay = 5;
//        int Bx = 12;
//        int By = 9;
//
//        int ans = distance(Ax, Ay, Bx, By);
//        System.out.println(ans);

//        int[][] arr = new int [2][2];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//        }


//        int[] arr = {1,2,3,4,5};
//
//        for(int counter: arr){
//            System.out.println(counter++);
//        }


//        float f1 = 2.0f;
//        double d1 = 4.0;
//        double result = f1 * d1;
//        System.out.println(result);



//        DomesticAnimal da = new DomesticAnimal("cat");
//        System.out.println(da.animalFamily);

//
//        B b = new B();
//        D d = new D();
//        B bd = new D();
//        System.out.println(b.m + " " + d.m + " " + bd.m);


//        Map<String, String> lhm = new LinkedHashMap<>();
//        lhm.put("Platform", "Windows");
//        lhm.put("Language", "Java");
//        lhm.put("Version", "1.5");
//        out.format("%s", lhm);

//        int i1 = 3521;
//        int i2 = 2452;
//        int i3 = 1352;
//
//        int ans = findKey(i1, i2, i3);
//        System.out.println(ans);



//        try{
//            if(args.length ==0){
//                return;
//            }
//            System.out.println(args[0]);
//        }
//        finally{
//            System.out.println("The end");
//        }


//        for(int i=1; i<20; i++){
//            if(i > 10){
//                break;
//            }
//            else{
//                System.out.println(i);
//            }
//        }

//   My m = new My();
//   m.init();
//   m.cal();

//       int i1 = 3521;
//       int i2 = 2452;
//       int i3 = 1352;
//       int ans = findKey(i1, i2, i3);
//       System.out.println(ans);

//        int a = 0;
//        int b=9;
//        int bArr[] = new int[1];
//        bArr[0]=b;
//        inc1(a);
//        inc2(bArr);
//        System.out.println("a=" + a +"b="+b+"bArr[0]="+bArr[0]);



//        LinkedHashSet<String> lhs = new LinkedHashSet<>();
//        lhs.add("ninety");
//        lhs.add("forty");
//        lhs.add("sixty");
//        lhs.add("twenty");
//        for(String elemnt:lhs){
//            System.out.print(elemnt+" ");
//        }


//        int arr[] = {1,0,1,1,0,1,1};
//        int arr1[] = {1,5,6,7,8,9,17};
//
//        int ans = min(arr, arr1);
//        System.out.println(ans);
//       int data[] = {2,1,3,2,4,2,4};
//       Set<Integer> my = new TreeSet<>();
//       for(int n : data){
//           my.add(n);
//       }
//       for(int s:my){
//           System.out.println(s+" ");
//       }
//        int arr[] = {6,4,1};
//        int n = 4;
//        int k = 1;
//
//        int ans = ethan(arr, n, k, 0);
//        System.out.println(ans);
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            int arr[] = new int[n];
//            for (int i =0;i<n;i++){
//                arr[i] = sc.nextInt();
//            }
//        Arrays.sort(arr);
//
//
//        int i = 0, j = n-1;
//
//        while (i < j) {
//
//            System.out.println(arr[j--]);
//
//            System.out.println(arr[i++]);
//
//        }
//
//        if (n % 2 != 0)
//
//            System.out.println(arr[i]);


//
//Scanner sc = new Scanner(System.in);
//int N  = sc.nextInt();
//int k = sc.nextInt();
////String s ="";
//int x=0;
//int size = k*N;
//int count=0;
//String arr[] = new String[size];
//for(int i =0;i<N;i++){
//    for(int j =0;j<k;j++){
////        s = sc.nextLine();
//     String s = sc.next();
//     arr[x] = s;
//     x++;
//    }
////    System.out.println(s);
//}
//System.out.println(s);
//        for(int i =0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

//        for(int i =0;i<size;i++){
//            for(int j=i+1;j<size;j++){
//                if(arr[i].equals(arr[j])){
//                    count++;
//                }
//            }
//        }
//        System.out.println(size-count);
//    }

//        Scanner sc = new Scanner(System.in);
//        int B = sc.nextInt();
//        int J = sc.nextInt();
//        int T = sc.nextInt();
//        int arr[] = new int[J];
//        int arr1[] = new int[T];
//        for(int i=0; i<J; i++){
//            arr[i] = sc.nextInt();
//        }
//        for(int i=0; i<T; i++) {
//            arr1[i] = sc.nextInt();
//        }
//        int maxSum = 0;
//        int i1=-1;
//        int i2=-1;
//        for(int i=0; i<J; i++){
//            for(int j=0; j<T; j++){
//                int sum = arr[i] + arr1[j];
//                if(sum <= B) {
//                    if (sum > maxSum) {
//                        maxSum = sum;
//                        i1 = i;
//                        i2 = j;
//                    }
//                }
//            }
//        }
//
//        if(i1==-1 && i2==-1){
//            System.out.println(-1);
//        }else {
//            System.out.println(arr[i1] + arr1[i2]);
//        }
    }

//        public void bag(){
//            System.out.println("B");
//        }


//    public static void inc1(int x){
//        x++;
//    }
//    public static void inc2(int []x){
//        x[0]++;
//    }

}

//    public static String formWord(String input1){
//        String ans="";
//        for(int i =0;i<input1.length();i++){
//            if(input1.charAt(i)==':') {
//               int c1 = input1.charAt(i-1);
//               int c2 = input1.charAt(i-2);
//               int z=c1-c2;
//               int a = Math.abs(z);
//               if(a==0){
//                   char c = Character.toUpperCase(input1.charAt(i - 1));
//                    ans += c;
//               }else{
//                   int v = 'a'+a-1;
//                   char c = Character.toUpperCase((char)v);
//                   ans += c;
//               }
//            }
//            if(i==input1.length()-1){
//                int c1 = input1.charAt(input1.length()-1);
//                int c2 = input1.charAt(input1.length()-2);
//                int z=c1-c2;
//                int a = Math.abs(z);
//                if(a==0){
//                    char c = Character.toUpperCase(input1.charAt(input1.length()-1));
//                    ans += c;
//                }else{
//                    int v = 'a'+a-1;
//                    char c = Character.toUpperCase((char)v);
//                    ans += c;
//                }
//            }
//
//
//        }
//
//        return ans;
//
//
//    }


//    public static int countV(String input1) {
//        int vcount = 0;
//        input1 = input1.toLowerCase();
//        for (int i = 0; i < input1.length(); i++) {
//            //Checks whether a character is a vowel
//            if (input1.charAt(i) == 'a' || input1.charAt(i) == 'e' || input1.charAt(i) == 'i' || input1.charAt(i) == 'o' |
//            | input1.charAt(i) == 'u') {
//                //Increments the vowel counter
//                vcount++;
//            }
//        }
//        return vcount;
//    }




//    public static String checkEmail(String input1){
//        String p1 = "";
//        String p2 = "";
//        String p3 = "";
//        int i1 = 0;
//        String ans = "";
//
//        for(int i=0; i<input1.length(); i++){
//            if(input1.charAt(i) == '@'){
//                i1 = i;
//                break;
//            }
//            else{
//                p1+= input1.charAt(i);
//            }
//        }
//        int i2 =0;
//        for(int i=i1; i<input1.length(); i++){
//            if(input1.charAt(i) == '.'){
//                i2 = i;
//                break;
//            }
//            else{
//                p2+= input1.charAt(i);
//            }
//        }
//        for(int i=i2; i<input1.length(); i++){
//                p3+= input1.charAt(i);
//        }
//
//        String s = ".com";
//        String s1 = "@wipro";
//        String s2 = "@gmail";
//        String s3 = "@yahoo";
//
////        if(p1.length() > 15){
////            ans += p1;
////            ans += ":";
////            ans+=p2;
////            ans+=":";
////            ans+="invalid";
////            return ans;
////        }
////        else if(!(p3 == s)){
////            ans += p1;
////            ans += ":";
////            ans+=p2;
////            ans+=":";
////            ans+="invalid";
////            return ans;
////        }
////        else if(!(p2.equals(s1)) || !(p2.equals(s2)) || !(p2.equals(s3))){
////            ans += p1;
////            ans += ":";
////            ans+=p2;
////            ans+=":";
////            ans+="invalid";
////            return ans;
////        }
////        else if(!(p1.matches("[a-z0-9]")){
////            ans += p1;
////            ans += ":";
////            ans+=p2;
////            ans+=":";
////            ans+="invalid";
////            return ans;
////        }
////        else{
////            ans += p1;
////            ans += ":";
////            ans+=p3;
////            ans+=":";
////            ans+="valid";
////            return ans;
////        }
//
//        if(p1.length() <= 15 && (p2.equals(s1) || p2.equals(s2) || p2.equals(s3)) && p3.equals(s) && p1.matches("[a-z0-9]+")){
//            ans += p1;
//            ans += ":";
//            ans+=p3;
//            ans+=":";
//            ans+="valid";
//            return ans;
//        }
//        else{
//            ans += p1;
//            ans += ":";
//            ans+=p2;
//            ans+=":";
//            ans+="invalid";
//            return ans;
//        }
//    }

//
//        public static int findSum(String str)
//    {
//        String temp = "0";
//        int sum = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//
//            if (Character.isDigit(ch))
//                temp += ch;
//            else {
//                sum += Integer.parseInt(temp);
//                temp = "0";
//            }
//        }
//
//        return sum + Integer.parseInt(temp);
//    }
//
//    public static String alpha(String str){
//        String ans = "";
//        for(int i=0; i<str.length(); i++){
//            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') ||  (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
//                ans = ans + str.charAt(i);
//            }
//        }
//        return ans;
//    }
//
//    public static String find(String input1, int input2){
//        String ans = "";
//        if(input1.isEmpty()){
//            return "NULL";
//        }
//        int c=0;
//        for(int i=0; i<input1.length(); i++){
//            if(input1.charAt(i) == ' '){
//                c++;
//            }
//        }
//        if(c > 0){
//            return "NULL";
//        }
//
//        if(input1.matches("[!@#&()–:;',?/*~$^+=<>]")){
//            return "NULL";
//        }
//
//        if(input2 == 0){
//            ans = "" + findSum(input1);
//        }
//        else{
//            ans = alpha(input1);
//        }
//
//        if(ans == "" || ans.charAt(0) == '0'){
//            return "ZERO";
//        }
//        else {
//            return ans;
//        }
//    }
//
//    public static String findLongWord(String input1){
//        int n = input1.length();
//        String ans = "";
//        if(n <= 10){
//            return input1;
//        }
//        else{
//            ans += input1.charAt(0);
//            ans += n-2;
//            ans+= input1.charAt(n-1);
//            return ans;
//        }
//    }


//    static int findIndex(int n)
//    {
//
//        if (n <= 1)
//            return n;

//        int a = 0, b = 1, c = 1;
//        int res = 1;
//
//        while (c < n)
//        {
//            c = a + b;
//
//            res++;
//            a = b;
//            b = c;
//        }
//
//        int a = 0;
//        int b =1;
//        int c=0;
//        for(int i =0;i<n;i++)
//        {
//            c= a+b;
//            a=b;
//            b=c;
//        }
//
//        return c;
//    }
//
//    public static int sumation(int num){
//        int total = num;
//        while(total/10 != 0){
//            total = sum(total);
//        }
//
//        return total;
//    }
//
//    public static int sum(int num){
//        int digit = 0;
//        int sum = 0;
//        while(num != 0){
//            digit = num%10;
//            sum = sum+digit;
//            num = num/10;
//        }
//
//        return sum;
//    }

//    public static int SumOfCommonAlpha(char input1[], char input2[]){
//        ArrayList<Character> ans = new ArrayList<>();
//        int answer =0;
//        for(int i=0; i<input1.length; i++){
//            for(int j=0; j<input2.length; j++){
//                if(input1[i] == input2[j]){
//                    ans.add(input1[i]);
//                }
//            }
//        }
//
//        int sum=0;
//        for(int i=0; i<ans.size(); i++){
//            sum+= ans.get(i);
//        }
//
//        answer = sumation(sum);
//
//        return answer;

//    }

//    public static void demo(int a, int b){
//        System.out.println(a + " " + b);
//    }




//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String str="";
//        String []arr = new String[n+1];
//        for(int i=0; i<=n; i++){
//            str= sc.nextLine();
//            arr[i] = str;
//        }
//
//        for(int j =0;j<arr.length;j++){
//            String ans = arr[j];
//            for(int k = 0;k<ans.length();k++){
//                System.out.print(ans.charAt(k));
//                if(ans.charAt(k) == ' '){
//                    System.out.println();
//                    System.out.println();
//                }
//            }
//            System.out.println();
//        }
//        System.out.println(str);









