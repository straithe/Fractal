/**
 * B. Postnikoff
 * Pixel 
 * 2016-03-28
 */

import java.awt.Color;

public class Pixel 
{
    private Color color;
    private Complex coordinate;  

    // Pixel constructor.
    public Pixel(Complex coordinate)
    {
        this.coordinate = coordinate;
    }

    // Sets the color of the pixel.
    public void setPixelColor(int iterations, int maxIterations)
    {
        double percentageIterations = 0;        
        
        if (iterations < maxIterations)
        {
            percentageIterations = (maxIterations - iterations);
        }

        percentageIterations *= 1.0 / maxIterations;

        if (iterations >= maxIterations)
        {
            color = Color.BLACK;
        }
        else if (iterations >= maxIterations * .9)
        {
            color = new Color(255, 204, 229);
        }
        else if (iterations >= maxIterations * .8)
        {
            color = new Color(255, 153, 204);
        }
        else if (iterations >= maxIterations * .7)
        {
            color = new Color(255, 102, 178);            
        }
        else if (iterations >= maxIterations * .6)
        {
            color = new Color(255, 51, 153);
        }
        else if (iterations >= maxIterations * .5)
        {
            color = new Color(255, 0, 127);
        }
        else if (iterations >= maxIterations * .4)
        {
            color = new Color(204, 0, 102);
        }
        else if (iterations >= maxIterations * .2)
        {
            color = new Color(153, 0, 76);
        }
        else if (iterations >= maxIterations * .1)
        {
            color = new Color(102, 0 ,51);
        }
        else if (iterations >= maxIterations * .09)
        {
            color = new Color(51, 0, 25);
        }
        else if (iterations >= maxIterations * .08)
        {
            color = new Color(25, 0, 51);
        }
        else if (iterations >= maxIterations * .07)
        {
            color = new Color(51, 0, 102);
        }
        else if (iterations >= maxIterations * .06)
        {
            color = new Color(76, 0, 153);
        }
        else if (iterations >= maxIterations * .05)
        {
            color = new Color(102, 0 , 204);
        }
        else if (iterations >= maxIterations * .04)
        {
            color = new Color(127, 0 , 255);
        }
        else if (iterations >= maxIterations * .03)
        {
            color = new Color(153, 51, 255);
        }
        else if (iterations >= maxIterations * .02)
        {
            color = new Color(178, 102, 255);
        }
        else if (iterations >= maxIterations * .01)
        {
            color = new Color(204, 153, 255);
        }
        else
        {
            color = Color.BLACK;
        }
    }

    // Gets the pixel coordinate
    public Complex getCoordinate()
    {
        return coordinate;
    }

    // Gets the pixel color.
    public Color getColor()
    {
        return color;
    }
}
