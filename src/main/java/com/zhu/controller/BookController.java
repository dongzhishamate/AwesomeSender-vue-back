package com.zhu.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhu.entity.Book;
import com.zhu.entity.Student;
import com.zhu.service.BookService;
import com.zhu.util.code.ErrorEnum;
import com.zhu.util.result.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-15
 */
@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired
  BookService bookService;

  @RequestMapping("/getBooksByPageAndSearch")
  public Result<?> getBooksByPageAndSearch(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(defaultValue = "") String search) {
    //封装page
    Page<Book> page = new Page<>(pageNum, pageSize);
    //封装查询条件
    LambdaQueryWrapper<Book> wrapper = Wrappers.<Book>lambdaQuery().orderByAsc(Book::getId);
    if(StrUtil.isNotBlank(search)) {
      //封装模糊查询条件
      wrapper.like(Book::getName, search);
    }
    //返回分页查询结果
    Page<Book> bookPage = bookService.page(page, wrapper);
    return Result.success(bookPage);
  }

  @PostMapping("/saveBook")
  public Result<?> saveBook(@RequestBody Book book) {
    bookService.saveOrUpdate(book);
    return Result.success();
  }

  @DeleteMapping("/{id}")
  public Result<?> deleteById(@PathVariable Long id) {
    bookService.removeById(id);
    return Result.success();
  }
}
