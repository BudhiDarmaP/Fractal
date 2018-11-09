
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author budhidarmap
 */
public class FractalJPanel extends JPanel {

    private String Shape, Shape1, Shape2, Shape3, Shape4, Shape5; // stores shape used to draw fractal
    private Color color; // stores color used to draw fractal
    private int level, level1, level2, level3, level4, level5;   // stores current level of fractal
    private int CPoint;   // stores size of point
//    private double X1, Y1, X2, Y2;   // first coordinat
    private double X1 = 500, Y1 = 300, X2 = 100, Y2 = 300;   // first coordinat
    private Point point1, point2, point3, point4, point5, point6;

    private final int WIDTH = 600;  // defines width of JPanel
    private final int HEIGHT = 580; // defines height of JPanel

    // set the initial fractal level to the value specified
    // and set up JPanel specifications
    public FractalJPanel(int currentLevel) {
        if (Shape == null) {
            Shape1 = "Line";
            Shape2 = "Triangle";
            Shape3 = "Square";
            Shape4 = "Pentagon";
            Shape5 = "Hexagon";
        }
        color = Color.BLACK; // initialize drawing color to black
        level = currentLevel; // set initial fractal level
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    } // end constructor FractalJPanel
    // draw fractal recursively

    public void drawFractal(String shape, int level, double x1, double y1, double x2, double y2, Graphics g) {
        // base case: draw a line connecting two given points
        if (level == 0) {
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else // recursion step: determine new points, draw next level
        {
            if (shape.equals("Triangle")) {
                double dx = (x2 - x1) / 3.;
                double dy = (y2 - y1) / 3.;

                double x1n = x1 + dx;
                double y1n = y1 + dy;

                double x2n = x1 + 2. * dx;
                double y2n = y1 + 2. * dy;

                double xexp = .5 * dx - .866 * dy + x1n;
                double yexp = .5 * dy + .866 * dx + y1n;

                drawFractal(shape, level - 1, x1, y1, x1n, y1n, g);
                drawFractal(shape, level - 1, x1n, y1n, xexp, yexp, g);
                drawFractal(shape, level - 1, xexp, yexp, x2n, y2n, g);
                drawFractal(shape, level - 1, x2n, y2n, x2, y2, g);
            } else if (shape.equals("Square")) {
                double dx = (x2 - x1) / 3.;
                double dy = (y2 - y1) / 3.;

                double x1n = x1 + dx;
                double y1n = y1 + dy;

                double x2n = x1 + 2. * dx;
                double y2n = y1 + 2. * dy;

                double xexp = x1n + .9 * dx - .9 * dy;
                double yexp = y1n + .9 * dx;

                drawFractal(shape, level - 1, x1, y1, x1n, y1n, g);
                drawFractal(shape, level - 1, x1n, y1n, x1n, yexp, g);
                drawFractal(shape, level - 1, x1n, yexp, xexp, yexp, g);
                drawFractal(shape, level - 1, xexp, yexp, xexp, y2n, g);
                drawFractal(shape, level - 1, xexp, y2n, x2n, y2n, g);
                drawFractal(shape, level - 1, x2n, y2n, x2, y2, g);

            } else if (shape.equals("Pentagon")) {
                double degrees072 = Math.toRadians(72);
                double degrees108 = Math.toRadians(108);
                double dx = (x2 - x1) / 3.;
                double dy = (y2 - y1) / 3.;

                double x1n = x1 + dx;
                double y1n = y1 + dy;

                double x2n = x1 + 2. * dx;
                double y2n = y1 + 2. * dy;

                double x1xp = x2n + .425 * dx;
                double y1xp = y2n + .904 * dx;

                double x2xp = x1xp - .844 * dx;
                double y2xp = (y2n + .5 * dx) + (.5 * dx * 3.077);

                double x3xp = x1n - .425 * dx;
                double y3xp = y1n + .904 * dx;

                drawFractal(shape, level - 1, x2n, y2n, x2, y2, g);
                drawFractal(shape, level - 1, x1xp, y1xp, x2n, y2n, g);
                drawFractal(shape, level - 1, x2xp, y2xp, x1xp, y1xp, g);
                drawFractal(shape, level - 1, x3xp, y3xp, x2xp, y2xp, g);
                drawFractal(shape, level - 1, x1n, y1n, x3xp, y3xp, g);
                drawFractal(shape, level - 1, x1, y1, x1n, y1n, g);

            } else if (shape.equals("Hexagon")) {
                double degrees120 = Math.toRadians(120);

                double dx = (x2 - x1) / 3.;
                double dy = (y2 - y1) / 3.;

                double x1n = x1 + dx;
                double y1n = y1 + dy;

                double x2n = x1 + 2. * dx;
                double y2n = y1 + 2. * dy;

//
                double x1xp = x1n - .866 * dx + .866 * dy;//x kanan bawah
                double y1xp = y1n + .866 * dx - .866 * dy;//y kanan bawah

                double x2xp = x1xp + .866 * dx - .866 * dy;//x kanan atas
                double y2xp = y1xp + .866 * dx + .866 * dy;//y kanan atas

                double x4xp = x2n + .866 * dx - .866 * dy;//x kiri bawah
                double y4xp = y2n + .866 * dx - .866 * dy;//y kiri bawah

                double x3xp = x4xp - .866 * dx - .866 * dy;//x kiri atas
                double y3xp = y4xp + .866 * dx + .866 * dy;//y kiri atas

                drawFractal(shape, level - 1, x1, y1, x1n, y1n, g);
                drawFractal(shape, level - 1, x1n, y1n, x1xp, y1xp, g);
                drawFractal(shape, level - 1, x1xp, y1xp, x2xp, y2xp, g);
                drawFractal(shape, level - 1, x2xp, y2xp, x3xp, y3xp, g);
                drawFractal(shape, level - 1, x3xp, y3xp, x4xp, y4xp, g);
                drawFractal(shape, level - 1, x4xp, y4xp, x2n, y2n, g);
                drawFractal(shape, level - 1, x2n, y2n, x2, y2, g);
//                
            } else {
                double x3 = (x1 + x2) / 2;
                double y3 = (y1 + y2) / 2;

                double xD = x1 + (x3 - x1) / 2 - (y3 - y1) / 2;
                double yD = y1 + (y3 - y1) / 2 + (x3 - x1) / 2;
                // recursively draw the Fractal
                drawFractal(shape, level - 1, xD, yD, x1, y1, g);
                drawFractal(shape, level - 1, xD, yD, x3, y3, g);
                drawFractal(shape, level - 1, xD, yD, x2, y2, g);
            }// end else // end method drawFractal
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw fractal pattern
        g.setColor(color);
        if (CPoint > 1) {
            if (CPoint == 3) {
                level2 = level;
                Shape2 = Shape;
            } else if (CPoint == 4) {
                level3 = level;
                Shape3 = Shape;
            } else if (CPoint == 5) {
                level4 = level;
                Shape4 = Shape;
            } else if (CPoint == 6) {
                level5 = level;
                Shape5 = Shape;
            } else {
                level1 = level;
                if (Shape == null) {
                    Shape1 = "Line";
                } else {
                    Shape1 = Shape;
                }
            }
            if (CPoint > 1) {
                drawFractal(Shape1, level1, point2.getX(), point2.getY(), point1.getX(), point1.getY(), g);
            }
            if (CPoint > 2) {
                drawFractal(Shape2, level2, point3.getX(), point3.getY(), point2.getX(), point2.getY(), g);
            }
            if (CPoint > 3) {
                drawFractal(Shape3, level3, point4.getX(), point4.getY(), point3.getX(), point3.getY(), g);
            }
            if (CPoint > 4) {
                drawFractal(Shape4, level4, point5.getX(), point5.getY(), point4.getX(), point4.getY(), g);
            }
            if (CPoint > 5) {
                drawFractal(Shape5, level5, point6.getX(), point6.getY(), point5.getX(), point5.getY(), g);
            }
        } else if (point1 != null) {
            g.drawOval(getPoint1().x, getPoint1().y, 2, 2);
        }
    } // end method paintComponent
    // set draw shape    

    public void setShape(String Shape) {
        this.Shape = Shape;
    }

    public void setShape1(String Shape) {
        this.Shape1 = Shape;
    }

    public void setShape2(String Shape) {
        this.Shape1 = Shape;
    }

    public void setShape3(String Shape) {
        this.Shape1 = Shape;
    }

    public void setShape4(String Shape) {
        this.Shape1 = Shape;
    }

    public void setShape5(String Shape) {
        this.Shape1 = Shape;
    }
    //set the shape

    public void setColor(Color c) {
        color = c;
    }
    // set the new level of recursion

    public void setLevel(int currentLevel) {
        level = currentLevel;
    }
    // returns level of recursion 

    public int getLevel() {
        return level;
    }

    public void setLevel1(int currentLevel) {
        level1 = currentLevel;
    }
    // returns level of recursion 

    public int getLevel1() {
        return level1;
    }

    public void setLevel2(int currentLevel) {
        level2 = currentLevel;
    }
    // returns level of recursion 

    public int getLevel2() {
        return level2;
    }

    public void setLevel3(int currentLevel) {
        level3 = currentLevel;
    }
    // returns level of recursion 

    public int getLevel3() {
        return level3;
    }

    public void setLevel4(int currentLevel) {
        level4 = currentLevel;
    }
    // returns level of recursion 

    public int getLevel4() {
        return level4;
    }

    public void setLevel5(int currentLevel) {
        level5 = currentLevel;
    }
    // returns level of recursion 

    public int getLevel5() {
        return level5;
    }

    public int getCPoint() {
        return CPoint;
    }

    public void setCPoint(int cPoint) {
        this.CPoint = cPoint;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public Point getPoint5() {
        return point5;
    }

    public void setPoint5(Point point5) {
        this.point5 = point5;
    }

    public Point getPoint6() {
        return point6;
    }

    public void setPoint6(Point point6) {
        this.point6 = point6;
    }
}; // end class FractalJPanel
