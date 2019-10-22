package com.sixweb.sixspringboot.dao;

import com.sixweb.sixspringboot.pojo.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
