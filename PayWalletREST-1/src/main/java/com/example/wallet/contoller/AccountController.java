package com.example.wallet.contoller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.validation.Valid;

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
	
	@Autowired
	private AccountService accService;
	
	@Autowired
	private AccountRepository1 accrep;
	
	
	@Autowired
	private TransactionRepository tranrepo;
	
	@RequestMapping(value = "/create", method = { RequestMethod.GET,RequestMethod.POST },consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	 public String createAccount(@RequestBody Account ac) {

		Account ac1 = ac;
		//return ResponseEntity.ok().body(ac1);
		Random r= new Random();
		int n=r.nextInt(1000000000);
		ac1.setAccountno(n);
		ac1.setOpeningdate(null);
		ac1.setUsername(ac.getUsername());
		ac1.setPassword(ac.getPassword());
		accrep.save(ac1);
		System.err.println(ac1);
		//return accrep.getOne(ac.getAccountno());
		return "Account created successfully";
	}
	
	@GetMapping("/accountlist")
	public List<Account> getall()
	{
		//return accService.getAll();
		return accService.getAll();
	}
	
	@GetMapping("/accountlist/{accountno}")
	public Account findAccount(@PathVariable Long accountno){
		return accService.getByIdentity(accountno);
	}
	
	//@PostMapping("/update")
	@RequestMapping(value = "/update", method = { RequestMethod.GET,RequestMethod.POST },consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void updateAcc(@RequestBody Account a) throws AccountException {
	 accService.update(a);
	}
	
	@RequestMapping(value = "/delete", method = { RequestMethod.GET,RequestMethod.POST })
	public void deleteAcc(Account a) {
		accrep.delete(a);
	}
		
	  @RequestMapping(value = "/deposit/{accno}/{amount}", method ={ RequestMethod.GET,RequestMethod.POST })
	public ResponseEntity<HttpStatus> depositMoney(@PathVariable  Long accno,@PathVariable Float amount) {
		  
		accService.deposit(accno,amount);
		  
		return ResponseEntity.ok(HttpStatus.OK);
	    	}
	
      @RequestMapping(value = "/withdraw/{accno}/{amount}", method = { RequestMethod.GET,RequestMethod.POST })
	public ResponseEntity<HttpStatus> withdrawMoney(@PathVariable Long accno, @PathVariable Float amount) {
	//	accService.withdraw(Integer.parseInt(details[0]), Float.parseFloat(details[1]));
    	  if(accrep.getOne(accno).getBalance()<=amount)
    	  {
    		  System.err.println("Amount low");
    	  }
    	  else
    		  System.err.println("okay");
    	  accService.withdraw(accno,amount);
		return ResponseEntity.ok(HttpStatus.OK);
      }
      
      @GetMapping("/transfer/{acc_no}/{dest_acc}/{amount}")
  	public boolean transfer(@PathVariable Long acc_no, @PathVariable Long dest_acc, @PathVariable Float amount) {
    	  
    	  System.err.println(acc_no+"transfer controller method");
    	  accService.deposit(dest_acc, amount);
    	  accService.withdraw(acc_no, amount);
  		return true;
  	}
      
  	@GetMapping("/trans/{id}")
  	public List<Transaction> getTrans(@PathVariable Long id)
  	{
  		
  		//System.err.println(""+accrep.getOne(id).getTransactions());
  		System.err.println(tranrepo.count());
  		
  		return accrep.getOne(id).getTransactions();
  		//return tranrepo.getOne(id);
  		//System.err.println(tranrepo.findBysourceAcc(id));
  		
  		//return tranrepo.findAll();
  		
  	}
  	@GetMapping("/getBalance/{accountno}")
	public float getBalance(@PathVariable Long accountno) {
  		
		return accrep.getOne(accountno).getBalance();
	}
  	
  	
	}

