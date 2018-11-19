package com.mskf;

/**
 * Created by mskf on 2018/11/18.
 */
public class TestUtils {
    public static void hint(String msg) {
        msg("Hint \uD83D\uDCA1",msg);
    }
    public static void result(String msg) {
        msg("Result:",msg);
    }

    public static void msg(String channel, String msg) {
        System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg));
    }

    public static void success(boolean success) {
        System.out.println(String.format("TECHIO> success %s", success));
    }

    public static void terminal(){
        System.out.println("TECHIO> terminal");
    }
}