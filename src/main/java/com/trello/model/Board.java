package com.trello.model;

import javax.persistence.*;

@Entity
@Table(name = "Board")
public class Board implements Comparable<Board> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Creator_Id")
    private Long creatorId;
    @Column(name = "Creator_Timestamp")
    private Long creatorTimestamp;

    public Board() {
        this.creatorTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Board that) {
        return Long.compare(this.creatorTimestamp, that.creatorTimestamp);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
