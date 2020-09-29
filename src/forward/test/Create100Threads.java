package forward.test;

/**
 * TODO
 *
 * @author Redamancy@浮生若梦
 * @version 1.0
 * @date 2020/9/8 - 0:39
 * @since jdk 1.8
 */
public class Create100Threads {
    public static void main(String[] args) {
        for(int i = 0;i < 100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
