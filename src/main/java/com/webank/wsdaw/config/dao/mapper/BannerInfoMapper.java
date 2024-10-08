package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.BannerInfoEntity;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BannerInfoMapper {

    @Select("SELECT * FROM t_banner_info where status = 0 order by priority")
    public List<BannerInfoEntity> selectAll();

    @Insert(
            "INSERT INTO t_banner_info (name, url, img, priority) "
                    + "VALUES (#{name}, #{url}, #{img}, #{priority})")
    @Options(useGeneratedKeys = true, keyProperty = "pkId")
    public int insert(BannerInfoEntity bannerInfo);
}
