import java.io.*;
import java.util.Scanner;

public class var7_2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try {
            Scanner sc = new Scanner(System.in);
            File f1 = new File("C:\\lab7\\people.txt");
            f1.createNewFile();
            fos = new FileOutputStream(f1);
            oos = new ObjectOutputStream(fos);
            System.out.println("kolich");
            int kolich = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < kolich; i++){
                People people = new People();
                System.out.println("Фамимлия");
                people.Fam = sc.nextLine();
                System.out.println("Имя");
                people.Imya = sc.nextLine();
                System.out.println("Пол");
                people.Pol = sc.nextLine();
                System.out.println("Рост");
                people.Rost = sc.nextInt();
                sc.nextLine();
                oos.writeObject(people);
            }
            fis = new FileInputStream(f1);
            oin = new ObjectInputStream(fis);
            People n = null;
            for (int i = 0; i < kolich; i++) {
                n = (People) oin.readObject();
                if (n.Rost>170){
                    System.out.println(n);
                }
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            oin.close();
            fis.close();
        }
    }
}