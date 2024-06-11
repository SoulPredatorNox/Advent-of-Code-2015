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

        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '^') {
                north++;
            } else if (s.charAt(i) == 'v') {
                south++;
            } else if (s.charAt(i) == '<') {
                west++;
            } else if (s.charAt(i) == '>') {
                east++;
            }
        }

        int[][] savedata = new int[(north + south) * 2][(east + west) * 2];
        int cnt = 0;
        savedata[west][north] = 1;

        for (int i = west; i < s.length(); ) {
            for (int j = north; j < s.length(); ) {

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
                if (cnt == s.length() - 1) {
                    break;
                }
                cnt++;
            }
        }

        System.out.println(housestotal);
        System.out.println(north);
        System.out.println(east);
        System.out.println(west);
        System.out.println(south);
    }
}
