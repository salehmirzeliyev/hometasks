package hometask1;

import hometask1.ThreadSpawner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Threadtest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = "sample.txt";
        countLines(filePath, 10, 2);
    }

    public static void countLines(String path, int lineCount, int threadCount) throws IOException, InterruptedException {
        ThreadSpawner spawner = new ThreadSpawner(threadCount);
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        StringBuilder nLines = new StringBuilder();
        int linesRead = 0;
        while ((line = reader.readLine()) != null) {
            nLines.append(line);
            linesRead++;
            if (linesRead == lineCount) {
                spawner.spawn(nLines.toString(), true);
                linesRead = 0;
                nLines.setLength(0);
            }
            if (linesRead > 0) {
                spawner.spawn(nLines.toString(), false);
            }
            reader.close();
        }
    }
}