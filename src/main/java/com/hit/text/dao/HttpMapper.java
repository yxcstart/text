package com.hit.text.dao;

import com.hit.text.entity.Http;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @create 2021-09-08 23:32
 */
@Mapper
public interface HttpMapper {
    int insertHttp(Http http);
}
