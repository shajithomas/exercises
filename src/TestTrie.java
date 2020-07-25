import org.junit.Test;
import org.junit.Assert;

public class TestTrie {
    public TestTrie() {
    }

    @Test
    public void testSearch() {
        String searchWord = "abc";
        Trie trie = new Trie();
        Assert.assertEquals(false, trie.search(searchWord));
    }

    @Test
    public void testInsert() {
        Trie trie = new Trie();
        trie.insert("cat");
        Assert.assertEquals(true, trie.search("cat"));
    }

    @Test
    public void testDeleteSoft(){
        Trie trie = new Trie();
        insertWords(trie);
        System.out.println(trie.toString());
        trie.deleteWordSoft("cat");
        Assert.assertEquals(false,trie.search("cat"));
    }

    @Test
    public void testDetete() {
        Trie trie = new Trie();
        insertWords(trie);
        trie.deleteWord("cattler");
        Assert.assertEquals(true, trie.search("cattle"));
        Assert.assertEquals(true, trie.search("categorically"));
    }

    @Test
    public void testDeteteWordExists() {
        Trie trie = new Trie();
        insertWords(trie);
        trie.deleteWord("cattle");
        Assert.assertEquals(false, trie.search("cattle"));
        Assert.assertEquals(true, trie.search("categorically"));

    }

    @Test
    public void testInsertAfterDelete(){
        Trie trie = new Trie();
        insertWords(trie);
        System.out.println(trie.toString());
        trie.deleteWordSoft("cat");
        Assert.assertEquals(false,trie.search("cat"));
        trie.insert("cat");
        Assert.assertEquals(true,trie.search("cat"));
    }

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        insertWords(trie);
        System.out.println(trie.toString());

        Assert.assertEquals(true, trie.search("cat"));
        Assert.assertEquals(false, trie.search("cap"));
        Assert.assertEquals(false, trie.search("cattler"));
        Assert.assertEquals(true, trie.search("cattle"));
        Assert.assertEquals(true, trie.search("category"));
        Assert.assertEquals(true, trie.search("categorically"));

    }

    private void insertWords(Trie trie) {
        trie.insert("cat");
        trie.insert("cattle");
        trie.insert("category");
        trie.insert("categorically");
        trie.insert("test");
        trie.insert("tester");
    }
}
