package DataStructure.Graphs;

import DataStructure.Queue.QueueEmptyException;
import DataStructure.Queue.QueueUsingLL;

import java.util.Scanner;

public class BFS_Graph {


    public static void printHelper(int edges[][] , int startingVertex, boolean[] visited){

        // hum is questio me queue ka use krenge or as like level order traversal in case of tree solve krenge but hum yahan pr recursrion use nhi krenge bcz
        // recursion apna phle ek taraf ka pura kaam krke aata h or phir return krta h value or ye DFS hee ho jayega basically
        // so hum recusrion use nhi krenge
        // hum starting vertex ko queue me insert krenge or usko bhar nikalenge or phir jo b uske adjacent h unko add kredenge queue me or hum aisa hee krenge last tk
        // isme hum visited wala case b dhyan rkhenge ki hmne wo vertex dobara add nhi krne jo hum add kr chuke h
        // hum apni khud ki Queue use krenge jo hmne bna rkhi h

        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        queue.enqueue(startingVertex);   // starting index queue me insert krdiya
        visited[startingVertex] = true;  // wo visit ho chuka h to true return krdo

        int n = edges.length;  // adjancey values nikalne k liye
         while(!queue.isEmpty()){  // queue empty nhi h to
             int front;
             try {
                  front  = queue.dequeue();  // element nikalo or hme pta hee h front element niklta h hmesha
             } catch (QueueEmptyException e) {  // ye exception kbhi aayegi nhi but phir b hmne surround krdiya kyunki software hmara error dikha rha tha
                 return;
             }

             System.out.println(front);  // front print krwa diya

             //now check adjancey vertex
             for(int i =0;i<n;i++){
                 if(edges[front][i] == 1 && !visited[i]){ // front jo nikli h vertex wo puri traverse kri for column i , agar wahan path h mtlb value 1 h and
                     // wo vertex visit b nhi hua h to hum queue me daal denge
                     queue.enqueue(i);  // i wali vertex daal di
                     visited[i] = true; // visited true b krdi

                 }
             }
         }




    }

    public static void print(int edges[][]){
        boolean[] visited = new boolean[edges.length];
        for(int i =0;i< edges.length;i++){
            if(!visited[i]){
                printHelper(edges,i,visited);
            }
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOExcception {

        int n ;
        int e;
        Scanner  sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[n][n];

        for(int i =0;i<e;i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;

        }

        print(edges);

    }
}
