package az.azure.manage.mapper;

import az.azure.manage.entity.CustomerInfoPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2024/9/25
 */
@Mapper
@Repository
public interface CustomerInfoMapper extends BaseMapper<CustomerInfoPo> {

}
