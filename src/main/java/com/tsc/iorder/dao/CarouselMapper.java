package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("carsouselMapper")
public interface CarouselMapper {
    List<Carousel> list(SearchParam searchParam);

    void updateIsShow(SearchParam searchParam);

    int listCount();

    void show(SearchParam searchParam);

    void hidden(SearchParam searchParam);
}
