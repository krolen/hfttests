package my;

import com.google.common.base.Stopwatch;
import my.beans.impl.SimpleBean;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.concurrent.ThreadLocalRandom.*;

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
//    Files.deleteIfExists(file);
        int entries = 500_000_000;
        int valueSize = 8 + 8 + 8 + 8 + 8 + 8 + 8 + 4;
        try (ChronicleMap<Long, SimpleBean> map = ChronicleMapBuilder
                .of(Long.class, SimpleBean.class)
                .valueSize(valueSize)
                .entries(entries)
                .createPersistedTo(file.toFile())) {
            long start = System.currentTimeMillis();
//      SimpleBean value = new SimpleBean();
//
//      for (long i = 0; i < entries; i += 2000000) {
//        System.out.printf("put %d keys%n", i);
//        for (long j = i; j < i + 2000000; j++) {
//          value.setId(j);
//          map.put(j, value);
//        }
//      }

            long time = System.currentTimeMillis() - start;
            System.out.printf("Took %.1f second to write %,d entries%n", time / 1e3, map.longSize());

            long count = 0;
            int attempts = 500_000;

//            LongStream longStream = LongStream.generate(() -> current().nextLong(1, entries)).limit(attempts);
            LongStream longStream = LongStream.range(1, attempts);
            long[] longs = longStream.toArray();
            System.out.println(longs.length);
            Stopwatch timer = Stopwatch.createStarted();
            Arrays.stream(longs).
                    parallel().
                    forEach((i) -> {
    if (i % 10_000 == 0) {
        System.out.println(map.get(i));
    } else {
        map.get(i);
    }
});
            System.out.println("Reading time " + timer.stop().elapsed(TimeUnit.MILLISECONDS));

            for (long i = attempts * 1; i < attempts * 2; i++) {
//                count += ThreadLocalRandom.current().nextLong(1, entries);
//                map.containsKey(ThreadLocalRandom.current().nextLong(1, entries));
//                map.get(ThreadLocalRandom.current().nextLong(1, entries));
//                System.out.println(map.get(ThreadLocalRandom.current().nextLong(1, entries)));
//                map.get(i);
            }
            System.out.println("count = " + count);
        }

        System.out.println("Process finished");
    }

    private static void option2() throws IOException {
        Path file = getFile();
//      Files.deleteIfExists(file);
//      int entries = 10_000_000;  // works
        int entries = 100_000_000;
        ChronicleMapBuilder<Long, SimpleBean> builder = ChronicleMapBuilder.of(Long.class, SimpleBean.class).
                valueSize(56).entries(entries);
        ChronicleMap<Long, SimpleBean> map = null;
        map = builder.createPersistedTo(file.toFile());


        long count = entries / 3;
        try {
            for (long i = 0; i < count - 5; i++) {
                map.put(i, new SimpleBean(i));
                if (i % 50000 == 0) {
                    System.out.println("i = " + i);
                }
            }
            map.close();
            map = builder.createPersistedTo(file.toFile());
            for (long i = count; i < count * 2 - 5; i++) {
                map.put(i, new SimpleBean(i));
                if (i % 50000 == 0) {
                    System.out.println("i = " + i);
                }
            }
            map.close();
            map = builder.createPersistedTo(file.toFile());
            for (long i = count * 2; i < count * 3 - 5; i++) {
                map.put(i, new SimpleBean(i));
                if (i % 50000 == 0) {
                    System.out.println("i = " + i);
                }
            }
//        System.gc();
//        for (long i = count; i < 2* count; i++) {
//          map.put(i, new SimpleBean(i));
//        }
//        System.gc();
//        for (long i = 2*count; i < 3*count; i++) {
//          map.put(i, new SimpleBean(i));
//        }
//        System.gc();
            for (long i = 0; i < count; i = i + 50000) {
                System.out.println(map.get(i));
            }
            System.out.println(map.get(count - 1));
            System.out.println(map.longSize());
        } finally {
            assert map != null;
            map.close();
        }
    }

    private static Path getFile() {
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
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
