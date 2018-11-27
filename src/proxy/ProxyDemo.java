package proxy;

public class ProxyDemo {
    public static void main(String[] args){
        IDog target = new DunDog();
        IDog dog = (IDog) ProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
