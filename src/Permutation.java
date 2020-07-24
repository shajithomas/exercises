import java.lang.String;
import java.lang.StringBuffer;
import java.lang.System;
import java.util.Arrays;

public class Permutation {
    static char []in;
    static StringBuffer outputString;
    static boolean []used;
    static int inputLength;

    public static void permute( String input)
    {
      inputLength = input.length();
      used = new boolean[ inputLength ];
      outputString = new StringBuffer();
      in = input.toCharArray( );

      doPermute(0);

    }

      static void doPermute ( int level)
      {
         if( level == inputLength) {
         System.out.println ( outputString.toString());
         return;
         }

        for( int i = 0; i < inputLength; ++i )
        {

           if( used[i] ) continue;

           outputString.append( in[i] );
           used[i] = true;
           doPermute( level + 1 );
           used[i] = false;
           outputString.setLength(   outputString.length() - 1 );
        }
     }
    public static void main ( String []args) {

        permute(args[0]);
    }
}