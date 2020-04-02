package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Root;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RootMapper {
    List<Root> list();
}
