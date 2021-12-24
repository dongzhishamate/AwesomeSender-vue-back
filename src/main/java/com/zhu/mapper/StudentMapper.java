package com.zhu.mapper;

import com.zhu.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-10
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
