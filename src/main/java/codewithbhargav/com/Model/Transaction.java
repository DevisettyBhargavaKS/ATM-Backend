package codewithbhargav.com.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private int Amount;

    private int currentBalance=0;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private   Account userId;

    @ManyToOne
    @JoinColumn(name="TransactionalType",referencedColumnName = "id")
    private  TransactionalType type;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
