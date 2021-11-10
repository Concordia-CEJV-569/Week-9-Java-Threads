public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
//        anotherThread.run(); it would run from MAIN thread in this case
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
            }
        });

        myRunnableThread.start();
        anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");


    }
}
