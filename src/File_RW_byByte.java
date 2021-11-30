import java.io.*;

public class File_RW_byByte {
    public static void main(String[] args) throws IOException {
        Reader in = null;
        Writer out = null;
        try {
            in = new FileReader("E:\\MyFile.txt");
            out = new FileWriter("E:\\MyFile2.txt, true");
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.write((char)oneByte);
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!");
        }
        finally {
            in.close();
            out.close();
        }
    }
}