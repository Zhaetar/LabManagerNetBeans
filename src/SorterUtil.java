import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Sort a 400 MB file on a 40MB RAM
 *
 * @author raju rama krishna
 * @see http://javatroops.blogspot.co.nz
 *
 */
public class SorterUtil {

    public static void main(String[] args) throws Exception {
        int i = 0;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        Set<String> set;
        String line;
        
        set = new TreeSet<>();
        bufferedReader = new BufferedReader(new FileReader(new File("C:\\maratona.bin")));
        line = bufferedReader.readLine();
        
        while (line != null) {
            set.add(line);

            if (set.size() == 60000) {
                FileWriter fw;
                fw = new FileWriter(new File("C:\\temp-" + i + ".txt"));
                for (String x : set) {
                    fw.write(x);
                    fw.write("\n");
                }
                fw.close();
                i++;
                set = new TreeSet<>();
            }
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedReader = null;

        fileWriter = new FileWriter(new File("C:\\temp-" + i + ".txt"));
        for (String x : set) {
            fileWriter.write(x);
            fileWriter.write('\n');
        }
        fileWriter.close();

        Map<String, Integer> map = new TreeMap<>();

        BufferedReader[] brArr = new BufferedReader[i + 1];
        for (int j = 0; j <= i; j++) {
            brArr[j] = new BufferedReader(new FileReader(new File("C:\\temp-" + j + ".txt")));
            map.put(brArr[j].readLine(), j);
        }

        bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\output.txt")));

        String endofline = "\n";
        while (!map.isEmpty()) {
            line = map.keySet().iterator().next();
            i = map.get(line);
            map.remove(line);
            bufferedWriter.write(line);
            bufferedWriter.write(endofline);
            line = brArr[i].readLine();
            if (line != null) {
                map.put(line, i);
            }
        }
        bufferedWriter.close();

        for (int j = 0; j < brArr.length; j++) {
            brArr[j].close();
            new File("C:\\temp-" + j + ".txt").delete();
        }
    }

}
