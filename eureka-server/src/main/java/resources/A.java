package resources;

import org.springframework.beans.factory.annotation.Autowired;

public class A {

//    @Autowired
    B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String print() {
        return "aaaaaaa";
    }
}
