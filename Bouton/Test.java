
import javax.swing.JFrame;
import java.awt.Color;

public class Test {

    public static void main(String[] args) {
        Panneau pann = new Panneau();
        Menu m = new Menu(pann);
        Fenetre1 fen = new Fenetre1(pann);
    }
}
