package az.azure.manage.mapper;

import az.azure.manage.entity.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2021/12/6
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPo> {

}
