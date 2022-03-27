package hello.springadvanced.proxy.trace.callback;

public interface TraceCallback<T> {
    T call();
}
