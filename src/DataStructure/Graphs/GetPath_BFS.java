package DataStructure.Graphs;

import java.io.IOException;
import java.util.*;

public class GetPath_BFS {


    public static ArrayList<Integer> getPath(int edges[][] , int startingVertex , int endVertex , boolean visited[]){

        ArrayList<Integer> output = new ArrayList<>();
        if(startingVertex == endVertex){  // agar start or end ek hee ho to usi ko retunr krwa do
            output.add(startingVertex);
            visited[startingVertex] = true;  // visited array to true krni hee h

            return output;
        }

        Queue<Integer> queue = new LinkedList<>();  // queue li taaki hum adjacent vertex ka dhyan rkh ske
        queue.add(startingVertex);  // queue mw add kri
        HashMap<Integer, Integer> map = new HashMap<>();  // Hashmap liya kyunki hum end vertex tk to phuch jayenge traverse krte queue ko but hme path b to find krna h
        // or path k liye hme previous vertex chyiea to unko store krwane k liye hmne hashmap liya taaki inke parents ko store krwa ske


        while(!queue.isEmpty()){
            int front = queue.remove();
            for(int i = 0;i<edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, front);  // map me daalo jo visiit kiya h wo or uska parent mtlb jo nikala h quueue se
                    if (i == endVertex) {
                        output.add(i);

                        while(!output.contains(startingVertex)){  // ye path bnane k liye
                            int temp = map.get(i);  // map se value get krte rho i k corresponding
                            output.add(temp);  // arraylist me add krte rho

                            i = temp;  // while ki condition
                        }

                        return output;  //last me arraylist krdi return
                    }
                }
            }
        }

        return null;  // agar path nhi hua to return null


    }


    public static void main(String[] args)  throws NumberFormatException, IOException {
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[n][n];

        for(int i = 0; i<e; i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        int startingVertex=sc.nextInt();
        int endingVertex=sc.nextInt();
        boolean visited[]=new boolean[edges.length];
        ArrayList<Integer> ans=getPath(edges,startingVertex,endingVertex,visited);
        if(ans!=null){
            for(int elem:ans)
            {
                System.out.print(elem+" ");
            }
        }
    }
}
