package desafioKatahpvf;

import desafioKatahpvf.modPrecios;
import desafioKatahpvf.contPrecios;
import org.junit.Test;

public class arregloPrecios {

    private contPrecios container_aaab = new contPrecios(TestData.items("AAAB"));

    @Test(expected = IllegalArgumentException.class)
    public void testErroneo() {
        rule("A", 0, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalido() {
        rule("A", 1, -1);
    }

    @Test
    public void testCanBeAppliedNotEnoughItems() {
        assert !rule("A", 4, 20).canBeAppliedTo(container_aaab);
    }

    @Test
    public void testCanBeAppliedDifferentArticle() {
        assert !rule("C", 1, 20).canBeAppliedTo(container_aaab);
    }

    @Test
    public void testCanBeAppliedSuccessful() {
        assert rule("A", 3, 20).canBeAppliedTo(container_aaab);
    }

    private modPrecios rule(String name, int amount, int total) {
        return new modPrecios(TestData.item(name), amount, total);
    }
}
