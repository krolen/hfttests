package my;

import my.beans.impl.SimpleBean;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author kkulagin
 * @since 09.11.2014
 */

public class SimpleTest {

    public static void main(String[] args) throws IOException {
        option2();
    }

    private static void option2() throws IOException {
      Path file = getFile();
      Files.deleteIfExists(file);
//      int entries = 10_000_000;  // works
      int entries = 30_000_000;
      ChronicleMapBuilder<Long, SimpleBean> builder = ChronicleMapBuilder.of(Long.class, SimpleBean.class).
          valueSize(56).entries(entries);
      ChronicleMap<Long, SimpleBean> map = null;
      try {
        map = builder.createPersistedTo(file.toFile());
        long count = entries - 5;
//        for (long i = 0; i < count; i++) {
//          map.put(i, new SimpleBean(i));
//        }
//        System.gc();
//        for (long i = count; i < 2* count; i++) {
//          map.put(i, new SimpleBean(i));
//        }
//        System.gc();
//        for (long i = 2*count; i < 3*count; i++) {
//          map.put(i, new SimpleBean(i));
//        }
//        System.gc();
//        for (long i = 0; i < count; i = i + 50000) {
//          System.out.println(map.get(i));
//        }
        System.out.println(map.get(count - 1));
        System.out.println(map.longSize());
      } finally {
        assert map != null;
        map.close();
      }
    }

    private static Path getFile() {
        String tempDir = System.getProperty("java.io.tmpdir");

        return Paths.get(tempDir, "SimpleTest");
    }

    private static void option1() throws IOException {
//        ChronicleMap<String, ISimpleBean> chm = OffHeapUpdatableChronicleMapBuilder
//                        .of(String.class, ISimpleBean.class)
//                        .keySize(10)
//                        .create();

      Path file = getFile();
        ChronicleMapBuilder builder = ChronicleMapBuilder.of(Long.class, SimpleBean.class).
            entries(1_000_000_000).entrySize(50);

        ChronicleMap<Long, SimpleBean> map = builder.createPersistedTo(file.toFile());

        long count = 2;
        for (long i = 0; i < count; i++) {
            map.put(i, new SimpleBean(i));
        }
        System.out.println(map.get(count - 1));
        System.out.println(map.longSize());
    }


}
