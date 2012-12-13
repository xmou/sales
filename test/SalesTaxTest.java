import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SalesTaxTest {

    @Test
    public void should_duty_free_when_goods_is_local_exempted() throws Exception {
         // given
         Goods goods = new Goods("AK", 12.49, 0.0);

        // when
        double tax = goods.computeTax();

         // then
        assertThat(tax, is(0.0));
    }

    @Test
    public void should_not_duty_free_when_goods_is_local_basic_taxable() throws Exception {
        // given
        Goods goods = new Goods("Atom Bomb", 14.99, 0.1);

        // when
        double tax = goods.computeTax();

        // then
        assertThat(tax, is(1.50));
    }

    @Test
    public void should_not_duty_free_when_goods_is_imported_basic_taxable() throws Exception {
        // given
        Goods goods = new Goods("Imported Atom Bomb", 14.99, 0.15);

        // when
        double tax = goods.computeTax();

        // then
        assertThat(tax, is(2.25));
    }

    @Test
    public void should_not_duty_free_when_good_is_imported_exempted() throws Exception {
        // given
        Goods goods = new Goods("Imported Hammer", 10.00, 0.05);

        // when
        double tax = goods.computeTax();

        // then
        assertThat(tax, is(0.5));

    }

}
