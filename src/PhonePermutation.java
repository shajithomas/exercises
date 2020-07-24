/*
 * Telephone digits to all combinations of words
 * This is a variation of general permutation problem
 * For each character associated with a telephone digit, recursively call the function again
 * basically finding all the permutation of the rest of the digits.
 * There is a caveat here - some of the numbers have more than 3 chars which is not handled in this version.
 */
import java.lang.*;
import java.lang.AbstractMethodError;
import java.lang.Boolean;
import java.lang.Character;
import java.lang.InheritableThreadLocal;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;

public class PhonePermutation {
    int PHONE_NUMBER_LENGTH = 7;

    void printTelephoneWords(int[] phoneNum) {
        PHONE_NUMBER_LENGTH = phoneNum.length;
        char[] result = new char[PHONE_NUMBER_LENGTH];

        doPrintTelephoneWords(phoneNum, 0, result);
    }

    void doPrintTelephoneWords(int[] phoneNum, int curDigit,
                               char[] result) {
        if (curDigit == PHONE_NUMBER_LENGTH) {
            System.out.println(new String(result));
            return;
        }

        for (int i = 0; i < 3; i++) {
            result[curDigit] = getCharKey(phoneNum[curDigit], i);
            doPrintTelephoneWords(phoneNum, curDigit + 1, result);
            if (phoneNum[curDigit] == 0 ||
                    phoneNum[curDigit] == 1) return;
        }
    }

    // Use a 2 dimensional array to look up the values of characters representing the telephone digits.
    public char getCharKey(int digit, int place) {
        char [][]phoneChars = {{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','Q','R','S'},{'T','U','V'},{'W','X','Z'}};
        if ( digit == 0 || digit == 1 ) {
            return Character.forDigit(digit,10);
        }
        int index = digit - 2;
        return phoneChars[index][place];
    }
    /*
    * Utility converting character array representing integer digits to integer array
     */
    static int [] convert2IntArray(char []charArray) {
        int length = charArray.length;
        int []intArray = new int[length];
        for ( int i = 0; i < length; i++) {
            intArray[i] = Character.digit(charArray[i],10);
        }
        return intArray;
    }


    public static void main(String []args) {
        char []tempArray = args[0].toCharArray();
        int []phoneNum = convert2IntArray(tempArray);
        PhonePermutation converter = new PhonePermutation();
        converter.printTelephoneWords(phoneNum);
    }
}