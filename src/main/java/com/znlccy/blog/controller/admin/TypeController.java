package com.znlccy.blog.controller.admin;

import com.znlccy.blog.model.Type;
import com.znlccy.blog.service.TypeService;
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
 * @date: 2019-09-28-15:58
 * @remark: 分类控制器
 */
@Controller
@RequestMapping(value = "/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 所有博客内容
     * @return
     */
    @GetMapping(value = "/types")
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    /**
     * 分类新增页面
     * @return
     */
    @GetMapping(value = "/types/input")
    public String inputPage(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    /**
     * 分类编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "types/{id}/input")
    public String editInputPage(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * 新增分类
     * @param type
     * @return
     */
    @PostMapping(value = "/types")
    public String save(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        Type typeByName = typeService.getTypeByName(type.getName());

        if (typeByName != null) {
            result.rejectValue("name", "nameError", "不能重复添加分类");
        }

        Type t = typeService.saveType(type);

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        if (t == null) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }

        return "redirect:/admin/types";
    }


    /**
     * 更新分类
     * @param type
     * @param result
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping(value = "/types/{id}")
    public String edit(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        Type typeByName = typeService.getTypeByName(type.getName());

        if (typeByName != null) {
            result.rejectValue("name", "nameError", "不能重复添加分类");
        }

        Type t = typeService.updateType(id, type);

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }

        return "redirect:/admin/types";
    }

    /**
     * 删除分类成功
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping(value = "/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
