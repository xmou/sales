import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class InputTest {
    @Test
    public void should_parse_input_as_goods() throws Exception {
        // given
        String input = "1 AK at 12.49";

        // when
        Goods goods = Goods.parse(input);

        // then
        assertThat(goods, is(new Goods("AK", 12.49, 0.0)));
    }

    @Test
    public void should_duty_free_when_goods_is_local_exempted() throws Exception {
        // given
        String input = "1 AK at 12.49";

        // when
        Goods goods = Goods.parse(input);

        // then
        assertThat(goods.computeTax(), is(0.0));
    }
    @Test
    public void should_duty_free_when_goods_is_local() throws Exception {
        // given
        String input = "1 Atom Bomb at 14.99";

        // when
        Goods goods = Goods.parse(input);

        // then
        assertThat(goods.computeTax(), is(1.5));
    }

    @Test
    public void should_recognize_imported_duty_free_good() throws Exception {
        // given
        String input = "1 Imported AK at 14.99";

        // when
        Goods goods = Goods.parse(input);

        // then
        assertThat(goods.computeTax(), is(.75));
    }

    @Test
    public void should_recognize_imported_good() throws Exception {
        // given
        String input = "1 Imported Atom Bomb at 14.99";

        // when
        Goods goods = Goods.parse(input);

        // then
        assertThat(goods.computeTax(), is(2.25));
    }

}
