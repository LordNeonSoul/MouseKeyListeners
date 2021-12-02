package myProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is used for ...
 * @autor Juan Pablo Pantoja Gutierrez juan.pablo.pantoja@correounivalle.edu.co
 * @version v.1.2.0 date:21/11/2021
 */
public class GUI extends JFrame {
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JLabel labelImage;
    private JTextArea textoExpectativas;
    private Header headerProject;
    private Escucha escucha;
    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();
        //Default JFrame configuration
        this.setTitle("Mi Presentación");
        this.setSize(600,540);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("Hola, soy Juan Pablo, oprime los botones...", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        panelDatos = new JPanel();
        panelDatos.setBorder((BorderFactory.createTitledBorder(null,"Un poco más de mí...", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",Font.PLAIN,20), Color.white)));
        panelDatos.setBackground(Color.darkGray);
        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo...");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi Hobby...");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.setBackground(Color.darkGray);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textoExpectativas = new JTextArea(10,12);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar()== 'm'){
                panelDatos.removeAll();
                textoExpectativas.setFont(new Font("Times New Roman",Font.BOLD,22));
                textoExpectativas.setForeground(Color.white);
                textoExpectativas.setText("Siempre me ha gustado bastante este tipo\n"+
                        "de programación ya que lo veía en los ultimos años\n"+
                        "del colegio entonces me encuentro bastante emocionado\n"+
                        "y contento de estar viendo estas temáticasespero aprender\n"+
                        "bastante y poder familiarizar y afianzar conocimientos\n"+
                        "para desarrollar habilidades que me permitan finalizar\n"+
                        "el curso de manera satisfactoria.");
                textoExpectativas.setBackground(null);
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getComponent()==miFoto && e.getClickCount()==1){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/FotoMia.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            if(e.getComponent()==miHobby && e.getClickCount()==2){
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/Hobbys.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            revalidate();
            repaint();
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
    }
}
