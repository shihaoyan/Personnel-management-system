package com.shy.data.exception;

/**
 * @author 石皓岩
 * @create 2020-02-24 18:17
 * 描述：致命异常，如果数据转换错误直接停止程序运行
 */
public class DataReaderException extends RuntimeException {
    public DataReaderException() {
    }

    public DataReaderException(String message) {
        super(message);
    }
}
