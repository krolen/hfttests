package my;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author kkulagin
 * @since 10.11.2014
 */
public class KryoSerializer {
    private ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            // configure kryo instance, customize settings
            return kryo;
        };
    };


}
