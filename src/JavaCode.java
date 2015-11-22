package annotation;

import java.applet.Applet.*;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.URL;


public class JavaCode extends Object implements Cloneable, Comparable {

    public static void main(String[] args) {

        int i = 5;
        int j = 10;

        i += 5;
        j -= 2;

        System.out.println("i = " + i);
        System.out.println("j = " + j);

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
