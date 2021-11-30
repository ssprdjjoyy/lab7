import java.io.*;

public class Buf_RW_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;
        try {
            br = new BufferedReader(new FileReader("E:\\MyFile1.txt"),1024);
            out = new BufferedWriter(new FileWriter("E:\\MyFile2.txt"));
            int lineCount = 0;
            String s = br.readLine();
            while (s != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                out.write(s);
                out.newLine();
                s = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!");
        }
        finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}