package com.example.blog.controllers

import com.example.blog.Repository.CustomerRepository
import com.example.blog.model.Customer
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class CustomerController(private var customerRepository: CustomerRepository) {

    @GetMapping("/new")
    fun showSignUpForm(customer: Customer?): String? {
        return "/customers/add_customer"
    }


    @GetMapping("/edit/{id}")
    fun showUpdateForm(@PathVariable("id") id: Long, model: Model): String {
//        val customer = customerRepository.findByID(id)
        val customer = customerRepository.findById(id).get()
        model.addAttribute("customer", customer)
        return "/customers/update-customer"
    }

    @GetMapping("/delete/{id}")
    fun deleteUser(@PathVariable("id") id: Long, model: Model): String? {
        val customer = customerRepository.findById(id).get()
        customerRepository.delete(customer)
        model.addAttribute("customers", customerRepository.findAll())
        return "index"
    }

    @PostMapping("/addcustomer")
    fun addUser(customer: @Valid Customer, model: Model): String? {
        customerRepository.save(customer)
        model.addAttribute("customers", customerRepository.findAll())
        return "index"
    }

    @PostMapping("/update/{id}")
    fun updateUser(
        @PathVariable("id") id: Long, customer: Customer, model: Model
    ): String? {
        customerRepository.save(customer)
        model.addAttribute("customers", customerRepository.findAll())
        return "index"
    }

}

