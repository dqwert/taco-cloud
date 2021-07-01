package dev.wangqin.tacocloud.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;

import dev.wangqin.tacocloud.TacoOrder;

@Slf4j
@RequestMapping("/orders")
@Controller
public class OrderController {

  @GetMapping("/current") // combined with `@RequestMapping` to produce "/orders/current"
  public String orderForm(Model model) {
    model.addAttribute("tacoOrder", new TacoOrder());
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid TacoOrder tacoOrder, Errors errors) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    log.info("Order submitted: " + tacoOrder);
    return "redirect:/";
  }
}
