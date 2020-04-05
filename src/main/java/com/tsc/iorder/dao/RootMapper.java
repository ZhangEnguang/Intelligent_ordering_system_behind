package com.tsc.iorder.dao;

import com.tsc.iorder.domain.Root;
import com.tsc.iorder.domain.SearchParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component("rootMapper")
public interface RootMapper {
    List<Root> list();

    List<Root> getList(SearchParam searchParam);

    List<Root> listNoRoot();

    Root findRootByRootName(String rootName);

    int addRoot(String rootName);

    Root findRootById(int id);

    int update(Root resRoot);

    int delete(int id);
}
