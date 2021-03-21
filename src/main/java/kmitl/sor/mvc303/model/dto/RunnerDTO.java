package kmitl.sor.mvc303.model.dto;

import lombok.Data;

@Data
public class RunnerDTO {
    private String runnerId;
    private String firstName;
    private String lastName;
    private int age;
    private double distance;
    private String prize;
}
