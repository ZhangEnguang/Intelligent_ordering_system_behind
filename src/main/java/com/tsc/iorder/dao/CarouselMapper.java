package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("carsouselMapper")
public interface CarouselMapper {
    List<Carousel> list(SearchParam searchParam);

    void updateIsShow(SearchParam searchParam);

    void show(SearchParam searchParam);

    void hidden(SearchParam searchParam);

    int addCarousel(Carousel carousel);

    List<String> search();

    Carousel findById(int id);

    int update(Carousel carousel);

    List<Carousel> findSrc(String s);

    int delete(SearchParam searchParam);
}
