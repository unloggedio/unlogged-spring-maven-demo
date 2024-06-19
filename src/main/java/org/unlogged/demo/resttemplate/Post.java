package org.unlogged.demo.resttemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}
