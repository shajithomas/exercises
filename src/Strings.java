/**
 * Given a list of strings and an array with length 'n',
 * find the max numbers of strings from the list that can fit in the array
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Henry", "Henry11", "Henry1","David");
        long arrayLen = 20;

        strings.sort(Comparator.comparing(String::length));
/*
        strings.sort( (s1, s2) -> {
            return s1.length() - s2.length();
                });
*/
        System.out.println(strings);
        int len = 0;
        int i = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (len < arrayLen) {
            String str = strings.get(i);
            if ( (str.length() + len + 1) < arrayLen ) {
                strBuilder.append(str + " ");
                len += str.length()+1;
                i++;
            } else {
                break;
            }
        }

        char[] chars = strBuilder.toString().toCharArray();
        System.out.println(strBuilder.toString());
        System.out.println(chars);
        System.out.println("length: " + strBuilder.length());
    }
}