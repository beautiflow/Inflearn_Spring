package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String messge);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
