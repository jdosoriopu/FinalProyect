import org.stringtemplate.v4.Interpreter;
import org.stringtemplate.v4.ModelAdaptor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.misc.STNoSuchPropertyException;

import java.lang.reflect.Method;

/**
 * Created by User on 20/11/2015.
 */
public class ContextModelAdapter implements ModelAdaptor {
    @Override
    public Object getProperty(Interpreter interpreter, ST self, Object o, Object property, String propertyName) throws STNoSuchPropertyException {

        Method m = null;

        try {
            String mn = "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
            m = o.getClass().getMethod(mn);
        } catch (Exception e) {
        }
        if (m == null)
            try {
                m = o.getClass().getDeclaredMethod(propertyName);
            } catch (Exception e) {
            }

        MyCustomMethods myCustomMethods = null;
        if (m == null)
            try {
                myCustomMethods = new MyCustomMethods();
                m = myCustomMethods.getClass().getDeclaredMethod(propertyName, Object.class);
            } catch (Exception e) {
            }

        if (m != null) {
            Object res;
            try {
                if (myCustomMethods != null)
                    res = m.invoke(myCustomMethods, o);
                else
                    res = m.invoke(o);
                return res;
            } catch (Exception e) {
                throw new STNoSuchPropertyException(e, property, propertyName);
            }
        }
        else
            throw new STNoSuchPropertyException(null, property, propertyName);

    }
}
