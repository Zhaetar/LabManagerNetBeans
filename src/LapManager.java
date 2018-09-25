
import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public class LapManager {

    final static String FILE_NAME = "C:\\maratona.bin";
    final static String FILE_NAME2 = "C:\\output.txt";

    void generateFiles(int quantity, int verbose) throws IOException {
        File file = new File(FILE_NAME);

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")), false);
        if (verbose == 1) {
            System.out.println("Codigo\t | Data \t | Duracao \t | Nome do Corredor");
            System.out.println("-------\t | ------- \t | ------- \t | -------");
        }
        int j = 0;
        while (j == 0) {
            String separator = "";
            for (int i = 0; i < quantity; i++) {
                Runner runnerMan = new Runner(Runner.getRandomCode(), Runner.getRandomName(), Runner.getRandomDate(), Runner.getRandomTime());
                if (verbose == 1) {
                    runnerMan.printInfo();
                }
                writer.print(separator);
                writer.print(runnerMan.getInfo());
                separator = System.getProperty("line.separator");
            }
            writer.println();
            writer.close();
            j = 1;
        }
        
    }

    void generateBigFile(int verbose, double paramFileSize) throws UnsupportedEncodingException, FileNotFoundException {
        // Tamanho desejado do arquivo
        double fileSize = Double.parseDouble(System.getProperty("size", Double.toString((paramFileSize / 1024) + 0.01)));

        File file = new File(FILE_NAME);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")), false);
        int counter = 0;
        while (true) {
            String separator = "";
            for (int i = 0; i < 100; i++) {
                Runner runnerMan = new Runner(Runner.getRandomCode(), Runner.getRandomName(), Runner.getRandomDate(), Runner.getRandomTime());
                writer.print(separator);
                writer.print(runnerMan.getInfo());
                separator = System.getProperty("line.separator");
            }
            writer.println();
            // Verificar tamanho do arquivo
            if (++counter == 20000) {
                if (verbose == 1) {
                    System.out.printf("Tamanho atual: %.3f GB%n", file.length() / 1e9);
                }
                if (file.length() >= fileSize * 1e9) {
                    writer.close();
                    break;
                } else {
                    counter = 0;
                }
            }
        }
    }

    void readBigFileIndexedObjects(int indexType) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String currentLine;
        ArrayList<Runner> runnerList = new ArrayList<>();

        while ((currentLine = reader.readLine()) != null) {
            currentLine = currentLine.trim();
            String[] runnerElements = currentLine.split(",");
            runnerList.add(new Runner(runnerElements[0], runnerElements[1], runnerElements[2], runnerElements[3]));
        }
        switch (indexType) {
            case 1:
                Collections.sort(runnerList, new ComparatorCode());
                break;
            case 2:
                Collections.sort(runnerList, new ComparatorName());
                break;
            case 3:
                Collections.sort(runnerList, new ComparatorTime());
                break;
            case 4:
                Collections.sort(runnerList, new ComparatorDate());
                break;
        }
        int j = 0;
        while (runnerList.size() > j) {
            runnerList.get(j).printInfo();
            j++;
        }
    }
    
    void readBigFile() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME2));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            currentLine = currentLine.trim();
            String[] runnerElements = currentLine.split(",");
            Runner runner = new Runner(runnerElements[0], runnerElements[1], runnerElements[2], runnerElements[3]);
            runner.printInfo();
        }
    }
}
