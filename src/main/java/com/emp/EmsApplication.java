package com.emp;

import com.emp.entity.Employee;
import com.emp.repo.EmployeeRepository;
import com.emp.service.EmployeeServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

import static org.hibernate.Hibernate.map;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class EmsApplication {

	private EmployeeRepository employeeRepository;

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(EmsApplication.class, args);
		System.out.println("start");
		EmsApplication emsApplication = new EmsApplication();
		System.out.println(emsApplication.getEmpsAsync());
		System.out.println("end");
	}



	@Scheduled(fixedDelay = 2000, initialDelay = 1000)
	public void addEmployee1() throws InterruptedException{

		Employee e1 = new Employee(new Random().nextInt(123789456), "random", 1, 1);
		Employee e2 = new Employee(new Random().nextInt(123789456), "newrandom", 1, 0);

		List<Employee> employees = employeeRepository.saveAllAndFlush(List.of(e1, e2));

		System.out.println(employeeRepository.count());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	@Scheduled(fixedDelay = 2000)
	public void addEmployee2() throws InterruptedException {

		Employee e1 = new Employee(new Random().nextInt(123789456), "random", 1, 1);
		Employee e2 = new Employee(new Random().nextInt(123789456), "newrandom", 1, 0);

		List<Employee> employees = employeeRepository.saveAllAndFlush(List.of(e1, e2));

		System.out.println(employeeRepository.count());
		Thread.sleep(4000);

	}
	@Scheduled(fixedRate = 1000)
	public void addEmployee3() throws InterruptedException {

		Employee e1 = new Employee(new Random().nextInt(123789456), "random", 1, 1);
		Employee e2 = new Employee(new Random().nextInt(123789456), "newrandom", 1, 0);

		List<Employee> employees = employeeRepository.saveAllAndFlush(List.of(e1, e2));

		System.out.println(employeeRepository.count());
		Thread.sleep(4000);

	}

	@Scheduled(fixedRateString = "PT5s")
	public void addEmployee() throws InterruptedException  {

		Employee e1 = new Employee(new Random().nextInt(123789456), "random", 1, 1);
		Employee e2 = new Employee(new Random().nextInt(123789456), "newrandom", 1, 0);

		List<Employee> employeee1, employeee2 = employeeRepository.saveAllAndFlush(List.of(e1, e2));

		System.out.println(employeeRepository.count());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	//12.00 noon

	@Scheduled(cron = "0 0 12 * * *")
	public void clearEmpInactiveRecords() {

		List<Employee> employees = employeeRepository.findAll().stream().collect(Collectors.toList());
		employeeRepository.deleteAll(employees);

		//employeeRepository.findAll().stream().filter(e -> e.getactive() == 0.map(e->e.setId()).collect(Collectors.toList()
		//		);
		employeeRepository.flush();
        System.out.println(employeeRepository.count());
	}

	public void deleteEmps(List<String> ids){
		employeeRepository.deleteAllById(ids);
	}

	public TaskScheduler concurrenttaskScheduler() {
		TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		((ThreadPoolTaskScheduler) taskScheduler).setPoolSize(Integer.valueOf("$(app.thread.size)$"));
		return taskScheduler;
	}

	public CompletableFuture<List<Employee>> getEmpsAsync() throws InterruptedException{
		List<Employee> employees = employeeRepository.findAll();
		Thread.sleep(3000);
		return CompletableFuture.completedFuture(employees);
	}
}