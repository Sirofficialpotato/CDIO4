package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrTest {

    @Test
    void add() {
        DynamicArr<Integer> k = new DynamicArr();
        DynamicArr<String> s = new DynamicArr();
        k.add(4);
        k.print();
        k.add(5);
        k.print();
        k.add(6);
        k.print();
        k.add(8);
        System.out.println(k.atIndex(2));
        System.out.println(k.atIndex(44999));
        k.addAt(3, 25);
        k.print();
        k.decrease(1);
        k.print();
        k.decrease(25);
        k.print();
        s.add("zero");
        s.print();
        s.add("first");
        s.print();
        s.add("second");
        s.print();
        s.add("third");
        System.out.println((String)s.atIndex(2));
        System.out.println((String)s.atIndex(44999));
        s.addAt(3, "twenty-five");
        s.print();
        s.decrease(1);
        s.print();
        s.decrease(25);
        s.print();
    }

    @Test
    void atIndex() {
    }

    @Test
    void addAt() {
    }

    @Test
    void print() {
    }

    @Test
    void decrease() {
    }

    @Test
    void removeAt() {
        DynamicArr<Integer> arr = new DynamicArr();
        for (int i = 0; i < 20; i++) {
            arr.add(i);
        }
        arr.print();
        arr.removeAt(15);
        arr.print();
    }
    @Test
    void lastItemToFront(){
        DynamicArr<Integer> arr = new DynamicArr();
        arr.add(5);
        arr.add(15);
        arr.add(18);
        arr.print();
        arr.lastItemToFront();
        arr.print();

    }
}