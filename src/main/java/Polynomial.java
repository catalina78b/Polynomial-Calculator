import java.util.List;

public class Polynomial {

    private List<Monomial> monomialList;

    public Polynomial(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    public List<Monomial> getMonomialList() {
        return monomialList;
    }

    public void setMonomialList(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }


    public void addMonomialList(Monomial monomial) {
        this.monomialList.add(monomial);
    }

    public String toString(Polynomial p) {
        String stringResult = "";
        for (Monomial m : p.getMonomialList()) {
            stringResult = stringResult + m.toString();
        }
        return stringResult;
    }

    void sort(List<Monomial> monomialList) {
        monomialList.sort(new SortClass());
    }

}
