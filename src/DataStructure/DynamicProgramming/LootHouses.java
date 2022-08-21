package DataStructure.DynamicProgramming;

public class LootHouses {

    public static int maxMoneyLooted(int[] houses) {

        int m = houses.length;
        if(m==0){
            return 0;
        }

        int storage[] = new int[m+1];

        // ye dono base case h
        storage[0] = houses[0];  // phle case me sirf first element hee kyunki hmare pass h b bs wahi element
        storage[1] = Math.max(houses[0],houses[1]);   // second me hmatre pass do element h r hum ek hee le skte h bcs dono adjacent h to jo max hoga wo leliya

        for(int i = 2;i<m;i++){
            int opt1 = houses[i] + storage[i-2];  // case jb element include kiya
            int opt2  = storage[i-1];   // case hb nhi kiya include

            storage[i] = Math.max(opt1,opt2);
        }

        return storage[m-1];  // hmara ans last index pr pda hoga ....kyunki hme puri array traverse krni h and last index contains our answer

    }


    public static void main(String[] args) {

    }
}
