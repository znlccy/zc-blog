package com.znlccy.blog.controller.admin;

import com.znlccy.blog.model.Tag;
import com.znlccy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-28-16:39
 * @remark: 标签控制器器
 */
@Controller
@RequestMapping(value = "/admin")
public class TagController {

    /**
     * 依赖注入标签服务
     */
    @Autowired
    private TagService tagService;

    /**
     * 获取标签列表
     * @return
     */
    @GetMapping(value = "/tags")
    public String list(@PageableDefault(size = 10,sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    /**
     * 标签新增页面
     * @param model
     * @return
     */
    @GetMapping(value = "/tags/input")
    public String inputPage(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    /**
     * 标签编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "tags/{id}/input")
    public String editInputPage(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

    /**
     * 添加标签
     * @param tag
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping(value = "/tags")
    public String save(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        Tag tagByName = tagService.getTagByName(tag.getName());

        if (tagByName != null) {
            result.rejectValue("name", "nameError", "不能重复添加标签");
        }

        Tag t = tagService.saveTag(tag);

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        if (t == null) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }

    /**
     * 更新标签
     * @param tag
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping(value = "/tags/{id}")
    public String edit(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Tag tagByName = tagService.getTagByName(tag.getName());

        if (tagByName != null) {
            result.rejectValue("name", "nameError", "不能重复添加标签");
        }

        Tag t = tagService.updateTag(id, tag);

        if (result.hasErrors()) {
            return "admin/tags-input";
        }

        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }

    /**
     * 删除标签
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping(value = "/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }
}
