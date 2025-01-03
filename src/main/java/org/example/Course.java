package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students;
}
