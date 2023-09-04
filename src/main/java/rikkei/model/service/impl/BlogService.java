package rikkei.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.model.entity.Blog;
import rikkei.model.repository.IBlogRepository;
import rikkei.model.service.IBlogService;
import rikkei.model.service.IGenericService;

import java.util.List;
@Service

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog b) {
        blogRepository.save(b);

    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
