import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExtractorTest {
    @Test
    public void test1() {
        assertTrue(536 == NumberExtractor.extract("The pump is 536 deep underground.").get());
    }

    @Test
    public void test2() {
        assertTrue(9121 == NumberExtractor.extract("We processed 9121 records.").get());
    }

    @Test
    public void test3() {
        assertTrue(NumberExtractor.extract("Variables reported as having a missing type #65678.").isEmpty());
    }

    @Test
    public void test4() {
        assertTrue(10022 == NumberExtractor.extract("Interactive and printable 10022 ZIP code.").get());
    }

    @Test
    public void test5() {
        assertTrue(66723107008L == NumberExtractor.extract("The database has 66723107008 records.").get());
    }

    @Test
    public void test6() {
        assertTrue(NumberExtractor.extract("I received 23 456,9 KGs.").isEmpty());
    }
}