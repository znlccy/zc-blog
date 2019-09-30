package com.znlccy.blog.controller.admin;

import com.znlccy.blog.model.Blog;
import com.znlccy.blog.service.BlogService;
import com.znlccy.blog.service.TagService;
import com.znlccy.blog.service.TypeService;
import com.znlccy.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-28-09:40
 * @remark: 博客控制器
 */
@Controller
@RequestMapping(value = "/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    private static final String INPUT = "admin/blogs-input";

    private static final String LIST = "admin/blogs";

    private static final String REDIRECT_LIST = "redirect:admin/blogs";

    /**
     * 所有博客内容
     * @return
     */
    @GetMapping(value = "/blogs")
    public String list(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return LIST;
    }

    /**
     * 查询博客内容
     * @return
     */
    @PostMapping(value = "/blogs/search")
    public String search(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }

    /**
     * 博客新增页面
     * @param model
     * @return
     */
    @GetMapping(value = "/blogs/input")
    public String inputPage(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    /**
     * 博客新增功能
     * @param blog
     * @param model
     * @return
     */
    @PostMapping(value = "/blogs")
    public String save(@RequestBody Blog blog, Model model) {
        return "";
    }

    /**
     * 博客编辑页面
     * @param id
     * @param blog
     * @return
     */
    @PostMapping
    public String edit(@PathVariable Long id, @RequestBody Blog blog) {
        return "";
    }

}
