package tv.lostin.constant;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/3
 */
public class FolderTypeConstant {

    public static final String TYPE_MUSIC = "music";
    public static final String TYPE_MOVIE = "movie";

    public static String[] getFolderType() {
        return new String[]{
                TYPE_MUSIC,
                TYPE_MOVIE
        };
    }
}
