package com.zhu.service.serviceImpl;

import com.zhu.entity.Student;
import com.zhu.mapper.StudentMapper;
import com.zhu.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
