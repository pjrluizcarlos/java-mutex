# Examples of Mutex with Java

In a multithreaded application, two or more threads may need to access a shared resource at the same time, 
resulting in unexpected behavior. Examples of such shared resources are data-structures, input-output devices, 
files, and network connections.  

A mutex (or mutual exclusion) is the simplest type of synchronizer – it ensures that only one thread can 
execute the critical section of a computer program at a time.  

Every object in Java has an intrinsic lock associated with it.The synchronized method and the synchronized block 
use this intrinsic lock to restrict the access of the critical section to only one thread at a time.

Therefore, when a thread invokes a synchronized method or enters a synchronized block, it automatically 
acquires the lock. The lock releases when the method or block completes or an exception is thrown from them.

### Reference Documentation
For further reference, please consider the following sections:

* [Baeldung - Java Mutex](https://www.baeldung.com/java-mutex)
* [Baeldung - java Locks API](https://www.baeldung.com/java-concurrent-locks)
* [Baeldung - Synchronized](https://www.baeldung.com/java-synchronized)
