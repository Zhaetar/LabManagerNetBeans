
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public class LapManager {

    final static String FILE_NAME = "D:\\maratona.bin";
    final static String OUTPUT_FILE_NAME = "D:\\maratona_organizado.txt";
    final static String TEMPORARY_FILE_NAME = "D:\\maratona_temporario_";

    void generateFilesObject(int quantity, int verbose) throws IOException {
        FileOutputStream file = new FileOutputStream(FILE_NAME);
        ObjectOutputStream writer = new ObjectOutputStream(file);

        if (verbose == 1) {
            System.out.println("Codigo\t | Data \t | Duracao \t | Nome do Corredor");
            System.out.println("-------\t | ------- \t | ------- \t | -------");
        }
        int j = 0;
        while (j == 0) {
            for (int i = 0; i < quantity; i++) {
                Runner runnerMan = new Runner(Runner.getRandomCode(), Runner.getRandomName(), Runner.getRandomTime(), Runner.getRandomDate());
                if (verbose == 1) {
                    runnerMan.printInfo();
                }
                writer.writeObject(runnerMan);
            }
            writer.close();
            j = 1;
        }
    }

    void generateBigFileObjects(int verbose, double paramFileSize) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        // Tamanho desejado do arquivo
        double fileSize = Double.parseDouble(System.getProperty("size", Double.toString((paramFileSize / 1024) + 0.01)));
        File fileLoc = new File(FILE_NAME);
        FileOutputStream file = new FileOutputStream(fileLoc);
        ObjectOutputStream writer = new ObjectOutputStream(file);
        int counter = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                Runner runnerMan = new Runner(Runner.getRandomCode(), Runner.getRandomName(), Runner.getRandomTime(), Runner.getRandomDate());
                writer.writeObject(runnerMan);
            }

            // Verificar tamanho do arquivo
            if (++counter == 100) {
                if (verbose == 1) {
                    System.out.printf("Tamanho atual: %.3f GB%n", fileLoc.length() / 1e9);
                }
                if (fileLoc.length() >= fileSize * 1e9) {
                    writer.close();
                    file.close();
                    break;
                } else {
                    counter = 0;
                }
            }
        }
    }

    void readObjects(int indexType) throws FileNotFoundException, IOException, Exception {
        sortBigFile.sortFile(indexType);

        FileInputStream fis = new FileInputStream(OUTPUT_FILE_NAME);
        boolean cont = true;
        try {
            ObjectInputStream input = new ObjectInputStream(fis);
            while (cont) {
                Runner obj = (Runner) input.readObject();
                if (obj != null) {
                    obj.printInfo();
                } else {
                    cont = false;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            this.errorMessage("Fim do arquivo.");
        }
    }

    void errorMessage() {
        System.out.println("Ocorreu um erro.");
    }

    void errorMessage(String message) {
        System.out.println("Ocorreu o seguinte erro: " + message);
    }
}
