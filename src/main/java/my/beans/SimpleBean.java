package my.beans;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author kkulagin
 * @since 09.11.2014
 */
public class SimpleBean implements Externalizable {
    private long id = 1;
    private long id2 = 1;
    private long id3 = 1;
    private int fieldOne = 1;
//    private String stringField = "I am a string field";
//    private String stringField2 = "I am a string field 2222 2222222 22222222222";

    public SimpleBean(long id) {
        this.id = id;
    }

//    public SimpleBean(String stringField) {
//        this.stringField = stringField;
//    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(id);
        out.writeLong(id2);
        out.writeLong(id3);
        out.writeInt(fieldOne);
//        out.writeUTF(stringField);
//        out.writeUTF(stringField2);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        id2 = in.readLong();
        id3 = in.readLong();
        fieldOne = in.readInt();
//        stringField = in.readUTF();
//        stringField2 = in.readUTF();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    public long getId3() {
        return id3;
    }

    public void setId3(long id3) {
        this.id3 = id3;
    }

    public int getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(int fieldOne) {
        this.fieldOne = fieldOne;
    }

//    public String getStringField() {
//        return stringField;
//    }
//
//    public void setStringField(String stringField) {
//        this.stringField = stringField;
//    }
//
//    public String getStringField2() {
//        return stringField2;
//    }
//
//    public void setStringField2(String stringField2) {
//        this.stringField2 = stringField2;
//    }

    @Override
    public String toString() {
        return "SimpleBean{" +
            "id=" + id +
            ", id2=" + id2 +
            ", id3=" + id3 +
            ", fieldOne=" + fieldOne +
//            ", stringField='" + stringField + '\'' +
//            ", stringField2='" + stringField2 + '\'' +
            '}';
    }
}
