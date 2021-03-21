package kmitl.sor.mvc303.model.service;

import kmitl.sor.mvc303.model.dto.RunnerDTO;
import kmitl.sor.mvc303.model.entity.Runner;
import kmitl.sor.mvc303.model.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RunnerService {
    @Autowired
    RunnerRepository repository;

    public List<RunnerDTO>listAll(){
        List<Runner> runners = repository.findAll();
        List<RunnerDTO> res = new ArrayList<>();
        for(Runner runloopset : runners){
            RunnerDTO runnerSet = new RunnerDTO();
            runnerSet.setRunnerId(runloopset.getRunnerId());
            runnerSet.setFirstName(runloopset.getFirstName());
            runnerSet.setLastName(runloopset.getLastName());
            runnerSet.setAge(runloopset.getAge());
            runnerSet.setDistance(runloopset.getDistance());
            runnerSet.setPrize(runloopset.getPrize());
            res.add(runnerSet);
        }
        return res;
    }

    public void saveRunner(Runner runner){
        runner.setRunnerId(genarateId());
        runner.setPrize("Not Recive");
        repository.save(runner);
    }
    public Runner getRunner(long id){
        return repository.findById(id).get();
    }
    public String genarateId(){
        Random random = new Random();
        List<String> letter = Arrays.asList("A","B","C","D","E","F","G","H","I");
        List<String> number = Arrays.asList("0","1","2","3","4","5");
        String res = letter.get(random.nextInt(letter.size()))+letter.get(random.nextInt(letter.size()))+letter.get(random.nextInt(letter.size()))
                +number.get(random.nextInt(number.size()))+number.get(random.nextInt(number.size()))+number.get(random.nextInt(number.size()));
        return res;
    }
}
