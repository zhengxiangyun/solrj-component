package com.ibm.bj.component.solrj.service;

import java.io.IOException;

/**
 * Created by zhengxiangyun on 2015/11/11.
 */
public interface ICopyFileService {
    void copyFiles(String src, String dest, Integer interval, boolean needDelete) throws IOException;
}
