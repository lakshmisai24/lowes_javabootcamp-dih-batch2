package config;


import dao.EmployeeDaoServiceImpl;
import model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import service.ExportEmpDataService;
import service.ImportExportData;

@Configuration
public class ApplicationConfig {

    @Bean
    public Employee employee() {
        return new Employee();
    }

    @Bean
    public EmployeeDaoServiceImpl employeeDaoService() {
        return new EmployeeDaoServiceImpl();
    }

    @Bean
    public ExportEmpDataService exportEmpDataService() {
        return new ExportEmpDataService();
    }

    @Bean
    public ImportExportData importExportData() {
        return new ImportExportData();
    }

}


