import java.util.Comparator;

public class SortClass  implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        return Integer.compare(o2.getGrad(), o1.getGrad());
    }

}
