/**
 * B. Postnikoff
 * Fractal Window
 * 2016-03-28
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;


public class FractalWindow extends JPanel implements KeyListener, MouseListener
{     
    // Given variables and a delta
    static int maxIterations = 50;
    static float maxModulus = (float)2.0;
    static double delta = 0.005;

    // Fractal starting variables
    static Complex startingZ = null;
    static boolean mandelbrotBoolean = false;
    static int fractalChoice;

    // Window variables
    static JFrame frame = null;
    static Complex topLeft = new Complex(-2, 2);
    static boolean shift = false;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        //Added another fractal to try things out! 
        //Add more fractals later
        System.out.println("Available fractals: "
        + "\t\n1: g(z) = z^2 + c"
        + "\t\n2: g(z) = z^3 + c"
        + "\t\n3: g(z) = cz + (1-c)/z"
        + "\t\n4: g(z) = z^2 + c/z"
        + "\t\n5: g(z) = cz + (1-c)/z^2"
        + "\t\n6: g(z) = z^2 + c^3"
        + "\t\n7: Mandelbrot");

        System.out.print("\nEnter your selection: ");
        fractalChoice = scanner.nextInt();

        if (fractalChoice == 7)
        {
            startingZ = new Complex();
            mandelbrotBoolean = true;
        } else {
            double cReal;
            double cImaginary;
            
            System.out.print("Please enter the real portion of a complex variable c (< 1): ");
            cReal = scanner.nextDouble();

            System.out.print("Please enter the imaginary portion of a complex variable c (< 1 ): ");
            cImaginary = scanner.nextDouble();

            startingZ =  new Complex(cReal, cImaginary); 
        }

        setUpFrame();
    }

    // Computes the next value for a complex number z. 
    public Complex compute(Complex z, Complex c)
    {
        switch (fractalChoice)
        {
            case 1:
                return z.multiply(z).add(c);
            case 2:
                return z.multiply(z).multiply(z).add(c);
            case 3:
                return c.multiply(z).add(((new Complex(1,0)).subtract(c)).divide(z));
            case 4:
                return z.multiply(z).add(c.divide(z));
            case 5:
                return c.multiply(z).add(((new Complex(1,0)).subtract(c)).divide(z.multiply(z)));
            case 6:
                return z.multiply(z).add(c.multiply(c).multiply(c));
            case 7:
                return z.multiply(z).add(c); 
            default:
                return null;
        }
    }

    // Calculates the complex number for a pixel.
    public void nextZ(Complex z, Complex c, Pixel pixel)
    {
        int index = 0;

        while (z.absolute() < maxModulus && index <= maxIterations)
        {
            z = compute(z, c);
            index++;
        }

        pixel.setPixelColor(index, maxIterations);
    }
    
    // Sets up the fractal frame.
    public static void setUpFrame()
    {
        Container container;
        FractalWindow window;

        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        window = new FractalWindow();
        window.addKeyListener(window);
  
        frame.addKeyListener(window);
        frame.addMouseListener(window);
        frame.requestFocusInWindow();
        frame.setVisible(true);  

        container = frame.getContentPane();
        container.add(window);
    }    
    
    // Paint the fractal.
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Pixel pixel = new Pixel(new Complex(topLeft.getReal(),
            topLeft.getImaginary()));

        for (int i = 0; i < frame.getHeight(); i++)
        {
            for (int j = 0; j < frame.getWidth(); j++)
            {
                if (mandelbrotBoolean)
                {
                    nextZ(startingZ, pixel.getCoordinate(), pixel);
                }
                else
                {
                    nextZ(pixel.getCoordinate(), startingZ, pixel);
                }
                
                g.setColor(pixel.getColor());
                g.fillRect(j, i, 1, 1);
                pixel.getCoordinate().increaseReal(delta);
            }

            pixel.getCoordinate().decreaseImaginary(delta);
            pixel.getCoordinate().setReal(topLeft.getReal());
        }
    }

    // Mouse Clicked event handler.
    public void mouseClicked(MouseEvent e)
    {
        double newX, newY; 

        // Gets the current coordinates.
        newX = topLeft.getReal() + e.getX() * delta;
        newY = topLeft.getImaginary() - e.getY() * delta;

        // Changes the delta if shift has been pressed or released
        if (shift)
        {
            delta *= 1.5;
        }
        else
        {
            delta /= 1.5;
        }

        topLeft = new Complex(newX - (frame.getWidth() / 2) * delta, 
            newY + (frame.getHeight() / 2) * delta );

        // Opens up a new window with the new fractal.
        setUpFrame();
    }

    // Key pressed event handler.
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shift = true;
        }
    }

    // Key Released event handler.
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            shift = false;
        }
    }

    // Key typed stub.
    public void keyTyped(KeyEvent e)
    {
        // Nothing needs doing.
    }

    // Mouse entered stub.
    public void mouseEntered(MouseEvent e)
    {
        // Werk, werk.
    }

    // Mouse exited stub.
    public void mouseExited(MouseEvent e)
    {
        // Ready to work.
    }

    // Mouse pressed stub.
    public void mousePressed(MouseEvent e)
    {
        // Zug zug.
    }

    // Mouse released stub.
    public void mouseReleased(MouseEvent e)
    {
        // Be happy to. 
    }
}
