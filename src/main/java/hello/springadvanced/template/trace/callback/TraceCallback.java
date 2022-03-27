package hello.springadvanced.template.trace.callback;

public interface TraceCallback<T>  {
    T call();
}
