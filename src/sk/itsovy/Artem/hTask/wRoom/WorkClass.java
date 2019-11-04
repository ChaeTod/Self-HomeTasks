package sk.itsovy.Artem.hTask.wRoom;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkClass {

    /**
     * Print the parallelogram with inputted conditions
     */
    public void mSquad() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, input the number of rows and columns: ");
        int row = in.nextInt(), column = in.nextInt();
        if (row <= 0 || row > 1000) {
            System.out.println("Error! You have entered negative or a too small number of rows! The number should be from 1 to something, but not too high! Got: " + row);
        } else {
            if (column <= 0 || column > 1000) {
                System.out.println("Error! You have entered negative or a too small number of columns! The number should be from 1 to something, but not too high! Got: " + column);
            } else {
                for (int i = 1; i <= row; i++) {
                    for (int k = i; k <= row; k++) {
                        System.out.print("  ");
                    }
                    for (int j = 1; j <= column; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println(" ");
                }
            }
        }
    }

    /**
     * Calculate what animal you are from Chinese calendar:
     * Rat    : 1912, 1924, 1936, 1948, 1960, 1972, 1984, 1996, 2008
     * Bull   : 1913, 1925, 1937, 1949, 1961, 1973, 1985, 1997, 2009
     * Tiger  : 1914, 1926, 1938, 1950, 1962, 1974, 1986, 1998, 2010
     * Rabbit : 1915, 1927, 1939, 1951, 1963, 1975, 1987, 1999, 2011
     * Dragon : 1916, 1928, 1940, 1952, 1964, 1976, 1988, 2000, 2012
     * Snake  : 1917, 1929, 1941, 1953, 1965, 1977, 1989, 2001, 2013
     * Horse  : 1918, 1930, 1942, 1954, 1966, 1978, 1990, 2002, 2014
     * Goat   : 1919, 1931, 1943, 1955, 1967, 1979, 1991, 2003, 2015
     * Monkey : 1920, 1932, 1944, 1956, 1968, 1980, 1992, 2004, 2016
     * Rooster: 1921, 1933, 1945, 1957, 1969, 1981, 1993, 2005, 2017
     * Dog    : 1922, 1934, 1946, 1958, 1970, 1982, 1994, 2006, 2018
     * Pig    : 1923, 1935, 1947, 1959, 1971, 1983, 1995, 2007, 2019
     *
     * <p>
     * !Warning! - the minimum year to start the calculating is the 1912.
     * distance - the variable that helps to calculate the closest year from Rat years. At begging is the maximum difference between inputted year and the first to calculate rat year - 1912.
     * Math.abs - returns the absolute value of a given argument.
     * idx - the closest to inputted year of birth index which also is the index of needed animal from animals array.
     * fDistance - the variable that helps find the closest index of the Rat years to the inputted year. Finds minimum.
     * diffNum - the variable that consists the difference between the inputted year and the year from the Rat years. This difference is also an index for a specific animal from the animal array.
     * animals - an array that consists the number of different 12 animals.
     * yearsRat - an array that consists the years when who had born in this years is the Rat. Used like a stating point to calculate other years and animals.     *
     */
    public void cCalendar() {
        Scanner in = new Scanner(System.in);
        int[] animals = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] yearsRat = {1912, 1924, 1936, 1948, 1960, 1972, 1984, 1996, 2008};
        System.out.println("Please, input the year of your birth and we gonna find out who you are: ");
        int yearOfBirth = in.nextInt();
        int distance = Math.abs(yearsRat[0] - yearOfBirth);
        int idx = 0;
        int fDistance = 0;
        int diffNum = 0;

        if (yearOfBirth < 1912 || yearOfBirth > 2019) {
            System.out.println("Error! You should input the year of your birth more correctly. Year can be from the 1912 to 2019. Got: " + yearOfBirth);
        } else {
            for (int i = 0; i < yearsRat.length; i++) {
                fDistance = Math.abs(yearsRat[i] - yearOfBirth);
                if (yearOfBirth < yearsRat[i] /*&& fDistance <= 11*/) {
                    if (fDistance < distance) {
                        idx = i - 1;
                        distance = fDistance;
                    }
                } else {
                    if (fDistance < distance) {
                        idx = i;
                       distance = fDistance;
                    }
                }
            }

            System.out.println("The nearest year is: " + yearsRat[idx]); // Quick check if the calculation is right
            diffNum = Math.abs(yearOfBirth - yearsRat[idx]);
            switch (animals[diffNum]) {
                case 0: {
                    System.out.println("You are a Rat!");
                    System.out.println("People born in the years of the Rat are distinguished by charm and attractive appearance.");
                    break;
                }
                case 1: {
                    System.out.println("You are a Bull!");
                    System.out.println("People born in the year of the Bull are modest and diligent, patient and laconic, persistent and hardy.");
                    break;
                }
                case 2: {
                    System.out.println("You are a Tiger!");
                    System.out.println("People born in the year of the Tiger are very different from each other, especially - spiritually.");
                    break;
                }
                case 3: {
                    System.out.println("You are a Rabbit!");
                    System.out.println("The rabbit is the owner of a bright personality, he is gifted with talents, moderately ambitious, modestly modest, sophisticated and virtuous, has a good taste and understanding of beauty.");
                    break;
                }
                case 4: {
                    System.out.println("You are a Dragon!");
                    System.out.println("People born during the years of the Dragon have excellent health and a large supply of vitality.");
                    break;
                }
                case 5: {
                    System.out.println("You are a Snake!");
                    System.out.println("People born during the years of the Snake are distinguished by innate wisdom, insight and insight.");
                    break;
                }
                case 6: {
                    System.out.println("You are a Horse!");
                    System.out.println("People born in the year of the Horse are full of thirst for life, adventure and feats.");
                    break;
                }
                case 7: {
                    System.out.println("You are a Goat!");
                    System.out.println("People born in the year of the Goat are endowed with a variety of talents and rich imagination.");
                    break;
                }
                case 8: {
                    System.out.println("You are a Monkey!");
                    System.out.println("People born in the years of the Monkey, on the one hand, are smart, dexterous and agile.");
                    break;
                }
                case 9: {
                    System.out.println("You are a Rooster!");
                    System.out.println("People born in the years of the Rooster are distinguished by their straightforwardness and aggressiveness.");
                    break;
                }
                case 10: {
                    System.out.println("You are a Dog!");
                    System.out.println("People born in the years of the Dog are usually quite restless, always on the alert, never resting.");
                    break;
                }
                case 11: {
                    System.out.println("You are a Pig!");
                    System.out.println("People born in the years of the Pig are distinguished by their courage and ability to sacrifice themselves.");
                    break;
                }
                default:
                    System.out.println("Sorry, the system couldn't find any of the correct numbers! Try again!");
                    break;
            }
        }
    }
}
