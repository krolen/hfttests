package my;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author kkulagin
 * @since 09.11.2014
 */

public class SimpleTest {

    public static void main(String[] args) throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");

        File file = Paths.get(tempDir, "SimpleTest").toFile();
        ChronicleMap<Integer, CharSequence> map = ChronicleMapBuilder.of(Integer.class, CharSequence.class).
            file(file).entries(2).create();

        long count = 1000;
        for (int i = 0; i < count; i++) {
            map.put(i, String.valueOf(i));
        }
        System.out.println(map.get(1000));
        System.out.println(map.longSize());
    }



}
