/*--- Day 6: Probably a Fire Hazard ---

Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

For example:

turn on 0,0 through 999,999 would turn on (or leave on) every light.
toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
After following the instructions, how many lights are lit?
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Day6 {

    static Scanner in;
    static boolean [][]lightarray =new boolean[1000][1000];


    public static String command_handler() throws FileNotFoundException {

        String s = in.next();
        String temp;

        if (s.equals("toggle")){
            temp="swap";
            return temp;
        }

        if (in.hasNext()){
            s = in.next();
        }

        if (s.equals("on")){
            temp="on";
        }else if (s.equals("off")){
            temp="off";
        }else {
            temp="toggle";
        }return temp;
    }

    public static int[] number_handler() throws FileNotFoundException {

        String s = in.next();

        String temp1=s;
        int[] temp =new int[4];
        int cnt=0;
        int factor=1;
        int tempnum=0;

        for (int i = temp1.length()-1; i >0 ; i--) {
            if (temp1.charAt(i)!=','){
                tempnum=tempnum+factor*(temp1.charAt(i)-48);

                factor=factor*10;

            }else {
                factor=1;
                temp[cnt]=tempnum;
                tempnum=0;
                cnt++;
            }
        }

        temp[cnt]=tempnum+(temp1.charAt(0)-48)*factor;
        factor=1;
        tempnum=0;
        cnt++;



        s = in.next();
        s = in.next();
        String temp2=s;
        for (int i = temp2.length()-1; i >0 ; i--) {
            if (temp2.charAt(i)!=','){
                tempnum=tempnum+factor*(temp2.charAt(i)-48);

                factor=factor*10;

            }else {
                factor=1;
                temp[cnt]=tempnum;
                tempnum=0;
                cnt++;
            }
        }

        temp[cnt]=tempnum+(temp2.charAt(0)-48)*factor;

        return temp;
    }

    public static void turn_on(int xl, int yl,int xu, int yu) {
        for (int i = xl; i <= xu; i++) {
            for (int j = yl; j <= yu; j++) {
                lightarray[i][j]=true;
            }
        }
    }

    public static void turn_off(int xl, int yl,int xu, int yu) {
        for (int i = xl; i <= xu; i++) {
            for (int j = yl; j <= yu; j++) {
                lightarray[i][j]=false;
            }
        }
    }

    public static void swap(int xl, int yl, int xu, int yu) {

        for (int i = xl; i <= xu; i++) {
            for (int j = yl; j <= yu; j++) {
                if (lightarray[i][j]==true){
                    lightarray[i][j]=false;
                }else if (lightarray[i][j]==false){
                    lightarray[i][j]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        in = new Scanner(new FileReader("input/Day6"));

        while(in.hasNext()){
            String command=command_handler();

            int[] number=number_handler();

            int lower_borderx=number[1];
            int lower_bordery=number[0];
            int upper_borderx=number[3];
            int upper_bordery=number[2];


            if (command.equals("swap")){
                swap(lower_borderx,lower_bordery,upper_borderx,upper_bordery);
            }else if (command.equals("on")){
                turn_on(lower_borderx,lower_bordery,upper_borderx,upper_bordery);
            }else if(command.equals("off")){
                turn_off(lower_borderx,lower_bordery,upper_borderx,upper_bordery);
            }
        }

        int cntres=0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (lightarray[i][j]==true){
                    cntres++;
                }
            }
        }
        System.out.println(cntres);
        }
}



