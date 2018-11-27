package proxy;

public class DunDog implements IDog{
    @Override
    public void info() {
        System.out.println("我是一只乖狗狗");
    }

    @Override
    public void run() {
        System.out.println("我是在狂奔");
    }
}
