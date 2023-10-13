package com.example.blog.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.springframework.web.multipart.MultipartFile

@Entity
@Table(name = "Users")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: @NotBlank(message = "Name is required") String? = null
    var surname: @NotBlank(message = "Name is required") String? = null
    var email: @NotBlank(message = "Name is required") String? = null
//    var image: @NotBlank(message = "Name is required") MultipartFile? = null

    //    @Min(18)
    //    @Max(50)
    //    private Integer age;


}