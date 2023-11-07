package com.tarun.springbootmongoDb.Services;

import com.tarun.springbootmongoDb.Models.Expense;
import com.tarun.springbootmongoDb.Repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    public void addExpense(Expense expense){
        expenseRepo.insert(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public void updateExpense(Expense expense){
        Expense savedExpense=expenseRepo.findById(expense.getId())
                .orElseThrow(()->new RuntimeException("expense is not found"));
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        expenseRepo.save(savedExpense);
    }

    public Expense getExpenseByName(String name){
       return expenseRepo.findByName(name)
               .orElseThrow(()->new RuntimeException("cnat find the expense with given name"));
    }

    public void deleteExpense(String id) {
        expenseRepo.deleteById(id);
    }
}
