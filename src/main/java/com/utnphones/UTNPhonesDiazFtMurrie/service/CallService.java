package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.CallDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallService {

    //Properties:
    private final CallDao dao;

    //Constructors:
    @Autowired
    public CallService (CallDao dao) {
        this.dao = dao;
    }

    public Call addCall(Call call) { return dao.save(call); }

    //Methods:
    public List<Call> getAll()
    {
        return dao.findAll();
    }

    public Optional<Call> getCallById(Integer id)
    {
        return dao.findById(id);
    }

}
