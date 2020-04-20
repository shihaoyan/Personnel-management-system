package com.shy.data.myinterface.myimpl;

import com.shy.data.exception.DataReaderException;
import com.shy.data.myenum.FileType;
import com.shy.data.myinterface.myabstract.AbstractDataReader;
import com.shy.data.utils.FileUtils;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 石皓岩
 * @create 2020-02-24 17:30
 * 描述：该类主要是为了读取文本类型的数据
 */
public class DefaultDataReader extends AbstractDataReader {
    /**
     * 我们需要定义一个map用来存储转换之后的数据
     */
    private Map<String, Object> dataMaps = new ConcurrentHashMap<>();


    @Override
    public Map<String, Object> readerData(FileType fileType, File file) throws DataReaderException {
        //首先应该进行一些参数校验
        Assert.notNull(fileType, "文件类型不能为空");
        Assert.notNull(file, "文件对象不能为空");
        if (fileType.equals(FileType.TEXT)) {
            try {
                // 这个方法会返回一个数据集合
                Map<String, Object> dataMaps = readerText(file);
                this.dataMaps = dataMaps;
            } catch (Exception e) {
                throw e;
            }
        } else if (fileType.equals(FileType.EXCEL)) {
            try {
                Map<String, Object> dataMaps = readerExcel(file);
                this.dataMaps = dataMaps;
            } catch (Exception e) {
                throw e;
            }
        } else if (fileType.equals(FileType.JSON)) {
            try {
                Map<String, Object> dataMaps = readerJson(file);
                this.dataMaps = dataMaps;
            } catch (Exception e) {
                throw e;
            }
        } else if (fileType.equals(FileType.URL)) {
            try {
                Map<String, Object> dataMaps = readerUrl(file);
                this.dataMaps = dataMaps;
            } catch (Exception e) {
                throw e;
            }
        } else if (fileType.equals(FileType.OTHER)) {
            try {
                Map<String, Object> dataMaps = readerOther(file);
                this.dataMaps = dataMaps;
            } catch (Exception e) {
                throw e;
            }
        }
        return dataMaps;
    }

    /**
     * 读取其他类型的数据，这个里面不进行任何处理等待扩展
     * @param file
     * @return
     */
    private Map<String, Object> readerOther(File file) {
        return null;
    }

    /**
     * 通过爬虫技术读取指定URL的数据，
     * 但是当前方法可能不会进行任何实现，
     * 因为可能会通过不同的网址进行爬取数据，
     * 所以肯定不会写死方法，可能将来还会开发出一套爬虫框架
     * @param file
     * @return
     */
    private Map<String, Object> readerUrl(File file) {
        return null;
    }

    /**
     * 通过json转换技术读取数据，并转换成相应的对象，
     * 这个方法将会进行主要的实现，
     * 因为json数据格式很多
     * @param file
     * @return
     */
    private Map<String, Object> readerJson(File file) {
        return null;
    }

    /**
     * 根据传递进来的excel对象读取数据，这个方法也是主要的实现，
     * 到时候会在前台提供一套准确的excel模板。
     *
     * @param file
     * @return
     */
    private Map<String, Object> readerExcel(File file) {
        return null;
    }

    /**
     * 根据传递进来的文件获取数据,必须确定文件的格式必须是符合规定类型，
     * 前台也会规定文件格式的要求。
     *
     * @param
     * @param
     * @return
     */
    private Map<String, Object> readerText(File file) {
        //1.验证文本文件的格式是否正确
        boolean fileIsLegal = FileUtils.verifyTextFileLegal(file);
        //2.如果不正确直接抛出异常，等待用户进行处理
        return null;
    }


}
