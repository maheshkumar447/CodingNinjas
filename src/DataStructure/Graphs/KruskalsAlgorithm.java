package DataStructure.Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;   // ye weight k acc increasing order me array kos ort krne me help krega
    }
}
public class KruskalsAlgorithm {

    public static int findParent(int vertex, int []parent){
        if(parent[vertex] == vertex){
            return vertex;
        }
        return findParent(parent[vertex],parent);
    }

    public static void kruskals(Edge[] input, int n){
        Arrays.sort(input);  // ab input ko kis basis pe sort krna h ye hme decide krna pdega or usi k liye hmne comparable interface implement kiya h

        Edge[] output = new Edge[n-1];
        int count = 0; // count hme btayega ki hmare MST me kitni edgea aa chuki h
        int i =0;  // current konsi edge traverse ho rhi h wo ye btayega or we can say that ye hme currentEdge k baare me btayega

        int [] parent = new int[n];
        for(int p = 0;p<n;p++){
            parent[p] = p;  // shuru me  har element ka wo khud he parent hoga or hmne wahi kiya usi index pr wo index khud rkh diya
        }

        while(count != n-1){  // kyunki MST me maximum n-1 hee edges ho skti h
            Edge currentEdge = input[i];  // edge jisko hum ab consider kr rhe h
            // is edge k 2 vertex honge or un dono vertices k parent honge  or parent k liye hee hmne parent array bnayi h

            // to wo parent find kro
            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.destination, parent);

            // ab parents ko compare krna h
            if(sourceParent != destParent) { // jb nhi h equal tbhi hum inko add kr skte h MST me
                output[count] = currentEdge;  // output k count index pr current Edge rkhdi jo hum traverse kr rhe the
                count++; // count ko increase krdiya
                parent[sourceParent] = destParent;  // ab jo do parent aaye the unme se b ek ko child or ek ko parent bnana h or hmne wahi kiya h yahan pr
            }

            i++;  // current edge to har baar chge hogi chahe if ki condition true ho ya false or isiliye i ko increase to har baar krenge
        }
        // MST ko print krwane k liye
        for(int j =0;j<n-1;j++){
            if(output[j].source <output[j].destination){  // source or dest me se wo phle print kiya jo chota h
                System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
            }else{ // yahan b wahi jo chota h
                System.out.println(output[j].destination + " " + output[j].source + " " + output[j].weight);
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int E = sc.nextInt();

        Edge[] input = new Edge[E];

        for(int i = 0;i<E;i++){

            input[i] = new Edge();  // har element ka object bnana pdega taaki hum value set kr ske har element ki

            input[i].source = sc.nextInt();  //har ith element k liye source liya user se
            input[i].destination = sc.nextInt();  // destination b liya as an input
            input[i].weight = sc.nextInt();   // weight b liya
        }

        kruskals(input,n);

    }
}
