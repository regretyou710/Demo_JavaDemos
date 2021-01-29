package ResourceFileLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceFileLoaderUtilImpl implements IResourceFileLoaderUtil {

	@Override
	public Properties getResourceFileAtProject(String filePath) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		return prop;
	}

	@Override
	public Properties getResourceFileAtSoruce(String filePath) throws IOException {
		Properties prop = new Properties();
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream(filePath);
		prop.load(is);
		return prop;
	}

}
