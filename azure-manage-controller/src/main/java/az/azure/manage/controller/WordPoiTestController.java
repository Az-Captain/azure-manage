package az.azure.manage.controller;

import com.deepoove.poi.XWPFTemplate;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Az
 * @date 2023/5/19
 */
@Api(tags = "word文档中替换内容")
@RequestMapping("word")
@RestController
@Slf4j
public class WordPoiTestController {
    //        private String FILE_INFO = "/Users/azimat/IdeaProject/Play/azure-manage/docs/template.docx";
    private String FILE_NAME = "template.docx";
    private String DOCUMENT = "/docs/";
    private String OUTPUT_FILE_NAME = "output.docx";

    @GetMapping("/poi/start")
    public void poiStart() throws IOException {
        Resource resource = new ClassPathResource("");
        String file = resource.getFile().getParentFile().getParentFile().getParentFile() + DOCUMENT + FILE_NAME;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("");
        HashMap<String, String> map = Maps.newHashMap();
        map.put("title", "i, poi-tl Word模板引擎");
        map.put("name", "tony");
        map.put("age", "22");
        map.put("address", "ChinaBeijing");
        map.put("tel", "122121212");
        map.put("email", "tony@gmail.com");
        map.put("city", "Beijing");
//        XWPFTemplate template = XWPFTemplate.compile(FILE_INFO).render(
//                new HashMap<String, Object>() {{
//                    put("title", "Hi, poi-tl Word模板引擎");
//                }}
//        );
        XWPFTemplate template = XWPFTemplate.compile(file).render(map);
        String outputFile = resource.getFile().getParentFile().getParentFile().getParentFile() + DOCUMENT + OUTPUT_FILE_NAME;
        template.writeAndClose(new FileOutputStream(outputFile));
        stopWatch.stop();
        log.info("填充完毕，总共耗时{}", stopWatch.getTotalTimeSeconds());
    }
}
