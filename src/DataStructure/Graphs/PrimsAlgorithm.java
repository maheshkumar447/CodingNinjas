package DataStructure.Graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

    public static int findMinVertex(int []weight, boolean visited[]){
        int minVertex = -1;  // shuru me -1 maan liya
        for(int i =0;i<weight.length;i++){  // puri array traverse kri
            if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])){
                // if me conditions: ek to ye ki wo unvisited honi chyiea
                // dusra ye ki ya to minVertex pr -1 ho or ya phir weight kisi b ith index pr minVertex index se km hona chyiea kyunki hme min weight wali vertex chyiea hoti h
                // dhyan rkhne wali baat yahan ki minVertex == -1 wali condition hmesha phle likhi jayegi || se jaisa ki yahan likha h kyunki agar aisa nhi hua to
                // array index of bound exception aayega kyunki phir weight[minVertex] wali condition phle chlegi or bilkul starting me minVertex -1 hee h or -1 index nhi hota array me
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void prims(int [][]edges){
        int n = edges.length;
        // teen cheeze chyiea hme so leli
        boolean [] visited = new boolean[n];
        int  weight[] = new int[n];
        int parent[] = new int[n];


        // ab hme first vertex i.e. starting vertex ka weight 0 rkhna h or uska parent -1 rkhna h bcz ye hum assume kr rhe h
        weight[0] = 0;
        parent[0] = -1;

        // baaki sbhi nodes ka weight infinte rkhna h
        for(int i =1;i<n;i++){
            weight[i] = Integer.MAX_VALUE;
        }

        // now traverse whole graph
        for(int i =0;i<n;i++){
            // pick vertex with min weight
            int minVertex = findMinVertex(weight,visited);  // is function me hmne 2 argument pass kre h mtlb ek to weight array or ek ye ki wo unvisited honi chyiea
            visited[minVertex] = true;  // minVertex wali vertex ko visited bnado

            // now explore its unvisited neighbours
            for(int j = 0;j<n;j++){
                if(edges[minVertex][j] !=0 && !visited[j]){  // ye condition h ye btane k liye ki konsi node j ki neighbour h or konsi nhi h
                    // array me by default 0 hoti h values saari or agar koi node exist kregi to uska kuch n kuch weight to jrur hoga so agar koi b weight hua or wo unvisited hui to wo iski neighbour h otherwise nhi h
                    // now hum check krenge ki kya hme weight update krna chyiea ya nhi
                    if(edges[minVertex][j] < weight[j]){  // agar weight ka purana weight bda h new weight se to hum 2 cheese update krege
                        weight[j] = edges[minVertex][j];  // phli cheez weight i.e. jo ab minimum h wo krdenge
                        parent[j] = minVertex;  // dusri is uska parent kyunki hmne algo me discuss kr b rkha h ki parent b chnge hoga kyunki shuru me sbka parent hmne null mana tha or we can say by default 0 hota h kyunki array me by default 0 hoti h values saari

                    }

                }
            }
        }

        // now print edges of MST
        // hum vertex or uske parents se edges ka pta kr payenge
        for(int i = 1;i<n;i++){
            if(parent[i] < i){  // jiski value choti h wo phle print krwa rhe h or value choti depend krti h parent pr
                System.out.println(parent[i] + " " + i + " "  +weight[i]);
            }else{
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int E = sc.nextInt();

        int edges[][] = new int[n][n];
        for(int i = 0 ;i<E;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            edges[source][destination] = weight;
            edges[destination][source] = weight;
        }
//        boolean visited[] = new boolean[n];
        prims(edges);
    }
}
