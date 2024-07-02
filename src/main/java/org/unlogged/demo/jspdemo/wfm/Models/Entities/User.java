package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import static org.unlogged.demo.OtelConfig.makeSpan;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Transient
    @JsonIgnore
    private final Tracer tracer = GlobalOpenTelemetry.getTracer("unlogged-spring-maven-demo");

    @Id
    private long user_id;
    private String username;
    private String password;
    private String email;

    public User(long user_id, String username, String password, String email) {
        Span span = tracer.spanBuilder("custom_tracer").startSpan();
        makeSpan(span, "input.user_id", user_id);
        makeSpan(span, "input.username", username);
        makeSpan(span, "input.password", password);
        makeSpan(span, "input.email", email);

        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        span.end();
    }

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
        Span span = tracer.spanBuilder("custom_tracer").startSpan();

        StringBuilder userValue = new StringBuilder();
        userValue.append("user_id-").append(this.user_id).append(",")
                .append("username-").append(this.username).append(",")
                .append("password-").append(this.password).append(",")
                .append("email-").append(this.email).append(" ");

        String uv = userValue.toString();
        makeSpan(span, "output", uv);
        span.end();
        return uv;
    }
}
