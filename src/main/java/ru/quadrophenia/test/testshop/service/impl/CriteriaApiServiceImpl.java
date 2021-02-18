package ru.quadrophenia.test.testshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.quadrophenia.test.testshop.service.CriteriaApiService;

import javax.persistence.EntityManager;

@Service
public class CriteriaApiServiceImpl implements CriteriaApiService {
	@Autowired
	private EntityManager entityManager;

}
