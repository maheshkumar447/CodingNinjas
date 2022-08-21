package ObjectOrientedProgramming;

public class ComplexNumber {
    private int real;
    private int imaginary;
//    private int real2;
//    private int imaginary2;

    public ComplexNumber(int real,int imaginary){
        this.real = real;
        this.imaginary = imaginary;

//        this.real2 = real2;
//        this.imaginary2 = imaginary2;

    }

//    public int getReal1() {
//        return real1;
//    }
//
//    public void setReal1(int real1) {
//        this.real1 = real1;
//    }
//
//    public int getImaginary1() {
//        return imaginary1;
//    }
//
//    public void setImaginary1(int imaginary1) {
//        this.imaginary1 = imaginary1;
//    }
//
//    public int getReal2() {
//        return real2;
//    }
//
//    public void setReal2(int real2) {
//        this.real2 = real2;
//    }
//
//    public int getImaginary2() {
//        return imaginary2;
//    }
//
//    public void setImaginary2(int imaginary2) {
//        this.imaginary2 = imaginary2;
//    }

//        public int getReal1(){
//        return real1;
//    }
//    public int getImaginary1(){
//        return imaginary1;
//    }
//    public int getReal2(){
//        return real2;
//    }
//    public int getImaginary2(){
//        return imaginary2;
//    }
//
//    public void setReal1(int real1){
//        this.real1 = real1;
//    }
//    public void setReal2(int real2){
//        this.real2 = real2;
//    }
//    public void setImaginary1(int imaginary1){
//        this.imaginary1 = imaginary1;
//    }
//    public void setImaginary2(int imaginary2){
//        this.imaginary2 = imaginary2;
//    }

    public void plus(ComplexNumber c2){
        real=real+c2.real;
       imaginary =imaginary+c2.imaginary;

    }
    public void multiply(ComplexNumber c2){
//        real = ((real*c2.real)-(imaginary*c2.imaginary));
//        imaginary=-((real*c2.imaginary)+(imaginary*c2.real));
        int firstTerm = real* c2.real;
        int secondTerm = real*c2.imaginary;
        int thirdTerm = imaginary*c2.real;
        int fourthterm = -(imaginary*c2.imaginary);
        real = firstTerm+fourthterm;
        imaginary = secondTerm+thirdTerm;
    }
    public void print(){
        System.out.println(real + "+" + "i"+imaginary);
    }

}
