package com.tsc.iorder.service;

import com.tsc.iorder.dao.CarouselMapper;
import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarouselService {
    @Autowired
    private CarouselMapper mapper;
    public List<Carousel> list(SearchParam searchParam) {
        return  mapper.list(searchParam);
    }

    public void updateIsShow(SearchParam searchParam) {
        this.mapper.updateIsShow(searchParam);
    }

    public int listCount() {
       return this.mapper.listCount();
    }

    public void show(SearchParam searchParam) {
        this.mapper.show(searchParam);
    }

    public void hidden(SearchParam searchParam) {
        this.mapper.hidden(searchParam);
    }
}
