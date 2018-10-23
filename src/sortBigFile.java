
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public class sortBigFile {

    public static void sortFile(int indexType) throws Exception {
        int i = 0;
        // Input
        FileInputStream fis = new FileInputStream(LapManager.FILE_NAME);
        ObjectInputStream input = new ObjectInputStream(fis);
        // Output
        FileOutputStream fos;
        ObjectOutputStream writer;
        Set<Runner> set;
        Runner line;
        Comparator comparator;
        
        // Tipo de comparador
        switch (indexType) {
            default:
                comparator = new ComparatorCode();
                break;
            case 2:
                comparator = new ComparatorName();
                break;
            case 3:
                comparator = new ComparatorTime();
                break;
            case 4:
                comparator = new ComparatorDate();
                break;
        }

        set = new TreeSet<>(comparator);
        boolean cont = true;
        while (cont) {
            Runner obj = null;
            try {
                obj = (Runner) input.readObject();
            } catch (IOException | ClassNotFoundException e) {
            }
            if (obj != null) {
                set.add(obj);
                if (set.size() == 60000) {
                    fos = new FileOutputStream(new File(LapManager.TEMPORARY_FILE_NAME + i + ".txt"));
                    writer = new ObjectOutputStream(fos);
                    for (Runner x : set) {
                        writer.writeObject(x);
                    }
                    writer.close();
                    i++;
                    set = new TreeSet<>(comparator);
                }
            } else {
                cont = false;
            }
        }

        fos = new FileOutputStream(new File(LapManager.TEMPORARY_FILE_NAME + i + ".txt"));
        writer = new ObjectOutputStream(fos);
        for (Runner x : set) {
            writer.writeObject(x);
        }
        writer.close();
        fos.close();

        Map<Runner, Integer> map = new TreeMap<>(comparator);

        InputStream[] in = new FileInputStream[i + 1];
        ObjectInputStream[] oin = new ObjectInputStream[i + 1];

        for (int j = 0; j <= i; j++) {
            in[j] = new FileInputStream(new File(LapManager.TEMPORARY_FILE_NAME + j + ".txt"));
            oin[j] = new ObjectInputStream(in[j]);
            map.put((Runner) oin[j].readObject(), j);
        }

        fos = new FileOutputStream(new File(LapManager.OUTPUT_FILE_NAME));
        writer = new ObjectOutputStream(fos);

        while (!map.isEmpty()) {
            line = map.keySet().iterator().next();
            map.remove(line);
            writer.writeObject(line);
            line = null;
            try {
                line = (Runner) oin[i].readObject();
            } catch (IOException | ClassNotFoundException e) {
            }
            if (line != null) {
                map.put(line, i);
            }
        }
        writer.close();
        fos.close();

        for (int j = 0; j < in.length; j++) {
            in[j].close();
            new File(LapManager.TEMPORARY_FILE_NAME + j + ".txt").delete();
        }
    }

}
