package sk.itsovy.Artem.hTask.wRoom;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

                          Scanner in = new Scanner(System.in);
        System.out.println("Good day! Nice to meet you at my program. What do you want me to do for today?");
        System.out.println("1 - Print the paralelogram with inputted rows");
        System.out.println("2 - Input my birth data and tell me who I am from Chinese horoscope");
        System.out.println("0 - Exit");
        boolean input = false;
        WorkClass cast = new WorkClass();
        int x = in.nextInt();
        switch (x) {
            case 1: {
                cast.mSquad();
                break;
            }
            case 2: {
                cast.cCalendar();
                break;
            }
            case 0:{
                System.out.println("Sad to say you goodbye! I hope to see you again soon! Have a nice day!");
                break;
            }
            default:
                System.out.println("I'm sorry, but you have entered the wrong number of option. Waited for 1, 2 or 0 but got: " +x);
                break;
        }
    }
}
