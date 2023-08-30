public class ThreadMain {
    public static void main(String[] args) {
        //main 자체가 thread이다
        //Thread.currentThread().setPriority(10);  //스레드의 우선순위 결정(10~20)
        System.out.println("name=="+Thread.currentThread().getName());
        System.out.println("priority=="+Thread.currentThread().getPriority());
        System.out.println("state=="+Thread.currentThread().getState());  //스레드의 상태 확인 (Runnable)
        System.out.println("ID=="+Thread.currentThread().getId());  //스레드의 ID
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num =0;
               while (true) {
                //num++;
                System.out.printf("===");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               }
            }
        
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num =0;
               while (true) {
                //num++;
                System.out.printf("|");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               }
            }
        
        });
        thread01.start();
        thread02.start();
    }
}
