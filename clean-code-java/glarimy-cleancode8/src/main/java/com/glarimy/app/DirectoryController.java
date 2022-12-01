package com.glarimy.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glarimy.domain.Directory;
import com.glarimy.domain.entities.User;
import com.glarimy.domain.exceptions.UserNotFoundException;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

@RestController
public class DirectoryController {

	@Autowired
	private Directory directory;

	@PostMapping("/user")
	public ResponseEntity<UserData> register(@RequestBody UserData data) throws Exception {
		User user = data.toUser();
		User registeredUser = directory.add(user);
		return new ResponseEntity<UserData>(new UserData(registeredUser), HttpStatus.CREATED);
	}

	@GetMapping("/user/{phone}")
	public ResponseEntity<UserData> findByPhone(@PathVariable("phone") long phone) throws Exception {
		try {
			User user = directory.findByPhone(new PhoneNumber(phone)).orElseThrow(() -> new UserNotFoundException());
			return new ResponseEntity<UserData>(new UserData(user), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserData>> findByName(@RequestParam("name") String name) throws Exception {
		List<User> users = directory.searchByName(new Name(name));
		List<UserData> list = new ArrayList<UserData>();
		for (User user : users)
			list.add(new UserData(user));
		return new ResponseEntity<List<UserData>>(list, HttpStatus.OK);
	}

}
