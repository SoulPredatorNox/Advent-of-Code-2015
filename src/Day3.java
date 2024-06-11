/*
--- Day 3: Perfectly Spherical Houses in a Vacuum ---
Santa is delivering presents to an infinite two-dimensional grid of houses.

He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.

However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?

For example:

> delivers presents to 2 houses: one at the starting location, and one to the east.
^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input/Day3"));
        String s = in.next();

        int housestotal = 1;

        int[][] savedata = new int[(s.length()) * 2][(s.length()) * 2];
        int cnt = 0;
        savedata[s.length()][s.length()] = 1;
        int i = s.length();
        int j = s.length();

        while (cnt != s.length() - 1) {
            if (s.charAt(cnt) == '<') {
                i--;
                savedata[i][j]++;
                if (savedata[i][j] == 1) {
                    housestotal++;
                }
            } else if (s.charAt(cnt) == '^') {
                j--;
                savedata[i][j]++;
                if (savedata[i][j] == 1) {
                    housestotal++;
                }
            } else if (s.charAt(cnt) == 'v') {
                j++;
                savedata[i][j]++;
                if (savedata[i][j] == 1) {
                    housestotal++;
                }

            } else if (s.charAt(cnt) == '>') {
                i++;
                savedata[i][j]++;
                if (savedata[i][j] == 1) {
                    housestotal++;
                }
            }
            cnt++;
        }
        System.out.println(housestotal);
    }
}

