package Recursion;

public class GeometricSum {

    public static double findGeometricSum(int k){

        if(k==0){
            return 1;
        }
        double smallAns= findGeometricSum(k-1);
        smallAns = smallAns+(1/Math.pow(2,k));
        return smallAns;



    }

    public static void main(String[] args) {
        int k =3;
        double ans = findGeometricSum(k);
        System.out.println(ans);
    }
}
