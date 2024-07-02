package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import io.opentelemetry.api.trace.Span;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    public void addHashToName() {
        this.username += "#";
    }

    public void updateDetails(String input) {
        this.setEmail(this.getEmail().replace("@", input));
        if (input.startsWith("+")) {
            this.setPassword(this.getPassword().toUpperCase() + "_" + input.hashCode());
        } else {
            this.setPassword(this.getPassword() + "_" + input.hashCode());

        }
    }

    public String toString() {
        StringBuilder userValue = new StringBuilder();
        userValue.append("user_id-").append(this.user_id).append(",")
                .append("username-").append(this.username).append(",")
                .append("password-").append(this.password).append(",")
                .append("email-").append(this.email).append(" ");

        return userValue.toString();
    }
}
