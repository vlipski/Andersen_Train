import java.io.*;

public class ClassLoaderTrain extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);
        if (!file.isFile()) return null;
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            Class clazz = defineClass(file.getName().replace(".class", ""), bytes, 0, bytes.length);
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
