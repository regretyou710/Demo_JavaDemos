package ResourceFileLoader;

import java.io.IOException;
import java.util.Properties;

public interface IResourceFileLoaderUtil {
	// 默認文件路徑在Project底下
	public Properties getResourceFileAtProject(String filePath) throws IOException;

	// 使用ClassLoader，默認文件路徑在src(資源文件夾)底下
	public Properties getResourceFileAtSoruce(String filePath) throws IOException;
}
