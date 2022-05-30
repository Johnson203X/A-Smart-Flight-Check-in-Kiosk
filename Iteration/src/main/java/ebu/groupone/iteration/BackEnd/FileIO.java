package ebu.groupone.iteration.BackEnd;

import java.io.*;

/**
 * Class of handling the IO of stream format Data, the lowest level
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class FileIO {

    /**
     * Reading from storage file returning input String
     * @param filePath The location while file should be read from
     * @return String The input String to be used and processed
     * @throws IOException Unexpected IOException
     */
    protected static String read(String filePath) throws IOException {
        try (
                FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)
        ) {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp + "\n");
            }
            br.close();
            return sb.toString();
        }
    }

    /**
     * Writing to storage file with output String
     * @param filePath The location while file should be written to
     * @param str The output String to be stored
     * @throws IOException Unexpected IOException
     */
    protected static void write(String filePath, String str) throws IOException {
        File file = new File(filePath);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
        ps.close();

    }
}