package src.connect4.frontend;

import src.connect4.backend.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameUI extends JFrame {

    int rows = 6;
    int cols = 7;

    private int currentPlayer = 1; // 1= red, 2= yellow


    private int[][] grid = new int [6][7];
    Board board = new Board();

    public GameUI() {
        setTitle("Connect 4");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showWelcomeScreen();
        setVisible(true);
    }
    // welcome screen
    private void showWelcomeScreen() {

        //Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(102, 0, 153));

        // Title
        JLabel label = new JLabel("Welcome to Connect 4");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 42));

        // Tokens panel
        JPanel tokensPanel = new JPanel();
        tokensPanel.setLayout(new FlowLayout());
        tokensPanel.setOpaque(false);

        tokensPanel.add(new Token(Color.RED));
        tokensPanel.add(new Token(Color.YELLOW));
        tokensPanel.add(new Token(Color.RED));
        tokensPanel.add(new Token(Color.YELLOW));


        // Button
        JButton button = new JButton("Start Game");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(255, 255, 255));
        button.setMaximumSize(new Dimension(220, 60));
        button.setPreferredSize(new Dimension(220, 60));
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setFocusPainted(false);

        button.addActionListener(e -> {showGameScreen();});

        //Adding rule button
        JButton ruleButton = new JButton("Rule");
        ruleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleButton.setPreferredSize(new Dimension(200, 50));
        ruleButton.setMaximumSize(new Dimension(200, 50));
        ruleButton.setFont(new Font("Arial", Font.BOLD, 22));

        ruleButton.addActionListener(e -> showRule());

        // Add spacing + elements
        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalStrut(30));
        panel.add(tokensPanel);
        panel.add(button);
        panel.add(Box.createVerticalStrut(20));
        panel.add(ruleButton);
        panel.add(Box.createVerticalGlue());
        
        add(panel);
        revalidate();
        repaint();

    }

    // Game screen
    private void showGameScreen() {
        getContentPane().removeAll();

        JPanel gamePanel = new JPanel() {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


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

        

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int x = offsetX + col * cellSize;
                    int y = offsetY + row * cellSize;

                    // Draw the hole(empty)
                    g.setColor(Color.WHITE);
                    g.fillOval(x + 5, y + 5, cellSize - 10, cellSize - 10);

                    // Draw token if exists
                    if (grid[row][col] == 1) {
                        g.setColor(Color.RED);
                        g.fillOval(x + 5, y + 5, cellSize - 10, cellSize - 10);
                    } else if (grid[row][col] == 2) {
                        g.setColor(Color.YELLOW);
                        g.fillOval(x + 5, y + 5, cellSize - 10, cellSize - 10);

                    }
                }
            }

        }
  }; 

  // click handeling
  gamePanel.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e) {

        //get current size of the panel
        int panelWidth = gamePanel.getWidth();
        int panelHeight = gamePanel.getHeight();

        // calculate the size of each cell
        int cellSize = Math.min(panelWidth / cols, panelHeight / rows);

        // calculate the horizontal offset to center the board
        int offsetX = (panelWidth - (cols * cellSize)) / 2;

        // get X position where user clicked in pixels
        int x = e.getX();

        // convert pixel position to column index
        int column = (x - offsetX) / cellSize;

        //Ignore clicks outside the board
        if (column < 0 || column >= cols) {
            return;
        }
        //simulate token falling in the selected column
        for (int row = rows -1; row >= 0; row--) {
            //check if the posiion is empty
            if (grid[row][column] == 0) {

                //place token for current player
                grid [row][column] = currentPlayer;

                //switch player for next turn
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
                break;
            }
        }
        gamePanel.repaint(); // redraw the board
        
        System.out.println("Clicked column: " + column);
    }

  });

  // add panel to frame
        add(gamePanel);
        revalidate();
        repaint();

}

private void showRule() {
    String message = "Connect 4 Game\n\n"
            + "Connect 4 is a two-player game where players take turns dropping colored discs into a grid.\n" + 
                                "The discs fall to the lowest empty spot in the selected column.\n" + 
                                "The goal is to connect four discs in a row, either horizontally, vertically, or diagonally.\n" + 
                                "If the board becomes full before a player connects four discs, the game ends in a draw.\n\n"
            + "Good luck!";

JOptionPane.showMessageDialog(this, message, "Game Rule", JOptionPane.INFORMATION_MESSAGE);
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
