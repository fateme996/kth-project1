package src.connect4.frontend;

import src.connect4.backend.Board;
import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    Board board = new Board();

    public GameUI() {
        setTitle("Connect 4");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(102, 0, 153));

        // Title
        JLabel label = new JLabel("Welcome to Connect 4");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 32));

        // Tokens panel
        JPanel tokensPanel = new JPanel();
        tokensPanel.setLayout(new FlowLayout());
        tokensPanel.setOpaque(false);

        tokensPanel.add(new Token(Color.RED));
        tokensPanel.add(new Token(Color.YELLOW));
        tokensPanel.add(new Token(Color.RED));
        tokensPanel.add(new Token(Color.YELLOW));


        // Botton
        JButton button = new JButton("Start Game");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(255, 255, 255));
        button.setMaximumSize(new Dimension(220, 60));
        button.setPreferredSize(new Dimension(220, 60));
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setFocusPainted(false);

        button.addActionListener(e -> {showGameScreen();});

        // Add spacing + elements
        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalStrut(15));
        panel.add(tokensPanel);
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        add(panel);
        setVisible(true);
    }

    private void showGameScreen() {
        getContentPane().removeAll();

        JPanel gamePanel = new JPanel() {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponents(g);

            int rows = 6;
            int cols = 7;

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate dynamic cell size
            int cellSize = Math.min(panelWidth / cols, panelHeight / rows);

            // Center board
            int offsetX = (panelWidth - (cols * cellSize)) / 2;
            int offsetY = (panelHeight - (rows * cellSize)) / 2;

            // Draw the background
            g.setColor(new Color(0, 0, 200));
            g.fillRect(0, 0, panelWidth, panelHeight);

            // Draw the holes
            g.setColor(Color.WHITE);

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int x = offsetX + col * cellSize;
                    int y = offsetY + row * cellSize;

                    g.fillOval(x + 5, y + 5, cellSize - 10, cellSize - 10);
                }
            }

        }
  }; 
  
        add(gamePanel);
        revalidate();
        repaint();

}

// Token class
class Token extends JPanel {
    private Color color;

    public Token(Color color) {
        this.color = color;
        setPreferredSize(new Dimension(80, 80));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, getWidth(), getHeight());
    }
  } 
 } 
