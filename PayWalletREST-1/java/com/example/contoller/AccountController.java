package com.example.contoller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Account;
import com.example.repo.TransactionRepository;
import com.example.service.AccountService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/rest/walletApp")
public class AccountController {
	
	@Autowired
	private AccountService accService;
	
	
	
	@PostMapping("/create")
   public Account createAccount( Account ac) {

		return accService.add(ac);
		//return ResponseEntity.ok().body(ac1);
		//return ac1;
	}
	
	@GetMapping("/list")
	public List<Account> getall()
	{
		//return accService.getAll();
		return accService.getAll();
	}
	
	@GetMapping("/list/{accno}")
	public Optional<Account> findAccount(@PathVariable("accNo")Integer accNo){
		return accService.getByIdentity(accNo);
	}
	@PutMapping("/update")
	public void updateAcc(Account a) {
	 accService.update(a);
	}
	
	@DeleteMapping("/list/{accno}")
	public void deleteAcc(@PathVariable("accNo")Integer accNo) {
		accService.deleteAccount(accNo);
	}
		@RequestMapping(value = "/deposit", method = RequestMethod.POST)
		public ResponseEntity<HttpStatus> depositMoney(@Valid @RequestBody String[] details) {
		//	accService.deposit(Integer.parseInt(details[0]), Float.parseFloat(details[1]));
		return ResponseEntity.ok(HttpStatus.OK);
}
	
      @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> withdrawMoney(@Valid @RequestBody String[] details) {
	//	accService.withdraw(Integer.parseInt(details[0]), Float.parseFloat(details[1]));
		return ResponseEntity.ok(HttpStatus.OK);
      }
	}

