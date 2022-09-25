package tv.lostin.service;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.springframework.stereotype.Service;
import tv.lostin.constant.FileTypeConstant;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/2
 */
@Service
public class LocalService {
    public void ls(String path) {
        File file = new File(path);
        ls(file);
    }

    private void ls(File file) {
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.isDirectory()) {
                ls(f);
            } else {
                String ext = FilenameUtils.getExtension(f.getName());
                if (!Arrays.asList(FileTypeConstant.getMusicFileTypes()).contains(ext)) {
                    continue;
                }
                try {
                    AudioFile audioFile = AudioFileIO.read(f);
                    Tag tag = audioFile.getTag();
                    List<String> artists = tag.getFields(FieldKey.ARTIST).stream()
                            .map(TagField::toString)
                            .collect(Collectors.toList());
                    System.out.println("Artists: " + StringUtils.join(artists, ','));

                } catch (Throwable e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
