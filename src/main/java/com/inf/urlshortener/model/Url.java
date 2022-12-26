package com.inf.urlshortener.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;
@Entity
@Data
@NoArgsConstructor
@Table(name="url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String longUrl;

    @Column
    private String keyUrl;

}
