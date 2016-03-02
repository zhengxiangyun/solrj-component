package com.ibm.bj.component.solrj.service.impl;

import com.ibm.bj.component.solrj.service.IHdfsService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by zhengxiangyun on 2015/11/9.
 */

class RegexExludePathFilter implements PathFilter {  //文件过滤类

    private final String regex;
    private Path realPath;
	
	/**
	 *获取实际路径
	 *@return Path
	 */
    public Path getRealPath() {
        return realPath;
    }

	/**
	 *正则表达式过滤
	 *@param regex
	 */
    public RegexExludePathFilter(String regex) {
        this.regex = regex;
    }
	
	/**
	 *路径匹配
	 *@param Path
	 *@return boolean
	 */
    public boolean accept(Path path) {
        realPath = path;
        return !path.toString().matches(regex);
    }
}

@Service
public class HdfsServiceImpl implements IHdfsService {

	/**
	 *获取文件流
	 *@param hdfsPath
	 *@return FSDataInputStream
	 */
    @Override
    public FSDataInputStream getHdfsFile(String hdfsPath) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        RegexExludePathFilter repf = new RegexExludePathFilter("^.*/1901");
        FileStatus[] status = fs.globStatus(new Path(hdfsPath),repf);   //根据通配符匹配文件
        Path[] listedPaths = FileUtil.stat2Paths(status);                                                //获取相匹配文件的Path
        FSDataInputStream fsdi = null;
        if(listedPaths.length > 0) {
            fsdi = fs.open(listedPaths[0]);                                            //生产FSDataInputStream流
            //OutputStream output = new FileOutputStream("/tmp/" + listedPaths[0].toString().substring(listedPaths[0].toString().lastIndexOf("/"),listedPaths[0].toString().length()));
            //IOUtils.copyBytes(fsdi, output, 4096, true);
//            System.out.println(listedPaths[0]);
//            fsdi.close();                                                              //关闭流
        }
        return fsdi;
    }
	
	/**
	 *获取文件的实际hdfs路径
	 *@param hdfsPath
	 *@return String
	 */
    @Override
    public String getRealPath(String hdfsPath) throws IOException {
//        System.out.println("Path: " + hdfsPath);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        RegexExludePathFilter repf = new RegexExludePathFilter("^.*/1901");
        FileStatus[] status = fs.globStatus(new Path(hdfsPath),repf);   //根据通配符匹配文件

        return repf.getRealPath().toString();
    }

}
