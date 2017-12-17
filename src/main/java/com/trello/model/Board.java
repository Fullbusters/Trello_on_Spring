package com.trello.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "board")
public class Board implements Serializable, Comparable<Board>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private int creator_id;
    @Column
    private long creatorTimestamp;

    public Board() {
        this.creatorTimestamp=System.currentTimeMillis();
    }

    @Override
    public int compareTo(Board that){
        return Long.compare(this.creatorTimestamp, that.creatorTimestamp);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
}
