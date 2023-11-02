import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameOfLife extends JFrame {
    private final int numRows = 90;
    private final int numCols =90;


    private  Square[][] grid;
    private JPanel panel = new JPanel(new GridLayout(numRows, numCols));
    private JButton startButton = new JButton("Start");
    private JButton randomButton = new JButton("Random");
    private JToolBar toolBar = new JToolBar();
    private Timer gameTimer;

    public void randomizeGrid() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                boolean isAlive = Math.random() < 0.5;
                grid[i][j].color = isAlive ? Color.WHITE : Color.BLACK;
                grid[i][j].setBackground(grid[i][j].color);
            }
        }
    }

    public GameOfLife() {
        grid = new Square[numRows][numCols];
        //JButton button = new JButton("Start");



        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = new Square();
                panel.add(grid[i][j]);
            }
        }
        gameTimer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameTimer.isRunning()){
                    gameTimer.stop();
                    startButton.setText("Start");

                }else {
                    gameTimer.start();
                    startButton.setText("Pause");
                }

                    }
                });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeGrid();
                panel.repaint();
            }
        });



        toolBar.add(randomButton);
       // panel.add(button);
        toolBar.add(startButton);
        getContentPane().add(toolBar, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void updateGame(){
        Square[][] newGrid = new Square[numRows][numCols];

        for (int i = 0; i < numRows; i++){
            for (int j = 0 ; j < numCols; j++){
                newGrid[i][j] = new Square();
                boolean nextState = Alive.isALiveNextGeneration(grid,i ,j );
                newGrid[i][j].color = nextState ? Color.WHITE : Color.black ;
                newGrid[i][j].setBackground(newGrid[i][j].color);
            }
        }
        this.grid = newGrid;
        panel.removeAll();

        for (int i = 0 ; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                panel.add(grid[i][j]);

            }
        }
        panel.revalidate();
        panel.repaint();
    }

   public class Square extends JPanel {
        public Color getColor(){
            return color;
        }
        Color color;


        public Square() {

            color = Color.black;
            setBorder(BorderFactory.createLineBorder(Color.gray));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    color = Color.white;
                    setBackground(color);

                }

            });
            setPreferredSize(new Dimension(10, 10));  // Größe wurde für eine bessere Sichtbarkeit reduziert
            setBackground(color);
        }






    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfLife();
            }
        });
    }
}
 class Alive {
     public static boolean isALiveNextGeneration(GameOfLife.Square[][] grid, int i, int j) {
         boolean currentState = grid[i][j].getColor().equals(Color.WHITE);
         int livingNeighbors = countLivingNeighbors(grid, i, j);


         if (currentState) {
             return livingNeighbors == 2 || livingNeighbors == 3;
         } else {
             return livingNeighbors == 3;
         }

     }

     private static int countLivingNeighbors(GameOfLife.Square[][] grid, int i, int j) {
         int count = 0;
         int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
         int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};


         for (int k = 0; k < 8; k++) {
             int newX = i + dx[k];
             int newY = j + dy[k];

             if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                 if (grid[newX][newY].color.equals(Color.WHITE)) {
                     count++;
                 }
             }
         }
             return count;
         }

     }


