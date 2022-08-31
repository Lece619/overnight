package com.yjproject.overnight.repository;

import com.yjproject.overnight.domain.item.Item;
import com.yjproject.overnight.domain.item.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public void save(Product product){
        if(product.getId()==null){
            em.persist(product);
        } else{
            em.merge(product);
        }
    }

    public Product findOne(Long id){
        return em.find(Product.class,id);
    }

    public List<Product> findAll(){
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

}
