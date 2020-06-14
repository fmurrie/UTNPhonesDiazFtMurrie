package com.utnphones.UTNPhonesDiazFtMurrie.service;

import com.utnphones.UTNPhonesDiazFtMurrie.dao.LineTypeDao;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.LineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineTypeService {
    //Properties:
    private final LineTypeDao dao;

    //Constructors:
    @Autowired
    public LineTypeService(LineTypeDao dao){this.dao = dao;}

    //Methods:
    public void add(final LineType lineType) {
        dao.save(lineType);
    }

    public List<LineType> getAll()
    {
        return dao.findAll();
    }

    public Optional<LineType> getLineById(Integer id)
    {
        return dao.findById(id);
    }

}
