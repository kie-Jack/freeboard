package com.jcpdev.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
	private int pno;
	private String title;
	private String filename;
}
