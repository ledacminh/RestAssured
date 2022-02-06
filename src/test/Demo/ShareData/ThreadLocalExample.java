package ShareData;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal counter1 = new ThreadLocal();
        counter1.set("admin");
        String name = (String)counter1.get();
        System.out.println(name);
        counter1.remove();
        System.out.println((String)counter1.get());
        ThreadLocal counter2 =  ThreadLocal.withInitial(() -> "admin2");
        System.out.println((String)counter2.get());
        ThreadLocal<String> counter3 = new ThreadLocal<String>();
        counter3.set("Admin3");
        System.out.println(counter3.get());
    }
}
