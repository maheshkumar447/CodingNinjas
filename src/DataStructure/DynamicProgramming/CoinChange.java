package DataStructure.DynamicProgramming;

public class CoinChange {


    public static int countWaysToMakeChange(int denominations[], int value){

        int storage[] = new int[value+1];
        storage[0] = 1;
        
        for(int i =0;i<denominations.length;i++){
            for(int j = 0;j<=value;j++){
                if(j >= denominations[i]){
                    storage[j] = storage[j] + storage[j-denominations[i]];
                }
            }
        }

        return storage[value];

    }

    public static void main(String[] args) {

    }
}
