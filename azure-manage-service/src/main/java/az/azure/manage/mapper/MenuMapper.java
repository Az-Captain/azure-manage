package az.azure.manage.mapper;

import az.azure.manage.entity.MenuPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Az
 * @date 2022/4/10
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<MenuPo> {

}
