package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.model.BonusCard;
import ru.job4j.domain.model.Order;
import ru.job4j.order.service.BonusCardService;


@AllArgsConstructor
@RestController
@RequestMapping("/bonus")
public class CardController {

    private final BonusCardService cardService;

    @PostMapping("/")
    public ResponseEntity<BonusCard> create(@RequestBody BonusCard card) {
        return new ResponseEntity<>(cardService.save(card), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BonusCard> delete(@PathVariable int id) {
        BonusCard card = new BonusCard();
        card.setId(id);
        cardService.delete(card);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonusCard> findById(@PathVariable int id) {
        BonusCard card = cardService.findById(id);
        return new ResponseEntity<>(card, card == null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
