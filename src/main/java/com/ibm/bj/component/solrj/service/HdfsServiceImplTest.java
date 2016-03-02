package com.ibm.bj.component.solrj.service.impl;

import com.ibm.bj.component.solrj.service.IHdfsService;
import org.apache.hadoop.fs.FSDataInputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by zhengxiangyun on 2015/11/11.
 */
public class HdfsServiceImplTest {

    private IHdfsService hs;

    @Before
    public void setUp() throws Exception {
        hs = new HdfsServiceImpl();
    }

    @Test
    public void testGetHdfsFile() throws Exception {
        FSDataInputStream fsDataInputStream = hs.getHdfsFile("hdfs://master/destination/2015-11-10/保密制度.doc*");
    }

    @Test
    public void testGetRealPath() throws Exception {
        System.out.println(hs.getRealPath("hdfs://master/destination/2015-11-10/保密制度.doc.*"));
    }
}