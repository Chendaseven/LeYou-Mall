package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author CP
 * @date 2019/11/13 20:41
 */
@Api("分类管理")
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "根据pid获取分类管理列表")
    @ApiImplicitParams(@ApiImplicitParam(name = "pid",value = "pid",required = true))
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value="pid",defaultValue = "0") Long pid){

        if(pid == null || pid < 0){
            //400,参数不合法
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = categoryService.queryCategoriesByPid(pid);
        if(CollectionUtils.isEmpty(categories)){
            //404 服务器资源未找到
            return ResponseEntity.notFound().build();
        }

        //200:查询成功
        return ResponseEntity.ok(categories);
    }


}
