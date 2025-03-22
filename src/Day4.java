/*
--- Day 4: The Ideal Stocking Stuffer ---
Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

For example:

If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....

--- Part Two ---

        Now find one that starts with six zeroes.

*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.*;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {


        Scanner in = new Scanner(new FileReader("input/Day4"));
        String s = in.next();
        int limit=2;

        for (int temp = 1; temp < limit; temp++) {
            String hash = s+Integer.toString(temp);
            //String hash= "pqrstuv1048970"; testcase for basic functions
            System.out.println(hash);

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(hash.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }

            System.out.println(hashtext);

            if (hashtext.charAt(0) == '0'&hashtext.charAt(1) == '0'&hashtext.charAt(2) == '0'&hashtext.charAt(3) == '0'&hashtext.charAt(4) == '0'&hashtext.charAt(5) == '0') {
                System.out.println(hashtext);
                System.out.println(hash);

            }else limit++;
        }
    }
}