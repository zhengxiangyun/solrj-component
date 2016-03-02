package com.ibm.bj.component.solrj.service;

import java.io.IOException;

/**
 * Created by zhengxiangyun on 2015/11/25.
 */
public interface IConvertService {

    String doc2pdf(String docPath, String pdfLocation);

    String pdf2swf(String pdfPath, String swfLocation);

    String doc2swf(String docPath, String pdfLocation, String swfLocation);

}
