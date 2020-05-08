package com.example.wallet.contoller;

import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.bean.Account;
import com.example.wallet.bean.Transaction;
import com.example.wallet.exceptions.AccountException;
import com.example.wallet.repo.AccountRepository1;
import com.example.wallet.repo.TransactionRepository;
import com.example.wallet.service.AccountService;

@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/rest/walletApp")
public class AccountController {
	
	/**
	 *@author Khushi Ambastha
	 *Purpose: Account controller to map various URIs to their respective functions
	 *  
	 * 
	 */
	@Autowired
	private AccountService accService;
	
	@Autowired
	private AccountRepository1 accrep;
	
	
	@Autowired
	private TransactionRepository tranrepo;
	
	@RequestMapping(value = "/create", method = { RequestMethod.GET,RequestMethod.POST },consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	 public String createAccount(@RequestBody Account ac) {

		Account ac1 = ac;
		Random r= new Random();
		int n=r.nextInt(1000000000);
		ac1.setAccountno(n);
		ac1.setOpeningdate(null);
		ac1.setUsername(ac.getUsername());
		ac1.setPassword(ac.getPassword());
		accrep.save(ac1);
		System.err.println(ac1);
		
		return "Account created successfully";
	}
	
	@GetMapping("/accountlist")
	public List<Account> getall() throws AccountException
	{
		List<Account> Accountlist;
		try {
			Accountlist=accService.getAll();
		}
		catch(Exception e)
		{
			throw new AccountException(e.getMessage());
		}
		return Accountlist;
	}
	
	@GetMapping("/accountlist/{accountno}")
	public Account findAccount(@PathVariable Long accountno) throws AccountException{
		Account account;
		try {
			account= accService.getByIdentity(accountno);
		}
		catch(Exception e)
		{
			throw new AccountException(e.getMessage());
		}
		return account;
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET,RequestMethod.POST },consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void updateAcc(@RequestBody Account a) throws AccountException {
		try {
			
	 accService.update(a);
		}
		catch(Exception e)
		{
			throw new AccountException(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public void deleteAcc(@PathVariable Long id) {
		accrep.deleteById(id);
	}
		
	  @RequestMapping(value = "/deposit/{accno}/{amount}", method ={ RequestMethod.GET,RequestMethod.POST })
	public ResponseEntity<HttpStatus> depositMoney(@PathVariable  Long accno,@PathVariable Float amount) throws AccountException {
		  long dest=0;
		  try {
		accService.deposit(accno,dest,amount);
		return ResponseEntity.ok(HttpStatus.OK);
		  }
		  catch(Exception e)
		  {
			  throw new AccountException("Unable to deposit money"+e.getMessage());
		  }
		
	    	}
	
      @RequestMapping(value = "/withdraw/{accno}/{dest}/{amount}", method = { RequestMethod.GET,RequestMethod.POST })
	public ResponseEntity<HttpStatus> withdrawMoney(@PathVariable Long accno,@PathVariable Long dest, @PathVariable Float amount) throws AccountException {
	
    	  if(accrep.getOne(accno).getBalance()<=amount)
    	  {
    		  System.err.println("Amount low");
    		  return (ResponseEntity<HttpStatus>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    	  }
    	  else
    		  System.err.println("okay");
    	  accService.withdraw(accno,dest,amount);
		return ResponseEntity.ok(HttpStatus.OK);
      }
      
      @GetMapping("/transfer/{acc_no}/{dest_acc}/{amount}")
  	public ResponseEntity<HttpStatus> transfer(@PathVariable Long acc_no, @PathVariable Long dest_acc, @PathVariable Float amount) throws AccountException{
    	  
    	  accService.transfer(dest_acc,acc_no, amount);
    	  return ResponseEntity.ok(HttpStatus.OK);
  	}
      
  	@GetMapping("/trans/{id}")
  	public List<Transaction> getTrans(@PathVariable Long id)
  	{
  		System.err.println(tranrepo.count());
  		
  		return accrep.getOne(id).getTransactions();
  			
  	}
  	@GetMapping("/getBalance/{accountno}")
	public float getBalance(@PathVariable Long accountno) {
  		
		return accrep.getOne(accountno).getBalance();
	}
  	
  	
	}

