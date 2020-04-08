package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Module;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("moduleMapper")
public interface ModuleMapper {
    List<Module> list();
}
