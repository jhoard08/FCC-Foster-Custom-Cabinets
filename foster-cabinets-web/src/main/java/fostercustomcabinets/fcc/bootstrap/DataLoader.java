package fostercustomcabinets.fcc.bootstrap;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.Laborer;
import fostercustomcabinets.fcc.model.Material;
import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import fostercustomcabinets.fcc.services.JobService;
import fostercustomcabinets.fcc.services.LaborerService;

import java.time.LocalDate;


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
        job1.setAddress("244 Stewart Hills");
        job1.setCity("Rogersville");
        job1.setTelephone("4239219015");

        Material bobMaterial = new Material();
        bobMaterial.setMaterialType(savedWoodType);
        bobMaterial.setJob(job1);
        bobMaterial.setDate(LocalDate.now());
        bobMaterial.setName("Maple");
        job1.getMaterials().add(bobMaterial);

        jobService.save(job1);

        Job job2 = new Job();
        job2.setFirstName("Frank");
        job2.setLastName("Michaels");
        job2.setAddress("244 Stewart Hills");
        job2.setCity("Rogersville");
        job2.setTelephone("4239219015");

        Material franksMaterial = new Material();
        franksMaterial.setName("Cherry");
        franksMaterial.setJob(job2);
        franksMaterial.setDate(LocalDate.now());
        franksMaterial.setMaterialType(savedHandleType);
        job2.getMaterials().add(franksMaterial);



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
