package co.com.aglopezn.gameoflife.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FileUtilTest {

    @Test
    public void readFileAsAListOfStringLines(){
        List<String> expected =  new ArrayList<String>();
        expected.add("3 3 3");
        expected.add("...");
        expected.add("***");
        expected.add("...");
        List<String> content = FileUtil.read("static/initialStateTest.txt");
        Assertions.assertEquals(expected, content);
    }
}
