package com.ibm.bj.component.solrj.service.impl;

import com.ibm.bj.component.solrj.service.ICopyFileService;
import com.ibm.bj.component.solrj.util.FileMover;


/**
 * Created by zhengxiangyun on 2015/11/11.
 */
@Service
public class CopyFileServiceImpl implements ICopyFileService{
	
	/**
	 *文件拷贝
	 *@param src 源文件地址
	 *@param dest 目标地址
	 *@param interval 时间间隔
	 *@param needDelete 是否删除源文件
	 */
    @Override
    public void copyFiles(String src, String dest, Integer interval, boolean needDelete) throws IOException {
        FileMover.copyFiles(src,dest, interval, needDelete);
    }
}
