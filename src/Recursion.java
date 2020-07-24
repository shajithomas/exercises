/*
* Walmart interview question
* what will the following program print when called as follows
* func (4)
* Tip: Use a tree to represent the recursive call as follows
* func (4) = func(3),4,func(2)
* func(2),3,func(1), func(1),2
*/

import java.lang.System;

public class Recursion{
	public static void main(String []args) {
		func ( Integer.parseInt(args[0]));
    }

    public static void func(int n){
        if ( n <= 0) {
            return;
        }
        func(n-1);
        System.out.println(n);
        func(n-2);
    }
}
