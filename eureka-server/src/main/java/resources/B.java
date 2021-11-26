package resources;

import org.springframework.beans.factory.annotation.Autowired;

public class B {

//    @Autowired
    A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public String print() {
        return "bbbbbbb";
    }
}
