package com.ibm.bj.component.solrj.service;

import com.ibm.bj.component.solrj.model.FileTypeModel;
import com.ibm.bj.component.solrj.model.PageModel;

import java.util.List;

/**
 * Created by zhengxiangyun on 2015/11/6.
 */
public interface IQueryFileService {

    PageModel queryFiles(String keyword);

    PageModel queryFiles(String keyword, String type);

    PageModel queryFiles(String keyword, String type, Integer currentPage, Integer pageSize);

    List<FileTypeModel> queryFileTypes(String keyword);

}
