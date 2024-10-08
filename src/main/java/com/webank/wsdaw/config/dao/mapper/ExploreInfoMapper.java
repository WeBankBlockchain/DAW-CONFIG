package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.ExploreInfoEntity;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ExploreInfoMapper {
    @Select("SELECT * FROM t_explore_info WHERE pk_id = #{pkId}")
    public ExploreInfoEntity selectById(@Param("pkId") Long pkId);

    @Select("SELECT * FROM t_explore_info WHERE name = #{name}")
    public ExploreInfoEntity selectByName(@Param("name") String name);

    @Select("SELECT * FROM t_explore_info where status = 0 order by priority")
    public List<ExploreInfoEntity> selectAll();

    @Insert(
            "INSERT INTO t_explore_info (name, title, url, icon, priority) "
                    + "VALUES (#{name}, #{title}, #{url}, #{icon}, #{priority})")
    @Options(useGeneratedKeys = true, keyProperty = "pkId")
    public int insert(ExploreInfoEntity exploreInfo);

    @Select(
            "SELECT * FROM t_explore_info WHERE name LIKE CONCAT('%', #{name}, '%')  and status = 0 order by priority")
    List<ExploreInfoEntity> selectByNameLike(@Param("name") String name);
}
