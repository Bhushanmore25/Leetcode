class Foo {
    private boolean oneDone;
    private boolean twoDone;
    
    public Foo() {
        oneDone = false;
        twoDone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!oneDone) {
            wait();
        }
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!twoDone) {
            wait();
        }
        printThird.run();
    }
}
// class Foo {
//     private Object lock;
//     private boolean oneDone;
//     private boolean twoDone;
    
//     public Foo() {
//         lock = new Object();
//         oneDone = false;
//         twoDone = false;
//     }

//     public void first(Runnable printFirst) throws InterruptedException {
//         synchronized (lock) {
//             printFirst.run();
//             oneDone = true;
//             lock.notifyAll();
//         }
//     }

//     public void second(Runnable printSecond) throws InterruptedException {
//         synchronized (lock) {
//             while (!oneDone) {
//                 lock.wait();
//             }
//             printSecond.run();
//             twoDone = true;
//             lock.notifyAll();
//         }
//     }

//     public void third(Runnable printThird) throws InterruptedException {
//         synchronized (lock) {
//             while (!twoDone) {
//                 lock.wait();
//             }
//             printThird.run();
//         }
//     }
// }