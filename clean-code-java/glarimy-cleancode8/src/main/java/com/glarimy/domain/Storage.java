package com.glarimy.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.domain.entities.User;
import com.glarimy.domain.vo.Name;
import com.glarimy.domain.vo.PhoneNumber;

@Repository
public interface Storage extends JpaRepository<User, PhoneNumber> {
	public List<User> findByName(Name name);
}
