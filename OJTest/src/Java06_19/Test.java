package Java06_19;

    public class Test {
            private  void testMethod(){
                System.out.println("testMethod");
            }
            public static void main(String[] args) {
                ((Test)null).testMethod();
            }
}
