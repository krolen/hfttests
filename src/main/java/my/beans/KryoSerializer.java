package my.beans;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import my.beans.impl.SimpleBean;
import net.openhft.lang.io.Bytes;
import net.openhft.lang.io.serialization.BytesMarshaller;

import java.io.Serializable;

/**
 * Created by kkulagin on 11/14/2014.
 */
public class KryoSerializer implements BytesMarshaller<SimpleBean>, Serializable {

  private final ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
    protected Kryo initialValue() {
      return new Kryo();
    }
  };

  @Override
  public void write(Bytes bytes, SimpleBean iSimpleBean) {
    kryos.get().writeObject(new Output(bytes.outputStream()), iSimpleBean);
  }

  @Override
  public SimpleBean read(Bytes bytes) {
    return kryos.get().readObject(new Input(bytes.inputStream()), SimpleBean.class);
  }

  @Override
  public SimpleBean read(Bytes bytes, SimpleBean iSimpleBean) {
    throw new UnsupportedOperationException("asdf");
//    return null;
  }

}
