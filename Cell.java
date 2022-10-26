import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton {

    private int x;
    private int y;

    public int getmyX() {
        return x;
    }

    public int getmyY() {
        return y;
    }

    public Cell(int x, int y, Color color) {
        setBackground(color);
        setForeground(Color.yellow);
        this.x = x;
        this.y = y;
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cell button = (Cell) actionEvent.getSource();
                Board board = (Board) button.getParent();
                if (button.getBackground() == Color.black) {
                    return;
                }

                if (  !board.isClicked()) {
                    if(!(button.getBackground() == Color.gray)){
                    button.setText("НАЖАТАЯ");
                    board.setClicked(true);
                    board.clickedButton = button;
                } else {
                        return;
                    }
                    }else{

                    int buttonX = button.getmyX();
                    int buttonY = button.getmyY();
                    int boardX = board.clickedButton.getmyX();
                    int boardY = board.clickedButton.getmyY();

                    if(button.getBackground() == Color.gray && ((Math.abs(buttonX - boardX) == 1 && Math.abs(buttonY - boardY) == 0) || (Math.abs(buttonY - boardY) == 1 && Math.abs(buttonX - boardX) == 0))) {
                        Color tmpColor = button.getBackground();
                        button.setBackground(board.clickedButton.getBackground());
                        board.clickedButton.setBackground(tmpColor);

                        int tmpInt = board.cellsSetup[buttonX][buttonY];
                        board.cellsSetup[buttonX][buttonY] = board.cellsSetup[boardX][boardY];
                        board.cellsSetup[boardX][boardY] = tmpInt;

                        board.clickedButton.setText("");

                        board.setClicked(false);
                        board.checkForWin();
                    }
                    if(buttonX == boardX && buttonY == boardY) {
                        board.clickedButton.setText("");
                        board.setClicked(false);

                    }

                }
            }
        });
    }

}
