package ru.pflb.queueReadPoem;

//        Написать программу, которая читает файл poem.txt
//        и записывает каждую новую строку в очередь
//        (Queue <String> queue = new LinkedList<>();).
//
//        Вам понадобятся методы add(), peek(), poll().
//        Также написать метод, который будет выводить по очереди
//        все строки в консоль(FIFO - first in, first out) c
//        рандомной задержкой от 1 до 3 секунд.
//        Собрать проект в jar-файл.


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String theLine = "";
        Queue<String> lines = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("poem.txt"), StandardCharsets.UTF_16))){
            while((theLine = reader.readLine()) != null) {
                lines.add(theLine);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        slowConsoleReader(lines);

    }
    static Random random = new Random();
    static int timeDelay;
    public static void slowConsoleReader(Queue<String> lines) {
        while(lines.peek() != null) {
//            от 1 до 3ех секунд же мне кажется так норм
            timeDelay = 1000 + random.nextInt(2001);
            try{
                Thread.sleep(timeDelay);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(lines.poll());
        }
    }
}