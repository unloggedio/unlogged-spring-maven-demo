package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    private long user_id;
    private String username;
    private String password;
    private String email;
}
