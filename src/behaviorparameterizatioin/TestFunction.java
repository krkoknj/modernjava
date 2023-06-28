package behaviorparameterizatioin;

@FunctionalInterface
public interface TestFunction<T,U,S,A,B, R> {

    R apply(T t, U u, S s, A a, B b);
}
