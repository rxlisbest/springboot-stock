package com.ruiruisun.stock.controller;

import com.github.pagehelper.PageInfo;
import com.ruiruisun.stock.bean.PaginationBean;
import com.ruiruisun.stock.entity.Buyer;
import com.ruiruisun.stock.exception.BadRequestException;
import com.ruiruisun.stock.exception.NotFoundException;
import com.ruiruisun.stock.service.BuyerService;
import com.ruiruisun.stock.utils.LocaleMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ResponseBody
@RestController
@RequestMapping(value = "buyers")
public class BuyerController {
    @Resource
    private BuyerService buyerService;

    @Autowired
    PaginationBean paginationBean;

    @GetMapping("/index")
    public PageInfo<Buyer> index(HttpServletRequest request, Integer page) throws Exception {
        String name = request.getParameter("name");
        name = name != null ? name : "";
        if (page == null) {
            page = 1;
        }
        PageInfo<Buyer> buyerList = buyerService.findPageByName(name, page, paginationBean.getPageSize());
        return buyerList;
    }

    @GetMapping("/view/{id}")
    public Buyer view(@PathVariable int id) throws Exception {
        Buyer buyer = buyerService.findOne(id);
        if (buyer == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("buyer.not_exists"));
        }
        return buyer;
    }

    @PostMapping(value = "/create")
    public int create(@RequestBody Buyer request) throws Exception {
        String name = request.getName();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("buyer.name_empty"));
        }
        Buyer buyer = request;
        if (buyer.getPhone() == null) {
            buyer.setPhone("");
        }
        int id = buyerService.create(buyer);
        return id;
    }

    @PutMapping("/update/{id}")
    public int update(@RequestBody Buyer request, @PathVariable int id) throws Exception {
        String name = request.getName();
        if (name == null || name.length() == 0) {
            throw new BadRequestException(LocaleMessageUtils.getMsg("buyer.name_empty"));
        }
        Buyer buyer = buyerService.findOne(id);
        if (buyer == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("buyer.not_exists"));
        }
        buyer.setName(request.getName());
        if (buyer.getPhone() == null) {
            buyer.setPhone("");
        } else {
            buyer.setPhone(request.getPhone());
        }
        int rows = buyerService.update(buyer);
        return rows;
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id) throws Exception {
        Buyer buyer = buyerService.findOne(id);
        if (buyer == null) {
            throw new NotFoundException(LocaleMessageUtils.getMsg("buyer.not_exists"));
        }
        int rows = buyerService.delete(buyer);
        return rows;
    }
}
