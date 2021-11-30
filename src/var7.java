import java.io.*;
import java.util.*;

public class var7 {
    public static void main(String[] args) throws IOException, EOFException {
        Scanner sc = new Scanner(System.in);
        try {
            File f1 = new File("scr.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            rf.seek(0);
            System.out.println("Размер файла " + rf.length());
            System.out.println("kolich");
            int kolich = sc.nextInt();

            for (int i = 0; i < kolich; i++) {
                System.out.println("Fam:");
                String Fam = sc.next();
                rf.writeUTF(Fam);
                for (int j = 0; j < 20 - Fam.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Imya:");
                String Imya = sc.next();
                rf.writeUTF(Imya);
                for (int j = 0; j < 20 - Imya.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Pol:");
                String Pol = sc.next();
                rf.writeUTF(Pol);
                for (int j = 0; j < 20 - Pol.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Rost:");
                int Rost = sc.nextInt();
                rf.writeInt(Rost);
            }
            System.out.println("Размер файла " + rf.length());

            File f2 = new File("lab7.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            RandomAccessFile rf1 = new RandomAccessFile(f2, "rw");
            rf.seek(0);
            rf1.seek(0);
            System.out.println("Размер файла " + rf1.length());

            int found = 0;
            for (int i = 0; i < kolich; i++) {
                rf.seek(52*i);
                String Fam = rf.readUTF();
                rf.seek(52*i + 22);
                String Imya = rf.readUTF();
                rf.seek(52*i + 44);
                String Pol = rf.readUTF();
                rf.seek(52*i + 48);
                int Rost = rf.readInt();
                if (Rost > 170) {
                    rf1.writeUTF(Fam);
                    for (int j = 0; j < 20 - Fam.length(); j++) {
                        rf1.writeByte(1);
                    }
                    rf1.writeUTF(Imya);
                    for (int j = 0; j < 20 - Imya.length(); j++) {
                        rf1.writeByte(1);
                    }
                    rf1.writeUTF(Pol);
                    for (int j = 0; j < 20 - Pol.length(); j++) {
                        rf1.writeByte(1);
                    }
                    rf1.writeInt(Rost);
                    found++;
                }
            }
            System.out.println("Размер файла " + rf1.length());
            System.out.println("Количество записей: " + found);
            rf1.seek(0);
            for (int i = 0; i < found; i++) {
                rf1.seek(i * 52);
                String Fam = rf1.readUTF();
                rf1.seek(i * 52 + 22);
                String Imya = rf1.readUTF();
                rf1.seek(i * 52 + 44);
                String Pol = rf1.readUTF();
                rf1.seek(i * 52 + 48);
                int Rost = rf1.readInt();
                System.out.println("Фамилия: " + Fam + " Имя: " + Imya + " Пол: " + Pol + " Рост: " + Rost);
            }
            rf.close();
            rf1.close();
        } catch (EOFException eof) {
            System.out.println("EOF");
        } catch (IOException ioe) {
            System.out.println("IOE");
        }
    }
}
