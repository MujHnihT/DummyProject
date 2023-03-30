package com.example.dummyproject.model.entity.seconddb;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "file_streaming")
@Data
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_no")
    private Integer seqNo;

    @Column(name="file_name")
    private String name;


    @Lob
    @Column(name="file_data")
    private byte[] data;

}
