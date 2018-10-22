
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SorterUtil {

    final static String FILE_NAME = "C:\\maratona.bin";

    public static void sortFile() throws Exception {
        int i = 0;
        FileInputStream fis = new FileInputStream(FILE_NAME);
        FileOutputStream fos;
        ObjectInputStream input = new ObjectInputStream(fis);
        ObjectOutputStream fileWriter;
        Set<Runner> set;
        Runner line;

        set = new TreeSet<>(new ComparatorCode());
        boolean cont = true;
        while (cont) {
            Runner obj = null;
            try {
                obj = (Runner) input.readObject();
            } catch (Exception e) {
            }
            if (obj != null) {
                set.add(obj);
                if (set.size() == 60000) {
                    fos = new FileOutputStream(new File("C:\\temp-" + i + ".txt"));
                    ObjectOutputStream writer = new ObjectOutputStream(fos);
                    for (Runner x : set) {
                        writer.writeObject(x);
                    }
                    writer.close();
                    i++;
                    set = new TreeSet<>(new ComparatorCode());
                }
            } else {
                cont = false;
            }
        }

        fos = new FileOutputStream(new File("C:\\temp-" + i + ".txt"));
        ObjectOutputStream writer = new ObjectOutputStream(fos);
        for (Runner x : set) {
            writer.writeObject(x);
        }
        writer.close();
        fos.close();

        Map<Runner, Integer> map = new TreeMap<>(new ComparatorCode());

//        BufferedReader[] brArr = new BufferedReader[i + 1];
        InputStream[] in = new FileInputStream[i + 1];
        ObjectInputStream[] oin = new ObjectInputStream[i + 1];

        for (int j = 0; j <= i; j++) {
            in[j] = new FileInputStream(new File("C:\\temp-" + j + ".txt"));
            oin[j] = new ObjectInputStream(in[j]);
            map.put((Runner) oin[j].readObject(), j);
        }

        fos = new FileOutputStream(new File("C:\\output.txt"));
        writer = new ObjectOutputStream(fos);

        while (!map.isEmpty()) {
            line = map.keySet().iterator().next();
            map.remove(line);
            writer.writeObject(line);
            line = null;
            try {
                line = (Runner) oin[i].readObject();
            } catch (Exception e) {
            }
            if (line != null) {
                map.put(line, i);
            }
        }
        writer.close();
        fos.close();

        for (int j = 0; j < in.length; j++) {
            in[j].close();
            new File("C:\\temp-" + j + ".txt").delete();
        }
    }

}
