package dev.wangqin.tacocloud.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import dev.wangqin.tacocloud.TacoOrder;
import dev.wangqin.tacocloud.data.OrderRepository;


@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
@Controller
public class OrderController {

  private OrderRepository orderRepo;

  public OrderController(OrderRepository orderRepo) {
    this.orderRepo = orderRepo;
  }

  @GetMapping("/current") // combined with `@RequestMapping` to produce "/orders/current"
  public String orderForm(Model model) {
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "orderForm";
    }

    orderRepo.save(tacoOrder);
    sessionStatus.setComplete();

    return "redirect:/";
  }
}
