package DataStructure.Graphs;

import java.util.Scanner;

public class Graph {

    public static void printHelper(int edges[][] , int startingVertex, boolean visited[]){
        System.out.println(startingVertex);   // jahan se graph print krwana shuur krna h wo h startingvertex so isko sbse phle print krdiya
        visited[startingVertex] = true; // ye visit ho chuka h to isko mark krna pdega or mark krne k liye hmne isko true rkh diya

        int n = edges.length; //  hmne startingVertex se lekr puri edge ko traverse krna h mtlb puri us row ko
        for(int i =0;i<n;i++){
            if(edges[startingVertex][i] == 1 && !visited[i] ){ // mtlb adjancey matrix me us row k har column i.e. i ki value check kro ki kya value 1 h ya nhi agar 1 h to mtlb wahan path h or agar path h to condition true
                // ab if me hee dusri condtion ki kya wo vertex visit ho chuki h ya nhi agar nhi hui h to hee condition true hogi or hum orint kr skte h otherwise nhi kr skte print
                // so hmari dono condition true hongi to hum print krwayenge or print hum recursion call se krwa denge

                printHelper(edges,i,visited);  // yahan hmara startingVertex change hota rhega har baar kyunki pichli to print ho chuki h to usse aage wali vertex k lo=iye hmne recursion call kri h

            }
        }

    }

    public static void print(int edges[][] ){
        boolean[] visited = new boolean[edges.length];

        // AGAR YE NICHE WALI LINE CHLAKE DEKHNI H TO STARTINGVERTEX KO AS A ARGUMENT PASS KRNA PDEGA FUNCTION ME ISI ME

//        printHelper(edges,startingVertex,visited);
        // ab yahan ye hum print krwa denge or print ho b jauyega but ab b ek major dikkat h hmare code me
        // wo major prblm kya h ... suppose ek jagah vertex h 1,2,3 or ek jagah vertex h 4,5 or ye aapas me connected nhi h but ye ek hee graph me h
        // or hmne startingVertex 1 diya to wo 1,2,3 ko to print kr dega but wo 4 pr kbhi gya hee nhi to wo 4,5 ko print nhi krega jbki hine chyiea the
        // to iske liye hme ye krna hoga ki isko startingIndex as a argument pass na krke hum kuch ye krenge ki
        // hum edges wali array me dekhenge ki kya koi vertex aisi bachi h jo ek baar b visit na hui ho
        // agar koi aisi bachi h to hum uski ek vertex ko startingVertex de denge
        // or ye kaam hum for loop se krenge

        for(int i = 0;i<edges.length;i++){
            if(!visited[i]){  // agar nhi hua h visit to
                printHelper(edges,i,visited);   // ab kitne b unconnected component kyu na ho hum startigvertex ko chnge krte rhenge ie.e i here
            }
        }
    }







    public static void main(String[] args) {
        int n; // no of vertices
        int e; // no of edges

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();

        // ab 2D array bnani h to hum kis type ki bnaye int ya boolean kyunki hme true false store krwane h so boolean sahi rhega  but
        //hum int ki bnake values store krwa denge like 1, 0 kyunki baad me kaam aayega ye int bnana
        // jahan jahan edge hogi wahan 1 otherwise 0
        int edges[][] = new int[n][n];

        for(int i =0;i<e;i++){
            int firstVertex = sc.nextInt();
            int secondIndex = sc.nextInt();

            edges[firstVertex][secondIndex] = 1;   // first vertex se second vertex tk ki ek edge h
            edges[secondIndex][firstVertex] = 1;  // so iska vice versa b possible h or hum jahan edge h wahan 1 rkh denge
        }


        print(edges);


    }
}
