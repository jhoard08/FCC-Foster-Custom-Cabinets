package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Use;
import fostercustomcabinets.fcc.services.UseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UseMapService extends AbstractMapService<Use, Long> implements UseService {



    @Override
    public Set<Use> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Use object) {
        super.delete(object);
    }

    @Override
    public Use save(Use use) {

        if(use.getMaterial() == null || use.getMaterial().getJob() == null || use.getMaterial().getId() == null
        || use.getMaterial().getJob().getId() == null){
            throw new RuntimeException("Invalid Use of Material");
        }
        return super.save(use);
    }

    @Override
    public Use findById(Long id) {
        return super.findById(id);
    }
}
