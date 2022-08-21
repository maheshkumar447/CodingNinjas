package DataStructure.Trie;


import java.util.ArrayList;

class TrieNode{  // is class me hum wo sb include krenge jo ki ek trie Node ko chyiea
// ek trie node ko teen cheese chyiea
    // phli..data
    //dusri ki wo koi b particular node terminating h ya nhi i.e. bold h ya nhi
    // teesri...uske children store krwati ek array or is array ka max size 26 hoga
    // inki sbki or jyada explanation k liye refer to noteboook
    char data;
    boolean isTerminating;
    TrieNode children[];

    int childCount;   // 26 tk loop a chlana pde isiliye hmne ye rkha h

    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26]; // is array ki by default null hogi shuru me
        childCount = 0;  // shuru me hum manenge ki ek b child nhi h
    }
}

public class Trie {

    // trie class is like tree class and tree k liye hmare pass sirf root node honi chyiea
    // trie me root koi h nhi or uske children h alphabets ki form me
    // to trie k root ko hum null character se initialize krwa denge
     private TrieNode root;   // private isiliye taaki koi chnge na kr ske isko

    public Trie(){
        root = new TrieNode('\0');  // root me null charcter rkh diya
    }

    // three methods which is goig to be done in Trie is:
    // 1. add
    //2. search
    //3. remove

    // 1. add function
    public void add(String word){  // word add krna h
        // ye commented jrur pdho....yahi se sb clear hoga
/*
        // hum assume kr rhe h i saare small letters h
        int childIndex = word.charAt(0) - 'a';  // 0th index pr jo character h usme se a ki ASCII value ko subtract krdo hme us charcter ka index mil jayega jo hme insert krna h
        // mtlb  krna h to N character h root k children me ya nhi ye isse pta chlega
        // agar hoga to not null agar nhi to null
        TrieNode child = root.children[childIndex];  // root ki children array me childIndex pr wo element milega hme
        // ab ye null b ho skta h or not null b
        if(child == null){ // agar child null tha mtlb wahan tha nhi child i.e. N here
            child = new TrieNode(word.charAt(0));  // new child create krdo
            root.children[childIndex] = child; // root k children array me childIndex pr child daal diya
        }

        // ab N tk to kaam ho chuka h pr aage OTE ka rhta h to hum recursive call krege
        add(word.substring(1));  // yahan ek gadbad ho gyi yahan ye gadbad ho gyi ki jb ye recursive call hogi to ye root pe hee O dhundega jbki hme to N k aage root ko dhundhna h
        // to hme root ko chnge krna odega or usi k liye hmne add fumction ka helper function bnaya h \

 */

        add(root,word);


    }
    // ye helper function h add ka
    private  void add(TrieNode root, String word){

        if(word.length() == 0){  //ye base case h
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;  // jb jb  add hoga tb tb root k childCount ko ek se bdha do
        }
        add(child,word.substring(1));  // yahan child update ho rha h
    }








    //2nd method : SEARCH
    public boolean search(String word){
        // Write your code here
        return search(root,word);
    }

    private boolean search(TrieNode root, String word){

        if(word.length()==0){  // ye base case h
             return root.isTerminating; // kyunki aisa case b ho skta h ki maanlo hmare Trie me NEWS h or S ek terminating character h jbki W nhi
            // or search krne ko kaha jaye NEW to ans false aana chyiea but agar hum return true likhte yahan to to wo usko true return krwa deta jo ki galat hota
            // so root.isTerminating return krwa diya taaki agar word terminate ho rha h to hee return true kre otherwise false return krde

        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if(child == null){  // agar first letter hee nhi mila word ka to aage dhundhna hee kyu h to return false krwado
            return false;
        }
        return search(child,word.substring(1));  // child k liye recursive call krwadi

    }




    //3 method: Delete
    public void remove(String word){
        remove(root,word);
    }

    private void remove(TrieNode root, String word){

        if(word.length() == 0){
            root.isTerminating = false;   // jo terminating tha usko non terminating krdo taaki wo word mile hee na mltb delete ho jaye
            return;
        }

        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null){   // child h hee nhi to delete b kya hee krenge to simple delete krdo
            return;
        }
        remove(child,word.substring(1));
        // we can remove child node only if it is non terminating and its number of children are 0

        /*
        if(!child.isTerminating){  // child node terminating nhi h tbhi ye condition true hogi or if chlega mtlb hmne jo uper 2 rule likhe h ki node kb remve ho skti h usme se ek to if() ki condition me hee check ho gya

            // yahan hum check krenge ki us child node k further children na ho or aisa hum uske children array ko trvaerse krke krege
            int numChild = 0;
            for(int i =0;i<26;i++){
                if(child.children[i] != null){  // mtlb child node k further children h
                    numChild++;
                }
            }
            if(numChild == 0){
                // we can delete the child
                root.children[childIndex] = null;  // mtlb jis index pr children h wahan hmne null rkh diya array me
                child = null;
                root.childCount--;  // jb jb delete hoga to childCount km krte chlege or isi line ki wajah se ye pure if ki bjaay niche wala code krege
            }

        }

         */

        // uper jo multiCOmment code h uski jagah hum ye likhenge
        if(!child.isTerminating && child.childCount == 0){  // so hum itne se kaam se node ko remove kr skte h
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }


    }








    public int countWords() {
        // Write your code here
        //simple code of one line is in solution of coding ninjas i.e. take one variable and increment it whenever we add elements to it and decrement it when we remove an element
        // and here at last return that variable

        // but some different code which can be applied when we don't have add and remove function
        int ans = 0;
        for (int i =0;i<26;i++){
            if(root.children == null){
                continue;
            }
            int child = countWordsHelper(root.children[i]);
            ans += child;
        }
        return ans;
    }

    public int countWordsHelper(TrieNode root){
        if(root == null){
            return 0;
        }
        int childAns = 0;

        for(int i =0;i<26;i++){
            if(root.children == null){
                continue;
            }
            int temp = countWordsHelper(root.children[i]);
            childAns += temp;
        }
        return childAns;
    }







    public boolean patternMatching(ArrayList<String> vect, String pattern) {

        for(int i = 0;i<vect.size();i++){
            for(int j = 0;j<vect.get(i).length();j++){
                add(vect.get(i).substring(j));
            }
        }

        return search(pattern);

    }


    public boolean isPalindromePair(ArrayList<String> words){
        for(String word: words){
            this.add(reverseWord(word));
        }
        return isPalindromePair(this.root,words);
    }

    private static String reverseWord(String word){
        String reverse = "";
        for(int i = word.length()-1;i>=0;i--){
            reverse += word.charAt(i);
        }
        return reverse;
    }

    private boolean isPalindromePair(TrieNode root, ArrayList<String> words){
        if(words == null || words.size() == 0){
            return false;
        }

        for(String word: words){
            if(doesPairExistFor(root , word, 0)){
                return true;
            }
        }
        return false;
    }

    private boolean doesPairExistFor(TrieNode root, String word, int startIndex){
        if(word == ""){
            return true;
        }

        if(startIndex ==  word.length()){
            if(root.isTerminating){
                return true;
            }
            return checkRemainingBranchesInTrie(root, "");
        }

        int charIndex = word.charAt(startIndex)-'a';
        TrieNode correspondingChild = root.children[charIndex];

        if(correspondingChild == null){
            if(root.isTerminating){
                return checkWordForPalindrome(word.substring(startIndex));
            }
            return false;
        }
        return doesPairExistFor(correspondingChild, word, (startIndex + 1));
    }

    private boolean checkRemainingBranchesInTrie(TrieNode root, String word){
        if(root.isTerminating){
            if(checkWordForPalindrome(word)){
                return true;
            }
        }

        for(TrieNode childNode : root.children){
            if(childNode == null){
                continue;
            }

            String fwd = word + childNode.data;
            if(checkRemainingBranchesInTrie(childNode,fwd)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkWordForPalindrome(String word){
        int startIndex = 0;
        int endIndex = word.length()-1;

        while(startIndex < endIndex){
            if(word.charAt(startIndex) != word.charAt(endIndex)){
                return false;
            }
            startIndex += 1;
            endIndex -= 1;
        }
        return true;
    }

}







