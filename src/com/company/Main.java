package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

//    static String[] files = {"a_example.txt", "b_read_on.txt", "c_incunabula.txt", "d_tough_choices.txt", "e_so_many_books.txt","f_libraries_of_the_world.txt"};
    static String[] files = {"a_example.txt", "b_read_on.txt"};
    static String[] output = {"output1.txt", "output2.txt", "output3.txt", "output4.txt", "output5.txt", "output6.txt"};

    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Library> libraryList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < files.length; i++) {
            int number_of_books = 0;
            int number_of_libraries = 0;
            int maximum_days = 0;

//            int[] splitedIntegers = {};

            try {
                File myObj = new File(files[i]);
                Scanner myReader = new Scanner(myObj);

                int LineNumber = 1;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] splited = data.split("\\s+");
                    if (LineNumber == 1) {
                        number_of_books = Integer.parseInt(splited[0]);
                        number_of_libraries = Integer.parseInt(splited[1]);
                        maximum_days = Integer.parseInt(splited[2]);
                    }else if (LineNumber == 2){
                      int[] bookScores = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();

                        for (int j = 0; j < bookScores.length; j++) {
                            bookList.add(new Book( j,bookScores[j]));
                        }

                    }else {

                        if (LineNumber % 2 == 1){
                            int[] library_details = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();
                            libraryList.add(new Library(library_details[0],library_details[1],library_details[2]));
                        }

                    }
                    LineNumber++;
                }

//                receiveInputs(maximum, number_of_slices, splitedIntegers, output[i]);

                System.out.println("Libraries "+ number_of_libraries);
                myReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static void receiveInputs(int maximumSum, int number_of_slices, int[] slices, String outputFileName) {
        int sum = 0;
        ArrayList<Integer> results = new ArrayList<>();
        int lastcheckedElement = 0;
        for (int i = (number_of_slices - 1); i >= 0; i--) {
            sum += slices[i];
            if (sum < maximumSum) {
                results.add(i);
                lastcheckedElement = i;
            } else {
                sum -= slices[i];

//                break;
            }

        }

        Collections.sort(results);

        String output = results.size() + "\n";
        StringBuilder slicess = new StringBuilder();

        for (Integer result : results) {
            slicess.append(result).append(" ");
        }
        slicess.toString().trim();



        output += slicess;
        System.out.println(output);
        writeUsingOutputStream(output, outputFileName);


    }

    private static void writeUsingOutputStream(String data, String outPutFileName) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(outPutFileName));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
