package my;

import gr.forth.ics.memorymeasurer.MemoryMeasurer;
import my.beans.SimpleBean;

/**
 * @author kkulagin
 * @since 10.11.2014
 */
public class MemoryTest2 {

    public static void main(String[] args) {

        long objectSize = MemoryMeasurer.count(new SimpleBean(2));
        System.out.println(objectSize);

//        objectSize = MemoryMeasurer.count(new SimpleBean("asdf fsaasf klj;ljksadf asdfs adfl kjasdf asdf;lkj;lkjdsaf asdf ;alskdjfasdfadsflkjasdfdsa  fdsfdsafdsaf" +
//            "asdffdsafdsa dsafdsafdsaf asdfdasfdddddddddddf asdfads fasdfsadlkfjasd;lkifjweaiolfruweoifjdsklfnasd.,lk; fjhdaslfda/klf jdsalkfj as;dlfkijhdaslkfnmad,.adsf adsf" +
//            "asdfsdaaaaaaaaaaaaaaaaaa dsaffffffffffffffffffffff dsfffffffffffffffffffffffffffffffffffffff"));
//        System.out.println(objectSize);

        int count = 1000;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < count; j++) {
            builder.append(j);
        }
        objectSize = MemoryMeasurer.count(builder.toString());
        System.out.println(objectSize);

        objectSize = MemoryMeasurer.count(new String("asdf fsaasf klj;ljksadf asdfs adfl kjasdf asdf;lkj;lkjdsaf asdf ;alskdjfasdfadsflkjasdfdsa  fdsfdsafdsaf" +
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

        objectSize = MemoryMeasurer.count(new String("fffff "));
        System.out.println(objectSize);
    }
}
