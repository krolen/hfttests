package my.beans.impl;

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
public class SimpleBean implements Externalizable, ISimpleBean {
    private long id = 1;
    private long id2 = 1;
    private long id3 = 1;
    private int fieldOne = 1;
    private byte[] bytes = new byte[1000];
    private StringBuilder sb = new StringBuilder();

    public SimpleBean(long id) {
        this.id = id;
        for (int i = 0; i < 100; i++) {
            bytes[i] = (byte) i;
        }
        sb.append("asdfsdafsda asfsdafdsa fadsfas dsfa sdaf asdf asdf asdf as");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(id);
        out.writeLong(id2);
        out.writeLong(id3);
        out.writeInt(fieldOne);
        out.write(bytes);
//        out.writeUTF(stringField);
//        out.writeUTF(stringField2);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        id2 = in.readLong();
        id3 = in.readLong();
        fieldOne = in.readInt();
        in.read(bytes);
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
    public String toString() {
        return "SimpleBean{" +
            "id=" + id +
            ", id2=" + id2 +
            ", id3=" + id3 +
            ", fieldOne=" + fieldOne +
            ", bytes=" + Arrays.toString(bytes) +
            ", sb=" + sb +
            '}';
    }
}
