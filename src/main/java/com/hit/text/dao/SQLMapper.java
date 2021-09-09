package com.hit.text.dao;

import com.hit.text.entity.SQLStatement;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @create 2021-09-09 0:01
 */
@Mapper
public interface SQLMapper {
    int insertSql(SQLStatement sqlStatement);
}
