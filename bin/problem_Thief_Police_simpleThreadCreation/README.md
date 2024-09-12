## Summary of this file:
1. Thread creation can be done using Runnable interface implementation with run() overidden. This task can be passed to the thread creation constructor.
2. Thread creation can also be done using the extension or creation of concrete class from the Thread class (implements Runnable interface internally). Directly create an object of this new thread class.
3. Thread class encapsulates all thread related functions like - sleep(long millisec), setName(String nameOfThread), getName(), setPriority(int priority), getPriority() and so on.
