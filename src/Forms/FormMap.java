package Forms;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Владимир on 06.08.2016.
 */
public class FormMap extends JFrame {
    final static int MAX_SIZE_X = 50;
    final static int MAX_SIZE_Y = 50;
    final static int MIN_SIZE_X = 3;
    final static int MIN_SIZE_Y = 3;
    final static int MIN_SIZE_CELL = 20;
    final static int MAX_SIZE_CELL = 60;

    public FormMap (){
        super();
        setTitle("Крестики-Нолики");
        setSize(500,500);
        setLocation(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(new Color(0, 0, 200));

        Map jMap = new Map(3, 3, 30);
        JPanel jbPanelButton = new JPanel(new GridLayout());
        JPanel jbPanelInfo = new JPanel(new GridLayout());
        JPanel jbPanelLeft = new JPanel(new GridLayout());
        jbPanelLeft.setPreferredSize(new Dimension(10,200));
        //jbPanelLeft.setBackground(new Color(120,120,120,100));
        add(jMap, BorderLayout.CENTER);
        add(jbPanelButton, BorderLayout.NORTH);
        add(jbPanelLeft, BorderLayout.WEST);
        add(jbPanelInfo, BorderLayout.SOUTH);
        jbPanelInfo.add(new JLabel(jMap.movesResidue));
        jbPanelInfo.add(new JLabel(jMap.lastCoordinates));
        JButton jbStart = new JButton("Новая игра");
        JButton jbEnd = new JButton("Закончить игру");
        jbPanelButton.add(jbStart);
        jbPanelButton.add(jbEnd);

        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jbEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
}
