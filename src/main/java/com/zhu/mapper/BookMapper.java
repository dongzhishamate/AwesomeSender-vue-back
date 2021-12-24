package com.zhu.mapper;

import com.zhu.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-15
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
