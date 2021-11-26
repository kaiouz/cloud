package resources;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        A a = (A) context.getBean("a");
//        B b = (B) context.getBean("b");
        System.out.println(a.print());
//        System.out.println(b.a.print());
    }
}
