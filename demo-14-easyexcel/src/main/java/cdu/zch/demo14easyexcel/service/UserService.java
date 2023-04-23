package cdu.zch.demo14easyexcel.service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zch
 **/
public interface UserService {

    void upload(InputStream inputStream) throws IOException;

    void downloadExcel(ServletOutputStream outputStream);

    void fillExcelTemplate(ServletOutputStream outputStream);
}
