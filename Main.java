import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        super("Hello World");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new JLabel("Hello, World!"));
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        System.out.println("Hello Connect 4!");
        SwingUtilities.invokeLater(Main::new);
    }
}
