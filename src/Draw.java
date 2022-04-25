/*
Rashid Imtiaz
4/1/22
CMCS 405
Project 2
 */

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

public class Draw extends GLJPanel implements GLEventListener, KeyListener, ActionListener {

    int redValue = 50;
    int greenValue = 50;

    public static void main(String[] args) {



        JFrame window = new JFrame("3D Model");
        Draw panel = new Draw();
        window.setContentPane(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        panel.requestFocusInWindow();

        JFrame info = new JFrame("Info");
        info.setSize(300, 150);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        info.setLocationRelativeTo(window);
        JTextPane information = new JTextPane();
        information.setText("Use the arrow keys to rotate the objects\n Use |WASD| to translate the objects\n  Use the backspace to reset view");
        info.add(information);
        info.setVisible(true);

        JFrame control = new JFrame("Control");
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        //control.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        control.setSize(400,400);
        info.setLocationRelativeTo(info);

        JRadioButton redLight = new JRadioButton();
        redLight.setVisible(true);
        JLabel redLightText = new JLabel("Red Light");
        redLightText.setVisible(true);
        JSlider redSlider = new JSlider(0,0,100,50);
        redSlider.addChangeListener(redValue);
        redSlider.setVisible(true);



        JRadioButton greenLight = new JRadioButton();
        greenLight.setVisible(true);
        JLabel greenLightText = new JLabel("green Light");
        greenLightText.setVisible(true);
        JSlider greenSlider = new JSlider(0,0,100,50);
        greenSlider.setVisible(true);

        redLight.setBounds(0,5,20,20);
        redLightText.setBounds(30,5,100,20);
        redSlider.setBounds(100,5,250,25);

        greenLight.setBounds(0,50,20,20);
        greenLightText.setBounds(30,50,100,20);
        greenSlider.setBounds(100,50,250,25);

        controlPanel.add(redLight);
        controlPanel.add(redLightText);
        controlPanel.add(redSlider);
        controlPanel.add(greenLight);
        controlPanel.add(greenLightText);
        controlPanel.add(greenSlider);

        control.add(controlPanel);
        control.setVisible(true);


    }

    // Default Transform
    private double rotateX = 0;
    private double rotateY = 0;
    private double translateX = 0;
    private double translateY = 0;

    private Draw() {
        super(new GLCapabilities(null));
        setPreferredSize(new Dimension(1000, 1000));
        addGLEventListener(this);
        addKeyListener(this);
    }

    //The logic used to parse through the array to help build the object
    private void drawObj(GL2 gl2, Shapes obj, double x, double y) {
        gl2.glPushMatrix();
        gl2.glScaled(0.1, 0.1, 0.1);
        gl2.glTranslated(x, y, 0);

        for (int i = 0; i < obj.faces.length; i++) {
            gl2.glPushMatrix();

            gl2.glColor3f(1, 1, 1);

            gl2.glBegin(GL2.GL_LINE_LOOP);
            for (int j = 0; j < obj.faces[i].length; j++) {
                int v = obj.faces[i][j];
                gl2.glVertex3dv(obj.vertices[v], 0);
            }
            gl2.glEnd();

            gl2.glPopMatrix();
        }
        gl2.glPopMatrix();
    }

    public void display(GLAutoDrawable drawable) {

        GL2 gl2 = drawable.getGL().getGL2();
        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);


        gl2.glLoadIdentity();
        double rotateZ = 0;
        gl2.glRotated(rotateZ, 0, 0, 1);
        gl2.glRotated(rotateY, 0, 1, 0);
        gl2.glRotated(rotateX, 1, 0, 0);
        double translateZ = 0;
        gl2.glTranslated(translateX, translateY, translateZ);

        //Draws the objects
        drawObj(gl2, Shapes.shape1, 0, 0);
        drawObj(gl2, Shapes.shape2, 3, 0);
        drawObj(gl2, Shapes.shape3, -3, 0);
        drawObj(gl2, Shapes.shape4, 3, -3);
        drawObj(gl2, Shapes.shape5, 0, -3);
        drawObj(gl2, Shapes.shape6, -3, -3);
    }

    public void init(GLAutoDrawable drawable) {
        // called when the panel is created
        GL2 gl2 = drawable.getGL().getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glOrtho(-1, 1, -1, 1, -1, 1);
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glClearColor(0, 0, 0, 1);
        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glLineWidth(2);
    }

    //Used to control the movement
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_LEFT) rotateY -= 10;
        else if (key == KeyEvent.VK_RIGHT) rotateY += 10;
        else if (key == KeyEvent.VK_DOWN) rotateX -= 10;
        else if (key == KeyEvent.VK_UP) rotateX += 10;
        else if (key == KeyEvent.VK_W) translateY += .1;
        else if (key == KeyEvent.VK_A) translateX -= .1;
        else if (key == KeyEvent.VK_S) translateY -= .1;
        else if (key == KeyEvent.VK_D) translateX += .1;
        else if (key == KeyEvent.VK_BACK_SPACE){
            rotateX = 0;
            rotateY= 0;
            translateX = 0;
            translateY=0;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    }
}