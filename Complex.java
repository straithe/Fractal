/**
 * B. Postnikoff
 * Complex
 * 2016-03-28
 */

public class Complex 
{
    private double real;
    private double imaginary;
    
    // Default complex number object constructor.
    public Complex()
    {
        this.real = 0;
        this.imaginary = imaginary;
    }
    
    // Complex number object constructor.
    public Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    // Multiplies this complex number by another complex number.
    public Complex multiply(Complex complexNumber)
    {
        double realValue = (this.real * complexNumber.real) 
            - (this.imaginary * complexNumber.imaginary);
        double imaginaryValue = (this.real * complexNumber.imaginary) 
            + (complexNumber.real * this.imaginary);
        
        return new Complex(realValue, imaginaryValue);
    }
    
    // Adds another complex number to this complex number.
    public Complex add(Complex complexNumber)
    {        
        double realValue = this.real + complexNumber.real;
        double imaginaryValue = this.imaginary + complexNumber.imaginary;
        Complex add = new Complex(realValue, imaginaryValue);        
        
        return add;
    }
    
    // Subtracts another complex number from this complex number. 
    public Complex subtract(Complex complexNumber)
    {
        double realValue = this.real - complexNumber.real;
        double imaginaryValue = this.imaginary - complexNumber.imaginary;
        Complex subtract = new Complex(realValue, imaginaryValue);
        
        return subtract;
    }

    // Divides this complex number by another complex number.
    public Complex divide(Complex complexNumber)
    {
        Complex conjugate = complexNumber.conjugate();
        Complex temporary  = new Complex(this.real, this.imaginary);
        Complex divide = temporary.multiply(conjugate).realDivide((conjugate.real * conjugate.real)
        	+ (conjugate.imaginary * conjugate.imaginary));
        
        return divide;
    }

    // Retrieves the conjugate of this number.
    public Complex conjugate()
    {
        Complex conjugate = new Complex(this.real, ((-1) * this.imaginary));
        
        return conjugate;
    }
    
    // Divides this complex number by a real number.
    public Complex realDivide(double real)
    {
        double realValue = this.real / real;
        double imaginaryValue = this.imaginary / real;
        Complex divide = new Complex(realValue, imaginaryValue);
        
        return divide;
    }

    // Retrieves the absolute value of this complex number.
    public double absolute()
    {
        double absoluteValue = Math.sqrt((imaginary * imaginary) 
        	+ (real * real));
        
        return absoluteValue;
    }

    // Returns the real value of the complex number.
    public double getReal()
    {
        return real;
    }

    // Sets the real value of the complex number.
    public void setReal(double newReal)
    {
        real = newReal;
    }

    // Decreases the real portion of the complex number by an amount.
    public void decreaseReal(double delta)
    {
        real -= delta;
    }

    // Increases the real portion of the complex number by an amount;
    public void increaseReal(double delta)
    {
        real += delta;
    }

    // Returns the imaginary portion of the complex number.
    public double getImaginary()
    {
        return imaginary;
    }

    // Decreases the imaginary portion of the complex number.
    public void decreaseImaginary(double delta)
    {
        imaginary -= delta;
    }

    // Increases the imaginary portion of the complex number.
    public void increaseImaginary(double delta)
    {
        imaginary += delta;
    }

    // String representation of this complex number.
    public String toString()
    {
        return real + " + " + imaginary + " i";
    }
}
