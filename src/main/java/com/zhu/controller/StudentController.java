package com.zhu.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhu.entity.Student;
import com.zhu.service.StudentService;
import com.zhu.util.code.ErrorEnum;
import com.zhu.util.result.Result;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping("/getStudentsByPageAndSearch")
  public Result<?> getStudentsByPageAndSearch(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "") String search) {
    //封装page
    Page<Student> page = new Page<>(pageNum, pageSize);
    //封装查询条件
    LambdaQueryWrapper<Student> wrapper = Wrappers.<Student>lambdaQuery().orderByAsc(Student::getId);
    if(StrUtil.isNotBlank(search)) {
      //封装模糊查询条件
      wrapper.like(Student::getName, search);
    }
    //返回分页查询结果
    Page<Student> studnetPage = studentService.page(page, wrapper);
    return Result.success(studnetPage);
  }

  @PostMapping("/saveStudent")
  public Result<?> saveStudent(@RequestBody Student student) {
    studentService.saveOrUpdate(student);
    return Result.success();
  }

  @DeleteMapping("/{id}")
  public Result<?> deleteById(@PathVariable Long id) {
    studentService.removeById(id);
    return Result.success();
  }

  @PostMapping("/login")
  public Result<?> login(@RequestBody Student student) {
    QueryWrapper<Student> queryWrapper = new QueryWrapper();
    queryWrapper.eq("name", student.getName()).eq("password", student.getPassword());
    Student one = studentService.getOne(queryWrapper);
    if(one == null) {
      return Result.error("-1", "账号或者密码错误");
    }
    return Result.success(one);
  }

  @PostMapping("/register")
  public Result<?> register(@RequestBody Student student) {
    //判断创建的用户是否已经存在
    QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("name", student.getName());
    Student one = studentService.getOne(queryWrapper);
    if(one != null) {
      return Result.otherError(ErrorEnum.USER_EXIST);
    }
    studentService.save(student);
    return Result.success();
  }
}
