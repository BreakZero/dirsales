package com.creawor.sales.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Jin_ on 2016/11/10.
 *
 */
public interface ICommonService<T> {
  T save(T entity) throws Exception;

  void delete(String id) throws Exception;

  void delete(T entity) throws Exception;

  T findById(String id);

  T findBySample(T sample);

  List<T> findAll();

  Page<T> findAll(PageRequest pageRequest);
}
