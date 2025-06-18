package com.example.relations.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "users_schema", name = "t_account")
public class Account {
    @Id
    Long id;
    String name;

    @Column(name = "c_title")
    String title;

    @ManyToOne
    @JoinColumn(name = "c_user_id")
    User user;
}
