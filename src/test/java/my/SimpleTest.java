package my;

import my.beans.SimpleBean;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.map.ChronicleMapBuilder;
import net.openhft.lang.io.Bytes;
import net.openhft.lang.io.serialization.BytesMarshaller;
import net.openhft.lang.io.serialization.BytesMarshallerFactory;
import net.openhft.lang.io.serialization.impl.VanillaBytesMarshallerFactory;

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
        ChronicleMapBuilder builder = ChronicleMapBuilder.of(Long.class, SimpleBean.class).
            file(file).entries(1_000_000_000).entrySize(50);

//        BytesMarshallerFactory factory = createBytesMarshallerFactory();
//        builder.bytesMarshallerFactory(factory);
        ChronicleMap<Long, SimpleBean> map = builder.create();

        long count = 2;
        for (long i = 0; i < count; i++) {
            map.put(i, new SimpleBean(i));
        }
        System.out.println(map.get(count - 1));
        System.out.println(map.longSize());
    }

    private static BytesMarshallerFactory createBytesMarshallerFactory() {
        VanillaBytesMarshallerFactory factory = new VanillaBytesMarshallerFactory();
        factory.addMarshaller(SimpleBean.class, new BytesMarshaller<SimpleBean>() {

            @Override
            public void write(Bytes bytes, SimpleBean simpleBean) {
                bytes.writeObject(simpleBean);
            }

            @Override
            public SimpleBean read(Bytes bytes) {
                return (SimpleBean) bytes.readObject();
            }
        });
        return factory;
    }


}
