package eliteprofessional.utils;

public class UtilsWaits {
    public void wait (int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}