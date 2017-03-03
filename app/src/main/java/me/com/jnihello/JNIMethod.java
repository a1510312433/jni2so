package me.com.jnihello;

/**
 * Created by caobin on 2017/3/3.
 */

public class JNIMethod {
    static {
        System.loadLibrary("HelloJNI");
    }
    public static native String sayHello();
}
