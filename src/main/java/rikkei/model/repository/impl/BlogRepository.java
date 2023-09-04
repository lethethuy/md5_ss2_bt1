package rikkei.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.model.entity.Blog;
import rikkei.model.repository.IBlogRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository // Đánh dấu đây là 1 repository
@Transactional // đánh dấu đây là 1 Transaction
// Khi có Exception xảy ra thì Transaction sẽ rollback lại các thao tác trước đó.
public class BlogRepository implements IBlogRepository {
//    @Autowired
    @PersistenceContext
    private EntityManager entityManager; // khai bao kho entitymanager de thao tac vs database
    @Override
    public List<Blog> findAll(){
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b", Blog.class);
        return query.getResultList(); //
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b where b.id=:id", Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId()==null){
            // them moi
            entityManager.persist(blog);
        }else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

}
