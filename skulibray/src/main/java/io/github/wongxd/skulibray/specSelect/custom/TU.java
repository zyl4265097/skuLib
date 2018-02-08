package io.github.wongxd.skulibray.specSelect.custom;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;


/**
 * Created by wongxd on 2018/2/8.
 */


public class TU {
    private static volatile Toast toast;
    public static WeakReference<Context> c;


    private TU() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public static void register(WeakReference<Context> ctx) {
        c = ctx;
    }

    public static void t(String msg) {
        if (msg.isEmpty()) return;
        if (toast == null) {
            synchronized (TU.class) {
                if (toast == null) {
                    toast = Toast.makeText(c.get(), msg, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        } else {
            toast.setText(msg);
            toast.show();
        }
    }

    public static void t(int msgRes) {
        t(c.get().getString(msgRes));
    }


}
