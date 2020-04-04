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
}
