package eelly.com.lib_album.observable;


import java.util.List;

import eelly.com.lib_album.entity.LocalMedia;
import eelly.com.lib_album.entity.LocalMediaFolder;

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.lib.observable
 * email：893855882@qq.com
 * data：17/1/16
 */
public interface ObserverListener {
    void observerUpFoldersData(List<LocalMediaFolder> folders);

    void observerUpSelectsData(List<LocalMedia> selectMedias);
}
