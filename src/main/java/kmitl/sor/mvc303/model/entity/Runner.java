package kmitl.sor.mvc303.model.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "runner",uniqueConstraints = {@UniqueConstraint(columnNames={"runner_id"})})
public class Runner {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "runner_id" ,columnDefinition = "character varying (6)",nullable = false)
    private String runnerId;

    @Column(name = "distance", columnDefinition = "DOUBLE(10, 3)")
    private double distance;

    @NotNull
    @Column(name = "prize",columnDefinition = "character varying (50)",nullable = false)
    private String prize;

    @NotNull
    @Column(name = "first_name",columnDefinition = "character varying (50)",nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name",columnDefinition = "character varying (50)",nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "age",columnDefinition = "int(3)",nullable = false)
    private int age;
}
