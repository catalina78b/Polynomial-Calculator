import java.util.ArrayList;
import java.util.List;

public class Operations {
    public void removeALLZeros(List<Monomial> monomialList) {
        List<Monomial> toDelete = new ArrayList<>();
        for (Monomial m : monomialList) {
            if (m.getCoef() == 0)
                toDelete.add(m);
        }
        monomialList.removeAll(toDelete);
    }

    public Polynomial add(Polynomial p, Polynomial q) {
        List<Monomial> monomialList = new ArrayList<>();
        for (Monomial m1 : p.getMonomialList()) {
            for (Monomial m2 : q.getMonomialList()) {
                if (m1.getGrad() == m2.getGrad()) {
                    m1.setFound(true);
                    m2.setFound(true);
                    monomialList.add(new Monomial(m1.getGrad(), m1.getCoef() + m2.getCoef()));
                }
            }
        }
        for (Monomial m1 : p.getMonomialList()) {
            if (!m1.isFound()) {
                monomialList.add(new Monomial(m1.getGrad(), m1.getCoef()));
                m1.setFound(true);
            }
        }
        for (Monomial m2 : q.getMonomialList()) {
            if (!m2.isFound()) {
                monomialList.add(new Monomial(m2.getGrad(), m2.getCoef()));
                m2.setFound(true);
            }

        }
        removeALLZeros(monomialList);
        Polynomial result = new Polynomial(monomialList);
        result.sort(result.getMonomialList());
        return result;
    }

    public Polynomial subtract(Polynomial p, Polynomial q) {
        List<Monomial> monomialList = new ArrayList<>();
        for (Monomial m1 : p.getMonomialList()) {
            for (Monomial m2 : q.getMonomialList()) {
                if (m1.getGrad() == m2.getGrad()) {
                    m1.setFound(true);
                    m2.setFound(true);
                    monomialList.add(new Monomial(m1.getGrad(), m1.getCoef() - m2.getCoef()));
                }
            }
        }
        for (Monomial m1 : p.getMonomialList()) {
            if (!m1.isFound()) {
                monomialList.add(new Monomial(m1.getGrad(), m1.getCoef()));
                m1.setFound(true);
            }
        }
        for (Monomial m2 : q.getMonomialList()) {
            if (!m2.isFound()) {
                monomialList.add(new Monomial(m2.getGrad(), -m2.getCoef()));
                m2.setFound(true);
            }

        }
        removeALLZeros(monomialList);
        Polynomial result = new Polynomial(monomialList);
        result.sort(result.getMonomialList());
        return result;
    }

    public Polynomial multiply(Polynomial p, Polynomial q) {
        List<Monomial> monomialList = new ArrayList<>();
        for (Monomial m1 : p.getMonomialList()) {
            for (Monomial m2 : q.getMonomialList()) {
                monomialList.add(new Monomial(m1.getGrad() + m2.getGrad(), m1.getCoef() * m2.getCoef()));
            }
        }
        int size = monomialList.size();
        Polynomial p1 = new Polynomial(new ArrayList<>(monomialList.subList(0, (size + 1) / 2)));
        Polynomial p2 = new Polynomial(new ArrayList<>(monomialList.subList((size + 1) / 2, size)));
        Polynomial result = add(p1, p2);
        result.sort(result.getMonomialList());
        return result;
    }

    public Polynomial derivate(Polynomial p) {
        List<Monomial> monomialList = new ArrayList<>();
        for (Monomial m : p.getMonomialList()
        ) {
            monomialList.add(new Monomial(m.getGrad() - 1, m.getCoef() * m.getGrad()));
            m.setGrad(m.getGrad() - 1);
        }
        removeALLZeros(monomialList);
        Polynomial result = new Polynomial(monomialList);
        result.sort(result.getMonomialList());
        return result;
    }

    public Polynomial integrate(Polynomial p) {
        List<Monomial> monomialList = new ArrayList<>();
        for (Monomial m : p.getMonomialList()
        ) {
            monomialList.add(new Monomial(m.getGrad() + 1, m.getCoef() / (m.getGrad() + 1)));
            m.setGrad(m.getGrad() + 1);
        }
        removeALLZeros(monomialList);
        Polynomial result = new Polynomial(monomialList);
        result.sort(result.getMonomialList());
        return result;
    }

    public Polynomial divide(Polynomial p1, Polynomial p2) {
        Polynomial q, r, m, tt;
        if (p2 == null)
            throw new RuntimeException("P2=0!");
        List<Monomial> monomialList1 = new ArrayList<>();
        List<Monomial> monomialList2 = new ArrayList<>();
        List<Monomial> monomialList3 = new ArrayList<>();
        p1.sort(p1.getMonomialList());
        p2.sort(p2.getMonomialList());
        q = new Polynomial(monomialList1);
        tt = new Polynomial(monomialList2);
        m = new Polynomial(monomialList3);
        r = new Polynomial(p1.getMonomialList());
        while (r.getMonomialList().size() != 0 && r.getMonomialList().get(0).getGrad() >= p2.getMonomialList().get(0).getGrad()) {
            Monomial t = r.getMonomialList().get(0).divide(p2.getMonomialList().get(0));
            tt.getMonomialList().clear();
            tt.addMonomialList(t);
            q = add(q, tt);
            m.getMonomialList().clear();
            m = multiply(tt, p2);
            r = subtract(r, m);

        }
        return q;
    }

}
