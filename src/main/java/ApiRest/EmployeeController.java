package ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){
        return employeeRepository.findById(id).map(e -> {
            e.setName(employee.getName());
            e.setAddress(employee.getAddress());
            e.setRole(employee.getRole());
            return employeeRepository.save(employee);
        }).orElseGet(() -> {
            employee.setId(id);
            return employeeRepository.save(employee);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
}
