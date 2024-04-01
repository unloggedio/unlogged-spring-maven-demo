package org.unlogged.demo;

public class KindOfAUtilClass {
    public static void thisMethodTakesTimeToCompleteBasedOnParameter(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
