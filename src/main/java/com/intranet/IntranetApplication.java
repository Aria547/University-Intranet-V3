package com.intranet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intranet.dao.*;
import com.intranet.entities.*;
import com.intranet.metier.*;

@SpringBootApplication
public class IntranetApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRep ; 
	@Autowired
	private TeacherRepository teacherRep;
	@Autowired
	private SectionRepository sectionRep;
	@Autowired
	private AdministratorRepository administratorRep;
	@Autowired
	private CourseRepository courseRep;
	@Autowired
	private EvaluationRepository evaluationRep;
	@Autowired
	private NewsRepository newsRep;
	
	@Autowired
	private IntranetMetierInterface intranetMetierInterface;
	
	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Section g1 = sectionRep.save(new Section("3CT"));
		Section g2 = sectionRep.save(new Section("3CI"));
		Section g3 = sectionRep.save(new Section("3CB"));
		
		Teacher t1 = teacherRep.save(new Teacher("Maidi", "jribilogin", "azerty"));
		Teacher t2 = teacherRep.save(new Teacher("Jribi", "maidilogin", "azerty"));
		Teacher t3 = teacherRep.save(new Teacher("Marie", "marielogin", "azerty"));
		Teacher t4 = teacherRep.save(new Teacher("Arcellier", "arcellierlogin", "azerty"));
		
		Student s1 = studentRep.save(new Student("Aurelien", "aurelienlogin", "azerty", g1));
		Student s2 = studentRep.save(new Student("Thierry", "thierrylogin", "azerty", g2));
		Student s3 = studentRep.save(new Student("Thomas", "thomaslogin", "azerty", g3));

		Course c1 = courseRep.save(new Course("Vision", 2, t1, g1));
		Course c2 = courseRep.save(new Course("J2EE", 4, t2, g1));
		Course c3 = courseRep.save(new Course("R", 4, t3, g2));		
		Course c4 = courseRep.save(new Course("Hadoop", 4, t4, g3));
		
		Evaluation e1 = evaluationRep.save(new Evaluation(s1, c1, 17));
		Evaluation e2 = evaluationRep.save(new Evaluation(s1, c2, 15));
		Evaluation e3 = evaluationRep.save(new Evaluation(s2, c3, 18));
		Evaluation e4 = evaluationRep.save(new Evaluation(s3, c4, 17));
		
		Administrator a1 = administratorRep.save(new Administrator("Petit", "petitlogin", "azerty"));
		
		/*
		Random rnd = new Random();
		Date date = new Date(Math.abs(System.currentTimeMillis() - rnd.nextLong()));
		long HOUR = 3600*1000;
		Date myDate = new Date(date.getTime() +2 * HOUR);
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, 2017);
		System.out.println("HELLO " + myDate);
		Date zz = new Date(myDate.getTime());
		
		System.out.println("HELLO2 " + myDate);
		System.out.println("HELLO3 " + new Date());
		*/
		
		News n1 = newsRep.save(new News("Smart Home News: A new SmartThings app has been released in the app store", new Date())); 
		News n2 = newsRep.save(new News("Watch the Jaguar I-Pace Challenge the Tesla Model X",new Date()));
		News n3 = newsRep.save(new News("Here Are 911 Transcripts of Some of the Times Apple Employees Walked Directly Into Glass Walls",new Date()));
		News n4 = newsRep.save(new News("UCLA basketball slips into NCAA Tournament, will face St. Bonaventure in First Four",new Date()));
		News n5 = newsRep.save(new News("Historic vote in China will let president rule for life",new Date()));
		News n6 = newsRep.save(new News("Whole Foods Market approved for Sherman Oaks corner after traffic fears worked out",new Date()));
		
	}
}
