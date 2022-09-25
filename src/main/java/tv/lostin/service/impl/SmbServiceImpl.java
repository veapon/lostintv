package tv.lostin.service.impl;

import com.hierynomus.msfscc.fileinformation.FileAllInformation;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import org.springframework.util.StringUtils;
import tv.lostin.entity.FileEntity;
import tv.lostin.entity.FileEntity;
import tv.lostin.service.DeviceTypeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SMB服务
 *
 * @author veapon
 * @date 2022/1/8
 */
public class SmbServiceImpl extends DeviceTypeService {

    private final Session session;
    private DiskShare share;


    public SmbServiceImpl(String host, String user, String passwd) throws IOException {
        SMBClient client = new SMBClient();
        Connection connection = client.connect(host);
        AuthenticationContext ac = new AuthenticationContext(user, passwd.toCharArray(), null);
        session = connection.authenticate(ac);
    }

    public Session getSession() {
        return session;
    }

    public DiskShare getShare() {
        return share;
    }

    public void setShare(String name) {
        share = (DiskShare) getSession().connectShare(name);
    }

    @Override
    public List<FileEntity> ls(String dir) {
        List<String> ignoreFiles = Arrays.asList(".", "..", ".DS_Store");
        List<FileEntity> list = new ArrayList<>();
        for (FileIdBothDirectoryInformation f: share.list(dir)) {
            if (ignoreFiles.contains(f.getFileName())) {
                continue;
            }
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(f.getFileName());
            String path = String.format("%s/%s", dir, f.getFileName());
            fileEntity.setPath(StringUtils.trimTrailingCharacter(dir, '/') + "/" + f.getFileName());
            FileAllInformation fileInfo = share.getFileInformation(path);
            fileEntity.setDirectory(fileInfo.getStandardInformation().isDirectory() ? 1 : 0);
            list.add(fileEntity);
        }
        return list;
    }
}
