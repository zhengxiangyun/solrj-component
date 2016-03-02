package com.ibm.bj.component.solrj.service.impl;

import com.ibm.bj.component.solrj.service.ICopyFileService;
import com.ibm.bj.component.solrj.util.FileMover;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by zhengxiangyun on 2015/11/11.
 */
@Service
public class CopyFileServiceImpl implements ICopyFileService{

    @Override
    public void copyFiles(String src, String dest, Integer interval, boolean needDelete) throws IOException {
        FileMover.copyFiles(src,dest, interval, needDelete);
    }
}
