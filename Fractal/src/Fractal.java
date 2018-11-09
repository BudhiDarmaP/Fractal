
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author budhidarmap
 */
public class Fractal extends JFrame {

    private final int WIDTH = 600;
    private final int HEIGHT = 580;
    private final int MIN_LEVEL = 0, MAX_LEVEL = 15;
    private Color color = Color.BLACK;
    private String shape;

    int mKlik = 0;
    private JComboBox shapeChooser;
    private final JButton resetJButton, changeColorJButton, increaseLevelJButton,
            decreaseLevelJButton;
    private JLabel levelJLabel;
    private FractalJPanel drawSpace;
    private final JPanel mainJPanel, controlJPanel;
    private final String[] listShape = {"Level 1 (Line)", "Level 3 (Triangle)", "Level 4 (Square)", "Level 5 (Pentagon)", "Level 6 (Hexagon)"};

    // set up GUI
    public Fractal() {
        super("Fractal");

        // set up control panel
        controlJPanel = new JPanel();
        controlJPanel.setLayout(new FlowLayout());
        resetJButton = new JButton("Reset");
        resetJButton.addActionListener((ActionEvent e) -> {
            if (e != null) {
                mKlik = 0;
                drawSpace.setLevel(0);
                levelJLabel.setText("Level : 0");
                drawSpace.setCPoint(mKlik);
                drawSpace.setPoint1(null);
                drawSpace.setPoint2(null);
                drawSpace.setPoint3(null);
                drawSpace.setPoint4(null);
                drawSpace.setPoint5(null);
                drawSpace.setPoint6(null);
                drawSpace.setShape(null);
                drawSpace.setShape1(null);
                drawSpace.setShape2(null);
                drawSpace.setShape3(null);
                drawSpace.setShape4(null);
                drawSpace.setShape5(null);
                drawSpace.setLevel1(0);
                drawSpace.setLevel2(0);
                drawSpace.setLevel3(0);
                drawSpace.setLevel4(0);
                drawSpace.setLevel5(0);
            }
            repaint();
        });
        controlJPanel.add(resetJButton);
        shapeChooser = new JComboBox(listShape);
        controlJPanel.add(shapeChooser);
        shapeChooser.addActionListener((ActionEvent event) -> {
            shape = shapeChooser.getSelectedItem().toString().substring(9);
            if (shape.contains("Triangle")) {
                shape="Triangle";
            } else if (shape.contains("Square")) {
                shape="Square";
            } else if (shape.contains("Pentagon")) {
                shape="Pentagon";
            } else if (shape.contains("Hexagon")) {
                shape="Hexagon";
            } else {
                shape="Line";
            }
            drawSpace.setShape(shape);
            repaint();
        });
        changeColorJButton = new JButton("Color");
        controlJPanel.add(changeColorJButton);
        changeColorJButton.addActionListener((ActionEvent event) -> {
            if (mKlik != 0) {
                color = JColorChooser.showDialog(
                        Fractal.this, "Choose a color", color);
                if (color == null) {
                    color = Color.BLACK;
                }
                drawSpace.setColor(color);
            }
            repaint();
        });
        decreaseLevelJButton = new JButton("Decrease Level");
        controlJPanel.add(decreaseLevelJButton);
        decreaseLevelJButton.addActionListener((ActionEvent event) -> {
            if (mKlik != 0) {
                int level = drawSpace.getLevel();
                level--;
                if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
                    levelJLabel.setText("Level: " + level);
                    drawSpace.setLevel(level);
                }
            }
            repaint();
        });
        increaseLevelJButton = new JButton("Increase Level");
        controlJPanel.add(increaseLevelJButton);
        increaseLevelJButton.addActionListener((ActionEvent event) -> {
            if (mKlik != 0) {
                int level = drawSpace.getLevel();
                level++;
                if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
                    levelJLabel.setText("Level: " + level);
                    drawSpace.setLevel(level);
                }
            }
            repaint();
        });
        levelJLabel = new JLabel("Level: 0");
        controlJPanel.add(levelJLabel);
        drawSpace = new FractalJPanel(0);
        drawSpace.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getPoint() != null) {
                    int level = drawSpace.getLevel();
                    if (mKlik == 0) {
                        drawSpace.setPoint1(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    } else if (mKlik == 1) {
                        drawSpace.setPoint2(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    } else if (mKlik == 2) {
                        drawSpace.setPoint3(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    } else if (mKlik == 3) {
                        drawSpace.setPoint4(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    } else if (mKlik == 4) {
                        drawSpace.setPoint5(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    } else if (mKlik == 5) {
                        drawSpace.setPoint6(e.getPoint());
                        mKlik++;
                        drawSpace.setCPoint(mKlik);
                    }
                    drawSpace.setLevel(0);
                    levelJLabel.setText("Level : 0");
                    shapeChooser.setSelectedIndex(0);
                    repaint();
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

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        mainJPanel = new JPanel();
        mainJPanel.add(controlJPanel);
        mainJPanel.add(drawSpace);
        add(mainJPanel);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public static void main(String args[]) {
        Fractal demo = new Fractal();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setResizable(false);
    }
}
