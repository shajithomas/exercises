import java.util.ArrayList;
import java.util.List;

public class Trie {

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    public boolean deleteWordSoft(String str) {
        int i = 0;
        TrieNode parent = root;
        TrieNode child;
        while (i < str.length()) {
            child = findNode(parent.children,str.charAt(i));
            if (child == null) {
                return false;
            }
            parent = child;
            i++;
        }
        if (parent.isWord == false) {
            return false;
        }
        parent.isWord = false;
        return true;
    }

    boolean deleteWord(String word) {
        return deleteWordRecurse(root, word);
    }

    private boolean deleteWordRecurse(TrieNode root, String word) {
        if (word == null || word.isEmpty()) {
            if (root.children.isEmpty()) {
                return true;
            }
        }
        TrieNode child = findNode(root.children,word.charAt(0));
        if (child == null) {
            return false;
        }
        if (deleteWordRecurse(child, word.substring(1,word.length()))) {
            root.children.remove(child);
            return root.children.isEmpty();
        }
        return false;
    }

    class TrieNode {
       char data;
       boolean isWord;
       List<TrieNode> children;

       public TrieNode(char data) {
           this.data = data;
           children = new ArrayList<>();
       }

       @Override
       public String toString() {
           return "TrieNode{" +
                   "data=" + data +
                   ", isWord=" + isWord +
                   ", children=" + children +
                   '}';
       }
   }
   private TrieNode root;

   public Trie() {
       root = new TrieNode('*');
   }
   public boolean search(String searchWord) {
       int i = 0;
       TrieNode parent = root;
       TrieNode child;
       while ( i < searchWord.length()) {
           child = findNode(parent.children, searchWord.charAt(i));
           if (child == null) {
               return false;
           }
           parent = child;
           i++;
       }
       if (parent.isWord) {
           return true;
       }
       return false;
   }

   public void insert(String str) {
        int strLen = str.length();
        int i = 0;
        TrieNode parent = this.root;
        TrieNode child = this.root;
        while (i < strLen) {
            child = findNode(parent.children, str.charAt(i));
            if (child == null) {
                child = new TrieNode(str.charAt(i));
                parent.children.add(child);
            }
            parent = child;
            i++;
        }
        parent.isWord = true;
   }

    private TrieNode findNode(List<TrieNode> children, char c) {
       for (TrieNode child : children) {
           if (child.data == c) {
               return child;
           }
       }
       return null;
    }

}
