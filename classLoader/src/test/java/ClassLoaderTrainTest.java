import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ClassLoaderTrainTest {

    private Class clazz;
    private int[] testArray = {3, 22, 27, 47, 57, 67, 89, 91, 99};

    @Before
    public void setUp() throws Exception {
        Properties properties = System.getProperties();
        String separator = properties.getProperty("file.separator");
        String localDir = System.getProperty("user.dir");
        ClassLoaderTrain loader = new ClassLoaderTrain();
        clazz = loader.findClass(localDir.replace(
                "classLoader",
                "algorithms" + separator + "target" + separator + "classes" +separator +"BinarySearch.class"));
    }

    @Test
    public void classLoaderTest() throws Exception {
        if (clazz != null) {
            Method[] methods = clazz.getMethods();
            Method method = methods[0];
            assertEquals(method.invoke(clazz.getDeclaredConstructor().newInstance(), testArray, 47), 3);
        }
    }
}