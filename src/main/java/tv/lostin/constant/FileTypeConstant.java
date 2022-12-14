package tv.lostin.constant;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/3
 */
public class FileTypeConstant {

    public static final String TYPE_FLAC = "flac";
    public static final String TYPE_MP3 = "mp3";
    public static final String TYPE_APE = "ape";
    public static final String TYPE_WAV = "wav";

    public static List<String> getMusicFileTypes() {
        return Arrays.asList(TYPE_WAV, TYPE_APE, TYPE_FLAC, TYPE_MP3);
    }
}
