import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class ClassLoaderTrain extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(name);
        if (!file.isFile()) throw new ClassLoaderException("класс не найден");
        log.error("класс найден");
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            Class clazz = defineClass(file.getName().replace(".class", ""), bytes, 0, bytes.length);
            log.error("класс загружен");
            return clazz;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ClassLoaderException("класс не загрузился");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

}
