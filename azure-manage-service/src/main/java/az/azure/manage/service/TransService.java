package az.azure.manage.service;

import az.azure.manage.dto.TransDto;
import org.springframework.stereotype.Service;

/**
 * @author Az
 * @date 2022/10/11
 */
public interface TransService {
    String translation(TransDto transDto);
}
