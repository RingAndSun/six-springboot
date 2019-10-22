package com.sixweb.sixspringboot.service;

import com.sixweb.sixspringboot.dao.CategoryDAO;
import com.sixweb.sixspringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        List<Sort.Order> p = new ArrayList<>();
        p.add(new Sort.Order(Sort.Direction.DESC,"id"));
        //        Sort sort1 = new Sort(p);
        Sort sort = Sort.by(p);
        return categoryDAO.findAll();
    }

    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}

