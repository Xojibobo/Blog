package com.example.blog.Repository

import com.example.blog.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {


//    @Query(value = "select * from Users u where u.id = id", nativeQuery = true)
//    fun findByID(@Param("id") id:Long): Customer
}