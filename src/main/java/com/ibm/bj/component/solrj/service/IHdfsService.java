package com.ibm.bj.component.solrj.service;

import org.apache.hadoop.fs.FSDataInputStream;

import java.io.IOException;

/**
 * Created by zhengxiangyun on 2015/11/9.
 */
public interface IHdfsService {

    FSDataInputStream getHdfsFile(String hdfsPath) throws IOException;

    String getRealPath(String hdfsPath) throws IOException;

}
