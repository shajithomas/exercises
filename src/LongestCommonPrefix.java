import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas-HT
 * Date: 3/13/16
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonPrefix {
    public static void main( String[] args){

    }
    public String findLongestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String comPrefix = strs[0];
        for ( int i= 1; i < strs.length; i++) {
            comPrefix = compare ( comPrefix, strs[i]);
        }
        return comPrefix;
    }

    private String compare(String str, String str1) {
        int length = Math.min( str.length(), str1.length());
        for ( int i = 0; i < length; i++ ) {
            if ( str.charAt(i) == str1.charAt(i) ) {
                continue;
            }
            return str.substring(0,i);
        }
        return str.substring(0,length);
    }
}
