package com.tarun.springbootmongoDb.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;


@Document("expense")
@Data
@AllArgsConstructor
public class Expense {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "amount")
    private BigDecimal expenseAmount;
    @Field(name = "category")
    private ExpenseCategory expenseCategory;
}
