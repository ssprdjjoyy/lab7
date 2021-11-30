import java.io.Serializable;

public class People implements Serializable{
    String Fam;
    String Imya;
    String Pol;
    int Rost;

    public String toString() {
        return "People{" +
                "Фамилия='" + Fam + '\'' +
                ", Имя='" + Imya + '\'' +
                ", Пол='" + Pol + '\'' +
                ", Рост=" + Rost +
                '}';
    }
}
