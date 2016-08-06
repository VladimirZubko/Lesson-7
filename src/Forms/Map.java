package Forms;

import javax.swing.*;

import MyClass.XOGames;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Владимир on 06.08.2016.
 */
public class Map extends JPanel {
    //final static int SIZE_CELL = 40;
    private XOGames field;
    int lineX;
    int lineY;
    int sizeCell;
    String movesResidue = "---";
    String lastCoordinates = "_";

    public Map(int lineX, int lineY, int sizeCell) {
        this.lineX = lineX;
        this.lineY = lineY;
        this.sizeCell = sizeCell;
        field = new XOGames(lineX, lineY);
        //setBackground(Color.white);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Координаты " + (int)(e.getX()/sizeCell+1) + "x" + (int)(e.getY()/sizeCell+1));
                lastCoordinates = "Координаты " + (int)(e.getX()/sizeCell+1) + "x" + (int)(e.getY()/sizeCell+1);
                if (field.humanTurn(((int)(e.getX()/sizeCell)), ((int)(e.getY()/sizeCell)))) field.aiTurn();
                field.printField();

                repaint();
            }
        });
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(1,1, lineX*sizeCell, lineY*sizeCell);

        for (int i = 0; i < lineX; i++) g.drawLine(sizeCell*i, 0, sizeCell*i, sizeCell*lineY);
        for (int i = 0; i < lineY; i++) g.drawLine(0, sizeCell*i, sizeCell*lineX, sizeCell*i);

        for (int i = 0; i < lineX; i++) {
            for (int j = 0; j < lineY; j++) {
                switch (field.cellValue(i, j)) {
                    case 1:
                        g.drawLine((i*sizeCell + 5), (j*sizeCell + 5), ((i + 1) * sizeCell - 5), ((j + 1) * sizeCell) - 5);
                        g.drawLine((i*sizeCell + 5), ((j + 1) * sizeCell - 5), ((i + 1) * sizeCell - 5), (j*sizeCell + 5));
                        break;
                    case (-1):
                        g.drawOval((i*sizeCell + 5), (j*sizeCell + 5), (sizeCell-10), (sizeCell-10));
                        break;
                }
            }
        }
    }
}
