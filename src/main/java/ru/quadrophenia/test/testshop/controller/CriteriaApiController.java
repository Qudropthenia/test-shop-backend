package ru.quadrophenia.test.testshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.quadrophenia.test.testshop.domain.entity.Goods;
import ru.quadrophenia.test.testshop.service.CriteriaApiService;

import java.util.List;

@RestController
@RequestMapping("criteria-api")
public class CriteriaApiController {
	@Autowired
	private CriteriaApiService service;

	@GetMapping("listGoodsAll")
	public ResponseEntity<List<Goods>> listGoodsAll() {
		return ResponseEntity.ok(service.listGoodsAll());
	}

	@PostMapping("saveGoods")
	public ResponseEntity<?> saveNewGoods(
			@RequestBody Goods goods
	) {
		return ResponseEntity.ok(service.saveGoods(goods));
	}

	@GetMapping("gelGoods")
	public ResponseEntity<Boolean> delGoods(
			@RequestParam("id") Integer id
	) {
		return ResponseEntity.ok(service.delGoods(id));
	}

	@GetMapping("findGoodsByIdName")
	public ResponseEntity<?> findGoodsByIdName(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name", required = false) String name
	) {
		return ResponseEntity.ok(service.findGoodsByIdName(id, name));
	}
}
