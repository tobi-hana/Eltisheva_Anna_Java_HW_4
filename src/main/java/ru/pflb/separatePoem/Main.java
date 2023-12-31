package ru.pflb.separatePoem;

//        Написать программу, которая читает файл poem.txt,
//        и создает новые файлы, в каждый из которых записывается
//        абзац из стихотворения. Разделитель абзацев - это
//        пустая строка. Название файлов должны быть part1, part2, …, partN.
//        Мне прислать zip-архив.

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int counter = 1;
        String theLine = "";
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("poem.txt"), StandardCharsets.UTF_16))){

            while((theLine = reader.readLine())!= null) {
                if(theLine.isEmpty()) {
                    lines.remove(lines.size() - 1);
                    writePartOfPoem(lines, counter);
                    counter++;
                } else {
                    lines.add(theLine);
                }
            }
            writePartOfPoem(lines, counter);

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void writePartOfPoem(List<String> lines, int num) throws IOException{
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                String.format("part%d.txt", num)),
                        StandardCharsets.UTF_16));
        for(String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
        lines.clear();

    }
}