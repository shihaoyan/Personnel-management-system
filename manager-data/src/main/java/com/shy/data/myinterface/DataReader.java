package com.shy.data.myinterface;

import com.shy.data.exception.DataReaderException;
import com.shy.data.myenum.FileType;

import java.io.File;
import java.util.Map;

/**
 * @author 石皓岩
 * @create 2020-02-24 17:24
 * 描述：该接口得主要功能就是完成数据的读取功能,当用户选取某种数据类型或者直接选择文件的时候,通过不同的类型进行
 * 数据读取
 */
public interface DataReader {

    /**
     * 该方法主要是根据传进来的类型参数读取所有的这个类型的数据
     *
     * @param fileType 请求的类型,和将要读取数据的路径或者其他资源对象
     * @param <T>
     * @return
     */
    Map<String, Object> readerData(FileType fileType, File file) throws DataReaderException;


}
