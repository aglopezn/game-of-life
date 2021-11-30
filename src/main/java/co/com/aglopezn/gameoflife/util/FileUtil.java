package co.com.aglopezn.gameoflife.util;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtil {

    public static List<String> read(String filename) {
        try {
            Path filepath = ResourceUtils.getFile("classpath:" + filename).toPath();
            List<String> data = Files.readAllLines(filepath);
            return data;
        } catch (IOException e){
            throw new IllegalArgumentException("Couldn't read file: " + filename);
        }
    }
}
