package com.example.demo.bean;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Image 
{
	//@Value()
	private String imageID;
	
	@Value("abc.jpeg")
	private String imageURL;
}
