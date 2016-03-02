package com.ibm.bj.component.solrj.service.impl;

import com.ibm.bj.component.solrj.service.ICopyFileService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by zhengxiangyun on 2015/11/11.
 */
public class CopyFileServiceImplTest {
    private ICopyFileService cfs;

    @Before
    public void setUp() throws Exception {
        cfs = new CopyFileServiceImpl();
    }

    @Test
    public void testCopyFiles() throws IOException {
        String src = "C:/data_src/test/";
        String dest = "C:/data_now";
        cfs.copyFiles(src, dest, 5, true);
    }
}
