package com.tsc.iorder.service;

import com.tsc.iorder.dao.RootMapper;
import com.tsc.iorder.domain.Root;
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
}
