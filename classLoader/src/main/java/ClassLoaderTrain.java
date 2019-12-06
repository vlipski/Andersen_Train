import java.io.*;

public class ClassLoaderTrain extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);
        if (!file.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            Class clazz = defineClass(file.getName().replace(".class",""), bytes, 0, bytes.length);
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
