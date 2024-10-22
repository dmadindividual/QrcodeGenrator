package topg.QrCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor // This generates a constructor with all fields
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;


    private String email;


    private Long mobile;

    // Optional: You can keep this constructor for specific use cases
    public Student(String name, String email, Long mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}
