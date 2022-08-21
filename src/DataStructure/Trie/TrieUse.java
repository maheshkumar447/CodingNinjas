package DataStructure.Trie;

import java.util.ArrayList;

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();
//        t.add("this");
//        t.add("news");
//        System.out.println(t.search("news"));
//        t.remove("news");
//        System.out.println(t.search("news"));
        t.add("abc");
        t.add("mcba");
        ArrayList<String> al = new ArrayList<>();
        al.add(0,"abc");
        al.add(1,"mcab");
        boolean ans = t.isPalindromePair(al);
        System.out.println(ans);


    }
}
