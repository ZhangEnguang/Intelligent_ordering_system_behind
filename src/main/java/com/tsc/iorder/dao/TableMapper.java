package com.tsc.iorder.dao;

import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.Table;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("tableMapper")
public interface TableMapper {
    List<Table> getList(SearchParam searchParam);

    Table findTableByTableName(String tableName);

    int addTable(String typeName);

    Table findTableById(int id);

    int update(Table resTable);

    List<Table> list();

    int delete(int id);
}
