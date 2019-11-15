package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author CP
 * @date 2019/11/13 20:40
 */
public interface CategoryService {
    /**
     * @param pid
     *@return {@link List< Category>}
     *@throws
     *@author CP
     *@data 2019/11/13 21:02
     * 根据父节点查询子节点
     */
    List<Category> queryCategoriesByPid(Long pid);
}
