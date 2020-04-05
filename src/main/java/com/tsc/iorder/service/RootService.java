package com.tsc.iorder.service;

import com.tsc.iorder.dao.RootMapper;
import com.tsc.iorder.domain.Root;
import com.tsc.iorder.domain.SearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootService {
    @Autowired
    private RootMapper mapper;
    public List<Root> list() {
        return this.mapper.list();
    }

    public List<Root> getList(SearchParam searchParam) {
        return this.mapper.getList(searchParam);
    }

    public List<Root> listNoRoot() {
        return this.mapper.listNoRoot();
    }

    public Root findRootByRootName(String rootName) {
        return this.mapper.findRootByRootName(rootName);
    }

    public boolean addRoot(String rootName) {
        int i = this.mapper.addRoot(rootName);
        return i!=0;
    }

    public Root findRootById(int id) {
        return this.mapper.findRootById(id);
    }

    public boolean update(Root resRoot) {
        int i = this.mapper.update(resRoot);
        return i!=0;
    }

    public boolean delete(int id) {
        int i = this.mapper.delete(id);
        return i!=0;
    }
}
