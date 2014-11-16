package my.beans.impl;

import com.esotericsoftware.kryo.Kryo;
import my.beans.ISimpleBean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

/**
 * @author kkulagin
 * @since 09.11.2014
 */
public class SimpleBean implements ISimpleBean, Externalizable {

    private final ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            return new Kryo();
        }
    };

    private long id = 1;
    private long id2 = 1;
    private long id3 = 1;
    private long id4 = 1;
    private long id5 = 1;
    private long id6 = 1;
    private long id7 = 1;
    private int fieldOne = 1;
    private byte[] bytes = new byte[1000];
    private StringBuilder sb = new StringBuilder();

    public SimpleBean() {
    }

    public SimpleBean(long id) {
        this.id = id;
        for (int i = 0; i < 100; i++) {
            bytes[i] = (byte) i;
        }
        sb.append("asdfsdafsda asfsdafdsa fadsfas dsfa sdaf asdf asdf asdf as");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        kryos.get().writeObject(new Output(out.), iSimpleBean);

        out.writeLong(id);
        out.writeLong(id2);
        out.writeLong(id3);
        out.writeLong(id4);
        out.writeLong(id5);
        out.writeLong(id6);
        out.writeLong(id7);
        out.writeInt(fieldOne);
//        out.write(bytes);
//        out.writeUTF(stringField);
//        out.writeUTF(stringField2);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        id2 = in.readLong();
        id3 = in.readLong();
        id4 = in.readLong();
        id5 = in.readLong();
        id6 = in.readLong();
        id7 = in.readLong();
        fieldOne = in.readInt();
//        in.read(bytes = new byte[1000]);
//        stringField = in.readUTF();
//        stringField2 = in.readUTF();
    }


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId2() {
        return id2;
    }

    @Override
    public void setId2(long id2) {
        this.id2 = id2;
    }

    @Override
    public long getId3() {
        return id3;
    }

    @Override
    public void setId3(long id3) {
        this.id3 = id3;
    }

    @Override
    public int getFieldOne() {
        return fieldOne;
    }

    @Override
    public void setFieldOne(int fieldOne) {
        this.fieldOne = fieldOne;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public StringBuilder getSb() {
        return sb;
    }

    @Override
    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public long getId4() {
        return id4;
    }

    public void setId4(long id4) {
        this.id4 = id4;
    }

    public long getId6() {
        return id6;
    }

    public void setId6(long id6) {
        this.id6 = id6;
    }

    public long getId7() {
        return id7;
    }

    public void setId7(long id7) {
        this.id7 = id7;
    }


    public long getId5() {
        return id5;
    }

    public void setId5(long id5) {
        this.id5 = id5;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", id2=" + id2 +
                ", id3=" + id3 +
                ", id4=" + id4 +
                ", id5=" + id5 +
                ", id6=" + id6 +
                ", id7=" + id7 +
                ", fieldOne=" + fieldOne +
                ", bytes=" + Arrays.toString(bytes) +
                ", sb=" + sb +
                '}';
    }
}
