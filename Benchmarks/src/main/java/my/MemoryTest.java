package my;

import my.beans.impl.SimpleBean;

/**
 * @author kkulagin
 * @since 10.11.2014
 */
public class MemoryTest {

    public static void main(String[] args) {

        int count = 1000;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < count; j++) {
            builder.append(j);
        }
        long objectSize = ObjectSizeFetcher.getObjectSize(builder.toString());
        System.out.println(objectSize);

        objectSize = ObjectSizeFetcher.getObjectSize(new SimpleBean(5));
        System.out.println(objectSize);



        objectSize = ObjectSizeFetcher.getObjectSize(new String("asdf fsaasf klj;ljksadf asdfs adfl kjasdf asdf;lkj;lkjdsaf asdf ;alskdjfasdfadsflkjasdfdsa  fdsfdsafdsaf" +
            "asdffdsafdsa dsafdsafdsaf asdfdasfdddddddddddf asdfads fasdfsadlkfjasd;lkifjweaiolfruweoifjdsklfnasd.,lk; fjhdaslfda/klf jdsalkfj as;dlfkijhdaslkfnmad,.adsf adsf" +
            "asdfsdaaaaaaaaaaaaaaaaaa dsaffffffffffffffffffffff dsfffffffffffffffffffffffffffffffffffffff dsfaasdfsadf" +
            "sdafdsafffffffffffffff fdsaaaaaaaaaaaaaaaf fdsaaaaaaaaaaaaaaaaaaaaaaaaf fdsaaaaaaaaaaaaaaaaaaaaa" +
            "dfsafffffffffffffffff dsffffffffffffffffff dfsssssssssssssssssssssss dsffffffffffffffffffffffffffff dsffffffffffffffffffffffffff" +
            "sdffffffffffffffffffffffffffff " +
            "asdf fsaasf klj;ljksadf asdfs adfl kjasdf asdf;lkj;lkjdsaf asdf ;alskdjfasdfadsflkjasdfdsa  fdsfdsafdsaf" +
                        "asdffdsafdsa dsafdsafdsaf asdfdasfdddddddddddf asdfads fasdfsadlkfjasd;lkifjweaiolfruweoifjdsklfnasd.,lk; fjhdaslfda/klf jdsalkfj as;dlfkijhdaslkfnmad,.adsf adsf" +
                        "asdfsdaaaaaaaaaaaaaaaaaa dsaffffffffffffffffffffff dsfffffffffffffffffffffffffffffffffffffff dsfaasdfsadf" +
                        "sdafdsafffffffffffffff fdsaaaaaaaaaaaaaaaf fdsaaaaaaaaaaaaaaaaaaaaaaaaf fdsaaaaaaaaaaaaaaaaaaaaa" +
                        "dfsafffffffffffffffff dsffffffffffffffffff dfsssssssssssssssssssssss dsffffffffffffffffffffffffffff dsffffffffffffffffffffffffff" +
                        "sdffffffffffffffffffffffffffff "));
        System.out.println(objectSize);

        objectSize = ObjectSizeFetcher.getObjectSize(new String("fffff "));
        System.out.println(objectSize);
    }
}
