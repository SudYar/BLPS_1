package sudyar.blps.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Ordering")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NonNull
    private Integer price;

    @Column(name = "owner_login")
    private String ownerLogin;

    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;


}
