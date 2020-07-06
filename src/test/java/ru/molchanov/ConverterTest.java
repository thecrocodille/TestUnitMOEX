package ru.molchanov;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class ConverterTest {

    Converter converter = new Converter();

    @Test
    public void testConverter(){
        converter.setFirstSystem(2);
        converter.setSecondSystem(10);
        converter.setNumToConvert("1100011101010010010");
        converter.convert();
        Assert.assertEquals(converter.getResult(), "408210");
        converter.setSecondSystem(36);
        converter.convert();
        Assert.assertEquals(converter.getResult(), "8qz6");
        converter.setFirstSystem(8);
        converter.convert();
        Assert.assertEquals(converter.getResult(), "5jjzn43hgco");
        converter.setNumToConvert("1234567");
        assertNotEquals("7c6v", converter.getResult());
        converter.convert();
        Assert.assertEquals("7c6v", converter.getResult());

    }
}
