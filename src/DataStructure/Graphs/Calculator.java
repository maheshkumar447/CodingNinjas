package DataStructure.Graphs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"7","8","9","+",
                             "4","5","6","-",
                             "1","2","3","*",
                             ".","/","C","?",
                             "+/-","=","0"};

    int [] dimW = {430,70,150,140};
    int[] dimH = {50,60};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    boolean[] function = new boolean[4];
    double[] temporary = {0,0};
    JTextArea display = new JTextArea(2,25);
    Font font = new Font("Times new Roman", Font.BOLD,20);

    Calculator(){ // constructor bnaya h
        super("Calculator"); // super keyword se porent class call ki hui h or isme ek string pass ki gyi h , ye string actually me ek title h or yahan hum jo b likhenge wo hmare calculator window k title me show hoga
        setDesign();  // to set basic design
        setSize(500,300);  // ye parent class i.e. JFrame me inbuilt function h
        setResizable(false);  // hum window ko resize kr paye....true mtlb kr skte h or false mtlb nhi..... false isiliye kyunki layout na khrab ho
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // close press krne pe kya hona chyiea..... EXIT hona chyiea
        GridLayout grid = new GridLayout(5,5);   // 5*5 ka grid bnaya
        setLayout(grid);   // Jframe ka layout set kr dega

        for(int i = 0;i<4;i++){
            function[i] = false;
        }

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);   // isme kaafi properties h jaise ki align kahan hone chyiea elements ...cemter me left me ya kahan
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1); // horizontal gap kitna hona chyiea and vertical also
        // upto here jitni b classes aayi h wo saari inbuilt classes h


        for(int i =0 ;i<5;i++){
            row[i] = new JPanel();  // har row ko ek JPanel assign kiya
        }
        row[0].setLayout(f1);  // first row ka lyout alag se set kiya kyunki hme phli ka layout alag chyiea tha i.e. screen of our calculator

        for(int i =1;i<5;i++){
            row[i].setLayout(f2);  // second row se aage sbhi k liye alag tarah ka layout
        }

        for(int i = 0;i<19;i++){  // i =0 se 19 tk har button pr kuch n kuch kaam krenge
            button[i] = new JButton();   // har ek ko object bnaya h JButton ka taaki wo as a button treat ho
            button[i].setText(buttonString[i]);  //  har button ka text set kiya
            button[i].setBackground(Color.WHITE);  // background color set kiya
            button[i].setFont(font);  // font set kiya
            button[i].addActionListener(this);
        }

        // yahan chaar properties JTextArea  k liye h i.e. our screen of calculator
        display.setFont(font);  // uska font set kiya
        display.setEditable(true);  // mltb hum screen pr click krke type kr skte h agar ye false kiya to hum aisa nhi kr skte
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);  // jo b hum type krenge wo right se left jayega
        display.setPreferredSize(displayDimension);  // TextArea ka size set  kiya

        for(int i = 0;i<14;i++){
            button[i].setPreferredSize(regularDimension);   // har button ki dimension ...14 ki alag
        }

        for(int i = 14;i<18;i++){
            button[i].setPreferredSize(rColumnDimension);  /// baaki 18 ki alag
        }
        button[18].setPreferredSize(zeroButDimension);

        row[0].add(display);  // add TextView to JPanel
        add(row[0]); // add jpanel to frame

        // jo uper do line me kiya wo sbhi rows k liye krnege khyunki agar frame me add hoga tbhi visible h
        for(int i =0;i<4;i++){
            row[1].add(button[i]);
        }
        row[1].add(button[14]);
        add(row[1]);

        for(int i =4;i<8;i++){
            row[2].add(button[i]);
        }
        row[2].add(button[15]);
        add(row[2]);

        for(int i =8;i<12;i++){
            row[3].add(button[i]);
        }
        row[3].add(button[16]);
        add(row[3]);

        row[4].add(button[18]);
        for(int i =12;i<14;i++){
            row[4].add(button[i]);
        }
        row[4].add(button[17]);
        add(row[4]);

        setVisible(true);  // to make the frame visible ... this is necessary
    }

    public void clear(){
        try{
            display.setText("");
            for(int i = 0;i<4;i++){
                function[i] = false;
            }
            for(int i =0;i<2;i++){
                temporary[i] = 0;
            }
        }
        catch (NullPointerException e){

        }
    }

    public void getSqrt(){
        try{
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));
        }catch (NumberFormatException e){

        }
    }

    public void getPosNeg(){
        try{
            double value = Double.parseDouble(display.getText());
            if(value != 0){
                value = value * (-1);
                display.setText(Double.toString(value));
            }else{

            }
        }catch (NumberFormatException e){

        }
    }

    public void getResult(){
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        try{
            if (function[2] == true) {
                result = temporary[0]*temporary[1];
            }else if(function[3] ==  true){
                result = temporary[0]/temporary[1];
            }else if(function[0] == true){
                result = temporary[0] + temporary[1];
            }else if(function[1] == true){
                result = temporary[0] - temporary[1];
            }
            display.setText(Double.toString(result));
            for(int i =0;i<4;i++){
                function[i] = false;
            }
        }catch (NumberFormatException e){

        }
    }

    public final void setDesign(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Exception e){

        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() ==  button[0]){
            display.append("7");
        }
        if(ae.getSource() ==  button[1]){
            display.append("8");
        }
        if(ae.getSource() ==  button[2]){
            display.append("9");
        }
        if(ae.getSource() ==  button[3]){
            // add function[0]
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() ==  button[4]){
            display.append("4");
        }
        if(ae.getSource() ==  button[5]){
            display.append("5");
        }
        if(ae.getSource() ==  button[6]){
            display.append("6");
        }
        if(ae.getSource() ==  button[7]){
            // subtract function[1]
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() ==  button[8]){
            display.append("1");
        }
        if(ae.getSource() ==  button[9]){
            display.append("2");
        }
        if(ae.getSource() ==  button[10]){
            display.append("3");
        }
        if(ae.getSource() ==  button[11]){
            //  multiply function[2]
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() ==  button[12]){
            display.append(".");
        }
        if(ae.getSource() ==  button[13]){
            //  divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() ==  button[14]){
            clear();
        }
        if(ae.getSource() ==  button[15]){
            getSqrt();
        }
        if(ae.getSource() ==  button[16]){
            getPosNeg();
        }
        if(ae.getSource() ==  button[17]){
            getResult();
        }
        if(ae.getSource() ==  button[18]){
            display.append("0");
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
