package com.training.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	private Long id;
@NotBlank(message="Username cannot be blank")
private String username;
@Min(value=18,message="Minimum age is 18")
@Max(value=60,message="Maxium age is 60")
private int age;
@Email(message="Not in proper format")
private String email;

}
