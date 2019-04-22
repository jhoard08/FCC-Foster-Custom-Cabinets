package fostercustomcabinets.fcc.bootstrap;

import fostercustomcabinets.fcc.model.*;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import fostercustomcabinets.fcc.services.SpecialitiesService;
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
    private final SpecialitiesService specialitiesService;

    public DataLoader(JobService jobService, LaborerService laborerService, MaterialTypeService materialTypeService,
                      SpecialitiesService specialitiesService) {
        this.jobService = jobService;
        this.laborerService = laborerService;
        this.materialTypeService = materialTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = materialTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        MaterialType wood = new MaterialType();
        wood.setName("Maple");
        MaterialType savedWoodType = materialTypeService.save(wood);

        MaterialType handles = new MaterialType();
        wood.setName("Stainless Steel Knob");
        MaterialType savedHandleType = materialTypeService.save(handles);

        Specialty newHire = new Specialty();
        newHire.setDescription("New Employee");
        Specialty savedNewHire = specialitiesService.save(newHire);

        Specialty advanced = new Specialty();
        advanced.setDescription("Advanced");
        Specialty savedAdvance = specialitiesService.save(advanced);

        Specialty worldClass = new Specialty();
        worldClass.setDescription("World Class");
        Specialty savedWorldClass = specialitiesService.save(worldClass);

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
        laborer1.getSpecialties().add(savedNewHire);

        laborerService.save(laborer1);

        Laborer laborer2 = new Laborer();
        laborer2.setFirstName("Joe");
        laborer2.setLastName("Casswell");
        laborer2.getSpecialties().add(savedAdvance);

        laborerService.save(laborer2);

        System.out.println("Loaded Laborers . . . .");
    }
}
