package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("rootMapper")
public interface RootMapper {
    List<Root> list();
}
