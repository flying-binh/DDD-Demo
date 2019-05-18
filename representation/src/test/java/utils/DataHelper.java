package utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class DataHelper {

    private static final String FIXTURE_PATH = "/fixtures/";

    public static String loadFixtureData(String fileName) throws IOException {
        return IOUtils.toString(DataHelper.class.getResource(FIXTURE_PATH + fileName), Charset.defaultCharset());
    }
}
