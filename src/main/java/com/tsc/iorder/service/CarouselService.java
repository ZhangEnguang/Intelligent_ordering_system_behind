package com.tsc.iorder.service;

import com.tsc.iorder.dao.CarouselMapper;
import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void show(SearchParam searchParam) {
        this.mapper.show(searchParam);
    }

    public void hidden(SearchParam searchParam) {
        this.mapper.hidden(searchParam);
    }

    public boolean addCarousel(Carousel carousel) {
        int i = this.mapper.addCarousel(carousel);
        return i!=0;
    }

    public List<String> search() {
        return this.mapper.search();
    }

    public Carousel findById(int id) {
        return this.mapper.findById(id);
    }

    public boolean update(Carousel carousel) {
        int i = this.mapper.update(carousel);
        return i!=0;
    }

    public List<Carousel> findSrc(String s) {
       return this.mapper.findSrc(s);
    }

    public boolean delete(SearchParam searchParam) {
        int i = this.mapper.delete(searchParam);
        return i!=0;
    }
}
