package edu.ucsd.cs110.tests;
import edu.ucsd.cs110.temperature.Fahrenheit;
import edu.ucsd.cs110.temperature.Temperature;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FahrenheitTest {
    private float delta = 0.001f;

    @Test
    public void testFahrenheit(){
        float value = 12.34f;
        Fahrenheit temp = new Fahrenheit(value);

        Assert.assertEquals(value, temp.getValue(), delta);
    }

    @Test
    public void testFahrenheitToString(){
        float value = 12.34f;

        Fahrenheit temp = new Fahrenheit(value);
        String string = temp.toString();

        String beginning = "" + value;
        String ending = " F";

        // Verify the suffix of the formatted string
        Assert.assertTrue(string.startsWith(beginning));

        // Verify the prefix of the formatted string
        Assert.assertTrue(string.endsWith(ending));

        // Verify the middle of the formatted string
        int endIndex = string.indexOf(ending);

        // (Hint: what is the length of the middle of the string?)
        Assert.assertTrue(string.substring(0, endIndex).equals(beginning));
    }

    @Test
    public void testFahrenheitToFahrenheit()
    {
        Fahrenheit temp = new Fahrenheit(32);

        Temperature convert = temp.toFahrenheit();
        Assert.assertEquals(32, convert.getValue(), delta);
    }

    @Test
    public void testFahrenheitToCelsius(){
        Fahrenheit temp = new Fahrenheit(32);

        Temperature convert = temp.toCelsius();
        Assert.assertEquals(0, convert.getValue(), delta);

        temp = new Fahrenheit(212);
        convert = temp.toCelsius();

        Assert.assertEquals(100, convert.getValue(), delta);
    }
}