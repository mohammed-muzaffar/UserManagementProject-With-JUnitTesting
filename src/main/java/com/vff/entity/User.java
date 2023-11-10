package com.vff.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "User firstName should not be null or empty")
	@Column(nullable=false)
	private String firstName;
	
	@NotEmpty(message = "User lastName should not be null or empty")
	@Column(nullable=false)
	private String lastName;
	
	@NotEmpty(message = "User email should not be null or empty")
	@Email(message = "emial should be valid")
	@Column(nullable=false, unique=true)
	private String email;
	
	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
