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
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "engMeaning"})
@Table(name = "estonian_word")
public class EstonianWord {

    @Id
    @Column(name = "est_id")
    private String word;

    @ManyToMany(mappedBy = "estMeaning", cascade = {CascadeType.ALL, CascadeType.MERGE})
    private Set<EnglishWord> engMeaning;
}
