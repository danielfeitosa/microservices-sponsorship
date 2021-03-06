package com.comfort.sponsorshiphub.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Sponsor  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( updatable = false, nullable = false )
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	@Builder
	public Sponsor(Long id, Long version, Timestamp createdDate, Timestamp lastModifiedDate) {

	
	}
	
	

}
