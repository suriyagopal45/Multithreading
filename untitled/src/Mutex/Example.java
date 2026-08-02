package Mutex;

public class Example {
    public static void main(String[] args) {

    }
}
//A Mutex (Mutual Exclusion) is a synchronization mechanism that allows only one thread at a time to access a shared resource.
//
//Java doesn't have a class named Mutex in the standard library. Instead, these act as a mutex:
//
//✅ synchronized
//✅ ReentrantLock
//
//Both ensure mutual exclusion.

//Mutex vs Semaphore
//
//This is a common interview question.
//
//Feature	Mutex	Semaphore
//Number of owners	1	Multiple permits
//Allows one thread?	✅ Yes	Depends on permit count
//Ownership	Yes	No
//Example	ReentrantLock	Semaphore(4)