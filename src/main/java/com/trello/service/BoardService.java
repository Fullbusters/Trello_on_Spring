package com.trello.service;

import com.trello.dao.BoardRepository;
import com.trello.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BoardService {
    @Autowired
    private BoardRepository repository;

    public void save(Board board){
        repository.save(board);
    }

    public Board findOne(Long id){Board board=repository.findOne(id);
            return board;
    }
    public List<Board> getAll(){
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
