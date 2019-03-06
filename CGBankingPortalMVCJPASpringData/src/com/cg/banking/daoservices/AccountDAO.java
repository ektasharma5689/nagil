package com.cg.banking.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.banking.beans.Account;
public interface AccountDAO extends JpaRepository<Account, Integer>{
	
}