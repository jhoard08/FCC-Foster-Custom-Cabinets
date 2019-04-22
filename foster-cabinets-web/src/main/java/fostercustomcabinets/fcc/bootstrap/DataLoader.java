package fostercustomcabinets.fcc.bootstrap;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.Laborer;
import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fostercustomcabinets.fcc.services.JobService;
import fostercustomcabinets.fcc.services.LaborerService;


@Component
public class DataLoader implements CommandLineRunner {

    private final JobService jobService;
    private final LaborerService laborerService;
    private final MaterialTypeService materialTypeService;

    public DataLoader(JobService jobService, LaborerService laborerService, MaterialTypeService materialTypeService) {
        this.jobService = jobService;
        this.laborerService = laborerService;
        this.materialTypeService = materialTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        MaterialType wood = new MaterialType();
        wood.setName("Maple");
        MaterialType savedWoodType = materialTypeService.save(wood);

        MaterialType handles = new MaterialType();
        wood.setName("Stainless Steel Knob");
        MaterialType savedHandleType = materialTypeService.save(handles);

        Job job1 = new Job();
        job1.setFirstName("Bob");
        job1.setLastName("Coder");

        jobService.save(job1);

        Job job2 = new Job();
        job2.setFirstName("Frank");
        job2.setLastName("Michaels");

        jobService.save(job2);

        System.out.println("Loaded Jobs . . . .");

        Laborer laborer1 = new Laborer();
        laborer1.setFirstName("Anthony");
        laborer1.setLastName("Stull");

        laborerService.save(laborer1);

        Laborer laborer2 = new Laborer();
        laborer2.setFirstName("Joe");
        laborer2.setLastName("Casswell");

        laborerService.save(laborer2);

        System.out.println("Loaded Laborers . . . .");

    }
}
