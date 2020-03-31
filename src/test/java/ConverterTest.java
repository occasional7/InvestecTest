import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
    @Test
    public void test1() {
        String text = Converter.convert(536);
        System.out.println(text);
        assertEquals("five hundred and thirty-six", text);
    }

    @Test
    public void test2() {
        String text = Converter.convert(9121);
        System.out.println(text);
        assertEquals("nine thousand, one hundred and twenty-one", text);
    }

    @Test
    public void test3() {
        String text = Converter.convert(10022);
        System.out.println(text);
        assertEquals("ten thousand and twenty-two", text);
    }

    @Test
    public void test4() {
        String text = Converter.convert(66723107008L);
        System.out.println(text);
        assertEquals("sixty-six billion, seven hundred and twenty-three million, one hundred and seven thousand and eight", text);
    }

    @Test
    public void test5() {
        String text = Converter.convert(0);
        System.out.println(text);
        assertEquals("zero", text);
    }

    @Test
    public void test7() {
        String text = Converter.convert(1000);
        System.out.println(text);
        assertEquals("one thousand", text);
    }

    @Test
    public void test8() {
        String text = Converter.convert(100);
        System.out.println(text);
        assertEquals("one hundred", text);
    }

    @Test
    public void test9() {
        String text = Converter.convert(10);
        System.out.println(text);
        assertEquals("ten", text);
    }

    @Test
    public void test10() {
        String text = Converter.convert(1000000);
        System.out.println(text);
        assertEquals("one million", text);
    }

    @Test
    public void test11() {
        String text = Converter.convert(1000000000);
        System.out.println(text);
        assertEquals("one billion", text);
    }
}