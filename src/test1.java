import java.io.IOException;
import java.lang.*;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.System;
import java.util.*;
import java.util.ArrayList;

public class test1 {
	public static void main ( String[] args) {
		testSingleton();
		new test1().testList();
		new test1().mapTest();
        System.out.println("\n========================\n");
        new test1().genericArray();
        System.out.println("\n========================\n");
        new test1().genericArrayList();
	}
	public static void testSingleton() {
		Singleton instance = Singleton.getInstance();
		instance.test();
	}
	/* Cannot create - b/c cannot inherit from a singleton
	public void testSingletonInheritance() {
		SingletonInheritance instance = new SingletonInheritance();
		instance.test();
	}
	*/
	public void testList() {
		List <String>v = new ArrayList<String>();
		v.add("test");
		v.add(new String("4"));
		String i = v.get(0);
		String ii = v.get(1);
		System.out.println ("the string is: " + i );
		
		//test Iterator for list
		System.out.println("\nIterator on List... ");
		Iterator<String> itr = v.listIterator();
		while ( itr.hasNext() ) {
			String s = itr.next();
			System.out.println(s);
		}
		
	}
	public void mapTest() {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "some data1");
		map.put("key2", "some data2");
		
		for ( String key : map.keySet() ) {
			System.out.println("key: "+ key + "    value: "+ map.get(key));
		}
		
		System.out.println("\nTesting the traversal thru iterator");
		Iterator<String> itr = map.keySet().iterator();
		while (itr.hasNext() ) {
			String key = itr.next();
			System.out.println("key: "+ key + "    value: "+ map.get(key));
		}
	}

    /*
        Create a generic array of objects
     */
    public void genericArray() {
        Object []objArray = new Object[5];
        objArray[0] = new String("String Object");
        objArray[1] = new Integer(10);
        objArray[2] = new Double(1.0);

        //print them out
        System.out.println(objArray[0]);
        System.out.println(objArray[1]);
        System.out.println(objArray[2]);
        if (objArray[3] == null) {
            System.out.println("objArray[3] is null");
        } else {
            System.out.println("objArray[3] is not null" + objArray[3]);
        }

    }

    /*
        Create a generic arraylist of objects
        check if we can assign a subclass object to superclass list
     */
    public void genericArrayList() {
        ArrayList<Object> objList = new ArrayList<Object>();
        objList.add(new String("String Object"));
        objList.add(new Integer(10));
        objList.add(new Double(1.0));

        //print them out
        System.out.println(objList.get(0));
        System.out.println(objList.get(1));
        System.out.println(objList.get(2));

        ArrayList<java.lang.Exception> exceptions = new ArrayList<Exception>();
        exceptions.add(new Exception("an Exception"));
        exceptions.add(new IOException("an IOException"));
        exceptions.add( new RuntimeException("a RuntimeException"));

        //print them out
        System.out.println(exceptions.get(0));
        System.out.println(exceptions.get(1));
        System.out.println(exceptions.get(2));
        if (exceptions.get(3) == null) {
            System.out.println("exceptions[3] is null");
        } else {
            System.out.println("exceptions[3] is not null" + exceptions.get(3));
        }


    }

}  