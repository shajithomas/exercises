import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class MyHashMap {

    //class to store each entry
    public class Entry{
        Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    Entry[] items;
    int size = 0;

    /** Initialize your data structure here. */
    public MyHashMap(int size) {
        items = new Entry[size];
        this.size = size;
    }

    public void put(Object key, Object value) {
        int hash = key.hashCode();
        int index = hash % size;

        //create a new Entry object
        Entry newEntry = new Entry(key, value);
        Entry entry = items[index];

        if (entry == null || (entry.hashCode() == hash)) {
            items[index] = newEntry;
        } else {
            while (entry.next != null) {
                entry = entry.next;
            }
            entry.next = newEntry;
        }
    }

    public Object remove(Object key) {
        int hash = key.hashCode();
        int index = hash % size;

        Entry entry = items[index];
        if (entry == null) {
            return null;
        }
        if (entry.key == key) {
            items[index] = entry.next;
            return entry.value;
        }
        while ( entry.next != null) {
            if (entry.next.key == key) {
                Entry temp = entry.next;
                entry.next = entry.next.next;
                return temp.value;
            }
            entry = entry.next;
        }
        return null;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(Object key) {
        Object item = get(key);
        return (item != null);

    }

    public Object get(Object key) {
        int hash = key.hashCode();
        int index = hash % size;

        Entry entry = items[index];
        if (entry == null) {
            return null;
        } else if (entry.key.equals(key)) {
            return entry.value;
        } else {
            Entry next = entry;
            while (next != null && !next.key.equals(key)){
                next = next.next;
            }
            return ( next == null ? null : next.value);
        }
    }

    public static class UnitTest{

        MyHashMap map;

        @Before
        public void setup() {
            map = new MyHashMap(10);
        }

        @Test
        public void putAndGet() {
            String value = "test1";
            map.put(1, value);
            String value2 = "test2";
            map.put(2, "test2");
            String value12 = "test12";
            map.put(12, value12);
            String value22 = "test22";
            map.put(22, value22);
            String result = map.get(1).toString();
            Assert.assertEquals(value, result);
            Assert.assertEquals(value2, map.get(2));
            Assert.assertEquals(value12, map.get(12));
            Assert.assertEquals(value22, map.get(22));
            Assert.assertNull(map.get(20));
        }

        // remove the 1st one in the linked list
        // 2nd one in the linked list should still be there.
        @Test
        public void remove() {
            String value = "test1";
            map.put(1, value);
            String value2 = "test2";
            map.put(2, "test2");
            String value12 = "test12";
            map.put(12, value12);
            map.put(22, "test22");
            String result = map.remove(2).toString();
            Assert.assertEquals("test2", result);
            Assert.assertNull(map.get(2));
            Assert.assertEquals("test12", map.get(12));
            Assert.assertEquals("test22", map.get(22));

            map.remove(22);
            Assert.assertNull(map.get(22));
        }

        //remove the 2nd one in the linked list.
        // it should remove the 2nd one and the 1st one should still be there.
        @Test
        public void remove2() {
            String value = "test1";
            map.put(1, value);
            String value2 = "test2";
            map.put(2, "test2");
            String value12 = "test12";
            map.put(12, value12);
            String result = map.remove(12).toString();
            Assert.assertEquals("test12", result);
            Assert.assertNull(map.get(12));
            Assert.assertEquals("test2", map.get(2));
        }

        @Test
        public void contains() {
            String value = "test1";
            map.put(1, value);
            String value2 = "test2";
            map.put(2, "test2");
            String value12 = "test12";
            map.put(12, value12);

            Assert.assertTrue(map.contains(1));
            Assert.assertTrue(map.contains(12));
            Assert.assertFalse(map.contains(15));

        }
    }

}
