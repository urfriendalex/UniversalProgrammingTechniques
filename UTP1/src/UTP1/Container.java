package UTP1;

import java.util.ArrayList;
import java.util.List;

public class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult> implements IContainer<TElement, TAggregateResult> {
    private final List<TElement> elements;

    public Container() {
        elements = new ArrayList<>();
    }

    public void addEl(TElement element) {
        elements.add(element);
    }

    public void addList(List<TElement> list) {
        elements.addAll(list);
    }

    public TElement get(int index) {
        if (index < elements.size() || !elements.isEmpty()) {
            return elements.get(index);
        }
            return null;
    }

    @Override
    public List<TElement> elements() {
        return elements;
    }

    @Override
    public TAggregateResult aggregateAllElements() {
        TAggregateResult inermidiateResult = null;
        for (TElement el: elements) {
            inermidiateResult = el.aggregate(inermidiateResult);
        }
        System.out.println(inermidiateResult);
        return inermidiateResult;
    }

    @Override
    public TElement cloneElementAtIndex(int index) {
        if ((index >=0 && index < elements.size()) || !elements.isEmpty()) {
            return elements.get(index).deepClone();
        }else
        return null;
    }
}
