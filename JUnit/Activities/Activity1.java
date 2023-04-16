package activities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Activity1 {

    static ArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    public void insertTest() {
        Assertions.assertEquals(2, list.size());
        list.add("gama");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("alpha", list.get(0));
        Assertions.assertEquals("beta", list.get(1));
        Assertions.assertEquals("gama", list.get(2));
    }

    @Test
    public void replaceTest() {
        Assertions.assertEquals(2, list.size());
        list.add("delta");
        Assertions.assertEquals(3, list.size());
        list.set(1, "test");
        Assertions.assertEquals("alpha", list.get(0));
        Assertions.assertEquals("test", list.get(1));
        Assertions.assertEquals("delta", list.get(2));


    }
}
