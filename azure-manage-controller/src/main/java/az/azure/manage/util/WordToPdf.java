package az.azure.manage.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 说明
 *
 * @author GQ
 * @date 2022/11/28
 */
public class WordToPdf {

    public static String DOC_PATH = "/Users/azimat/IdeaProject/Play/pdf-word-image/file/1CT23041910086438.docx";
    public static String PDF_PATH = "/Users/azimat/IdeaProject/Play/pdf-word-image/file/1CT23041910086438.pdf";

    public static void main(String[] args) {
        FileOutputStream os = null;
        try {
            long start = System.currentTimeMillis();
            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
            ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
            License license = new License();
            license.setLicense(is);

            // 新建一个空白pdf文档
            File file = new File(PDF_PATH);
            os = new FileOutputStream(file);
            // Address是将要被转化的word文档
            Document doc = new Document(DOC_PATH);
            doc.save(os, SaveFormat.PDF);
            long end = System.currentTimeMillis();
            System.out.println("总共使用" + (end - start) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
