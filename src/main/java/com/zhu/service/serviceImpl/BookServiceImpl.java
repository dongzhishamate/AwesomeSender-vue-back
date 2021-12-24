package com.zhu.service.serviceImpl;

import com.zhu.entity.Book;
import com.zhu.mapper.BookMapper;
import com.zhu.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufangyuan
 * @since 2021-12-15
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
