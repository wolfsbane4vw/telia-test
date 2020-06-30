package com.test.teliatest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "word")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "estMeaning"})
@Table(name = "english_word")
public class EnglishWord {

    @Id
    @Column(name = "eng_id")
    private String word;


    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(
            name = "EstonianWord_EnglishWord",
            joinColumns = @JoinColumn(name = "eng_id"),
            inverseJoinColumns = @JoinColumn(name = "est_id")
    )
    private Set<EstonianWord> estMeaning;
}
