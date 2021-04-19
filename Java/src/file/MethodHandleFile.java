package file;

import java.io.IOException;

public interface MethodHandleFile {
	public boolean Write(String fileName, String content, boolean mode) throws IOException;
	public String Read(String fileName);
}
