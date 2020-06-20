package Java05_31;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableTest implements Serializable {

    private String name;
    private List<Food> foods = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableTest t = new SerializableTest();
        t.name = "快餐店";
        t.foods.add(new Food("牛排"));
        t.foods.add(new Food("汉堡"));
        t.foods.add(new Food("可乐"));
        // 输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(t); // 序列化 java 对象为二进制数据(拷贝)
        t.name = "慢慢吃";
        t.foods.get(2).name = "牛奶"; // 把可乐改成牛奶
        // 观察打印结果会发现, 这里虽然修改了 t 的某些值,但是 t2 还是打印的是原来的值, 这就是深拷贝
        // 输入流
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        // toByteArray() -> 转成二进制数组
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializableTest t2 = (SerializableTest) ois.readObject(); // readObject -> 读取对象
        System.out.println(t);
        System.out.println(t2);
    }

    private static class Food implements Serializable{
        private String name;

        public Food(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                ", foods=" + foods +
                '}';
    }
}
