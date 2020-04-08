package com.tsc.iorder.service;

import com.tsc.iorder.dao.ModuleMapper;
import com.tsc.iorder.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private ModuleMapper mapper;

    public List<Module> list() {
        return this.mapper.list();
    }
}
