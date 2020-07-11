package com.prep.crudrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prep.crudrest.model.Sports;
@Repository
public interface SportRepository  extends CrudRepository<Sports, Integer>{
}
