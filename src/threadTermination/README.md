## Why and When to terminate a thread:
1. Thread consumes resources:
- Memory and kernel resources (when the application is running, even if thread is not in running state)
- CPU cycles and cache memory (when the thread is executing).
2. If a thread finished its work, but the application is still running, we want to clean up the resources used by this thread.
3. If a thread is misbehaving, we would want to stop it. For example, if a thread is taking more time to execute (more time than we expected it to take), in such cases we want to stop such a thread.
4. By default, an application is running or consuming the space/resources, even if a single thread is alive in that application. Even if the main thread has stopped working, but other thread is active, then also the application is considered to be running. In such cases we want the entire application to stop.

## Thread.interrupt()
Thread A can interrupt Thread B in two ways:
1. 
