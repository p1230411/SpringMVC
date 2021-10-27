package hello.core.CallOfValueAndReference;

import org.junit.jupiter.api.Test;

class ValueAndRefTest {

    void func1(Integer a) {
        a = 3;
        System.out.println("func1 : " + a);
    }

    void func2(ValueAndRef a) {
        a.setValue(3);
        System.out.println("func2 : " + a.toString());
    }

    @Test
    void ttt() {
        ValueAndRef valueAndRef = new ValueAndRef(2);
        Integer a = 2;
        func1(a);
        func2(valueAndRef);
        System.out.println("main a : " + a);
        System.out.println("main valueAndRef : " + valueAndRef.toString());

    }
}



