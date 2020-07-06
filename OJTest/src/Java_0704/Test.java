package Java_0704;

public class Test {
    String name;

    Test(String str) {
        name = str;
    }

    Test() {
        this("hahahaha");
    }

    public static void main(String args[]) {
        Test t1 = new Test("oooooo");
        Test t2 = new Test();
        System.out.println(t1.name + "  " +t2.name);
    }
}