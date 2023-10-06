import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {
    private JLabel gameOverLabel;

    JPanel gameFieldPanel;
    Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(Game.widthOfField,Game.heightOfField);
    //setting the icon
        this.setLocation(550,200);
        this.setResizable(false);
        ImageIcon frameEmblem = new ImageIcon("C:\\Users\\yurap\\IdeaProjects\\Saper\\Images\\EmblemBomb.jpg");
        this.setIconImage(frameEmblem.getImage());

        this.getContentPane().setBackground(Color.pink);
        gameFieldPanel = new JPanel();
        gameFieldPanel.setBackground(new Color(44,44,44));

            gameFieldPanel.setBounds(0, Game.UPPER_BAR_DY, Game.NUMBER_OF_CELLS* Game.CELL_SIZE, Game.NUMBER_OF_CELLS* Game.CELL_SIZE);
            this.setLayout(null);
        //placement of cells
        this.filingCells();

    }
        private void filingCells(){
            gameFieldPanel.setLayout(new GridLayout(Game.NUMBER_OF_CELLS,Game.NUMBER_OF_CELLS));
            JLabel cellLabel = new JLabel();
            cellLabel.setOpaque(true);
            cellLabel.setBackground(gameFieldPanel.getBackground());

            //adding cells to the pannel;
            for(int i = 0 ; i < Game.NUMBER_OF_CELLS;i++){
                for(int j = 0 ; j < Game.NUMBER_OF_CELLS;j++){
                    gameFieldPanel.add(this.creatingLabelForCell(i,j));
                }
            }

            cellLabel.setLocation(Game.CELL_SIZE,Game.CELL_SIZE);
            this.add(gameFieldPanel);
                //adding the GameOverLabel an making it invisible
                    gameOverLabel = new JLabel();
                    gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
                    gameOverLabel.setVerticalAlignment(JLabel.CENTER);
                    gameOverLabel.setLocation(this.getX()+this.getWidth(),this.getY()+this.getHeight());
                    gameOverLabel.setSize(100,40);
                    gameOverLabel.setText("Game over");
                    gameOverLabel.setVisible(false);
            this.setVisible(true);

        }
        //creates a label for a cell


                private JLabel creatingLabelForCell(int horizontalNumber,int verticalNumber){
                    JLabel defaultcell = new JLabel();
                    defaultcell.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Cell.createCells();
                            if(e.getButton() == 1){
                                defaultcell.setBackground(Color.pink);
                                defaultcell.setHorizontalAlignment(JLabel.CENTER);
                                if(Cell.getMassivOfCells()[horizontalNumber][verticalNumber].getStateOfCell()== Cell.StateOfCell.HAS_BOMB_NEARBY){
                                    //print number of bombs nearby
                                }
                                if(Cell.getMassivOfCells()[horizontalNumber][verticalNumber].getStateOfCell()== Cell.StateOfCell.HAS_BOMB){
                                    //game over
                                    gameOverLabel.setVisible(true);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    System.exit(0);
                                }
                            }
                            if(e.getButton() == 3){
                                defaultcell.setBackground(Color.red);
                                defaultcell.setFont(new Font("serif",Font.BOLD,30));
                                defaultcell.setText("F");
                                defaultcell.setHorizontalAlignment(JLabel.CENTER);
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    defaultcell.setOpaque(true);
                    defaultcell.setBackground(gameFieldPanel.getBackground());
                    defaultcell.setBorder(BorderFactory.createLineBorder(Color.pink,Game.THICKNESS_OF_BORDERLINE));
                    return defaultcell;
                }


}

