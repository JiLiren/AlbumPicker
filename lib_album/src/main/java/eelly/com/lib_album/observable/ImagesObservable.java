package eelly.com.lib_album.observable;


import java.util.ArrayList;
import java.util.List;

import eelly.com.lib_album.entity.LocalMedia;
import eelly.com.lib_album.entity.LocalMediaFolder;
import eelly.com.lib_album.tools.DebugUtil;

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.lib.observable
 * email：893855882@qq.com
 * data：17/1/11
 */
public class ImagesObservable implements SubjectListener {
    //观察者接口集合
    private List<ObserverListener> observers = new ArrayList<>();

    private List<LocalMediaFolder> folders;
    private List<LocalMedia> medias;
    private List<LocalMedia> selectedImages;
    private static ImagesObservable sObserver;

    private ImagesObservable() {
        folders = new ArrayList<>();
        medias = new ArrayList<>();
        selectedImages = new ArrayList<>();
    }

    public static ImagesObservable getInstance() {
        if (sObserver == null) {
            synchronized (ImagesObservable.class) {
                if (sObserver == null) {
                    sObserver = new ImagesObservable();
                }
            }
        }
        return sObserver;
    }


    /**
     * 存储文件夹图片
     *
     * @param list
     */

    public void saveLocalFolders(List<LocalMediaFolder> list) {
        if (list != null) {
            folders = list;
        }
    }


    /**
     * 存储图片
     *
     * @param list
     */
    public void saveLocalMedia(List<LocalMedia> list) {
        medias = list;
    }


    /**
     * 读取图片
     */
    public List<LocalMedia> readLocalMedias() {
        if (medias == null) {
            medias = new ArrayList<>();
        }
        return medias;
    }

    /**
     * 读取所有文件夹图片
     */
    public List<LocalMediaFolder> readLocalFolders() {
        if (folders == null) {
            folders = new ArrayList<>();
        }
        return folders;
    }


    /**
     * 读取选中的图片
     */
    public List<LocalMedia> readSelectLocalMedias() {
        return selectedImages;
    }


    public void clearLocalFolders() {
        if (folders != null)
            folders.clear();
    }

    public void clearLocalMedia() {
        if (medias != null)
            medias.clear();
        DebugUtil.i("ImagesObservable:", "clearLocalMedia success!");
    }

    public void clearSelectedLocalMedia() {
        if (selectedImages != null)
            selectedImages.clear();
    }

    @Override
    public void add(ObserverListener observerListener) {
        observers.add(observerListener);
    }

    @Override
    public void remove(ObserverListener observerListener) {
        if (observers.contains(observerListener)) {
            observers.remove(observerListener);
        }
    }
}