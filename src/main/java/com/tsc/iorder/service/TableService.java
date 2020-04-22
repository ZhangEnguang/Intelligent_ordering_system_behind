package com.tsc.iorder.service;

import com.tsc.iorder.dao.TableMapper;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    private TableMapper mapper;

    public List<Table> getList(SearchParam searchParam) {
        return this.mapper.getList(searchParam);
    }

    public Table findTableByTableName(String tableName) {
        return this.mapper.findTableByTableName(tableName);
    }

    public boolean addTable(String typeName) {
        int i = this.mapper.addTable(typeName);
        return i!=0;
    }

    public Table findTableById(int id) {
        return this.mapper.findTableById(id);
    }

    public boolean update(Table resTable) {
        int i = this.mapper.update(resTable);
        return i!=0;
    }

    public List<Table> list() {
        return this.mapper.list();
    }

    public boolean delete(int id) {
        int i = this.mapper.delete(id);
        return i!=0;
    }
}
