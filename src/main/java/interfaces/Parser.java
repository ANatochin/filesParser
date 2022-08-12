package interfaces;

import java.io.File;
import java.util.List;

public interface Parser {

    public List<String> getSupportedExtensions();

    public boolean isSupportFile(String str);

    public List<ResultItem> parse(File file, String str);

}
