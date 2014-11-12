package my.beans;

/**
 * @author kkulagin
 * @since 12.11.2014
 */
public interface ISimpleBean {
    default byte[] getBytes() {
        return bytes;
    }

    default void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    default StringBuilder getSb() {
        return sb;
    }

    default void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    long getId();

    void setId(long id);

    long getId2();

    void setId2(long id2);

    long getId3();

    void setId3(long id3);

    int getFieldOne();

    void setFieldOne(int fieldOne);
}
