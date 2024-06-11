/*
--- Day 2: I Was Told There Would Be No Math ---
The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.

Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.

For example:

A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.
All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?

--- Part Two ---
The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the length they need to order, which they would again like to be exact.

The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.

For example:

A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of ribbon for the bow, for a total of 14 feet.
How many total feet of ribbon should they order?

Dev: Petar Wiener
10.06.2024
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader("input/Day2"));

        int result = 0;
        int ribbonlength = 0;

        while (in.hasNext()) {
            int l = 0;
            int w = 0;
            int h = 0;
            int posofx = 0;
            int minnum = 0;

            String s = in.next();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'x') {
                    posofx = i + 1;
                    break;
                }
                l *= 10;
                l += Character.getNumericValue(s.charAt(i));

            }
            for (int i = posofx; i < s.length(); i++) {
                if (s.charAt(i) == 'x') {
                    posofx = i + 1;
                    break;
                }
                w *= 10;
                w += Character.getNumericValue(s.charAt(i));
            }
            for (int i = posofx; i < s.length(); i++) {
                if (s.charAt(i) == 'x') {
                    posofx = i + 1;
                    break;
                }
                h *= 10;
                h += Character.getNumericValue(s.charAt(i));
            }
            if (l * w < w * h) {
                minnum = l * w;
            } else minnum = w * h;

            minnum = Integer.min(minnum, h * l);
            result += 2 * l * w + 2 * w * h + 2 * h * l + minnum;

            //part 2
            int[] minside = new int[]{l, w, h};
            Arrays.sort(minside);
            ribbonlength += minside[0] * 2 + minside[1] * 2 + l * w * h;


        }
        System.out.println("Part1: "+result);
        System.out.println("Part2: "+ribbonlength);
    }
}

