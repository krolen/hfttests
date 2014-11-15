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
        option3();
    }



  private static void option3() throws IOException {
    Path file = getFile();
    Files.deleteIfExists(file);
    int entries = 60_000_000;
    int valueSize = 8 + 8 + 8 + 4;
    try (ChronicleMap<Long, SimpleBean> map = ChronicleMapBuilder
        .of(Long.class, SimpleBean.class)
        .valueSize(valueSize)
        .entries(entries)
        .createPersistedTo(file.toFile())) {
      long start = System.currentTimeMillis();
      SimpleBean value = new SimpleBean();
      for (long i = 0; i < entries; i += 2000000) {
        System.out.printf("put %d keys%n", i);
        for (long j = i; j < i + 2000000; j++) {
          value.setId(j);
          map.put(j, value);
        }
      }
      long time = System.currentTimeMillis() - start;

      for (long i = 0; i < entries; i = i + 1000000) {
        System.out.println(map.get(i));
      }
      System.out.println(map.get(entries - 1L));
      System.out.printf("Took %.1f second to write %,d entries%n", time / 1e3, map.longSize());
    }
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
